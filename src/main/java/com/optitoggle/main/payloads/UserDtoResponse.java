package com.optitoggle.main.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.optitoggle.main.entities.Roles;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDtoResponse {

    private Integer userid;
    private String firstName;
    private String lastName;
    private String emailid;
    private Date createdOn;

    private Set<Roles> roles = new HashSet<>();
}
