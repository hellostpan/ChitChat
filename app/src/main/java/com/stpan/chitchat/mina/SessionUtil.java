package com.stpan.chitchat.mina;


import com.google.gson.Gson;

import org.apache.mina.core.session.IoSession;

/**
 * Created by STPAN on 2016/4/3.
 */
public class SessionUtil {
    private static SessionUtil sessionUtil = null;
    private IoSession ioSession;
    private Gson gson = null;
    private Result result = null;
    private SessionUtil() {
    }

    public static SessionUtil getInstance() {

        if (sessionUtil == null) {
            synchronized (SessionUtil.class){
                if (sessionUtil==null){
                    sessionUtil = new SessionUtil();
                }
            }
        }
        return sessionUtil;
    }

    public IoSession getIoSession() {
        return ioSession;
    }

    public void setIoSession(IoSession ioSession) {
        this.ioSession = ioSession;
        if (gson==null){
            gson = new Gson();
        }
    }

    public void sendMessage(String to, final Object message) {
        if (ioSession==null){
            SocketClient.getSocketClient().connectServer();
        }else if (!ioSession.isConnected()){
            ioSession = null;
            SocketClient.getSocketClient().connectServer();
        }else {
            result = new Result();
            //result.setFrom(MyApplication.getInstance().getUserId());
            result.setTo(to);
            result.setCode("2");
            result.setMessage(message.toString());
            ioSession.write(gson.toJson(result));
        }
    }

    public void sendHeartbeat(){
        ioSession.write("1");
    }

}
