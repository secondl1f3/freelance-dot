package com.dot.freelance.repository;

import com.dot.freelance.domain.Account;
import com.dot.freelance.domain.Address;
import com.dot.freelance.dto.AddressType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
    List<Address> findByAccountId(String accountId);

    List<Address> findByAccountIdAndAddressTypeOrderByCreateAtDesc(String accountId, AddressType addressType);
}
