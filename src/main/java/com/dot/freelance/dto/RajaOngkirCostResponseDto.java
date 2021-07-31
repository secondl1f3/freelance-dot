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
public class RajaOngkirCostResponseDto {
    private String code;
    private String name;
    private List<CourierCost> costs;
}
