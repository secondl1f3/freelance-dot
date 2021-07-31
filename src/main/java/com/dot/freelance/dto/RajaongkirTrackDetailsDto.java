package com.dot.freelance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RajaongkirTrackDetailsDto {
    String waybill_number;
    String waybill_date;
    String waybill_time;
    String weight;
    String origin;
    String destination;
    String shippper_name;
    String shipper_address1;
    String shipper_address2;
    String shipper_address3;
    String shipper_city;
    String receiver_name;
    String receiver_address1;
    String receiver_address2;
    String receiver_address3;
    String receiver_city;
}
