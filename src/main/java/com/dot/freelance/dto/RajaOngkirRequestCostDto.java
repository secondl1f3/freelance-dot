package com.dot.freelance.dto;

import com.dot.freelance.constant.AppConstant;
import com.dot.freelance.constant.Courier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RajaOngkirRequestCostDto {
    private String origin;
    private String destination;
    private Integer weight;
    private String courier;
}
