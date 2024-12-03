package com.hotel.models;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
public class Hotel {

    @Id
    private ObjectId id;

    @NotBlank(message = "hotel name is requires")
    private String nameOfHotel;

    @NotBlank(message = "hotel location is required")
    private String location;

    @NotBlank(message = "hotel about is required")
    private String about;
}
