package com.example.service;

import com.example.Taskdto.EmployeeDTO;
import com.example.repositories.Task.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDTO> findByName() {
        return null;
    }

    @Override
    public List<EmployeeDTO> findByName(String name) {
        return this.employeeRepository.findByName(name);
    }

}
