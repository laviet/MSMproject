package com.group15.msm.message.response;

import com.group15.msm.dao.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 14-11-2019
 * Time: 23:59
 */
@Getter
@Setter
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String currentUser;
    private Set<Role> role;

    public JwtResponse(String accessToken, String currentUser, Set<Role> role) {
        this.token = accessToken;
        this.currentUser = currentUser;
        this.role = role;
    }
}
