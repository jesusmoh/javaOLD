package app.core.persistence.dao;

import app.core.model.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeDAOImp implements IEmployeeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Employee> getEmployees()
    {
        String query = "SELECT * FROM employee";
        List<Employee> r= entityManager.createNativeQuery(query).getResultList();
        return r;
    }

}
