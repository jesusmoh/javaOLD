package app.core.service;

import app.core.model.Employee;
import app.core.persistence.dao.IEmployeeDAO;
import app.core.persistence.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    IEmployeeRepository iEmployeeRepository;

    @Autowired
    IEmployeeDAO iEmployeeDAO;

    public List<Employee> getEmployees() {
        return iEmployeeRepository.findAll();
    }

    public List<Employee> getEmployees2() {
        return iEmployeeDAO.getEmployees();
    }

}
