package in.co.vwits.ems.dao.impl;
import java.util.List;

import in.co.vwits.ems.dao.EmployeeDAO;
import in.co.vwits.ems.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class EmployeeJpaDaoImpl implements EmployeeDAO{
	
	private EntityManagerFactory factory;
	
	public EmployeeJpaDaoImpl() {
		factory = Persistence.createEntityManagerFactory("emsapp");	
	}

	@Override
	public List<Employee> getAllEmployees() {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		String jpql="FROM Employee";
		TypedQuery<Employee> query = em.createQuery(jpql,Employee.class);
		List<Employee> employeeList = query.getResultList();
		tx.commit();
		em.close();	
		return employeeList; 
	}

	@Override
	public Employee getEmployeeById(int id) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Employee e = em.find(Employee.class, id); 
		tx.commit();
		em.close(); 
		return e;
	}

	@Override
	public void addEmployee(Employee employee) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(employee);   
		tx.commit();
		em.close();
	}

	@Override
	public void updateEmployee(Employee employee) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(employee); 
		tx.commit();
		em.close();	
	}

	@Override
	public void deleteEmployee(int id) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Employee.class, id));  
		tx.commit();
		em.close(); 
	}
}