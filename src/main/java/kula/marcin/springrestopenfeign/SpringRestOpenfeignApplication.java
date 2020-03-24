package kula.marcin.springrestopenfeign;

import kula.marcin.springrestopenfeign.service.TodoService;
import kula.marcin.springrestopenfeign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class SpringRestOpenfeignApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestOpenfeignApplication.class, args);
	}

	@Autowired
	private TodoService todoService;

	@Autowired
	private UserService userService;

	@Scheduled(fixedRate = 20000)
	private void scheduler() {
		userService.getUsers().forEach(u -> {
			System.out.println("User #" + u.getId() + " (" + u.getUsername() + ")");
			todoService.getTodosBy(u.getId()).forEach(t ->
					System.out.println(String.format("\t[%s] task: %s",
							t.isCompleted() ? "*" : " ",
							t.getTitle())));
		});
	}

	@Override
	public void run(String... args) throws Exception {
		scheduler();
	}
}
