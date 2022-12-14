package com.team.winners.thirdcycleproject.service;

import com.team.winners.thirdcycleproject.models.Employee;
import com.team.winners.thirdcycleproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public <S extends Employee> S save(S entity) {
        return employeeRepository.save(entity);
    }

    public void update(Employee enterpriseRequest, Integer id){
        Optional<Employee> employeeOp = this.employeeRepository.findById(id);
        Employee employee = employeeOp.get();

        employee.setEmail(enterpriseRequest.getEmail());
        employee.setEnterprise(enterpriseRequest.getEnterprise());
        employee.setRole(enterpriseRequest.getRole());
        employee.setProfile(enterpriseRequest.getProfile());

    }

    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    public Boolean deleteById(Integer id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.employeeRepository.findAll(pageable);
    }
}
