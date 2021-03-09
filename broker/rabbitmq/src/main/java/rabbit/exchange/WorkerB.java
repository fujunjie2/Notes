package rabbit.exchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import rabbit.EnumExchangeType;
import rabbit.Rb;

public class WorkerB {

    public static void main(String[] args) throws Exception{
        Channel channel = Rb.init();

        channel.exchangeDeclare(Producer.EXCHANGE_NAME, EnumExchangeType.FANOUT.getExchangeTypeName());

        String queueName = channel.queueDeclare().getQueue();

        System.out.println("B: --" + queueName);

        channel.queueBind(queueName, Producer.EXCHANGE_NAME, "");

        DeliverCallback deliverCallback = Rb.defaultCallBack(channel, "B");

        channel.basicConsume(queueName, !Rb.AUTO_ACK, deliverCallback, consumerTag -> {});
    }
}
