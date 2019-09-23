package latihan.putri.maven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BiodataApplication {
	public static void main(String[] args) {
		SpringApplication.run(BiodataApplication.class, args);
	}
}