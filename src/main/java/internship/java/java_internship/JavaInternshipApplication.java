package internship.java.java_internship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class JavaInternshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaInternshipApplication.class,  args);
	}

}
