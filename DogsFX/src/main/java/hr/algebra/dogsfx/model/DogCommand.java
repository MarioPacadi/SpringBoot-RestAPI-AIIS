package hr.algebra.dogsfx.model;

public class DogCommand {
    private String breedName;

    private String breedType;
    private String breedDescription;

    public DogCommand(DogBreed dog) {
        this.breedName = dog.getBreedName();
        this.breedType = dog.getBreedType();
        this.breedDescription = dog.getBreedDescription();
    }

    public DogCommand() {

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

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    public void setBreedType(String breedType) {
        this.breedType = breedType;
    }

    public void setBreedDescription(String breedDescription) {
        this.breedDescription = breedDescription;
    }
}
