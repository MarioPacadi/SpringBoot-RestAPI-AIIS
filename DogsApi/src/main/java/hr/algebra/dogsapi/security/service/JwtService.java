package hr.algebra.dogsapi.security.service;

import hr.algebra.dogsapi.models.Account;

public interface JwtService {

    boolean authenticate(String token);

    String createJwt(Account account);

}
