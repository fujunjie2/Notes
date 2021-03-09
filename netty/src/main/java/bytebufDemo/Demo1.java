package bytebufDemo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;
import java.util.Arrays;

public class Demo1 {


    public static void main(String[] args) {


        byte[] demoByte = "中".getBytes();

//        for(byte k : demoByte) {
//            System.out.println(Integer.toBinaryString((int) k) + " " + k);
//        }

        ByteBuf byteBuf = Unpooled.buffer(10);

        byteBuf.writeBytes(demoByte);
//
        int len = byteBuf.readableBytes();

        System.out.println(byteBuf.toString(CharsetUtil.UTF_8));

    }
}
