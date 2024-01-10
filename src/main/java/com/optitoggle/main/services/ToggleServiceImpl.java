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

@Service
public class ToggleServiceImpl implements ToggleService {

    @Autowired
    private ToggleDao toggleDao;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserDao userDao;

    @Override
    public List<ToggleDto> getAllToggle() {
        List<Toggle> toggles = this.toggleDao.findAll();
        List<ToggleDto> toggleDtos = toggles.stream().map((toggle) -> this.modelMapper.map(toggle, ToggleDto.class))
                .collect(Collectors.toList());
        return toggleDtos;

    }

    @Override
    public ToggleDto getToggleById(int flagId) {
        Toggle toggle = this.toggleDao.findById(flagId)
                .orElseThrow(() -> new ResourceNotFoundException("Toggle", "flagId", flagId));
        return this.modelMapper.map(toggle, ToggleDto.class);
    }

    @Override
    public List<ToggleDto> getTogglesByUser(Integer userid) {
        User user = this.userDao.findById(userid)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userid", userid));
        List<Toggle> toggles = this.toggleDao.findByUser(user);
        List<ToggleDto> toggleDtos = toggles.stream().map((toggle) -> this.modelMapper.map(toggle, ToggleDto.class))
                .collect(Collectors.toList());
        return toggleDtos;
    }

    @Override
    public ToggleDto addToggle(ToggleDto toggleDto, Integer userid) {

        User user = this.userDao.findById(userid)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userid", userid));
        Toggle toggle = this.modelMapper.map(toggleDto, Toggle.class);
        toggle.setCreatedOn(new Date());
        toggle.setUser(user);
        Toggle toggleCreated = toggleDao.save(toggle);
        return this.modelMapper.map(toggleCreated, ToggleDto.class);

    }

    @Override
    public ToggleDto updateToggle(ToggleDto toggleDto, int flagId) {
        Toggle toggle = this.toggleDao.findById(flagId)
                .orElseThrow(() -> new ResourceNotFoundException("Toggle", "flagId", flagId));
        toggle.setKey(toggleDto.getKey());
        toggle.setName(toggleDto.getName());
        toggle.setDescription(toggleDto.getDescription());
        toggle.setEnabled(toggleDto.isEnabled());
        Toggle toggleUpdated = toggleDao.save(toggle);
        return this.modelMapper.map(toggleUpdated, ToggleDto.class);

    }

    @Override
    public void deleteToggle(int flagId) {
        Toggle toggle = this.toggleDao.findById(flagId)
                .orElseThrow(() -> new ResourceNotFoundException("Toggle", "flagId", flagId));
        this.toggleDao.delete(toggle);
    }

}
