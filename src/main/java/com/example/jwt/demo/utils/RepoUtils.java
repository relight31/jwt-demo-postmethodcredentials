package com.example.jwt.demo.utils;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class RepoUtils {

    public static UserDetails rowsetToUserDetails(SqlRowSet rowSet) {
        String username = rowSet.getString("username");
        String password = rowSet.getString("password");
        String roles = rowSet.getString("roles");

        return User.withUsername(username)
                .password(password)
                .roles(roles)
                .build();
    }
}
