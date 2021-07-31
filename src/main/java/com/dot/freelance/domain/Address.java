package com.dot.freelance.domain;

import com.dot.freelance.common.BaseDomain;
import com.dot.freelance.dto.AddressType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "IS_DELETED=false")
@Builder
public class Address extends BaseDomain {
    private String label;
    private String receiverName;
    private String senderName;
    private String phoneNumber;
    private String province;
    private String provinceId;
    private String city;
    private String cityId;
    private String postalCode;
    private String subDistrict;
    private String subDistrictId;
    private String latitude;
    private String longitude;
    private Boolean isDefault;
    private Boolean isDelivery;
    private String detail;
    @Enumerated(EnumType.STRING)
    private AddressType addressType;
    private String accountId;

    @Builder
    public Address(String id, String label, String receiverName, String senderName, String phoneNumber, String province,
                   String provinceId, String city, String cityId, String postalCode, String subDistrict,
                   String subDistrictId, String latitude, String longitude, Boolean isDefault, Boolean isDelivery,
                   String detail, LocalDateTime createAt, LocalDateTime updateAt, Boolean isDeleted, String accountId) {
        super(id, createAt, updateAt, isDeleted);
        this.label = label;
        this.receiverName = receiverName;
        this.senderName = senderName;
        this.phoneNumber = phoneNumber;
        this.province = province;
        this.provinceId = provinceId;
        this.city = city;
        this.cityId = cityId;
        this.detail = detail;
        this.postalCode = postalCode;
        this.subDistrict = subDistrict;
        this.subDistrictId = subDistrictId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.isDefault = isDefault;
        this.isDelivery = isDelivery;
        this.accountId = accountId;
    }
}
