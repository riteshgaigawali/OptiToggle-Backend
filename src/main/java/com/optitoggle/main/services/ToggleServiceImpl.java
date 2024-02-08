package com.optitoggle.main.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.optitoggle.main.dao.ToggleDao;
import com.optitoggle.main.dao.UserDao;
import com.optitoggle.main.entities.Toggle;
import com.optitoggle.main.entities.User;
import com.optitoggle.main.exceptions.ResourceNotFoundException;
import com.optitoggle.main.payloads.ToggleDto;
import com.optitoggle.main.payloads.ToggleDtoResponse;

@Service
public class ToggleServiceImpl implements ToggleService {

    @Autowired
    private ToggleDao toggleDao;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserDao userDao;

    @Override
    public List<ToggleDtoResponse> getAllToggle() {
        List<Toggle> toggles = this.toggleDao.findAll();
        List<ToggleDtoResponse> toggleDtoResponses = toggles.stream()
                .map((toggle) -> this.modelMapper.map(toggle, ToggleDtoResponse.class))
                .collect(Collectors.toList());
        return toggleDtoResponses;

    }

    @Override
    public ToggleDtoResponse getToggleById(int flagId) {
        Toggle toggle = this.toggleDao.findById(flagId)
                .orElseThrow(() -> new ResourceNotFoundException("Toggle", "flagId", flagId));
        return this.modelMapper.map(toggle, ToggleDtoResponse.class);
    }

    @Override
    public List<ToggleDtoResponse> getTogglesByUser(Integer userid) {
        User user = this.userDao.findById(userid)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userid", userid));
        List<Toggle> toggles = this.toggleDao.findByUser(user);
        List<ToggleDtoResponse> toggleDtoResponses = toggles.stream()
                .map((toggle) -> this.modelMapper.map(toggle, ToggleDtoResponse.class))
                .collect(Collectors.toList());
        return toggleDtoResponses;
    }

    @Override
    public ToggleDtoResponse addToggle(ToggleDto toggleDto, Integer userid) {

        User user = this.userDao.findById(userid)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userid", userid));
        Toggle toggle = this.modelMapper.map(toggleDto, Toggle.class);
        toggle.setCreatedOn(new Date());
        toggle.setUser(user);
        Toggle toggleCreated = toggleDao.save(toggle);
        return this.modelMapper.map(toggleCreated, ToggleDtoResponse.class);

    }

    @Override
    public ToggleDtoResponse updateToggle(ToggleDto toggleDto, int flagId) {
        Toggle toggle = this.toggleDao.findById(flagId)
                .orElseThrow(() -> new ResourceNotFoundException("Toggle", "flagId", flagId));
        toggle.setKey(toggleDto.getKey());
        toggle.setName(toggleDto.getName());
        toggle.setDescription(toggleDto.getDescription());
        toggle.setEnabled(toggleDto.isEnabled());
        Toggle toggleUpdated = toggleDao.save(toggle);
        return this.modelMapper.map(toggleUpdated, ToggleDtoResponse.class);

    }

    @Override
    public void deleteToggle(int flagId) {
        Toggle toggle = this.toggleDao.findById(flagId)
                .orElseThrow(() -> new ResourceNotFoundException("Toggle", "flagId", flagId));
        this.toggleDao.delete(toggle);
    }

}
