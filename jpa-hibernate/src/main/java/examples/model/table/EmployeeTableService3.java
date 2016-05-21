package examples.model.table;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class EmployeeTableService3 {

	protected EntityManager em;

	public EmployeeTableService3(EntityManager em) {
		this.em = em;
	}

	public EmployeeTable3 createEmployeeTable3(String name, long salary) {
		EmployeeTable3 emp = new EmployeeTable3();
		emp.setName(name);
		emp.setSalary(salary);
		em.persist(emp);
		return emp;
	}

	public List<EmployeeTable3> findAllEmployeeTable3s() {
		TypedQuery<EmployeeTable3> query = em.createQuery("SELECT e FROM EmployeeTable3 e", EmployeeTable3.class);
		return query.getResultList();
	}

}
