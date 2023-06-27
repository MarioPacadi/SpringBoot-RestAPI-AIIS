package hr.algebra.dogsapi.payload.request;

import javax.validation.constraints.*;

public class DogUpdateCommand {

    @PositiveOrZero(message = "Id must be positive or zero")
    private Long id;
    @NotBlank(message = "Name must not be empty")
    @Size(max = 200, message = "Name can't have more than 200 characters")
    private String breedName;

    @NotNull(message = "Must be a type of DOG")
    private String breedType;
    private String breedDescription;

    public Long getId() {
        return id;
    }

    public String getBreedName() {
        return breedName;
    }

    public String getBreedType() {
        return breedType;
    }

    public String getBreedDescription() {
        return breedDescription;
    }
}
