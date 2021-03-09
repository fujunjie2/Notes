package test.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;

public class EchoServerHandler1 implements ChannelHandler {
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerAdded1");
    }

    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelRemoved1");
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

    }
}
