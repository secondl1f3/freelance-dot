package com.dot.freelance.service.impl;

import com.dot.freelance.domain.Account;
import com.dot.freelance.domain.Address;
import com.dot.freelance.dto.AddressDto;
import com.dot.freelance.dto.AddressType;
import com.dot.freelance.exception.NotFoundException;
import com.dot.freelance.repository.AccountRepository;
import com.dot.freelance.repository.AddressRepository;
import com.dot.freelance.service.AddressService;
import com.dot.freelance.service.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private final AddressMapper addressMapper = AddressMapper.INSTANCE;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void create(AddressDto addressDto) {
//        Account account = accountRepository.findById(addressDto.getAccountId())
//                .orElseThrow(() -> new NotFoundException("Address id {0}".replace("{0}", addressDto.getAccountId().toString())));
        Address address = addressMapper.toAddress(addressDto);
//        address.setAccount(account);
        addressRepository.save(address);
    }

    @Override
    public void update(String id, AddressDto addressDto) {
        Address address = getAddressById(id);
        addressMapper.updateAddressFromAddressDto(addressDto,address);
        addressRepository.save(address);
    }

    @Override
    public AddressDto getById(String id) {
        Address address = getAddressById(id);
        return addressMapper.toAddressDto(address);
    }

    @Override
    public List<AddressDto> getAddressAccount(String accountId, AddressType addressType) {
        List<Address> addresses = addressRepository.findByAccountIdAndAddressTypeOrderByCreateAtDesc(accountId, addressType);
        return addressMapper.toListAddressDto(addresses);
    }

    private Address getAddressById(String id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Address id {0}".replace("{0}", id.toString())));
    }
}
