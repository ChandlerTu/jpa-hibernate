package examples.model.auto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeAutoTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.chandlertu.jpa");
		EntityManager em = emf.createEntityManager();
		EmployeeAutoService service = new EmployeeAutoService(em);

		em.getTransaction().begin();
		EmployeeAuto emp = service.createEmployeeAuto("John Doe", 45000);
		em.getTransaction().commit();
		System.out.println("Persisted " + emp);

		em.getTransaction().begin();
		EmployeeAuto emp2 = service.createEmployeeAuto("John Doe2", 45000);
		em.getTransaction().commit();
		System.out.println("Persisted " + emp2);

		List<EmployeeAuto> emps = service.findAllEmployeeAutos();
		for (EmployeeAuto e : emps) {
			System.out.println("Found EmployeeAuto: " + e);
		}

		em.close();
		emf.close();
	}

}
