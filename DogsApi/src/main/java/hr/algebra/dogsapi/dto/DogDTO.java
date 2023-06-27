package hr.algebra.dogsapi.dto;

import hr.algebra.dogsapi.models.DogBreed;

public class DogDTO {

    private final Long id;
    private final String breedName;
    private final String breedType;
    private final String breedDescription;

    public DogDTO(DogBreed dog) {
        this.id=dog.getId();
        this.breedName=dog.getBreedName();
        this.breedType=dog.getBreedType();
        this.breedDescription= dog.getBreedDescription();
    }

    public DogDTO(String breedName,DogBreed dog) {
        this.id=dog.getId();
        this.breedName=breedName;
        this.breedType=dog.getBreedType();
        this.breedDescription= dog.getBreedDescription();
    }

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

    @Override
    public String toString() {
        return "DogDTO{" +
                "breedName='" + breedName + '\'' +
                ", breedType='" + breedType + '\'' +
                ", breedDescription='" + breedDescription + '\'' +
                '}';
    }
}
