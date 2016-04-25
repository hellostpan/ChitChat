package com.stpan.chitchat.services;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.stpan.chitchat.mina.SessionUtil;
import com.stpan.chitchat.mina.SocketClient;

/**
 * 功能：
 * 创建时间:2016/4/5 21:39
 * 作者:pst
 */
public class MessageService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init(){
        start();
    }

    private void start(){
        if (SessionUtil.getInstance().getIoSession() !=null){
            return;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                SocketClient.getSocketClient().connectServer();
            }
        }).start();
        //heartbeat();
    }

    private void heartbeat(){
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (SessionUtil.getInstance().getIoSession()!=null){
                    SessionUtil.getInstance().sendHeartbeat();
                }
                handler.postDelayed(this,60000);
            }
        };
        handler.postDelayed(runnable,50000);
    }


}
