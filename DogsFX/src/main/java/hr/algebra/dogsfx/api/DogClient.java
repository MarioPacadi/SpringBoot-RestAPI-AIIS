package hr.algebra.dogsfx.api;

import com.google.gson.Gson;
import hr.algebra.dogsfx.model.DogBreed;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import hr.algebra.dogsfx.model.DogCommand;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import hr.algebra.dogsfx.helper.Alerts;
public class DogClient {

    private final String baseUrl="http://localhost:8081/dog/";

    private final HttpHeaders headers = new HttpHeaders() {{
        setContentType(MediaType.APPLICATION_JSON);
    }};

    public List<DogBreed> getAllDogs() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<DogBreed[]> DogArrayResponse =
                restTemplate.getForEntity(baseUrl, DogBreed[].class);

        for(DogBreed dog : Objects.requireNonNull(DogArrayResponse.getBody())) {
            System.out.println("Dog breed: " + dog.getBreedName());
            System.out.println("Breed type: " + dog.getBreedType());
            System.out.println("Dog description: " + dog.getBreedDescription());
            System.out.println("-----------------------------");
        }

        DogBreed[] DogArray = DogArrayResponse.getBody();
        return Arrays.asList(DogArray);
    }

    public void saveDog(DogBreed dog) {
        Alerts.checkName(dog.getBreedName());

        RestTemplate restTemplate = new RestTemplate();

        DogCommand newDog = new DogCommand(dog);

        String requestJson = new Gson().toJson(newDog);
        System.out.println(requestJson);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestJson, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(baseUrl, requestEntity, String.class);
        System.out.println("POST RESPONSE: " + response.getStatusCode());
    }

    public void updateDog(String breedName, DogBreed updatedDog) {
        RestTemplate restTemplate = new RestTemplate();
        String restEndpointUrl = baseUrl + breedName;

        DogCommand newDog = new DogCommand(updatedDog);

        String requestJson = new Gson().toJson(newDog);
        System.out.println(requestJson);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestJson, headers);
        restTemplate.put(restEndpointUrl, requestEntity, newDog.getBreedName());
        System.out.println("Updated dog with breedName: " + newDog.getBreedName());

    }

    public void deleteDog(String breedName) {
        RestTemplate restTemplate = new RestTemplate();
        String restEndpointUrl = baseUrl + breedName;

        restTemplate.delete(restEndpointUrl);
    }

    public DogBreed getByName(String breedName)  {
        try{
            RestTemplate restTemplate = new RestTemplate();
            String restEndpointUrl = baseUrl + breedName;
            ResponseEntity<DogBreed> DogResponse = restTemplate.getForEntity(restEndpointUrl, DogBreed.class);

            return DogResponse.getBody();
        }
        catch (HttpClientErrorException ex){
            return null;
        }
    }
}
