package com.optitoggle.main.payloads;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ToggleDtoResponse {

    private int flagId;
    @NotEmpty(message = "Key can not be empty !!")
    private String key;
    @NotEmpty(message = "Name can not be empty !!")
    private String name;
    private String description;
    private boolean enabled;
    private String optionalField;
    private Date createdOn;

}
