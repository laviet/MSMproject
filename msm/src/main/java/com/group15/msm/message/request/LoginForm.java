package com.group15.msm.message.request;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
/**
 * @author: laviet
 * Version: 1.0
 * Create date: 14-11-2019
 * Time: 23:54
 */
@Getter
@Setter
public class LoginForm {
    @NotBlank
    @Size(min=3, max = 60)//todo
    private String username;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
}
