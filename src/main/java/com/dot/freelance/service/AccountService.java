package com.dot.freelance.service;

import com.dot.freelance.domain.Account;
import com.dot.freelance.dto.AccountDto;
import com.dot.freelance.dto.AddressDto;

import java.util.List;

public interface AccountService {

    void create(Account account);

    AccountDto getById(String id);

    List<AccountDto> getAllAccount();
}
