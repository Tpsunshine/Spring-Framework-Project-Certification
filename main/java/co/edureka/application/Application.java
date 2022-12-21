package co.edureka.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import co.edureka.application.repository.LoginRepository;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("co.edureka")
public class Application {

	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		//LoginRepository loginReo  = context.getBean(LoginRepository.class);
		
	}

}
