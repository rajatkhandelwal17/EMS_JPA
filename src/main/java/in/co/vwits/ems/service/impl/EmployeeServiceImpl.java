package in.co.vwits.ems.service.impl;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import in.co.vwits.ems.dao.EmployeeDAO;
import in.co.vwits.ems.dao.impl.EmployeeJdbcDaoImpl;
import in.co.vwits.ems.dao.impl.EmployeeJpaDaoImpl;
import in.co.vwits.ems.model.Employee;
import in.co.vwits.ems.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl() {
    	employeeDAO = new EmployeeJpaDaoImpl();
//     	employeeDAO = new EmployeeJdbcDaoImpl();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
    
    @Override
	public List<Employee> sortEmployeesByName() {
	    return employeeDAO.getAllEmployees()
	              .stream()
	              .sorted(Comparator.comparing(Employee::getName))
	              .collect(Collectors.toList());
	}
    
    public List<Employee> sortEmployeesBySalary() {
	    return employeeDAO.getAllEmployees()
	              .stream()
	              .sorted(Comparator.comparing(Employee::getSalary))
	              .collect(Collectors.toList());
	}
}
