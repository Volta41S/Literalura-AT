package LiterAlura_AT.com.alura.challege.literalura;

import LiterAlura_AT.com.alura.challege.literalura.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args)throws Exception {
		Principal principal = new Principal();
		principal.verElMenu();
	}
}
