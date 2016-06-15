package helloWorld;

import helloWorld.domain.Customer;
import helloWorld.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by arnavagarwal on 14/06/16.
 */

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        repository.deleteAll();
        repository.save(new Customer("Alice", "Smith", "123"));
        repository.save(new Customer("Bob", "Smith", "234"));
    }
}
