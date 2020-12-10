package core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import core.domain.service.IPersonService;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

    private static final Logger LOG =LoggerFactory.getLogger(SpringBootConsoleApplication.class);
    
    @Autowired
    private IPersonService iPersonService;
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

       iPersonService.addPerson("JESUS");
    }

}
