package com.stpan.chitchat.mina;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

/**
 * Created by STPAN on 2016/4/3.
 */
public class MyProtocolCodecFactory implements ProtocolCodecFactory {
    private MyProtocolDecoder decoder;
    private MyProtocolEncoder encoder;

    public MyProtocolCodecFactory() {
        decoder = new MyProtocolDecoder();
        encoder = new MyProtocolEncoder();
    }

    public ProtocolEncoder getEncoder(IoSession ioSession) throws Exception {
        return encoder;
    }

    public ProtocolDecoder getDecoder(IoSession ioSession) throws Exception {
        return decoder;
    }
}
