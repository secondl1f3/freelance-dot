package com.dot.freelance.controller;

import com.dot.freelance.dto.RajaOngkirDto;
import com.dot.freelance.dto.RajaOngkirRequestCostDto;
import com.dot.freelance.exception.NotFoundException;
import com.dot.freelance.feign.RajaOngkirFeignClient;
import com.dot.freelance.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipments")
public class ShipmentController extends BaseController{

    @Autowired
    private RajaOngkirFeignClient rajaOngkirFeignClient;

    @Autowired
    private ShipmentService shipmentService;

    @GetMapping("/province")
    public Object getProvince() {
        try {
            RajaOngkirDto result = rajaOngkirFeignClient.getProvince();
            return buildResponseGeneralSuccess(shipmentService.getProvince(result));
        } catch (NotFoundException e) {
            return buildResponseNotFound(e.getMessage());
        } catch (Exception e) {
            return buildResponseGeneralError(e.getMessage());
        }
    }

    @GetMapping("/city")
    public Object getCity(@RequestParam("provinceId") String provinceId) {
        try {
            RajaOngkirDto result = rajaOngkirFeignClient.getCity(provinceId);
            return buildResponseGeneralSuccess(shipmentService.getCity(result));
        } catch (NotFoundException e) {
            return buildResponseNotFound(e.getMessage());
        } catch (Exception e) {
            return buildResponseGeneralError(e.getMessage());
        }
    }

    @GetMapping("/subdistrict")
    public Object getSubdistrict(@RequestParam("cityId") String cityId) {
        try {
            RajaOngkirDto result = rajaOngkirFeignClient.getSubdistrict(cityId);
            return buildResponseGeneralSuccess(shipmentService.getSubDistrict(result));
        } catch (NotFoundException e) {
            return buildResponseNotFound(e.getMessage());
        } catch (Exception e) {
            return buildResponseGeneralError(e.getMessage());
        }
    }

    @PostMapping("/cost")
    public Object costShipment(@RequestBody RajaOngkirRequestCostDto dto) {
        try {
            return buildResponseGeneralSuccess(rajaOngkirFeignClient.postCost(dto));
        } catch (Exception e) {
            return buildResponseGeneralError(e.getMessage());
        }
    }

}
