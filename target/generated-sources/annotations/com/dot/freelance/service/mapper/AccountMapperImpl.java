package com.dot.freelance.service.mapper;

import com.dot.freelance.domain.Account;
import com.dot.freelance.domain.Account.AccountBuilder;
import com.dot.freelance.dto.AccountDto;
import com.dot.freelance.dto.AccountDto.AccountDtoBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-31T09:59:49+0700",
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

        if ( account.getId() != null ) {
            accountDto.id( account.getId() );
        }
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

    @Override
    public Account toAccount(AccountDto accountDto) {
        if ( accountDto == null ) {
            return null;
        }

        AccountBuilder account = Account.builder();

        if ( accountDto.getId() != null ) {
            account.id( accountDto.getId() );
        }
        if ( accountDto.getName() != null ) {
            account.name( accountDto.getName() );
        }
        if ( accountDto.getGender() != null ) {
            account.gender( accountDto.getGender() );
        }
        if ( accountDto.getMobile() != null ) {
            account.mobile( accountDto.getMobile() );
        }
        if ( accountDto.getEmail() != null ) {
            account.email( accountDto.getEmail() );
        }
        if ( accountDto.getUsername() != null ) {
            account.username( accountDto.getUsername() );
        }
        if ( accountDto.getIsDisabled() != null ) {
            account.isDisabled( accountDto.getIsDisabled() );
        }

        return account.build();
    }

    @Override
    public List<AccountDto> toListAccountDto(List<Account> accountList) {
        if ( accountList == null ) {
            return null;
        }

        List<AccountDto> list = new ArrayList<AccountDto>( accountList.size() );
        for ( Account account : accountList ) {
            list.add( toAccountDto( account ) );
        }

        return list;
    }
}
