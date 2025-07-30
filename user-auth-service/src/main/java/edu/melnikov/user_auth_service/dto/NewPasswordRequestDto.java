package edu.melnikov.user_auth_service.dto;

import edu.melnikov.user_auth_service.validation.ValidPassword;
import lombok.Data;

@Data
public class NewPasswordRequestDto {
    @ValidPassword
    private String newPassword;

    @ValidPassword
    private String oldPassword;
}
