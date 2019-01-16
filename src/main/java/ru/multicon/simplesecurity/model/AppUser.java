package ru.multicon.simplesecurity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class AppUser {
    private Long userId;
    private String userName;
    private String encrytedPassword;

    @Override
    public String toString() {
        return this.userName + "/" + this.encrytedPassword;
    }
}
