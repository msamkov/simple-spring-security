package ru.multicon.simplesecurity.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.multicon.simplesecurity.model.AppUser;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AppUserMapper implements RowMapper<AppUser> {

    public static final String BASE_SQL //
            = "Select u.User_Id, u.User_Name, u.Encryted_Password From App_User u ";

    @Override
    public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {

        Long userId = rs.getLong("User_Id");
        String userName = rs.getString("User_Name");
        String encrytedPassword = rs.getString("Encryted_Password");

        return AppUser.builder()
                .userId(userId)
                .userName(userName)
                .encrytedPassword(encrytedPassword)
                .build();
    }

}
