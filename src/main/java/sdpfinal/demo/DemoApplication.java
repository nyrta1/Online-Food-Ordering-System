package sdpfinal.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sdpfinal.demo.controllers.SystemController;
import sdpfinal.demo.jdbc_database_control.DatabaseConfig;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired private SystemController systemController;
	public static void main(String[] args) {
		DatabaseConfig.testingTheDatabase();
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		systemController.managementSystem();
	}
}
