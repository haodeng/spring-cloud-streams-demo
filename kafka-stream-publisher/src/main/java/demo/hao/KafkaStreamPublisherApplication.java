package demo.hao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Supplier;

@SpringBootApplication
public class KafkaStreamPublisherApplication {
    private static int messageDemoId = 1;

    @Bean
    public Supplier<String> supplier() {
        return () -> {
            return new Hello(messageDemoId++, "world").toString();
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaStreamPublisherApplication.class, args);
    }

}
