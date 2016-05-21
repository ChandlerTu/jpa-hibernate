package examples.model.table;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeTableTest2 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.chandlertu.jpa");
		EntityManager em = emf.createEntityManager();
		EmployeeTableService service = new EmployeeTableService(em);

		em.getTransaction().begin();
		EmployeeTable emp = service.createEmployeeTable("John Doe", 45000);
		em.getTransaction().commit();
		System.out.println("Persisted " + emp);

		em.getTransaction().begin();
		EmployeeTable emp2 = service.createEmployeeTable("John Doe2", 45000);
		em.getTransaction().commit();
		System.out.println("Persisted " + emp2);

		List<EmployeeTable> emps = service.findAllEmployeeTables();
		for (EmployeeTable e : emps) {
			System.out.println("Found EmployeeAuto: " + e);
		}

		EmployeeTableService2 service2 = new EmployeeTableService2(em);

		em.getTransaction().begin();
		EmployeeTable2 emp3 = service2.createEmployeeTable2("John Doe3", 45000);
		em.getTransaction().commit();
		System.out.println("Persisted " + emp3);

		em.getTransaction().begin();
		EmployeeTable2 emp4 = service2.createEmployeeTable2("John Doe4", 45000);
		em.getTransaction().commit();
		System.out.println("Persisted " + emp4);

		List<EmployeeTable2> emps2 = service2.findAllEmployeeTable2s();
		for (EmployeeTable2 e : emps2) {
			System.out.println("Found EmployeeAuto: " + e);
		}

		em.close();
		emf.close();
	}

}
