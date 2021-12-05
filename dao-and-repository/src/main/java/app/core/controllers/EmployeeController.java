package app.core.controllers;

import app.core.model.Employee;
import app.core.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value="/employeescount", method= RequestMethod.GET,headers = "Accept=application/json",produces = "application/json")
    public int readEmployees() {
        return employeeService.getEmployees().size();
    }

    @RequestMapping(value="/employeescount2", method= RequestMethod.GET,headers = "Accept=application/json",produces = "application/json")
    public int readEmployees2() {
        return employeeService.getEmployees2().size();
    }

}
