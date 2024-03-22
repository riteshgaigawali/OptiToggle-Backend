package com.optitoggle.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.optitoggle.main.payloads.ApiResponse;
import com.optitoggle.main.payloads.ToggleDto;
import com.optitoggle.main.payloads.ToggleDtoResponse;
import com.optitoggle.main.services.ToggleService;

import io.swagger.annotations.Api;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/optitoggle")
@Api(tags = "Toggle Management APIs")
public class ToggleController {

    @Autowired
    private ToggleService toggleService;

    // GET -- Get all toggle details.
    @GetMapping("/toggle")
    public ResponseEntity<List<ToggleDtoResponse>> getAllToggle() {
        List<ToggleDtoResponse> toggleDtoResponses = this.toggleService.getAllToggle();
        return new ResponseEntity<List<ToggleDtoResponse>>(toggleDtoResponses, HttpStatus.OK);

    }

    // GET -- Get toggle by id.
    @GetMapping("toggle/{flagId}")
    public ResponseEntity<ToggleDtoResponse> getToggleById(@PathVariable int flagId) {
        ToggleDtoResponse toggleDtoResponse = this.toggleService.getToggleById(flagId);
        return new ResponseEntity<ToggleDtoResponse>(toggleDtoResponse, HttpStatus.OK);
    }

    // GET -- Get toggle of particular user

    @GetMapping("user/{userid}/toggle")
    public ResponseEntity<List<ToggleDtoResponse>> getToggleByUser(@PathVariable Integer userid) {
        List<ToggleDtoResponse> toggles = this.toggleService.getTogglesByUser(userid);
        return new ResponseEntity<List<ToggleDtoResponse>>(toggles, HttpStatus.OK);
    }

    // POST -- Add toggle.
    @PostMapping(path = "user/{userid}/toggle", consumes = "application/json")
    public ResponseEntity<ToggleDtoResponse> addToggle(@Valid @RequestBody ToggleDto toggleDto,
            @PathVariable Integer userid) {
        ToggleDtoResponse toggleAdded = this.toggleService.addToggle(toggleDto, userid);
        return new ResponseEntity<ToggleDtoResponse>(toggleAdded, HttpStatus.CREATED);

    }

    // PUT -- Update toggle
    @PutMapping("/toggle/{flagId}")
    public ResponseEntity<ToggleDtoResponse> updateToggle(@Valid @RequestBody ToggleDto toggleDto,
            @PathVariable int flagId) {
        ToggleDtoResponse updatedToggle = this.toggleService.updateToggle(toggleDto, flagId);
        return new ResponseEntity<ToggleDtoResponse>(updatedToggle, HttpStatus.OK);
    }

    // DELETE -- Delete toggle

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("toggle/{flagId}")
    public ResponseEntity<ApiResponse> deleteToggle(@PathVariable int flagId) {
        this.toggleService.deleteToggle(flagId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Toggle deleted succesfully", true), HttpStatus.OK);

    }
}
