package com.nagarro.service;

import com.nagarro.models.Employee;
import com.nagarro.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Sanyam Goel created on 16/9/18
 */
@Service
@Transactional
public class EmployeeService {

//    @Autowired
//    EmployeeRepository employeeRepository;

    EmployeeRepository employeeRepository = new EmployeeRepository();

    @Transactional
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.getEmployees();
        if (employeeList == null) {
            System.err.println("Empty List found!");
        }
        return employeeList;
    }

    @Transactional
    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }

    //    @Transactional
    public void updateEmployee(Employee employee) {
        employeeRepository.updateEmployee(employee);
    }

    public Employee getEmployee(long empCode) {
        Employee employee = (Employee) employeeRepository.getEmployee(empCode);
        if (employee == null) {
            System.err.println("Employee not found!");
        }
        return employee;
    }


}
