package com.dot.freelance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDto {

    private String id;
    private String receiverName;
    private String senderName;
    @NotEmpty
    private String phoneNumber;
    @NotEmpty
    private String label;
    @NotEmpty
    private String province;
    @NotEmpty
    private String provinceId;
    @NotEmpty
    private String city;
    @NotEmpty
    private String cityId;
    @NotEmpty
    private String postalCode;
    @NotEmpty
    private String subDistrict;
    @NotEmpty
    private String subDistrictId;
    @NotEmpty
    private String latitude;
    @NotEmpty
    private String longitude;
    @NotNull
    private Boolean isDefault;
    @NotNull
    private Boolean isDelivery;
    private String detail;
    private String accountId;
    @NotNull
    private AddressType addressType;

}
