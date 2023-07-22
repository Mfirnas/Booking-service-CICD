package det.ey.bookingservice.bookingservice.controller;

import det.ey.bookingservice.bookingservice.dto.BookingDto;
import det.ey.bookingservice.bookingservice.publisher.BookingDtoProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/confirmation")
public class BookingProcessController {

    private BookingDtoProducer producer;

    public BookingProcessController(BookingDtoProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/process")
    public ResponseEntity<String> processBookingConfirmation(@RequestBody BookingDto dto){
      producer.publishBookingDto(dto);
      return  ResponseEntity.ok("Booking DTO sent to booking_exchange");
    }
}
