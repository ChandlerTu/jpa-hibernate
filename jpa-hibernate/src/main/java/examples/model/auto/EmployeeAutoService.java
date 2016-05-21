package examples.model.auto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class EmployeeAutoService {

	protected EntityManager em;

	public EmployeeAutoService(EntityManager em) {
		this.em = em;
	}

	public EmployeeAuto createEmployeeAuto(String name, long salary) {
		EmployeeAuto emp = new EmployeeAuto();
		emp.setName(name);
		emp.setSalary(salary);
		em.persist(emp);
		return emp;
	}

	public List<EmployeeAuto> findAllEmployeeAutos() {
		TypedQuery<EmployeeAuto> query = em.createQuery("SELECT e FROM EmployeeAuto e", EmployeeAuto.class);
		return query.getResultList();
	}

}
