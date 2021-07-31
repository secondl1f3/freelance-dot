package com.dot.freelance.service.mapper;

import com.dot.freelance.domain.Address;
import com.dot.freelance.dto.AddressDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Named("toAddress")
    Address toAddress(AddressDto addressDto);

    @Named("toAddressDto")
    @Mapping(source = "id", target = "id")
    @Mapping(target = "accountId", source = "accountId")
    AddressDto toAddressDto(Address address);

    @IterableMapping(qualifiedByName = "toAddressDto")
    List<AddressDto> toListAddressDto(List<Address> addresses);

    @Mapping(target = "id", ignore = true)
    void updateAddressFromAddressDto(AddressDto addressDto, @MappingTarget Address address);

}
