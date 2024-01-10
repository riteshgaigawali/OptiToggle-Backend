package com.optitoggle.main.services;

import java.util.List;

import com.optitoggle.main.payloads.ToggleDto;

public interface ToggleService {

    // Find implementation of this methods in ToggleServiceImpl.java file.

    // Returns all toggle at once.
    public List<ToggleDto> getAllToggle();

    // Return toggle with specified id.
    public ToggleDto getToggleById(int flagId);

    // Return toggle associated with particular user.
    public List<ToggleDto> getTogglesByUser(Integer userid);

    // Add toggle to the database.
    public ToggleDto addToggle(ToggleDto toggleDto, Integer userid);

    // Update toggle.
    public ToggleDto updateToggle(ToggleDto toggleDto, int flagId);

    // Delete toggle from database.
    public void deleteToggle(int flagId);
}
