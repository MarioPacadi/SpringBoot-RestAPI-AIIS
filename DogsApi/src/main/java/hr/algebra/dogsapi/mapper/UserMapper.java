package hr.algebra.dogsapi.mapper;


import hr.algebra.dogsapi.dto.UserDto;
import hr.algebra.dogsapi.models.Account;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    Account to(UserDto source);

    UserDto from(Account destination);

    List<UserDto> mapToDto(List<Account> packages);

    List<Account> map(List<UserDto> employees);
}
