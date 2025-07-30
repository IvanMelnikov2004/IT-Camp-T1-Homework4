package edu.melnikov.user_auth_service.dto;

import edu.melnikov.user_auth_service.validation.ValidEmail;
import edu.melnikov.user_auth_service.validation.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {

    @ValidEmail
    private String email;

    @ValidPassword
    private String password;
}
