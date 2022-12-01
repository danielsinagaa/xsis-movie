package com.xsis.movie.model.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class MovieServiceResponse {

    private Long id;

    private String title;

    private String description;

    private Double rating;

    private String image;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;
}
