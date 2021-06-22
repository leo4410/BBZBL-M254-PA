package ch.bbzbl.m254;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String helloWorld() {
        String returnString = "Hello World!";
        return returnString;
    }

    @PostMapping("/hello")
    public String helloName(@RequestBody String name) {
        String returnString = "Hello " + name + "!";
        return returnString;
    }
}
            