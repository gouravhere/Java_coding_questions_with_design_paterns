package EqualAndHashCodeContract;

public class Employee {

	private int id;
	private String name;
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
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
	//for deep compare -- equals hash code 1st part i.e equals method
	public boolean equals(Employee emp) {
		if(emp == null || getClass()!= emp.getClass())
		{
			return false;
		}
		if(emp == this)
		{
			return true;
		}
		Employee e = (Employee)emp; //type casted
		return(this.getId() == e.getId());
		
	}
	
	//simplest way to get hash code
	public int hashCode() {
		return getId();
	}
}
