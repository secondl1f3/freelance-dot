package com.dot.freelance.service.impl;

import com.dot.freelance.domain.Account;
import com.dot.freelance.dto.AccountDto;
import com.dot.freelance.exception.NotFoundException;
import com.dot.freelance.repository.AccountRepository;
import com.dot.freelance.service.AccountService;
import com.dot.freelance.service.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private final AccountMapper accountMapper = AccountMapper.INSTANCE;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDto getById(String id) {
        Account account =  accountRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Address id {0}".replace("{0}", id)));
        return accountMapper.toAccountDto(account);
    }
}
