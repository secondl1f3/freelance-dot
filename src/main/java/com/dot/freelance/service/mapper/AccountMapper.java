package com.dot.freelance.service.mapper;

import com.dot.freelance.domain.Account;
import com.dot.freelance.dto.AccountDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    @Named("toAccountDto")
    AccountDto toAccountDto(Account account);

    @Named("toAccount")
    Account toAccount(AccountDto accountDto);

    @IterableMapping(qualifiedByName = "toAccountDto")
    List<AccountDto> toListAccountDto(List<Account> accountList);
}
