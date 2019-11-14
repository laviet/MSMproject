package com.group15.msm.message.response;

import lombok.Getter;
import lombok.Setter;

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

    public JwtResponse(String accessToken) {
        this.token = accessToken;
    }
}
