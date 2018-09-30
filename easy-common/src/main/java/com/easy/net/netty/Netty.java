package com.easy.net.netty;

import com.easy.net.netty.client.NettyClient;
import com.easy.net.netty.server.NettyServer;

/**
 * @Description: Description
 * @Author: jp
 * @CreateDate: 2018/9/30 9:23
 * @Version: 1.0
 */
public class Netty {
    public static NettyServer getServer(){
        return new NettyServer();
    }
    public static NettyClient getClient(){
        return new NettyClient();
    }
}
