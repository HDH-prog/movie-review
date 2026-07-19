package com.movie.review.dto;

import lombok.Getter;

@Getter
public class UpdateReviewRequest {
    private String title;
    private String content;
    private Integer rating;
}
