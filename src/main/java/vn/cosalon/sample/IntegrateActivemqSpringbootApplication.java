package vn.cosalon.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class IntegrateActivemqSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntegrateActivemqSpringbootApplication.class, args);
    }

}
