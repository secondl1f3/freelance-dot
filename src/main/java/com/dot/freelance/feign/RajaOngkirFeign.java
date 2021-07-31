package com.dot.freelance.feign;

import com.dot.freelance.dto.*;
import feign.Headers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface RajaOngkirFeign {

    @GetMapping("/province")
    @Headers({"Content-Type:application/json;charset=utf-8"})
    RajaOngkirDto getProvince();

    @GetMapping("/city")
    @Headers({"Content-Type:application/json;charset=utf-8"})
    RajaOngkirDto getCity(@RequestParam("province") String province);

    @GetMapping("/subdistrict")
    @Headers({"Content-Type:application/json;charset=utf-8"})
    RajaOngkirDto getSubdistrict(@RequestParam("city") String city);

    @PostMapping("/cost")
    @Headers({"content-type: application/x-www-form-urlencoded"})
    RajaOngkirCostDto postCost(RajaOngkirRequestCostDto rajaongkirRequestCostDto);

    @PostMapping("/waybill")
    @Headers({"content-type: application/x-www-form-urlencoded"})
    RajaOngkirTrackDto postTrack(RajaOngkirRequestTrackDto rajaongkirRequestTrackDto);
}
