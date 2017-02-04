package happkidoAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        DataManager.getInstance(args[0]);
        SpringApplication.run(Application.class, args);
    }
}