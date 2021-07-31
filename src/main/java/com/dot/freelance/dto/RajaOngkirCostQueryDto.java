package com.dot.freelance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RajaOngkirCostQueryDto {
    private String origin;
    private String destination;
    private String weight;
    private String courier;
}
