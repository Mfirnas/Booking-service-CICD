package det.ey.bookingservice.bookingservice.controller;

import det.ey.bookingservice.bookingservice.publisher.RabbitMqProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {

    private RabbitMqProducer producer;

    public BookingController(RabbitMqProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/process")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){

          System.out.println(message +"from booking service rabbitMQ");
        producer.sendMessage(message);
        return  ResponseEntity.ok("message sent to exchange :"+message);
    }
}
