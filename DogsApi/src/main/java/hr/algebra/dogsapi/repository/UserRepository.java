package hr.algebra.dogsapi.repository;

import hr.algebra.dogsapi.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByUsername(String username);

}
