package george.taco_cloud.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    private Date createdAt = new Date();
    @NonNull
    @Size(min = 5, message = "at least 5 characters long")
    private String name;

    @NonNull
    @Size(min = 1, message = "at least 1 ingredient pls")
    @ManyToMany()
    private List<Ingredient> ingredients;

    public Taco() {
    }

    public Taco(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }
}
