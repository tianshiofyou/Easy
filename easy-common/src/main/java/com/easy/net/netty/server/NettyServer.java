package com.easy.net.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ServerChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NettyServer  {
    private  int port; //设置服务端端口
    private  EventLoopGroup group = null;
    private  ServerBootstrap b = new ServerBootstrap();

    private Class<? extends ServerChannel> channel;
    private ChannelHandler channelHandler;

    private ChannelFuture f = null;

    private final static EventLoopGroup DEFAULT_EVENT_LOOP_GROUP = new NioEventLoopGroup();
    private final static int DEFAULT_PORT = 6789;
    private final static Class<? extends ServerChannel> DEFAULT_CHANNEL = NioServerSocketChannel.class;
    private final static ChannelHandler DEFAULT_CHANNEL_HANDLER = new NettyServerFilter();

    public NettyServer() { }

    public NettyServer port(int port){
        this.port = port;
        return this;
    }

    public int getPort(){
        if (port <= 0) {
            port = DEFAULT_PORT;
        }
        return port;
    }


    public NettyServer eventLoopGroup(EventLoopGroup eventLoopGroup){
        this.group = eventLoopGroup;
        return this;
    }

    public EventLoopGroup getEventLoopGroup(){
        if (null == group) {
            group = DEFAULT_EVENT_LOOP_GROUP;
        }
        return group;
    }

    public NettyServer channel(Class<? extends ServerChannel> channel){
        this.channel =  channel;
        return this;
    }

    public Class<? extends ServerChannel> getChannel(){
        if (null == channel) {
            channel = DEFAULT_CHANNEL;
        }
        return channel;
    }

    public NettyServer childHandler(ChannelHandler handler){
        this.channelHandler = handler;
        return this;
    }

    public ChannelHandler getChannelHandler(){
        if (null == channelHandler) {
            channelHandler = DEFAULT_CHANNEL_HANDLER;
        }
        return channelHandler;
    }


    /**
     * Netty创建全部都是实现自AbstractBootstrap。
     * 客户端的是Bootstrap，服务端的则是    ServerBootstrap。
     * spring容器启动的时候 启动netty服务器
     **/
    public void listen(){
        b.group(getEventLoopGroup());
        b.channel(getChannel());
        b.childHandler(getChannelHandler()); //设置过滤器
        start();
    }

    /**
     * Netty创建全部都是实现自AbstractBootstrap。
     * 客户端的是Bootstrap，服务端的则是    ServerBootstrap。
     * spring容器启动的时候 启动netty服务器
     **/
    public void listen(int port){
        b.group(getEventLoopGroup());
        b.channel(getChannel());
        b.childHandler(getChannelHandler()); //设置过滤器
        this.port = port;
        start();
    }

    private void start(){
        try {
            // 服务器绑定端口监听
            f = b.bind(getPort()).sync();
            log.info("netty服务端启动成功...");

            // 监听服务器关闭监听
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
            group.shutdownGracefully(); ////关闭EventLoopGroup，释放掉所有资源包括创建的线程
        }
    }

    /**
     * @return Returns {@code true} if this task completed.
     */
    public boolean isDone(){

        return f.isDone();
    }

    public boolean isCancelled(){
        return f.isCancelled();
    }

    public boolean isCancellable(){
        return f.isCancellable();
    }

    public boolean isSuccess(){
        return f.isSuccess();
    }

    public boolean shunDown(){
        group.shutdownGracefully();
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("NettyServer: ");
        builder
        .append("{ ")
        .append("port:").append(port)
        .append(',')
        .append(" EventLoopGroup: '").append(group.getClass().getName()).append("'")
        .append(" ServerChannel: '").append(channel.getClass().getName()).append("'")
        .append(" ChannelHandler: '").append(channelHandler.getClass().getName()).append("'")
        .append(" }");
        return super.toString();
    }
}
