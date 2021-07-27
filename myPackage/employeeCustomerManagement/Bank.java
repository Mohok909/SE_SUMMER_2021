package myPackage.employeeCustomerManagement;
import myPackage.accountManagement.Customer;

public class Bank implements CustomerOperations,EmployeeOperations
{
	private Customer[] customers=new Customer[50];
	private Employee[] employees=new Employee[50];
	static int i=0,j=0;

	public void insertCustomer(Customer c)
	{
		try
		{
			customers[i]=c;
			i++;
			System.out.println("Customer inserted successfully");
		}
		catch(ArrayIndexOutOfBoundsException ex)
		{
			System.out.println("Customer insertion failed\nMaximum "+customers.length+" customers can be inserted");
		}
	}
	public void CustomerbyID(Customer c)
	{
		if(c!=null)
		{
			System.out.println("Details of Customer "+(i+1)+":");
			System.out.println("Name: "+customers[i].getName());
			System.out.println("NID: "+customers[i].getNid());	
		}
		else
		{
			
		}
	}
	public Customer getCustomer(int nid)
	{
		try
		{	
			for(i=0;i<customers.length;i++)
			{
				if(customers[i].getNid()==nid)
				{
					return customers[i];
				}
			}
		}
		catch(NullPointerException ex)
		{
			System.out.println("NID not found");
		}
		return null;
	}
	public void showAllCustomers()
	{
		for(i=0;i<customers.length;i++)
		{
			if(customers[i]!=null)
			{
				
				System.out.println("Details of Customer "+(i+1)+":");
				System.out.println("Name: "+customers[i].getName());
				System.out.println("NID: "+customers[i].getNid());
					
			}
			else
			{
				break;
			}
		}
	}

	public void insertEmployee(Employee e)
	{
		try
		{
			employees[j]=e;
			j++;
			System.out.println("Employee inserted successfully");
		}
		catch(ArrayIndexOutOfBoundsException ex)
		{
			System.out.println("Employee insertion failed "+employees.length+" employees can be inserted");
		}
	}
	public void EmployeebyID(Employee e)
	{
		

		if(employees[j]!=null)
		{
			
			System.out.println("Details of Employee "+(j+1)+":");
			System.out.println("Name: "+employees[j].getName());
			System.out.println("ID: "+employees[j].getEmpId());
			System.out.println("Salary: "+employees[j].getSalary());
			
		}
		else
		{
			
		}
	}
	public Employee getEmployee(String empId)
	{
		try
		{	
			for(j=0;j<employees.length;j++)
			{
				if((employees[j].getEmpId()).equals(empId)==true)
				{
					return employees[j];
				}
			}
		}
		catch(NullPointerException ex)
		{
			System.out.println("Employee's ID not found");
		}
		return null;
	}
	public void showAllEmployees()
	{
		for(j=0;j<employees.length;j++)
		{
			if(employees[j]!=null)
			{
				
				System.out.println("Details of Employee "+(j+1)+":");
				System.out.println("Name: "+employees[j].getName());
				System.out.println("ID: "+employees[j].getEmpId());
				System.out.println("Salary: "+employees[j].getSalary());
				
			}
			else
			{
				break;
			}
		}
	}
}