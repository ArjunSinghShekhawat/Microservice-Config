package com.user.service.exernal.service;

import com.user.service.models.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTELSERVICE")
public interface HotelService {

    @GetMapping("/hotel/get/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);
}
