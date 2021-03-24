package rabbitmq.subcribe.routekey;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import rabbitmq.RabbitMq;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class Producer2 {

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
                channel.basicPublish("SubscribeDirect", "direct1#", null, message.getBytes(StandardCharsets.UTF_8));
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
