package com.optitoggle.main.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Roles {
    @Id
    private int roleId;
    private String roleName;
    private String description;

}
