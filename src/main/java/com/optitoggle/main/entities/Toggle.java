package com.optitoggle.main.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
    private Date createdOn;
    private String optionalField;
    @ManyToOne // Many toggles can belong to one user
    private User user;

}
