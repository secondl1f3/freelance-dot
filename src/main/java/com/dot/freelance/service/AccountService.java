package com.dot.freelance.service;

import com.dot.freelance.dto.AccountDto;
import com.dot.freelance.dto.AddressDto;

public interface AccountService {

    void create(AccountDto accountDto);

    AccountDto getById(String id);
}
