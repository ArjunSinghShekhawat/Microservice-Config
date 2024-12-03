package com.hotel.service.impl;

import com.hotel.exception.ResourceNotFoundException;
import com.hotel.models.Hotel;
import com.hotel.repositories.HotelRepository;
import com.hotel.service.HotelService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;


    @Override
    public Hotel createNewHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotelById(ObjectId hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("Hotel is not found with "+hotelId));
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    @Override
    public void deleteHotel(ObjectId hotelId) {
        Hotel hotel = getHotelById(hotelId);
        hotelRepository.deleteById(hotelId);
    }

    @Override
    public Hotel updateHotel(ObjectId hotelId, Hotel hotel) {
        Hotel existHotel = getHotelById(hotelId);

        existHotel.setNameOfHotel(hotel.getNameOfHotel());
        existHotel.setAbout(hotel.getAbout());
        existHotel.setLocation(hotel.getLocation());

        return hotelRepository.save(existHotel);
    }
}
