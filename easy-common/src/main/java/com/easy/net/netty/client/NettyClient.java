package com.easy.net.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;


/**
 * Netty创建全部都是实现自AbstractBootstrap。
 * 客户端的是Bootstrap，服务端的则是    ServerBootstrap。
 **/

@Slf4j
public class NettyClient {

    private String host ;  //ip地址
    private int port;          //端口
    /// 通过nio方式来接收连接和处理连接
    private EventLoopGroup group;
    private Bootstrap b = new Bootstrap();
    private Class<? extends Channel> channel;
    private Channel dataChannel;
    private ChannelHandler channelHandler;
    private final static String DEFAULT_HOST = "127.0.0.1";
    private final static EventLoopGroup DEFAULT_EVENT_LOOP_GROUP = new NioEventLoopGroup();
    private final static int DEFAULT_PORT = 6789;
    private final static Class<? extends Channel> DEFAULT_CHANNEL = NioSocketChannel.class;
    private final static ChannelHandler DEFAULT_CHANNEL_HANDLER = new NettyClientFilter();



    public NettyClient host(String host){
        this.host = host;
        return this;
    }

    public String getHost(){
        if (StringUtils.isEmpty(this.host)) {
            this.host = DEFAULT_HOST;
        }
        return host;
    }

    public NettyClient port(int port){
        this.port = port;
        return this;
    }

    public int getPort(){
        if (port <= 0) {
            port = DEFAULT_PORT;
        }
        return port;
    }


    public NettyClient eventLoopGroup(EventLoopGroup eventLoopGroup){
        this.group = eventLoopGroup;
        return this;
    }

    public EventLoopGroup getEventLoopGroup(){
        if (null == group) {
            group = DEFAULT_EVENT_LOOP_GROUP;
        }
        return group;
    }

    public NettyClient channel(Class<? extends Channel> channel){
        this.channel =  channel;
        return this;
    }

    public Class<? extends Channel> getChannel(){
        if (null == channel) {
            channel = DEFAULT_CHANNEL;
        }
        return channel;
    }


    public NettyClient childHandler(ChannelHandler handler){
        this.channelHandler = handler;
        return this;
    }

    public ChannelHandler getChannelHandler(){
        if (null == channelHandler) {
            channelHandler = DEFAULT_CHANNEL_HANDLER;
        }
        return channelHandler;
    }

    public void start() throws Exception{
        log.info("客户端成功启动...");
        b.group(getEventLoopGroup());
        b.channel(getChannel());
        b.handler(getChannelHandler());
        // 连接服务端
        dataChannel = b.connect(getHost(), getPort()).sync().channel();
    }

    public void sendData(Object str) {
        dataChannel.writeAndFlush(str+ "\r\n");
        log.info("客户端发送String数据:"+str);
    }
    public void sendData(int i) {
        dataChannel.writeAndFlush(i+ "\r\n");
        log.info("客户端发送String数据:"+i);
    }
    public void sendData(double d) {
        dataChannel.writeAndFlush(d+ "\r\n");
        log.info("客户端发送String数据:"+d);
    }
    public void sendData(short s) {
        dataChannel.writeAndFlush(s+ "\r\n");
        log.info("客户端发送String数据:"+s);
    }
    public void sendData(byte b) {
        dataChannel.writeAndFlush(b+ "\r\n");
        log.info("客户端发送String数据:"+b);
    }
    public void sendData(long l) {
        dataChannel.writeAndFlush(l+ "\r\n");
        log.info("客户端发送String数据:"+l);
    }
    public void sendData(boolean bool) {
        dataChannel.writeAndFlush(bool+ "\r\n");
        log.info("客户端发送boolean数据:"+bool);
    }
    public void sendData(char c) {
        dataChannel.writeAndFlush(c+ "\r\n");
        log.info("客户端发送boolean数据:"+c);
    }
    public void sendData(float f) {
        dataChannel.writeAndFlush(f+ "\r\n");
        log.info("客户端发送boolean数据:"+f);
    }

    public boolean shunDown(){
        group.shutdownGracefully();
        return true;
    }

}

