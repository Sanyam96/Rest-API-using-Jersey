package com.nagarro.controllers;

import com.nagarro.models.Employee;
import com.nagarro.repository.EmployeeRepository;
import com.nagarro.service.EmployeeService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Sanyam Goel created on 16/9/18
 */
@Path("/")
public class EmployeeController {

    private EmployeeRepository employeeRepository = new EmployeeRepository();

    private EmployeeService employeeService = new EmployeeService();

    @GET
    @Path("/employees")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployees() {

//        List employees = employeeRepository.getEmployees();
        List<Employee> employees = employeeService.getAllEmployees();
        return employees;
    }

    @GET
    @Path("/employee/{employeeCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployee(
            @PathParam("employeeCode") long employeeCode
    ) {
        Employee employee = employeeService.getEmployee(employeeCode);
        return employee;
    }

    @POST
    @Path("/employee")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public void addEmployee(
//            @FormParam("employeeCode") long empCode,
//            @FormParam("employeeName") String empName,
//            @FormParam("location") String empLocation,
//            @FormParam("email") String empEmail,
//            @FormParam("dateOfBirth") String empDateOfBirth
            Employee employee
    ) {
//        Employee emp = new Employee();
//        emp.setEmployeeCode(empCode);
//        emp.setEmployeeName(empName);
//        emp.setLocation(empLocation);
//        emp.setEmail(empEmail);
//        Date date = null;
//        try {
//            date = new SimpleDateFormat("dd/MM/yyyy").parse(empDateOfBirth);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        emp.setDateOfBirth(date);
        String empDateOfBirth = employee.getDateOfBirth().toString();
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(empDateOfBirth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employee.setDateOfBirth(date);
        employeeService.addEmployee(employee);
    }

    @PUT
    @Path("/employee")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public void updateEmployee(
//            @FormParam("employeeCode") long empCode,
//            @FormParam("employeeName") String empName,
//            @FormParam("location") String empLocation,
//            @FormParam("email") String empEmail,
//            @FormParam("dateOfBirth") String empDateOfBirth
            Employee employee
    ) {
//        Employee emp = new Employee();
//        emp.setEmployeeCode(empCode);
//        emp.setEmployeeName(empName);
//        emp.setLocation(empLocation);
//        emp.setEmail(empEmail);
        String empDateOfBirth = employee.getDateOfBirth().toString();
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(empDateOfBirth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employee.setDateOfBirth(date);
        employeeService.updateEmployee(employee);
    }

}
