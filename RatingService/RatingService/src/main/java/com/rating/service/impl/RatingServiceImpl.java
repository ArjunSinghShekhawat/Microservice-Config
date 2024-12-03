package com.rating.service.impl;

import com.rating.models.Rating;
import com.rating.repositories.RatingRepository;
import com.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating createRating(Rating rating) {
        String id = UUID.randomUUID().toString();
        rating.setRatingId(id);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getAllUserRating(String userId) {

        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getAllHotelRating(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public Rating updateRating(String ratingId, Rating rating) {
        Rating existRating = ratingRepository.findById(ratingId).orElseThrow(()->new RuntimeException("Rating entity not found"));

        existRating.setRating(rating.getRating());
        return ratingRepository.save(existRating);
    }
}
