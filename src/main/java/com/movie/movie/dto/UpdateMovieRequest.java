package com.movie.movie.dto;

import lombok.Getter;

@Getter
public class UpdateMovieRequest {

    private String title;
    private String email;
    private String password;
    private String phoneNumber;
}