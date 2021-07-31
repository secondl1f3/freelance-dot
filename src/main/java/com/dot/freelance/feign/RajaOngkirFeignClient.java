package com.dot.freelance.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        name = "${feign.rajaongkir.name}",
        url = "${feign.rajaongkir.url}",
        configuration = FeignConfig.class,
        fallback =  RajaOngkirFeignClientFb.class
)
public interface RajaOngkirFeignClient extends RajaOngkirFeign {
}
