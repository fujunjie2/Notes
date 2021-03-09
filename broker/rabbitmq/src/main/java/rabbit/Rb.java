package rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import rabbit.helloword.Consumer;

import java.time.LocalTime;

public class Rb {

    public static String HOST = "192.168.1.223";

    public static boolean DURABLE = false;

    public static boolean AUTO_ACK = false;

    public static boolean EXCLUSIVE = false;

    public static boolean AUTO_DELETE = false;


    public static  ConnectionFactory getFactory() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Rb.HOST);
        factory.setPassword("123456");
        factory.setUsername("guest");

        return factory;
    }

    public static Channel init() throws Exception{
        ConnectionFactory factory = getFactory();

        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

        return channel;
    }

    public static DeliverCallback defaultCallBack (Channel channel, String consumer) {
        DeliverCallback callback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println("consumer" + consumer +": " + LocalTime.now() + message);
            Consumer.sleep(1000);
        };

        return callback;
    }



}
