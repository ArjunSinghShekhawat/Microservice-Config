package com.user.service.exernal.service;

import com.user.service.models.Rating;
import jakarta.ws.rs.Path;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "RATINGSERVICE")
public interface RatingService {

    @GetMapping("/rating/get-all/user/{userId}")
    List<Rating>getAllRatingOfUser(@PathVariable String userId);

    @PostMapping("/rating/create")
    Rating createRating(Rating rating);

    @PutMapping("/rating/update/{ratingId}")
    Rating updateRating(@PathVariable String ratingId,Rating rating);

    @DeleteMapping("/rating/delete/{ratingId}")
    void deleteRating(@PathVariable String ratingId);


}
