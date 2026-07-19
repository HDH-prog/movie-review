package com.movie.review.dto;

import lombok.Getter;

@Getter
public class GetReviewsResponse {
    private final Long id;
    private final String title;
    private final Integer rating;

    public GetReviewsResponse(Long id, String title, Integer rating) {
        this.id = id;
        this.title = title;
        this.rating = rating;
    }
}
