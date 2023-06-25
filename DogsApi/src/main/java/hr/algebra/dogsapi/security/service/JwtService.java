package hr.algebra.dogsapi.security.service;

import hr.algebra.dogsapi.security.domain.Account;

public interface JwtService {

    boolean authenticate(String token);

    String createJwt(Account account);

}
