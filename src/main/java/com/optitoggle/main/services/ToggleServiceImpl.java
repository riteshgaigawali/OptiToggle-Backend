package com.optitoggle.main.services;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.optitoggle.main.dao.ToggleDao;
import com.optitoggle.main.entities.Toggle;

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
    public Optional<Toggle> getToggleById(int flagId) {
        return toggleDao.findById(flagId);
    }

    // addToggle method impl
    @Override
    public Toggle addToggle(Toggle toggle) {
        toggleDao.save(toggle);
        return toggle;
    }

    // updateToggle method impl
    @Override
    public Toggle updateToggle(Toggle toggle) {
        toggleDao.save(toggle);
        return toggle;

    }

    // // deleteToggle mehtod impl
    @Override
    public void deleteToggle(int flagId) {
        toggleDao.deleteById(flagId);
    }

}
