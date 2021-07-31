package com.dot.freelance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RajaOngkirTrackResultDto {
    Boolean delivered;
    RajaongkirTrackSummaryDto summary;
    RajaongkirTrackDetailsDto details;
    RajaongkirTrackDeliveryDto delivery_status;
    List<Object> manifest;
}
