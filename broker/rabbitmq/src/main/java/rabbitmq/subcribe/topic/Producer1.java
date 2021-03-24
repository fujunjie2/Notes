package rabbitmq.subcribe.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import rabbitmq.RabbitMq;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 *   与 direct 一样，生产者 和消费者 channel 与 exchange 绑定，声明为 topic
 *   生产者发布消息的时候 指明 routeKey channel.basicPublish("SubscribeDirect", "direct#rtk", null, message.getBytes(StandardCharsets.UTF_8));
 *
 *   但是 消费者的 topic 的 routeKey，以一个 . 号分割， 如  insert.*  update.*  error.* 等
 *
 *    表示消费者 会消费 匹配 insert 或 update 或 error 开头的 routeKey 的队列的消息
 */

public class Producer1 {

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = RabbitMq.init();

        try {
            Connection con = connectionFactory.newConnection();

            Channel channel = con.createChannel();
            channel.exchangeDeclare("SubscribeTopic", "topic");
            channel.queueDeclare("TopicQueue",false,false,false,null);

            String template = "第 %s 个Topic信息";

            for(int i = 0; i < 10; i++) {
                String message = String.format(template, i);
                channel.basicPublish("SubscribeTopic", "topic#rtk", null, message.getBytes(StandardCharsets.UTF_8));
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
