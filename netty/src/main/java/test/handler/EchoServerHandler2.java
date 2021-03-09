package test.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;

public class EchoServerHandler2 implements ChannelInboundHandler {
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelRegistered();
        System.out.println("Registered2");
    }

    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Unregistered2");
    }

    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("active2");
    }

    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("inactive2");
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("read2");
    }

    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("complete2-");
    }

    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        System.out.println("triggered2");
    }

    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelWritabilityChanged2");
    }

    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerAdded2");
    }

    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerRemoved2");
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

    }
}
