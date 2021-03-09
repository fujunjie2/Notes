package rabbit.exchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import rabbit.EnumExchangeType;
import rabbit.Rb;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeoutException;

public class Producer {

    public static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws Exception {


        Channel channel = Rb.init();

        channel.exchangeDeclare(EXCHANGE_NAME, EnumExchangeType.FANOUT.getExchangeTypeName());

        String message = "hello fanout ";

        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes(Charset.forName("utf-8")));

    }
}
