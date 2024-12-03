package com.hotel.controller;

import com.hotel.exception.ResourceNotFoundException;
import com.hotel.models.Hotel;
import com.hotel.service.HotelService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
@Slf4j
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/create")
    public ResponseEntity<Hotel> createHotel(@Valid @RequestBody Hotel hotel){
        try{
            Hotel createdHotel = hotelService.createNewHotel(hotel);
            if(createdHotel!=null){
                return new ResponseEntity<>(createdHotel, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            log.info("Error occurred in hotel create api  while creating new hotel {}", e.getMessage());
            throw new ResourceNotFoundException("hotel Not created Error occurred in new hotel create api");
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Hotel>>getAllHotel(){
        return new ResponseEntity<>(hotelService.getAllHotel(),HttpStatus.OK);
    }
    @GetMapping("/get/{hotelId}")
    public ResponseEntity<Hotel>getHotelById(@PathVariable ObjectId hotelId){
        return new ResponseEntity<>(hotelService.getHotelById(hotelId),HttpStatus.OK);
    }
    @PutMapping("/update/{hotelId}")
    public ResponseEntity<Hotel>updateHotel(@PathVariable ObjectId hotelId,@RequestBody Hotel hotel){
        return new ResponseEntity<>(hotelService.updateHotel(hotelId,hotel),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{hotelId}")
    public ResponseEntity<?>deleteHotel(@PathVariable ObjectId hotelId){
        hotelService.deleteHotel(hotelId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
