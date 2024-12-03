package com.hotel.service;

import com.hotel.models.Hotel;
import org.bson.types.ObjectId;

import java.util.List;

public interface HotelService {

    Hotel createNewHotel(Hotel hotel);
    Hotel getHotelById(ObjectId hotelId);
    List<Hotel>getAllHotel();
    void deleteHotel(ObjectId hotelId);
    Hotel updateHotel(ObjectId hotelId,Hotel hotel);

}
