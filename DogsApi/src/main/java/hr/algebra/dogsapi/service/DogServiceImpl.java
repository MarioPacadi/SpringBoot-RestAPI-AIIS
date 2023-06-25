package hr.algebra.dogsapi.service;

import hr.algebra.dogsapi.command.DogCommand;
import hr.algebra.dogsapi.command.DogUpdateCommand;
import hr.algebra.dogsapi.domain.DogBreed;
import hr.algebra.dogsapi.dto.DogDTO;
import hr.algebra.dogsapi.repository.DogRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DogServiceImpl implements DogService {

    private final DogRepository dogRepository;

    public DogServiceImpl(DogRepository DogRepository) {
        this.dogRepository = DogRepository;
    }

    @Override
    public List<DogDTO> findAll() {
        return dogRepository.findAll().stream().map(DogDTO::new).collect(Collectors.toList());
    }

    @Override
    public Optional<DogDTO> findByName(String dogName) {
        return dogRepository.findByName(dogName).map(DogDTO::new);
    }

    @Override
    public Optional<DogDTO> save(DogCommand DogCommand) {
        return dogRepository
                .save(new DogBreed(DogCommand))
                .map(DogDTO::new);
    }

    @Override
    public Optional<DogDTO> update(String dogName, DogUpdateCommand updatedDogCommand) {
        return dogRepository
                .update(dogName, new DogBreed(updatedDogCommand))
                .map(Dog -> new DogDTO(dogName, Dog));
    }

    @Transactional
    @Override
    public void deleteByName(String dogName) {
        dogRepository.deleteByName(dogName);
    }
}
