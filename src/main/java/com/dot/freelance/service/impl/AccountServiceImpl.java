package com.dot.freelance.service.impl;

import com.dot.freelance.domain.Account;
import com.dot.freelance.dto.AccountDto;
import com.dot.freelance.exception.NotFoundException;
import com.dot.freelance.repository.AccountRepository;
import com.dot.freelance.service.AccountService;
import com.dot.freelance.service.mapper.AccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "account")
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private final AccountMapper accountMapper = AccountMapper.INSTANCE;

    @Autowired
    private AccountRepository accountRepository;

    @Caching(evict = { @CacheEvict(value = "allaccountcache", allEntries = true),
            @CacheEvict(value = "accountcache", key = "#account.id")
    })
    @Override
    public void create(AccountDto accountDto) {
        Account account = accountMapper.toAccount(accountDto);
        accountRepository.save(account);
        log.info("Account created successfully");
    }

    @Cacheable(value = "accountcache",key ="#id" )
    @Override
    public AccountDto getById(String id) {
        Account account =  accountRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Address id {0}".replace("{0}", id)));
        return accountMapper.toAccountDto(account);
    }
}
