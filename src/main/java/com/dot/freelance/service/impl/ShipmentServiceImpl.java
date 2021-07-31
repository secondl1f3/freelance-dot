package com.dot.freelance.service.impl;

import com.dot.freelance.dto.RajaOngkirDto;
import com.dot.freelance.service.ShipmentService;
import org.springframework.stereotype.Service;

@Service
public class ShipmentServiceImpl implements ShipmentService {
    @Override
    public Object getProvince(RajaOngkirDto rajaongkirDto) {
        return rajaongkirDto.getRajaongkir();
    }

    @Override
    public Object getCity(RajaOngkirDto rajaongkirDto) {
        return rajaongkirDto.getRajaongkir();
    }

    @Override
    public Object getSubDistrict(RajaOngkirDto rajaongkirDto) {
        return rajaongkirDto.getRajaongkir();
    }
}
