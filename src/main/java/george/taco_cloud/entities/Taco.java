package george.taco_cloud.entities;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class Taco {


    @NonNull
    @Size(min = 5, message = "at least 5 characters long")
    private String name;

    @NonNull
    @Size(min = 1, message = "at least 1 ingredient pls")
    private List<Ingredients> ingredients;
}
