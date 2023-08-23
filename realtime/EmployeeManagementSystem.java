package realtime;
class employee
{
	final static String companyname = "PRAVEEN TEA SHOP";
	int id;
	String name;
	double salary;
	employee(int id,String name,double salary)
	{
		System.out.println("create employee object....");
		this.id = id;
		this.name = name;
		this.salary = salary;	
	}

	void display() 
	{
		System.out.println("employee id "+id);
		System.out.println("employee name "+name);
		System.out.println("employee salary "+salary);
		
	}
	
}
public class EmployeeManagementSystem 
{
	public static void main(String[] args) 
	{
		System.out.println("welcome to "+employee.companyname);
		employee emp = new employee(123,"praveen",10000.0);
		emp.display();
		employee emp1 = new employee(123,"praveen",10000.0);
		emp1.display();
	}
}
