package rabbit.helloword;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import rabbit.Rb;

public class Producer {

    private static final String QUEUE_NAME ="hello";

    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = Rb.getFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();


        channel.queueDeclare(QUEUE_NAME, Rb.DURABLE, Rb.EXCLUSIVE, Rb.AUTO_DELETE, null);

        int count = 1;
        while (count <= 10) {
            String message = "第" + count++ + "个消息";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        }



    }
}
