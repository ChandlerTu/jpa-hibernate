package examples.model.table;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class EmployeeTableService2 {

	protected EntityManager em;

	public EmployeeTableService2(EntityManager em) {
		this.em = em;
	}

	public EmployeeTable2 createEmployeeTable2(String name, long salary) {
		EmployeeTable2 emp = new EmployeeTable2();
		emp.setName(name);
		emp.setSalary(salary);
		em.persist(emp);
		return emp;
	}

	public List<EmployeeTable2> findAllEmployeeTable2s() {
		TypedQuery<EmployeeTable2> query = em.createQuery("SELECT e FROM EmployeeTable2 e", EmployeeTable2.class);
		return query.getResultList();
	}

}
