package com.stpan.chitchat.mina;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 * Created by STPAN on 2016/4/3.
 */
public class MyProtocolEncoder implements ProtocolEncoder {
    public void encode(IoSession ioSession, Object o, ProtocolEncoderOutput protocolEncoderOutput) throws Exception {
        String s = null;
        if (o instanceof String){
            s = (String) o;
        }
        if (s!=null){
            CharsetEncoder charsetEncoder = (CharsetEncoder) ioSession.getAttribute("encoder");
            if (charsetEncoder==null){
                charsetEncoder = Charset.defaultCharset().newEncoder();
                ioSession.setAttribute("encoder",charsetEncoder);
            }
            IoBuffer ioBuffer = IoBuffer.allocate(s.length());
            ioBuffer.setAutoExpand(true);
            ioBuffer.putString(s,charsetEncoder);
            ioBuffer.flip();
            protocolEncoderOutput.write(ioBuffer);
        }
    }

    public void dispose(IoSession ioSession) throws Exception {

    }
}
