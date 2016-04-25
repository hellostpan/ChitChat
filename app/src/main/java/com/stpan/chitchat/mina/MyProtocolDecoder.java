package com.stpan.chitchat.mina;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import java.nio.charset.Charset;

/**
 * Created by STPAN on 2016/4/3.
 */
public class MyProtocolDecoder implements ProtocolDecoder {
    public void decode(IoSession ioSession, IoBuffer ioBuffer, ProtocolDecoderOutput protocolDecoderOutput) throws Exception {
        while (ioBuffer.hasRemaining()) {
            byte[] bytes = new byte[ioBuffer.limit()];
            ioBuffer.get(bytes);
            String s = new String(bytes, Charset.forName("UTF-8"));
            protocolDecoderOutput.write(s);
        }
    }

    public void finishDecode(IoSession ioSession, ProtocolDecoderOutput protocolDecoderOutput) throws Exception {

    }

    public void dispose(IoSession ioSession) throws Exception {

    }
}
