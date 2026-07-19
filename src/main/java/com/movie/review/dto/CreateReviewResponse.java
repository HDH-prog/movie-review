package com.movie.review.dto;

import lombok.Getter;

@Getter
public class CreateReviewResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final Integer rating;

    public CreateReviewResponse(Long id, String title, String content, Integer rating) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.rating = rating;
    }
}
