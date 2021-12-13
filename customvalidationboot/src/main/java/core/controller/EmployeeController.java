package core.controller;

import core.model.Employee;
import core.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/weblearner")
public class EmployeeController {

	@Autowired
	private EmployeeService dummyService;

	@GetMapping("/employees")
	public List<Employee> getEmployees() {

		return dummyService.getAll();
	}

	@PostMapping("/employees")
	public Employee newEmployee(@Valid @RequestBody Employee employee) {
		return dummyService.addEmployee(employee);
	}


}
