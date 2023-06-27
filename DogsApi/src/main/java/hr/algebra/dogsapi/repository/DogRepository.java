package hr.algebra.dogsapi.repository;

import hr.algebra.dogsapi.models.DogBreed;

import java.util.Optional;
import java.util.Set;

public interface DogRepository {

    Set<DogBreed> findAll();

    Optional<DogBreed> findByName(String dogName);

    Optional<DogBreed> save(DogBreed DogBreed);

    Optional<DogBreed> update(String dogName, DogBreed updatedDogBreed);

    void deleteByName(String dogName);
}
