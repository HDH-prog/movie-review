package com.movie.review.dto;

import lombok.Getter;

@Getter
public class GetReviewResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final Integer rating;

    public GetReviewResponse(Long id, String title, String content, Integer rating) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.rating = rating;
    }
}
