package hr.algebra.dogsapi.mapper;

import hr.algebra.dogsapi.dto.UserDto;
import hr.algebra.dogsapi.models.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserSignInUserMapper {

    UserDto from(Account destination);
}
