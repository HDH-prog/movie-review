package com.movie.review.controller;

import com.movie.review.dto.*;
import com.movie.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    // 생성
    @PostMapping("/movies/{movieId}/reviews")
    public ResponseEntity<CreateReviewResponse> saveReview(
            @PathVariable Long movieId,
            @RequestBody CreateReviewRequest request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(reviewService.save(movieId, request));
    }

    // 전체 조회
    @GetMapping("/movies/{movieId}/reviews")
    public ResponseEntity<List<GetReviewsResponse>> getReviews(
            @PathVariable Long movieId
    ) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(reviewService.getAll(movieId));
    }

    // 단건 조회
    @GetMapping("/movies/{movieId}/reviews/{reviewId}")
    public ResponseEntity<GetReviewResponse> getReview(
            @PathVariable Long reviewId
    ) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(reviewService.getOne(reviewId));
    }

    // 수정
    @PutMapping("/movies/{movieId}/reviews/{reviewId}")
    public ResponseEntity<UpdateReviewResponse> updateReview(
            @PathVariable Long reviewId,
            @RequestBody UpdateReviewRequest request
    ) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(reviewService.update(reviewId, request));
    }

    // 삭제
    @DeleteMapping("/movies/{movieId}/reviews/{reviewId}")
    public ResponseEntity<Void> deleteReview(
            @PathVariable Long reviewId
    ) {
        reviewService.delete(reviewId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}