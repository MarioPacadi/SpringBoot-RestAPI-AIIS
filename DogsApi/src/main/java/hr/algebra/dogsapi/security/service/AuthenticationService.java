package hr.algebra.dogsapi.security.service;

import hr.algebra.dogsapi.security.dto.LoginDTO;
import hr.algebra.dogsapi.security.command.LoginCommand;

import java.util.Optional;

public interface AuthenticationService {

    Optional<LoginDTO> login(LoginCommand command);

}
