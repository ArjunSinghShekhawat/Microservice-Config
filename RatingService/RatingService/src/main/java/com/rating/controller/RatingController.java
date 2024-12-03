package com.rating.controller;

import com.rating.models.Rating;
import com.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/create")
    public ResponseEntity<?>createRating(@RequestBody Rating rating){
        return new ResponseEntity<>(ratingService.createRating(rating), HttpStatus.CREATED);
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<Rating>>getAllRating(){
        return new ResponseEntity<>(ratingService.getAllRating(), HttpStatus.CREATED);
    }
    @GetMapping("/get-all/user/{userId}")
    public ResponseEntity<List<Rating>>getAllRatingByUserId(@PathVariable String userId){
        return new ResponseEntity<>(ratingService.getAllUserRating(userId), HttpStatus.CREATED);
    }
    @GetMapping("/get-all/hotel/{hotelId}")
    public ResponseEntity<List<Rating>>getAllRatingByHotelId(@PathVariable String hotelId){
        return new ResponseEntity<>(ratingService.getAllHotelRating(hotelId), HttpStatus.CREATED);
    }
    @PutMapping("/update/{ratingId}")
    public ResponseEntity<Rating>updateRating(@PathVariable String ratingId,@RequestBody Rating rating){
        Rating updatedRating = ratingService.updateRating(ratingId, rating);
        if(updatedRating!=null){
            return new ResponseEntity<>(updatedRating,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


}
