package rabbitmq.worker;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import rabbitmq.RabbitMq;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 *   rabbitmq 消息确认机制，默认是消息从队列中取出，就确认接收，但实际上是有可能取出还没消费，消费者就挂掉了，
 *   所以自动确认是有缺陷的。
 *
 *   中间件的消息分发机制默认是轮询的。不会考虑消费者的消费能力。
 *   如果要考虑消费者的能力 分发消息，首先需要限制消费者一次消费消息的次数，其次要将自动确认改为手动确认。
 *
 */

public class Producer {

    public static String QUEUE_NAME = "worker";

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = RabbitMq.init();

        try {
            Connection con = connectionFactory.newConnection();

            Channel channel = con.createChannel();
            // 设置每个消费者同时只能消费一条消息

            channel.queueDeclare("hello",false,false,false,null);

            String template = "第 %s 个信息";

            for(int i = 0; i < 10000; i++) {
                String message = String.format(template, i);
                channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
                System.out.println("send message:  " + message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
