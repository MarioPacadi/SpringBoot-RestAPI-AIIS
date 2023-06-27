package hr.algebra.dogsapi.security.service;

import hr.algebra.dogsapi.dto.LoginDTO;
import hr.algebra.dogsapi.payload.request.LoginCommand;

import java.util.Optional;

public interface AuthenticationService {

    Optional<LoginDTO> login(LoginCommand command);

}
