package core;

import lombok.RequiredArgsConstructor;
import core.entities.AppUser;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import core.service.impl.UserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@RequiredArgsConstructor
@EnableAutoConfiguration
@CrossOrigin(origins = "http://localhost:4200")
public class App implements CommandLineRunner {

  final UserService userService;

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

  
  @Override
  public void run(String... params) throws Exception {
    AppUser admin = new AppUser();
    admin.setId(1);
    admin.setUserName("admin");
    admin.setLastName("ortiz");
    admin.setFirstName("jesus");
    admin.setPassword("admin");
    admin.setEmail("admin@email.com");
    admin.setRoles("ROLE_ADMIN");

  //  userService.signup(admin);

    AppUser client = new AppUser();
    client.setId(2);
    client.setUserName("client");
    client.setLastName("enzo");
    client.setFirstName("ortiz");
    client.setPassword("client");
    client.setEmail("client@email.com");
    client.setRoles("ROLE_CLIENT");

 //   userService.signup(client);
  }

}
