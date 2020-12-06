package com.telecom.kanban.service.impl;
import com.telecom.kanban.dao.DeveloperRepository;
import com.telecom.kanban.domain.Developer;
import com.telecom.kanban.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeveloperServiceImpl implements DeveloperService {
    @Autowired
    private DeveloperRepository developerRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Developer> findAllDevelopers() {
        return this.developerRepository.findAll();
    }
}
