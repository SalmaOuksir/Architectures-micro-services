package ma.houmam.accountservice;

import ma.houmam.accountservice.clients.CustomerRestClient;
import ma.houmam.accountservice.entities.BankAccount;
import ma.houmam.accountservice.enums.AccountType;
import ma.houmam.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(AccountServiceApplication.class, args);
    }
    @Bean
CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient){
      return args -> {
          customerRestClient.allCustomers().forEach(c-> {
                      BankAccount bankAccount1 =BankAccount.builder()
                              .accountId(UUID.randomUUID().toString())
                              .currency("MAD")
                              .type(AccountType.CURRENT_ACCOUNT)
                              .createAt(LocalDate.now())
                              .balance(Math.random()*7000)
                              .customerId(c.getId())
                              .build();
                      BankAccount bankAccount2=BankAccount.builder()
                              .accountId(UUID.randomUUID().toString())
                              .currency("USD")
                              .type(AccountType.SAVING_ACCOUNT)
                              .createAt(LocalDate.now())
                              .balance(Math.random()*5000)
                              .customerId(c.getId())
                              .build();
                      bankAccountRepository.save(bankAccount1);
                      bankAccountRepository.save(bankAccount2);
                  }
                  );

      };
}

}
