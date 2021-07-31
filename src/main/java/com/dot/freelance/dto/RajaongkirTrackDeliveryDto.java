package com.dot.freelance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RajaongkirTrackDeliveryDto {
    String status;
    String pod_receiver;
    String pod_date;
    String pod_time;
}