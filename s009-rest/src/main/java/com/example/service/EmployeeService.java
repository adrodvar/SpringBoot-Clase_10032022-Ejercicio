package com.example.service;

import com.example.Taskdto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> findByName();

    List<EmployeeDTO> findByName(String name);
}
