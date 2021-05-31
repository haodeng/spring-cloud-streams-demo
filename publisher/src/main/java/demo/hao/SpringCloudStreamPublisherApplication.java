package demo.hao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
@EnableBinding(Source.class)
public class SpringCloudStreamPublisherApplication {

    @Autowired
    private Source source;;

    private static int messageDemoId = 1;

    @Scheduled(fixedDelay = 3000, initialDelay = 5000)
    public void run(){
        publish(new Hello(messageDemoId, "world"));
    }

    private void publish(Hello hello) {
        source.output().send(MessageBuilder.withPayload(hello).build());
        messageDemoId++;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStreamPublisherApplication.class, args);
    }

}
