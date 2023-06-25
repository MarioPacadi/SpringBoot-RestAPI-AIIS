package hr.algebra.dogsfx.model;

import java.util.Objects;

public class DogBreed {

    private Long id;
    private String breedName;
    private String breedType;
    private String breedDescription;
    private String furColor;
    private String origin;
    private double minHeightInches;
    private double maxHeightInches;
    private double minWeightPounds;
    private double maxWeightPounds;
    private int minLifeSpan;
    private int maxLifeSpan;
    private String imgThumb;
    private String imgSourceURL;
    private String imgAttribution;

    private boolean imgCreativeCommons;

    public DogBreed() {

    }

    public DogBreed(String breedName, String breedType, String breedDescription) {
        this.breedName = breedName;
        this.breedType = breedType;
        this.breedDescription = breedDescription;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DogBreed dogBreed)) return false;
        return Objects.equals(getBreedName(), dogBreed.getBreedName()) && Objects.equals(getBreedType(), dogBreed.getBreedType()) && Objects.equals(getBreedDescription(), dogBreed.getBreedDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBreedName(), getBreedType(), getBreedDescription());
    }

    @Override
    public String toString() {
        return "DogBreed{" +
                "breedName='" + breedName + '\'' +
                ", breedType='" + breedType + '\'' +
                ", breedDescription='" + breedDescription + '\'' +
                '}';
    }
}

