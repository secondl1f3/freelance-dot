package com.dot.freelance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RajaongkirTrackSummaryDto {
    String courier_code;
    String courier_name;
    String waybill_number;
    String service_code;
    String waybill_date;
    String shipper_name;
    String receiver_name;
    String origin;
    String destination;
    String status;

}
