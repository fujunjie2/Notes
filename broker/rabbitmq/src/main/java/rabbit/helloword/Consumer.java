package rabbit.helloword;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;
import rabbit.Rb;

import java.time.LocalTime;

public class Consumer {

    private static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception{
        Connection connection = Rb.getFactory().newConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, Rb.DURABLE, Rb.EXCLUSIVE, Rb.AUTO_DELETE, null);
        /**
         * 单独设置该参数无效, 设置之后, 该消费者仍然平均地收到 n-th 个消息
         * 需要 将 auto_ack 设置为 false , 并且 手动确认(basicConsume)
         */
        channel.basicQos(1);
        DeliverCallback callback = (consumerTag, delivery) -> {
            try {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println("consumer1: " + LocalTime.now() +message);
                sleep(5000);
            } finally {
                System.out.println(" [x] Done");
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            }

        };

        channel.basicConsume(QUEUE_NAME, Rb.AUTO_ACK, callback, consumerTag -> {});
    }

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

        }
    }
}
