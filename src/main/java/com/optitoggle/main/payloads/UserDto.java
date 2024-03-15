package com.optitoggle.main.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    @NotEmpty(message = "First name can't be empty !")
    private String firstName;
    @NotEmpty(message = "Last name can't be empty !")
    private String lastName;
    @Email(message = "Email address is not valid !")
    @NotEmpty(message = "Email can't be empty !")
    private String emailid;
    @NotEmpty(message = "Password can't be empty !")
    @Size(min = 3, max = 10, message = "Password must be min 3 charecters or max 10 charecters long !")
    private String password;

}
