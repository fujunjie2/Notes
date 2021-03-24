package rabbitmq.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import rabbitmq.RabbitMq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConsumerC {


    public static void main(String[] args) {

        ConnectionFactory connectionFactory = RabbitMq.init();

        try {
            Connection consumerC = connectionFactory.newConnection();

            Channel consumerChannel = consumerC.createChannel();

            consumerChannel.queueDeclare("hello", false, false, false, null);

            consumerChannel.basicConsume("hello", true, RabbitMq.helloWorldCallBack("ConsumerC"), consumerTag -> { });


        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
