package det.ey.bookingservice.bookingservice.publisher;

import det.ey.bookingservice.bookingservice.dto.BookingDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookingDtoProducer {

    private RabbitTemplate rabbitTemplate;

    public BookingDtoProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public  void publishBookingDto(BookingDto bookingDto){
        System.out.println("Booking DTO set to Exchange :"+bookingDto);
        rabbitTemplate.convertAndSend("booking_exchange","booking_json_key",bookingDto);
    }
}
