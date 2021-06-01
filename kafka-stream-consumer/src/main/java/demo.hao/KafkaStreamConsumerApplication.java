package demo.hao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
public class KafkaStreamConsumerApplication {

    @Bean
    public Consumer<String> consumer() {
        return input -> System.out.println(input);
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaStreamConsumerApplication.class, args);
    }

}
