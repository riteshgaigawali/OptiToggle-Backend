package com.optitoggle.main.services;

import java.util.List;

import com.optitoggle.main.payloads.ToggleDto;
import com.optitoggle.main.payloads.ToggleDtoResponse;

public interface ToggleService {

    // Find implementation of this methods in ToggleServiceImpl.java file.

    // Returns all toggle at once.
    public List<ToggleDtoResponse> getAllToggle();

    // Return toggle with specified id.
    public ToggleDtoResponse getToggleById(int flagId);

    // Return toggle associated with particular user.
    public List<ToggleDtoResponse> getTogglesByUser(Integer userid);

    // Add toggle to the database.
    public ToggleDtoResponse addToggle(ToggleDto toggleDto, Integer userid);

    // Update toggle.
    public ToggleDtoResponse updateToggle(ToggleDto toggleDto, int flagId);

    // Delete toggle from database.
    public void deleteToggle(int flagId);
}
