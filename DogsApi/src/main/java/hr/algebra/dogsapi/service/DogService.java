package hr.algebra.dogsapi.service;

import hr.algebra.dogsapi.payload.request.DogCommand;
import hr.algebra.dogsapi.payload.request.DogUpdateCommand;
import hr.algebra.dogsapi.dto.DogDTO;

import java.util.List;
import java.util.Optional;

public interface DogService {

    List<DogDTO> findAll();

    Optional<DogDTO> findByName(String dogName);

    Optional<DogDTO> save(DogCommand DogCommand);

    Optional<DogDTO> update(String dogName, DogUpdateCommand updatedDogCommand);

    void deleteByName(String dogName);

}
