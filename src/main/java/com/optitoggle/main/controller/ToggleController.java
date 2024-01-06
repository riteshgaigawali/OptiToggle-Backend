package com.optitoggle.main.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/optitoggle")
public class ToggleController {

    @Autowired
    private ToggleService toggleService;

    // Get all toggle details.
    @GetMapping("/toggle")
    public ResponseEntity<List<Toggle>> getAllToggle() {

        try {
            return new ResponseEntity<>(this.toggleService.getAllToggle(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // Get toggle by id.
    @GetMapping("toggle/{flagId}")
    public ResponseEntity<Toggle> getToggleById(@PathVariable int flagId) {

        try {
            return new ResponseEntity<>(this.toggleService.getToggleById(flagId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Add toggle.
    @PostMapping(path = "/toggle", consumes = "application/json")
    public ResponseEntity<Toggle> addToggle(@RequestBody Toggle toggle) {
        try {
            return new ResponseEntity<>(this.toggleService.addToggle(toggle), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // Update toggle
    @PutMapping("/toggle/{flagId}")
    public ResponseEntity<Toggle> updateToggle(@RequestBody Toggle toggle, @PathVariable int flagId) {
        try {
            return new ResponseEntity<>(this.toggleService.updateToggle(toggle, flagId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

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
