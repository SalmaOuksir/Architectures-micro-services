package ma.houmam.accountservice.web;

import ma.houmam.accountservice.clients.CustomerRestClient;
import ma.houmam.accountservice.entities.BankAccount;
import ma.houmam.accountservice.model.Customer;
import ma.houmam.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankAccountRestController {
   private BankAccountRepository bankAccountRepository;
   private CustomerRestClient customerRestClient;


    public BankAccountRestController(BankAccountRepository bankAccountRepository,CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }
    @GetMapping("/accounts")
    public List<BankAccount> accountList(){

        List<BankAccount> accountList= bankAccountRepository.findAll();
        accountList.forEach(acc -> {
            acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()));

        });
        return accountList;
    }
    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountbyId(@PathVariable String id){

        BankAccount bankAccount= bankAccountRepository.findById(id).get();
        Customer customer= customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
