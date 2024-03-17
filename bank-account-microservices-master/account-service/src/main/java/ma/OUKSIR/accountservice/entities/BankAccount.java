package ma.houmam.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.houmam.accountservice.enums.AccountType;
import ma.houmam.accountservice.model.Customer;

import java.time.LocalDate;
@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;
}
