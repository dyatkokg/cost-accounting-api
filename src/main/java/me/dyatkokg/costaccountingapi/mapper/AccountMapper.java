package me.dyatkokg.costaccountingapi.mapper;

import me.dyatkokg.costaccountingapi.dto.AccountDTO;
import me.dyatkokg.costaccountingapi.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(target = "id",ignore = true)
    Account toEntity(AccountDTO dto);

    AccountDTO toDTO(Account account);

}
