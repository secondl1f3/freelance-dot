package com.dot.freelance.feign;

import com.dot.freelance.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RajaOngkirFeignClientFb implements RajaOngkirFeignClient {

    @Override
    public RajaOngkirDto getProvince() {
        return null;
    }

    @Override
    public RajaOngkirDto getCity(String province) {
        return null;
    }

    @Override
    public RajaOngkirDto getSubdistrict(String city) {
        return null;
    }

    @Override
    public RajaOngkirCostDto postCost(RajaOngkirRequestCostDto rajaongkirRequestCostDto) {
        return null;
    }

    @Override
    public RajaOngkirTrackDto postTrack(RajaOngkirRequestTrackDto rajaongkirRequestTrackDto) {
        return null;
    }
}

