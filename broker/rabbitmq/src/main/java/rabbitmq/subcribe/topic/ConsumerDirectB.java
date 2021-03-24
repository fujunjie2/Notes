package rabbitmq.subcribe.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import rabbitmq.RabbitMq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConsumerDirectB {

    public static void main(String[] args) {

        ConnectionFactory connectionFactory = RabbitMq.init();

        try {
            Connection consumerB = connectionFactory.newConnection();

            Channel consumerChannel = consumerB.createChannel();

            // 消费者将自己的 channel 绑定到交换机上
            consumerChannel.exchangeDeclare("SubscribeTopic", "topic");

            String queueName = consumerChannel.queueDeclare().getQueue();

            consumerChannel.queueBind(queueName, "SubscribeTopic", "topic#rtk");


            consumerChannel.basicConsume(queueName, true, RabbitMq.helloWorldCallBack("ConsumerB"), consumerTag -> { });


        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
