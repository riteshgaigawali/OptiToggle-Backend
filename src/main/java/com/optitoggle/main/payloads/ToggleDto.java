package com.optitoggle.main.payloads;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ToggleDto {

    private int flagId;
    @NotEmpty(message = "Key can not be empty !!")
    private String key;
    @NotEmpty(message = "Name can not be empty !!")
    private String name;
    private String description;
    private boolean enabled;
    private Date createdOn;
    private UserDto user;

}
