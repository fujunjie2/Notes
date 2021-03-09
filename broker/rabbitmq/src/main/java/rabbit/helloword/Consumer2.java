package rabbit.helloword;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import rabbit.Rb;

import java.time.LocalTime;

public class Consumer2 {

    private static final String QUEUE_NAME = "hello";


    public static void main(String[] args) throws Exception{

        Connection connection = Rb.getFactory().newConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, Rb.DURABLE, Rb.EXCLUSIVE, Rb.AUTO_DELETE, null);

        DeliverCallback callback = (consumerTag, delivery) -> {
            try {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println("consumer2: " + LocalTime.now() + message);
                Consumer.sleep(1000);
            } finally {
                System.out.println(" [x] Done");
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            }


        };

        channel.basicConsume(QUEUE_NAME, Rb.AUTO_ACK, callback, consumerTag -> {});
    }
}
