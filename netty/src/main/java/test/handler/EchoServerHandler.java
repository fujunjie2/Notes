package test.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;


public class EchoServerHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private byte[] result = new byte[]{'H', 'e', 'l', 'l', 'o'};

    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        System.out.println(msg.toString(CharsetUtil.UTF_8));

        ctx.write(Unpooled.copiedBuffer(result));
        ctx.flush();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }
}
