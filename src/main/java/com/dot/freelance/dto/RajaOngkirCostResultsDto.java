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
public class RajaOngkirCostResultsDto {
//    private RajaOngkirCostQueryDto query;
//    private RajaOngkirCostStatusDto status;
    List<RajaOngkirCostResponseDto> results;
}
