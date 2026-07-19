package com.movie.review.service;

import com.movie.movie.entity.Movie;
import com.movie.movie.repository.MovieRepository;
import com.movie.review.dto.*;
import com.movie.review.entity.Review;
import com.movie.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;

    // 생성 -> CreateReviewRequest, CreateReviewResponse
    @Transactional
    public CreateReviewResponse save(Long movieId, CreateReviewRequest request) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new IllegalStateException("없는 영화입니다."));
        Review review = new Review(request.getTitle(), request.getContent(), request.getRating(), movie);
        Review savedReview = reviewRepository.save(review);
        return new CreateReviewResponse(
                savedReview.getId(),
                savedReview.getTitle(),
                savedReview.getContent(),
                savedReview.getRating()
        );
    }

    // 전체 조회 -> GetReviewsResponse
    @Transactional(readOnly = true)
    public List<GetReviewsResponse> getAll(Long movieId) {
        if (!movieRepository.existsById(movieId)) {
            throw new IllegalStateException("없는 영화입니다.");
        }
        List<Review> reviews = reviewRepository.findByMovieId(movieId);
        return reviews.stream()
                .map(review -> new GetReviewsResponse(
                        review.getId(),
                        review.getTitle(),
                        review.getRating()
                ))
                .toList();
    }

    // 단건 조회 -> GetReviewResponse
    @Transactional(readOnly = true)
    public GetReviewResponse getOne(Long reviewId) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(
                () -> new IllegalStateException("없는 리뷰입니다.")
        );
        return new GetReviewResponse(
                review.getId(),
                review.getTitle(),
                review.getContent(),
                review.getRating()
        );
    }

    // 수정 -> UpdateReviewRequest, UpdateReviewResponse
    @Transactional
    public UpdateReviewResponse update(Long reviewId, UpdateReviewRequest request) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(
                () -> new IllegalStateException("없는 리뷰입니다.")
        );
        review.update(request.getTitle(), request.getContent(), request.getRating());
        return new UpdateReviewResponse(review.getId(), review.getTitle(), review.getContent(), review.getRating());
    }

    // 삭제
    @Transactional
    public void delete(Long reviewId) {
        if (!reviewRepository.existsById(reviewId)) {
            throw new IllegalStateException("없는 리뷰입니다.");
        }
        reviewRepository.deleteById(reviewId);
    }
}
