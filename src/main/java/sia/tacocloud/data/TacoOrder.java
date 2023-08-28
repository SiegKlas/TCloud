package sia.tacocloud.data;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Table
public class TacoOrder implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private Date placedAt = new Date();

    @NotBlank(message = "Delivery name is required")
    @Size(min = 2, max = 50, message = "Name must be between {min} and {max} characters")
    private String deliveryName;

    @NotBlank(message = "Street is required")
    @Size(min = 2, max = 50, message = "Street must be between {min} and {max} characters")
    private String deliveryStreet;

    @NotBlank(message = "City is required")
    @Size(min = 2, max = 50, message = "City must be between {min} and {max} characters")
    private String deliveryCity;

    @NotBlank(message = "State is required")
    @Size(min = 2, max = 50, message = "State must be between {min} and {max} characters")
    private String deliveryState;

    @NotBlank(message = "Zip code is required")
    @Size(min = 6, max = 10, message = "Zip code must be between {min} and {max} characters")
    private String deliveryZip;

    @CreditCardNumber(message = "Not a valid credit card number")
    @Digits(integer = 16, fraction = 0, message = "Zip code must be {integer} characters")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])(/)([2-9][0-9])$", message = "Must be formatted MM/YY")
    @Size(min = 5, max = 5, message = "Date must be {min} characters")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}
