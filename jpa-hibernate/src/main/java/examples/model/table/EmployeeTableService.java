package examples.model.table;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class EmployeeTableService {

	protected EntityManager em;

	public EmployeeTableService(EntityManager em) {
		this.em = em;
	}

	public EmployeeTable createEmployeeTable(String name, long salary) {
		EmployeeTable emp = new EmployeeTable();
		emp.setName(name);
		emp.setSalary(salary);
		em.persist(emp);
		return emp;
	}

	public List<EmployeeTable> findAllEmployeeTables() {
		TypedQuery<EmployeeTable> query = em.createQuery("SELECT e FROM EmployeeTable e", EmployeeTable.class);
		return query.getResultList();
	}

}
