package com.dot.freelance.service.impl;

import com.dot.freelance.domain.Address;
import com.dot.freelance.dto.AddressDto;
import com.dot.freelance.dto.AddressType;
import com.dot.freelance.exception.NotFoundException;
import com.dot.freelance.repository.AddressRepository;
import com.dot.freelance.service.AddressService;
import com.dot.freelance.service.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private final AddressMapper addressMapper = AddressMapper.INSTANCE;

    @Autowired
    private AddressRepository addressRepository;

    @Caching(evict = { @CacheEvict(value = "alladdresscache", allEntries = true),
            @CacheEvict(value = "addresscache", key = "#address.id")
    })
    @Override
    public void create(AddressDto addressDto) {
        Address address = addressMapper.toAddress(addressDto);
        addressRepository.save(address);
    }

    @CachePut(key = "#address.id")
    @Override
    public void update(String id, AddressDto addressDto) {
        Address address = getAddressById(id);
        addressMapper.updateAddressFromAddressDto(addressDto,address);
        addressRepository.save(address);
    }

    @Cacheable(value = "addresscache",key ="#id" )
    @Override
    public AddressDto getById(String id) {
        Address address = getAddressById(id);
        return addressMapper.toAddressDto(address);
    }

    @Override
    public List<AddressDto> getAddressAccount(String accountId, AddressType addressType) {
        List<Address> addresses = addressRepository.findByAccountIdAndAddressTypeOrderByCreateAtDesc(accountId, addressType);
        if (addresses == null || addresses.isEmpty())
            return null;
        return addressMapper.toListAddressDto(addresses);
    }

    @Cacheable(value = "alladdresscache")
    @Override
    public List<AddressDto> getAllAddress() {
        List<Address> addresses = addressRepository.findAll();
        if (addresses == null || addresses.isEmpty())
            return null;
        return addressMapper.toListAddressDto(addresses);
    }

    private Address getAddressById(String id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Address id {0}".replace("{0}", id.toString())));
    }
}
