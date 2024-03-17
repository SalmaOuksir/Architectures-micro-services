package ma.houmam.customerservice;

import ma.houmam.customerservice.config.GlobalConfig;
import ma.houmam.customerservice.entities.Customer;
import ma.houmam.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
			List<Customer> customerList=List.of(
					Customer.builder()
							.firstName("Amine")
							.lastName("Houmam")
							.email("amine@gmail.com")
							.build(),
					Customer.builder()
							.firstName("Saad")
							.lastName("Aboufariss")
							.email("saad@gmail.com")
							.build(),
					Customer.builder()
							.firstName("Youssef")
							.lastName("Bouafia")
							.email("youssef@gmail.com")
							.build()


			);


			customerRepository.saveAll(customerList);
		};
	}

}
