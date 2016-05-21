package examples.model.table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class EmployeeTable3 {

	@TableGenerator(name = "EmployeeTable3", allocationSize = 1)
	@Id
	@GeneratedValue(generator = "EmployeeTable3")
	private int id;
	private String name;
	private long salary;

	public EmployeeTable3() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

}
