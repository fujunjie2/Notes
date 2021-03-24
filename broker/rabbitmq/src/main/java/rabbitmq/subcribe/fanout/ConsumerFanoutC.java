package rabbitmq.subcribe.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import rabbitmq.RabbitMq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConsumerFanoutC {


    public static void main(String[] args) {

        ConnectionFactory connectionFactory = RabbitMq.init();

        try {
            Connection consumerC = connectionFactory.newConnection();

            Channel consumerChannel = consumerC.createChannel();

            // 消费者将自己的 channel 绑定到交换机上
            consumerChannel.exchangeDeclare("SubscribeFanout", "fanout");

            String queueName = consumerChannel.queueDeclare().getQueue();

            consumerChannel.queueBind(queueName, "SubscribeFanout", "");


            consumerChannel.basicConsume(queueName, true, RabbitMq.helloWorldCallBack("ConsumerC"), consumerTag -> { });


        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
