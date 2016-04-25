package com.stpan.chitchat.mina;

import com.google.gson.Gson;

import org.apache.mina.core.RuntimeIoException;
import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.filterchain.IoFilterChain;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.write.WriteRequest;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.SocketSessionConfig;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.greenrobot.eventbus.EventBus;

import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by STPAN on 2016/4/4.
 */
public class SocketClient {
    private static SocketClient client;
    private NioSocketConnector connector;
    public static String TAG = "SocketClient";
    public static String host = "192.168.1.105";
    public static int port = 9898;

    public SocketClient() {
    }

    public static SocketClient getSocketClient() {
        if (client == null) {
            synchronized (SocketClient.class) {
                if (client == null) {
                    client = new SocketClient();
                }
            }
        }
        return client;
    }

    public void connectServer() {
        connector = new NioSocketConnector();
        connector.setConnectTimeoutMillis(10000);
        connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new MyProtocolCodecFactory()));
        connector.setHandler(new MyHandler());
        SocketSessionConfig config = connector.getSessionConfig();
        config.setIdleTime(IdleStatus.BOTH_IDLE, 10);
        connector.setDefaultRemoteAddress(new InetSocketAddress(host, port));
        for (; ; ) {
            try {
                ConnectFuture future = connector.connect();
                future.awaitUninterruptibly();
                System.out.println("connectServer: 连接服务端" + host + ":" + port + "[成功]" + ",,时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                break;
            } catch (RuntimeIoException e) {
                System.out.println("连接服务端" + host + ":" + port + "失败" + ",时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + ", 连接MSG异常,请检查MSG端口、IP是否正确,MSG服务是否启动,异常内容:" + e.getMessage());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    private class MyHandler extends IoHandlerAdapter {
        @Override
        public void sessionCreated(IoSession session) throws Exception {
            System.out.println("sessionCreated");
            SessionUtil.getInstance().setIoSession(session);
        }

        @Override
        public void sessionOpened(IoSession session) throws Exception {
            System.out.println("sessionOpened");
            Result result = new Result();
            result.setFrom("1");
            session.write(new Gson().toJson(result));
        }

        @Override
        public void sessionClosed(IoSession session) throws Exception {
            System.out.println("sessionClosed");
            reConnect(session);
        }

        @Override
        public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
            System.out.println("sessionIdle");
            if (session != null) {
                session.closeNow();
            }
        }

        @Override
        public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
            System.out.println("exceptionCaught: " + session.getId());
            cause.printStackTrace();
        }

        @Override
        public void messageReceived(IoSession session, Object message) throws Exception {
            String s = (String) message;
            System.out.println("messageReceived: " + s);
            EventBus.getDefault().post(s);
        }

        @Override
        public void messageSent(IoSession session, Object message) throws Exception {
            System.out.println("messageSent: " + String.valueOf(message));
        }

        @Override
        public void inputClosed(IoSession session) throws Exception {
            System.out.println("inputClosed");
            session.closeNow();
        }
    }

    private void reConnect(IoSession session){
        for (; ; ) {
            try {
                Thread.sleep(3000);
                ConnectFuture future = connector.connect();
                future.awaitUninterruptibly();
                session = future.getSession();
                if (session.isConnected()) {
                    System.out.println("断线重连[: " + connector.getDefaultRemoteAddress().getHostName()
                            + ":" + connector.getDefaultRemoteAddress().getPort() + " ]成功");
                    break;
                }
            } catch (InterruptedException e) {
                System.out.println("重连服务器登录失败,3秒再连接一次: " + e.getMessage());
            }
        }
    }

    private class MyIoFilter implements IoFilter {


        @Override
        public void init() throws Exception {
            System.out.println("MyIoFilter: init");
        }

        @Override
        public void destroy() throws Exception {
            System.out.println("MyIoFilter: destroy");
        }

        @Override
        public void onPreAdd(IoFilterChain parent, String name, NextFilter nextFilter) throws Exception {
            System.out.println("MyIoFilter: onPreAdd");
        }

        @Override
        public void onPostAdd(IoFilterChain parent, String name, NextFilter nextFilter) throws Exception {
            System.out.println("MyIoFilter: onPostAdd");
        }

        @Override
        public void onPreRemove(IoFilterChain parent, String name, NextFilter nextFilter) throws Exception {
            System.out.println("MyIoFilter: onPreRemove");
        }

        @Override
        public void onPostRemove(IoFilterChain parent, String name, NextFilter nextFilter) throws Exception {
            System.out.println("MyIoFilter: onPostRemove");
        }

        @Override
        public void sessionCreated(NextFilter nextFilter, IoSession session) throws Exception {
            System.out.println("MyIoFilter: sessionCreated");
        }

        @Override
        public void sessionOpened(NextFilter nextFilter, IoSession session) throws Exception {
            System.out.println("MyIoFilter: sessionOpened");
        }

        @Override
        public void sessionClosed(NextFilter nextFilter, IoSession session) throws Exception {
            System.out.println("MyIoFilter :  sessionClosed");

        }

        @Override
        public void sessionIdle(NextFilter nextFilter, IoSession session, IdleStatus status) throws Exception {
            System.out.println("MyIoFilter: sessionIdle");
        }

        @Override
        public void exceptionCaught(NextFilter nextFilter, IoSession session, Throwable cause) throws Exception {
            System.out.println("MyIoFilter: exceptionCaught");
        }

        @Override
        public void inputClosed(NextFilter nextFilter, IoSession session) throws Exception {
            System.out.println("MyIoFilter: inputClosed");
            session.closeNow();
        }

        @Override
        public void messageReceived(NextFilter nextFilter, IoSession session, Object message) throws Exception {
            System.out.println("MyIoFilter: messageReceived");
        }

        @Override
        public void messageSent(NextFilter nextFilter, IoSession session, WriteRequest writeRequest) throws Exception {
            System.out.println("MyIoFilter: messageSent");
        }

        @Override
        public void filterClose(NextFilter nextFilter, IoSession session) throws Exception {
            System.out.println("MyIoFilter: filterClose");
        }

        @Override
        public void filterWrite(NextFilter nextFilter, IoSession session, WriteRequest writeRequest) throws Exception {
            System.out.println("MyIoFilter: filterWrite");
        }
    }
}
