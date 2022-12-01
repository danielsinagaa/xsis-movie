package com.xsis.movie.model.request;

import lombok.Data;

@Data
public class MovieServiceRequest {
    private String title;

    private String description;

    private Double rating;

    private String image;
}
