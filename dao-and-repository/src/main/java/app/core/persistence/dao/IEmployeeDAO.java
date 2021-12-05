package app.core.persistence.dao;

import app.core.model.Employee;

import java.util.List;

public interface IEmployeeDAO {

    public List<Employee> getEmployees();
}
