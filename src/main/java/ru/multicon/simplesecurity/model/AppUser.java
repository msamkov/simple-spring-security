package ru.multicon.simplesecurity.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AppUser {
    private Long userId;
    private String userName;
    private String encrytedPassword;
}
