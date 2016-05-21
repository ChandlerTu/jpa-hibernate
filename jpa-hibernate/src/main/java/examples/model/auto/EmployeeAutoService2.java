package examples.model.auto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class EmployeeAutoService2 {

	protected EntityManager em;

	public EmployeeAutoService2(EntityManager em) {
		this.em = em;
	}

	public EmployeeAuto2 createEmployeeAuto2(String name, long salary) {
		EmployeeAuto2 emp = new EmployeeAuto2();
		emp.setName(name);
		emp.setSalary(salary);
		em.persist(emp);
		return emp;
	}

	public List<EmployeeAuto2> findAllEmployeeAuto2s() {
		TypedQuery<EmployeeAuto2> query = em.createQuery("SELECT e FROM EmployeeAuto2 e", EmployeeAuto2.class);
		return query.getResultList();
	}

}
