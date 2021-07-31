package com.dot.freelance.service;

import com.dot.freelance.dto.RajaOngkirDto;

public interface ShipmentService {

    Object getProvince(RajaOngkirDto rajaongkirDto);

    Object getCity(RajaOngkirDto rajaongkirDto);

    Object getSubDistrict(RajaOngkirDto rajaongkirDto);

}
