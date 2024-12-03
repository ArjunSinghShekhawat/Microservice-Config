package com.rating.service;

import com.rating.models.Rating;
import com.rating.repositories.RatingRepository;

import java.util.List;

public interface RatingService {

    Rating createRating(Rating rating);
    List<Rating>getAllRating();
    List<Rating>getAllUserRating(String userId);
    List<Rating>getAllHotelRating(String hotelId);
    Rating updateRating(String ratingId,Rating rating);
}

