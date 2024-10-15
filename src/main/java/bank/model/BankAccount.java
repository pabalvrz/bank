package bank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Generated;

@Data
@Entity
public class BankAccount {

    @Id
    @GeneratedValue
    private Long id;
    private String holderName;
    private Double money;
}
