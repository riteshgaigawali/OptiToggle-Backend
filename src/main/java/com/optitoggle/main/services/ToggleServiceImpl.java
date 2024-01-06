package com.optitoggle.main.services;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.stereotype.Service;

import com.optitoggle.main.dao.ToggleDao;
import com.optitoggle.main.entities.Toggle;
import com.optitoggle.main.exceptions.ResourceNotFoundEexception;

@Service
public class ToggleServiceImpl implements ToggleService {

    @Autowired
    private ToggleDao toggleDao;

    // getAllToggle method impl
    @Override
    public List<Toggle> getAllToggle() {
        return toggleDao.findAll();
    }

    // getToggleById method impl
    @Override
    public Toggle getToggleById(int flagId) {
        return toggleDao.findById(flagId)
                .orElseThrow(() -> (new ResourceNotFoundEexception("Toggle", "flagId", flagId)));
    }

    // addToggle method impl
    @Override
    public Toggle addToggle(Toggle toggle) {
        toggleDao.save(toggle);
        return toggle;
    }

    // updateToggle method impl
    @Override
    public Toggle updateToggle(Toggle toggle, int flagId) {
        Toggle updatedToggle = toggleDao.findById(flagId)
                .orElseThrow(() -> (new ResourceNotFoundEexception("Toggle", "flagId", flagId)));
        updatedToggle.setKey(toggle.getKey());
        updatedToggle.setName(toggle.getName());
        updatedToggle.setDescription(toggle.getDescription());
        updatedToggle.setEnabled(toggle.isEnabled());
        updatedToggle.setCreatedBy(toggle.getCreatedBy());
        toggleDao.save(updatedToggle);
        return updatedToggle;

    }

    // // deleteToggle mehtod impl
    @Override
    public void deleteToggle(int flagId) {
        Toggle toggle = toggleDao.findById(flagId)
                .orElseThrow(() -> (new ResourceNotFoundEexception("Toggle", "flagId", flagId)));
        toggleDao.deleteById(toggle.getFlagId());
    }

}
