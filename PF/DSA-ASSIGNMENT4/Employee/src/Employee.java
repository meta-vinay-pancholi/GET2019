public class Employee {
	int empId;
	String name;
    String adress;
	
	public Employee(int empId, String name , String adress) {
		super();
		this.empId = empId;
		this.name = name;
		this.adress = adress;
	
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
