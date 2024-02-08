package com.optitoggle.main.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.optitoggle.main.entities.Roles;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDtoResponse {

    private Integer userid;
    @NotEmpty(message = "Name can not be empty !!")
    private String firstName;
    @NotEmpty(message = "Name can not be empty !!")
    private String lastName;
    @Email(message = "Email address is not valid !!")
    private String emailid;

    private Date createdOn;

    private Set<Roles> roles = new HashSet<>();
}
