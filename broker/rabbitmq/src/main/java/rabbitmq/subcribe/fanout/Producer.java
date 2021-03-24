package rabbitmq.subcribe.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import rabbitmq.RabbitMq;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 *  订阅之 fanout， 生产者和消费者 channel 绑定到 exchange，
 *
 *  生产者 ：   Channel channel = con.createChannel();
 *             channel.exchangeDeclare("SubscribeFanout", "fanout");
 *             channel.queueDeclare("fanoutQueue",false,false,false,null);
 *  消费者：
 *             consumerChannel.exchangeDeclare("SubscribeFanout", "fanout");
 *             String queueName = consumerChannel.queueDeclare().getQueue();
 *             consumerChannel.queueBind(queueName, "SubscribeFanout", "");
 *             consumerChannel.basicConsume(queueName, true, RabbitMq.helloWorldCallBack("ConsumerC"), consumerTag -> { });
 *
 *  这种操作可以 让每个消费者 都订阅到生产的所有消息。
 *  生产者生产一个消息，则每个消费者都能 消费到一个消息
 *  典型的订阅模式
 */

public class Producer {

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = RabbitMq.init();

        try {
            Connection con = connectionFactory.newConnection();

            Channel channel = con.createChannel();
            channel.exchangeDeclare("SubscribeFanout", "fanout");
            channel.queueDeclare("fanoutQueue",false,false,false,null);

            String template = "第 %s 个信息";

            for(int i = 0; i < 10; i++) {
                String message = String.format(template, i);
                channel.basicPublish("SubscribeFanout", "", null, message.getBytes(StandardCharsets.UTF_8));
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
