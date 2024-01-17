package com.optitoggle.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.optitoggle.main.payloads.ApiResponse;
import com.optitoggle.main.payloads.ToggleDto;
import com.optitoggle.main.services.ToggleService;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/optitoggle")
public class ToggleController {

    @Autowired
    private ToggleService toggleService;

    // GET -- Get all toggle details.
    @GetMapping("/toggle")
    public ResponseEntity<List<ToggleDto>> getAllToggle() {
        List<ToggleDto> toggleDtos = this.toggleService.getAllToggle();
        return new ResponseEntity<List<ToggleDto>>(toggleDtos, HttpStatus.OK);

    }

    // GET -- Get toggle by id.
    @GetMapping("toggle/{flagId}")
    public ResponseEntity<ToggleDto> getToggleById(@PathVariable int flagId) {
        ToggleDto toggleDto = this.toggleService.getToggleById(flagId);
        return new ResponseEntity<ToggleDto>(toggleDto, HttpStatus.OK);
    }

    // GET -- Get toggle of particular user
    @GetMapping("user/{userid}/toggle")
    public ResponseEntity<List<ToggleDto>> getToggleByUser(@PathVariable Integer userid) {
        List<ToggleDto> toggles = this.toggleService.getTogglesByUser(userid);
        return new ResponseEntity<List<ToggleDto>>(toggles, HttpStatus.OK);
    }

    // POST -- Add toggle.
    @PostMapping(path = "user/{userid}/toggle", consumes = "application/json")
    public ResponseEntity<ToggleDto> addToggle(@Valid @RequestBody ToggleDto toggleDto, @PathVariable Integer userid) {
        ToggleDto toggleAdded = this.toggleService.addToggle(toggleDto, userid);
        return new ResponseEntity<ToggleDto>(toggleAdded, HttpStatus.CREATED);

    }

    // PUT -- Update toggle
    @PutMapping("/toggle/{flagId}")
    public ResponseEntity<ToggleDto> updateToggle(@Valid @RequestBody ToggleDto toggleDto, @PathVariable int flagId) {
        ToggleDto updatedToggle = this.toggleService.updateToggle(toggleDto, flagId);
        return new ResponseEntity<ToggleDto>(updatedToggle, HttpStatus.OK);
    }

    // DELETE -- Delete toggle
    @DeleteMapping("toggle/{flagId}")
    public ResponseEntity<ApiResponse> deleteToggle(@PathVariable int flagId) {
        this.toggleService.deleteToggle(flagId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Toggle deleted succesfully", true), HttpStatus.OK);

    }
}
