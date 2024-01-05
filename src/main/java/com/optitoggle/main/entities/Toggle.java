package com.optitoggle.main.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Toggle {

    // Toggle table attributes.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int flagId;
    @Column(name = "toggle_key")
    private String key;
    private String name;
    private String description;
    private boolean enabled;
    private String createdBy;
    private Date createdOn = new Date();

}
