package com.optitoggle.main.services;

import java.util.List;

import com.optitoggle.main.entities.Toggle;

public interface ToggleService {

    // Find implementation of this methods in ToggleServiceImpl.java file.

    // Returns all toggle at once.
    public List<Toggle> getAllToggle();

    // Return toggle with specified id.
    public Toggle getToggleById(int flagId);

    // Add toggle to the database.
    public Toggle addToggle(Toggle toggle);

    // Update toggle.
    public Toggle updateToggle(Toggle toggle, int flagId);

    // Delete toggle from database.
    public void deleteToggle(int flagId);
}
