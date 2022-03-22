package com.example.controllers.TaskController;

import com.example.Taskdto.EmployeeDTO;
import com.example.entities.TaskDTO.Employee;
import com.example.repositories.Task.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    Logger log = LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/search/employee/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id){
        return this.employeeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search/Name/{name}")
    public List<EmployeeDTO>findByName(@PathVariable String name){
        List<EmployeeDTO> dto = this.employeeRepository.findByName(name);
        return  dto;
    }
}
