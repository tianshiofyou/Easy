package com.easy.net;

import java.net.InetAddress;

/**
 * @Description: Description
 * @Author: jp
 * @CreateDate: 2018/10/18 14:38
 * @Version: 1.0
 */
public interface Server {

      void start();

      void stop();

      void listen(int port);

      InetAddress getInetAddress();
}
