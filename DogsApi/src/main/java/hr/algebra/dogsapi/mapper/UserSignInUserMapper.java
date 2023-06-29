package hr.algebra.dogsapi.mapper;

import hr.algebra.dogsapi.dto.SignInUserDto;
import hr.algebra.dogsapi.models.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserSignInUserMapper {

    SignInUserDto from(Account destination);
}
