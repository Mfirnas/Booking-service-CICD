package det.ey.bookingservice.bookingservice.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookingConsumer {

    @RabbitListener(queues = "booking_queue")
    public void consume(String message){
      System.out.println("message recived from consumer :"+message);
    }
}
