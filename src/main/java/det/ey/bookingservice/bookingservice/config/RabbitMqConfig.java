package det.ey.bookingservice.bookingservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    //spring bean for rabbitmq
    @Bean
    public Queue queue(){
        return new Queue("booking_queue");
    }

    @Bean
    public Queue jsonQue(){
        return  new Queue("booking_dto_que");
    }

    //spring bean for rabbitmq
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("booking_exchange");
    }

    //spring bean for rabbitmq binding
    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with("booking_key");
    }

    public  Binding jsonBinding(){

        return BindingBuilder
                .bind(jsonQue())
                .to(exchange())
                .with("booking_json_key");
    }

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
