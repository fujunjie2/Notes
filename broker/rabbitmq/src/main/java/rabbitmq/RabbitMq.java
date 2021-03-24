package rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import rabbit.helloword.Consumer;

import java.time.LocalTime;

public class RabbitMq {

    public static ConnectionFactory init() {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost("192.168.0.50");
        connectionFactory.setPort(5672);
//        connectionFactory.setPassword("123456");
//        connectionFactory.setUsername("guest");

        return connectionFactory;
    }


    public static DeliverCallback helloWorldCallBack(String consumer) {
        DeliverCallback callback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println("consumer" + consumer +": " + LocalTime.now() + message);
        };

        return callback;
    }
    // 限制消费者一次消费的消息数，并且将 channel 的自动确认改为手动确认，中间件才会根据消费者处理消息的能力分发消息
    public static DeliverCallback workerCostCallBack(Channel channel, String consumer, int waitSecond) {
        DeliverCallback callback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println("consumer" + consumer +": " + LocalTime.now() + message);
            try {
                Thread.sleep(waitSecond * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            }
        };

        return callback;
    }
}
