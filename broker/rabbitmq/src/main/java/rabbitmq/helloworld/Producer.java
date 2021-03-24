package rabbitmq.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import rabbitmq.RabbitMq;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 *  channel 直接绑定 到 queue， 多个消费者 轮流消费消息
 *
 *
 */

public class Producer {

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = RabbitMq.init();

        try {
            Connection con = connectionFactory.newConnection();

            Channel channel = con.createChannel();

            channel.queueDeclare("hello",false,false,false,null);

            String template = "第 %s 个信息";

            for(int i = 0; i < 10; i++) {
                String message = String.format(template, i);
                channel.basicPublish("", "hello", null, message.getBytes(StandardCharsets.UTF_8));
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
