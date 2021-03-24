package rabbitmq.subcribe.routekey;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import rabbitmq.RabbitMq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConsumerDirectA {

    public static void main(String[] args) {

        ConnectionFactory connectionFactory = RabbitMq.init();

        try {
            Connection consumerA = connectionFactory.newConnection();

            Channel consumerChannel = consumerA.createChannel();

            // 消费者将自己的 channel 绑定到交换机上
            consumerChannel.exchangeDeclare("SubscribeDirect", "direct");

            String queueName = consumerChannel.queueDeclare().getQueue();

            consumerChannel.queueBind(queueName, "SubscribeDirect", "direct#rtk");


            consumerChannel.basicConsume(queueName, true, RabbitMq.helloWorldCallBack("ConsumerA"), consumerTag -> { });


        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
