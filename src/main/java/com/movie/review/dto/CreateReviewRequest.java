package com.movie.review.dto;

import lombok.Getter;

@Getter
public class CreateReviewRequest {
    private String title;
    private String content;
    private Integer rating;
}
