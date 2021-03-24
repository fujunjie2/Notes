package rabbitmq.worker;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import rabbitmq.RabbitMq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConsumerB {

    public static void main(String[] args) {

        ConnectionFactory connectionFactory = RabbitMq.init();

        try {
            Connection consumerB = connectionFactory.newConnection();

            Channel consumerChannel = consumerB.createChannel();

            // 设置每个消费者同时只能消费一条消息
            consumerChannel.basicQos(1);

            consumerChannel.queueDeclare(Producer.QUEUE_NAME, false, false, false, null);

            consumerChannel.basicConsume(Producer.QUEUE_NAME, false, RabbitMq.workerCostCallBack(consumerChannel, "ConsumerB", 0), consumerTag -> { });


        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
