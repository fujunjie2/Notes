package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class NioServer {

    private static Selector selector;

    public final static int PORT = 8081;
    public final static int BUFF_SIZE = 10240;

    public static void main(String[] args) throws IOException{
        NioServer nioServer = new NioServer();
        nioServer.initServer();
    }


    private void initServer() throws IOException {

        this.selector = Selector.open();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(PORT));

        SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            // 阻塞方法
            int keyNumber = selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey nextKey = iterator.next();
                iterator.remove();

                if (nextKey.isAcceptable()) {
                    doAccept(nextKey);
                } else if (nextKey.isReadable()) {
                    doRead(nextKey);
                } else if (nextKey.isWritable()) {
                    doWrite(nextKey);
                } else if (nextKey.isConnectable()) {
                    doConnect(nextKey);
                }
            }

        }

    }

    public void doConnect(SelectionKey key) throws IOException{
        System.out.println("Conectable");

    }

    public void doAccept(SelectionKey key) throws IOException {
        ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
        System.out.println(key.isAcceptable());
        System.out.println("ServerSocketChannel正在循环监听");
        SocketChannel clientChannel = serverChannel.accept();
        System.out.println(clientChannel);

        if (clientChannel != null) {
            System.out.println(Thread.currentThread().getName());
            clientChannel.configureBlocking(false);
            clientChannel.register(key.selector(),SelectionKey.OP_READ);
        }
    }


    public void doRead(SelectionKey key) throws IOException {
        SocketChannel clientChannel = (SocketChannel) key.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(BUFF_SIZE);
        long bytesRead = clientChannel.read(byteBuffer);
        while (bytesRead>0){
            byteBuffer.flip();
            byte[] data = byteBuffer.array();
            String info = new String(data).trim();
            System.out.println("从客户端发送过来的消息是："+info);
            byteBuffer.clear();
            bytesRead = clientChannel.read(byteBuffer);
        }

        clientChannel.write(ByteBuffer.wrap("haha".getBytes(StandardCharsets.UTF_8)));

        if (bytesRead==-1){
            clientChannel.close();
        }
    }

    public void doWrite(SelectionKey key) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(BUFF_SIZE);
        byteBuffer.flip();
        SocketChannel clientChannel = (SocketChannel) key.channel();
        while (byteBuffer.hasRemaining()){
            clientChannel.write(byteBuffer);
        }
        byteBuffer.compact();
    }
}
