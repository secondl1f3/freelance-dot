package com.dot.freelance.service.mapper;

import com.dot.freelance.domain.Account;
import com.dot.freelance.dto.AccountDto;
import com.dot.freelance.dto.AccountDto.AccountDtoBuilder;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-31T03:07:22+0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountDto toAccountDto(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountDtoBuilder accountDto = AccountDto.builder();

        if ( account.getUsername() != null ) {
            accountDto.username( account.getUsername() );
        }
        if ( account.getName() != null ) {
            accountDto.name( account.getName() );
        }
        if ( account.getGender() != null ) {
            accountDto.gender( account.getGender() );
        }
        if ( account.getMobile() != null ) {
            accountDto.mobile( account.getMobile() );
        }
        if ( account.getEmail() != null ) {
            accountDto.email( account.getEmail() );
        }
        if ( account.getIsDisabled() != null ) {
            accountDto.isDisabled( account.getIsDisabled() );
        }

        return accountDto.build();
    }
}
