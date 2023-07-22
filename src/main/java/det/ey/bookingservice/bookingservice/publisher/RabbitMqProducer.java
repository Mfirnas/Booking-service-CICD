package det.ey.bookingservice.bookingservice.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqProducer {

    private RabbitTemplate rabbitTemplate;


    public RabbitMqProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message){
        System.out.println("message sent :"+message);

        rabbitTemplate.convertAndSend("booking_exchange","booking_key",message);
    }
}
