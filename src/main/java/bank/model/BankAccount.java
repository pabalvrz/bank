package bank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Generated;

@Data
@Entity
public class BankAccount {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Holder Name is mandatory")
    private String holderName;

    @NotNull(message = "Money is mandatory")
    private Double money;
}
