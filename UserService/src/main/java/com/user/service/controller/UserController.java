package com.user.service.controller;

import com.user.service.exception.ResourceNotFoundException;
import com.user.service.models.User;
import com.user.service.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/create")
    public ResponseEntity<User>createUser(@Valid @RequestBody User user){
        try{
            User createdUser = userService.saveNewUser(user);
            if(createdUser!=null){
                return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            log.info("Error occurred in user create api  while creating new user "+e.getMessage());
            throw new ResourceNotFoundException("User Not created Error occurred in new user create api");
        }
    }

    int retryCount=1;
    @GetMapping("/get-all")
//    @CircuitBreaker(name = "RATING_HOTEL_BREAKER",fallbackMethod = "ratingHotelFallBack")
//    @Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallBack")
    @RateLimiter(name = "userRateLimiter",fallbackMethod = "ratingHotelFallBack")
    public ResponseEntity<List<User>>getAllUser(){
        log.info("Retry Count "+retryCount);
        retryCount++;
        return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
    }
    //create rating fall back
    public ResponseEntity<List<User>>ratingHotelFallBack(Exception ex){


        User user = new User();
        user.setUsername("dumy name");
        user.setEmail("dummy@gmail.com");
        user.setAbout("hy service is down ");
        user.setUserId("12222222");

        return new ResponseEntity<>(List.of(user),HttpStatus.OK);
    }

    @GetMapping("/get/{userId}")
    @CircuitBreaker(name = "RATING_HOTEL_BREAKER",fallbackMethod = "ratingHotelFallBack1")
    public ResponseEntity<User>getUserById(@PathVariable String userId){
        return new ResponseEntity<>(userService.getUserByUserId(userId),HttpStatus.OK);
    }
    //create rating fall back
    public ResponseEntity<User>ratingHotelFallBack1(String userId,Exception ex){
        User user = new User();
        user.setUsername("dumy name");
        user.setEmail("dummy@gmail.com");
        user.setAbout("hy service is down ");
        user.setUserId("12222222");

        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @PutMapping("/update/{userId}")
    public ResponseEntity<User>updateUser(@PathVariable String userId,@RequestBody User user){
        return new ResponseEntity<>(userService.updateUser(userId,user),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?>deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
