package com.optitoggle.main.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.optitoggle.main.entities.Roles;

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

    private Integer userid;
    @NotEmpty(message = "Name can not be empty !!")
    private String firstName;
    @NotEmpty(message = "Name can not be empty !!")
    private String lastName;
    @Email(message = "Email address is not valid !!")
    private String emailid;
    @NotEmpty
    @Size(min = 3, max = 10, message = "Password must be min 3 charecters or max 10 charecters long !!")
    private String password;
    private Date createdOn;

    private Set<Roles> roles = new HashSet<>();
}
