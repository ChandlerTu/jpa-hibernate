package examples.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.chandlertu.jpa");
		EntityManager em = emf.createEntityManager();
		EmployeeService service = new EmployeeService(em);

		em.getTransaction().begin();
		Employee emp = service.createEmployee(158, "John Doe", 45000);
		em.getTransaction().commit();
		System.out.println("Persisted " + emp);

		emp = service.findEmployee(158);
		System.out.println("Found " + emp);

		List<Employee> emps = service.findAllEmployees();
		for (Employee e : emps) {
			System.out.println("Found employee: " + e);
		}

		em.getTransaction().begin();
		emp = service.raiseEmployeeSalary(158, 1000);
		em.getTransaction().commit();
		System.out.println("Updated " + emp);

		em.getTransaction().begin();
		service.removeEmployee(158);
		em.getTransaction().commit();
		System.out.println("Removed Employee 158");

		em.close();
		emf.close();
	}

}
