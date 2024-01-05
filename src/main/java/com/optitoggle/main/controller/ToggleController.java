package com.optitoggle.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.optitoggle.main.entities.Toggle;
import com.optitoggle.main.services.ToggleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class ToggleController {

    @Autowired
    private ToggleService toggleService;

    // Get all toggle details.
    @GetMapping("/toggle")
    public List<Toggle> getAllToggle() {

        return this.toggleService.getAllToggle();

    }

    // Get toggle by id.
    @GetMapping("toggle/{flagId}")
    public Optional<Toggle> getToggleById(@PathVariable int flagId) {

        return this.toggleService.getToggleById(flagId);
    }

    // Add toggle.
    @PostMapping(path = "/toggle", consumes = "application/json")
    public Toggle addToggle(@RequestBody Toggle toggle) {

        return this.toggleService.addToggle(toggle);
    }

    // Update toggle
    @PutMapping("/toggle")
    public Toggle updateToggle(@RequestBody Toggle toggle) {

        return this.toggleService.updateToggle(toggle);
    }

    // // Delete toggle
    @DeleteMapping("toggle/{flagId}")
    public ResponseEntity<HttpStatus> deleteToggle(@PathVariable int flagId) {
        try {
            this.toggleService.deleteToggle(flagId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
