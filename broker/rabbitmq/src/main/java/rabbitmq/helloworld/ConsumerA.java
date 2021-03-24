package rabbitmq.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import rabbitmq.RabbitMq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConsumerA {

    public static void main(String[] args) {

        ConnectionFactory connectionFactory = RabbitMq.init();

        try {
            Connection consumerA = connectionFactory.newConnection();

            Channel consumerChannel = consumerA.createChannel();

            consumerChannel.queueDeclare("hello", false, false, false, null);

            consumerChannel.basicConsume("hello", true, RabbitMq.helloWorldCallBack("ConsumerA"), consumerTag -> { });


        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
