package george.taco_cloud.stufftoorder;

import george.taco_cloud.entities.Taco;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class TacoOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date placedAt;

    @NotBlank(message = "Required delivery name")
    private String deliveryName;
    @NotBlank(message = "street required")
    private String deliveryStreet;

    @NotBlank(message = "delivery city needed")
    private String deliveryCity;
    @NotBlank(message = "delivery state neeeded")
    private String deliveryState;
    @NotBlank(message = "delivery zip neededed")
    private String deliveryZip;
    @CreditCardNumber(message = "not a valid credit card")
    private String ccNumber;
    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",
            message="Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;


    //cascade allows recursive deletion
    @OneToMany(cascade = CascadeType.ALL)
    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        tacos.add(taco);
    }
}
