package com.dot.freelance.service.mapper;

import com.dot.freelance.domain.Address;
import com.dot.freelance.domain.Address.AddressBuilder;
import com.dot.freelance.dto.AddressDto;
import com.dot.freelance.dto.AddressDto.AddressDtoBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-31T09:28:06+0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public Address toAddress(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        AddressBuilder address = Address.builder();

        if ( addressDto.getLabel() != null ) {
            address.label( addressDto.getLabel() );
        }
        if ( addressDto.getReceiverName() != null ) {
            address.receiverName( addressDto.getReceiverName() );
        }
        if ( addressDto.getSenderName() != null ) {
            address.senderName( addressDto.getSenderName() );
        }
        if ( addressDto.getPhoneNumber() != null ) {
            address.phoneNumber( addressDto.getPhoneNumber() );
        }
        if ( addressDto.getProvince() != null ) {
            address.province( addressDto.getProvince() );
        }
        if ( addressDto.getProvinceId() != null ) {
            address.provinceId( addressDto.getProvinceId() );
        }
        if ( addressDto.getCity() != null ) {
            address.city( addressDto.getCity() );
        }
        if ( addressDto.getCityId() != null ) {
            address.cityId( addressDto.getCityId() );
        }
        if ( addressDto.getPostalCode() != null ) {
            address.postalCode( addressDto.getPostalCode() );
        }
        if ( addressDto.getSubDistrict() != null ) {
            address.subDistrict( addressDto.getSubDistrict() );
        }
        if ( addressDto.getSubDistrictId() != null ) {
            address.subDistrictId( addressDto.getSubDistrictId() );
        }
        if ( addressDto.getLatitude() != null ) {
            address.latitude( addressDto.getLatitude() );
        }
        if ( addressDto.getLongitude() != null ) {
            address.longitude( addressDto.getLongitude() );
        }
        if ( addressDto.getIsDefault() != null ) {
            address.isDefault( addressDto.getIsDefault() );
        }
        if ( addressDto.getIsDelivery() != null ) {
            address.isDelivery( addressDto.getIsDelivery() );
        }
        if ( addressDto.getDetail() != null ) {
            address.detail( addressDto.getDetail() );
        }
        if ( addressDto.getAddressType() != null ) {
            address.addressType( addressDto.getAddressType() );
        }
        if ( addressDto.getAccountId() != null ) {
            address.accountId( addressDto.getAccountId() );
        }
        if ( addressDto.getId() != null ) {
            address.id( addressDto.getId() );
        }

        return address.build();
    }

    @Override
    public AddressDto toAddressDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDtoBuilder addressDto = AddressDto.builder();

        if ( address.getAccountId() != null ) {
            addressDto.accountId( address.getAccountId() );
        }
        if ( address.getId() != null ) {
            addressDto.id( address.getId() );
        }
        if ( address.getReceiverName() != null ) {
            addressDto.receiverName( address.getReceiverName() );
        }
        if ( address.getSenderName() != null ) {
            addressDto.senderName( address.getSenderName() );
        }
        if ( address.getPhoneNumber() != null ) {
            addressDto.phoneNumber( address.getPhoneNumber() );
        }
        if ( address.getLabel() != null ) {
            addressDto.label( address.getLabel() );
        }
        if ( address.getProvince() != null ) {
            addressDto.province( address.getProvince() );
        }
        if ( address.getProvinceId() != null ) {
            addressDto.provinceId( address.getProvinceId() );
        }
        if ( address.getCity() != null ) {
            addressDto.city( address.getCity() );
        }
        if ( address.getCityId() != null ) {
            addressDto.cityId( address.getCityId() );
        }
        if ( address.getPostalCode() != null ) {
            addressDto.postalCode( address.getPostalCode() );
        }
        if ( address.getSubDistrict() != null ) {
            addressDto.subDistrict( address.getSubDistrict() );
        }
        if ( address.getSubDistrictId() != null ) {
            addressDto.subDistrictId( address.getSubDistrictId() );
        }
        if ( address.getLatitude() != null ) {
            addressDto.latitude( address.getLatitude() );
        }
        if ( address.getLongitude() != null ) {
            addressDto.longitude( address.getLongitude() );
        }
        if ( address.getIsDefault() != null ) {
            addressDto.isDefault( address.getIsDefault() );
        }
        if ( address.getIsDelivery() != null ) {
            addressDto.isDelivery( address.getIsDelivery() );
        }
        if ( address.getDetail() != null ) {
            addressDto.detail( address.getDetail() );
        }
        if ( address.getAddressType() != null ) {
            addressDto.addressType( address.getAddressType() );
        }

        return addressDto.build();
    }

    @Override
    public List<AddressDto> toListAddressDto(List<Address> addresses) {
        if ( addresses == null ) {
            return null;
        }

        List<AddressDto> list = new ArrayList<AddressDto>( addresses.size() );
        for ( Address address : addresses ) {
            list.add( toAddressDto( address ) );
        }

        return list;
    }

    @Override
    public void updateAddressFromAddressDto(AddressDto addressDto, Address address) {
        if ( addressDto == null ) {
            return;
        }

        if ( addressDto.getLabel() != null ) {
            address.setLabel( addressDto.getLabel() );
        }
        if ( addressDto.getReceiverName() != null ) {
            address.setReceiverName( addressDto.getReceiverName() );
        }
        if ( addressDto.getSenderName() != null ) {
            address.setSenderName( addressDto.getSenderName() );
        }
        if ( addressDto.getPhoneNumber() != null ) {
            address.setPhoneNumber( addressDto.getPhoneNumber() );
        }
        if ( addressDto.getProvince() != null ) {
            address.setProvince( addressDto.getProvince() );
        }
        if ( addressDto.getProvinceId() != null ) {
            address.setProvinceId( addressDto.getProvinceId() );
        }
        if ( addressDto.getCity() != null ) {
            address.setCity( addressDto.getCity() );
        }
        if ( addressDto.getCityId() != null ) {
            address.setCityId( addressDto.getCityId() );
        }
        if ( addressDto.getPostalCode() != null ) {
            address.setPostalCode( addressDto.getPostalCode() );
        }
        if ( addressDto.getSubDistrict() != null ) {
            address.setSubDistrict( addressDto.getSubDistrict() );
        }
        if ( addressDto.getSubDistrictId() != null ) {
            address.setSubDistrictId( addressDto.getSubDistrictId() );
        }
        if ( addressDto.getLatitude() != null ) {
            address.setLatitude( addressDto.getLatitude() );
        }
        if ( addressDto.getLongitude() != null ) {
            address.setLongitude( addressDto.getLongitude() );
        }
        if ( addressDto.getIsDefault() != null ) {
            address.setIsDefault( addressDto.getIsDefault() );
        }
        if ( addressDto.getIsDelivery() != null ) {
            address.setIsDelivery( addressDto.getIsDelivery() );
        }
        if ( addressDto.getDetail() != null ) {
            address.setDetail( addressDto.getDetail() );
        }
        if ( addressDto.getAddressType() != null ) {
            address.setAddressType( addressDto.getAddressType() );
        }
        if ( addressDto.getAccountId() != null ) {
            address.setAccountId( addressDto.getAccountId() );
        }
    }
}
