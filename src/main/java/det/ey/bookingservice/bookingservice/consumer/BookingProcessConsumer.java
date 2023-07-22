package det.ey.bookingservice.bookingservice.consumer;

import det.ey.bookingservice.bookingservice.dto.BookingDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookingProcessConsumer {

    @RabbitListener(queues = "booking_dto_que")
    public void processBooking(BookingDto bookingDto){
    System.out.println("Data From Consumer :"+bookingDto);
    }
}
