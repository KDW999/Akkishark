package org.example.back.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequestDto {

    @NotBlank
    @Length(max=16)
    String nickname;

    @NotBlank
    @Length(max=16)
    String password;

    @NotBlank
    @Length(max=8)
    String gender;

    @NotBlank
    String birth;

    @NotBlank
    String user_email;

    @URL
    String profile_image;
}
