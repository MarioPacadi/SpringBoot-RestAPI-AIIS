package hr.algebra.dogsapi.controller;

import hr.algebra.dogsapi.dto.DogDTO;
import hr.algebra.dogsapi.payload.request.DogCommand;
import hr.algebra.dogsapi.payload.request.DogUpdateCommand;
import hr.algebra.dogsapi.service.DogService;
import org.springframework.http.HttpStatus;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("dog")
//@CrossOrigin(origins = "http://localhost:4200")
public class DogController {

    private final DogService dogService;

    private final JmsTemplate jmsTemplate;

    public DogController(DogService DogService, JmsTemplate jmsTemplate) {
        this.dogService = DogService;
        this.jmsTemplate = jmsTemplate;
    }

    @GetMapping
    public List<DogDTO> getAll() {
        return dogService.findAll();
    }

//    @GetMapping("{breedName}")
//    public DogDTO getByName(@PathVariable final String breedName) {
//        return dogService.findByName(breedName)
//                .orElseThrow(
//                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dog was not found by that breedName")
//                );
//    }

    @GetMapping("{id}")
    public DogDTO getByBreedName(@RequestParam final String breedName, @PathVariable String id) {
        return dogService.findByName(breedName)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dog was not found by that breedName")
                );
    }

//    @Secured("ADMIN")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public DogDTO save(@Valid @RequestBody final DogCommand command){
//        jmsTemplate.convertAndSend(
//                "Saving the Dog "+ command.getBreedName() + " to the database.");
        return dogService.save(command)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Dog with the same breedName already exists"));
    }

//    @Secured("ADMIN")
    @PutMapping("{breedName}")
    public DogDTO update(@PathVariable String breedName, @Valid @RequestBody final DogUpdateCommand updatedDogCommand){
        return dogService.update(breedName, updatedDogCommand)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dog was not found by that breedName")
                );
    }

    @Secured("ADMIN")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{breedName}")
    public void delete(@PathVariable String breedName){
        dogService.deleteByName(breedName);
    }

}
