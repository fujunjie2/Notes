package rabbit.exchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import rabbit.EnumExchangeType;
import rabbit.Rb;

public class WorkerA {

    public static void main(String[] args) throws Exception{

        Channel channel = Rb.init();

        channel.exchangeDeclare(Producer.EXCHANGE_NAME, EnumExchangeType.FANOUT.getExchangeTypeName());

        String queueName = channel.queueDeclare().getQueue();

        System.out.println("A: --" + queueName);

        channel.queueBind(queueName, Producer.EXCHANGE_NAME, "");

        DeliverCallback deliverCallback = Rb.defaultCallBack(channel, "A");

        channel.basicConsume(queueName, !Rb.AUTO_ACK, deliverCallback, consumerTag -> {});



    }
}
