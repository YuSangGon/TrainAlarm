package project.trainalarm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class TrainalarmApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainalarmApplication.class, args);
	}

}
