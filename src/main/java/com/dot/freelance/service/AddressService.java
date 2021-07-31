package com.dot.freelance.service;

import com.dot.freelance.domain.Account;
import com.dot.freelance.dto.AddressDto;
import com.dot.freelance.dto.AddressType;

import java.util.List;

public interface AddressService {

    void create(AddressDto addressDto);

    void update(String id, AddressDto addressDto);

    AddressDto getById(String id);

    List<AddressDto> getAddressAccount(String accountId, AddressType addressType);

}
