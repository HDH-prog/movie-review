package com.movie.dto;

import lombok.Getter;

@Getter
public class CreateMovieRequest {

    private String title;
    private String email;
    private String password;
    private String phoneNumber;
}