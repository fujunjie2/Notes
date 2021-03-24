package rabbitmq.subcribe.routekey;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import rabbitmq.RabbitMq;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 *   与 fanout 不同的是，生产者 和消费者 channel 与 exchange 绑定，声明为 direct
 *   生产者发布消息的时候 指明 routeKey channel.basicPublish("SubscribeDirect", "direct#rtk", null, message.getBytes(StandardCharsets.UTF_8));
 *
 *   消费者 消费消息的时候，可以指定 routeKey ，则对于同一个 exchange，同一个 队列，只有routeKey符合，消费者才会收到消息
 *
 *
 */

public class Producer {

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = RabbitMq.init();

        try {
            Connection con = connectionFactory.newConnection();

            Channel channel = con.createChannel();
            channel.exchangeDeclare("SubscribeDirect", "direct");
            channel.queueDeclare("DirectQueue",false,false,false,null);

            String template = "第 %s 个Direct信息";

            for(int i = 0; i < 10; i++) {
                String message = String.format(template, i);
                channel.basicPublish("SubscribeDirect", "direct#rtk", null, message.getBytes(StandardCharsets.UTF_8));
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
