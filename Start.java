import java.util.Scanner;
import myPackage.accountManagement.*;
import myPackage.employeeCustomerManagement.*;
import myPackage.transactionManagement.*;

public class Start
{
	public static void main(String args[])
	{
		try
		{
			Bank bank=new Bank();
			Employee existingEmployee=new Employee();
			Customer existingCustomer=new Customer();
			System.out.println("Welcome to the Bank System");
			Scanner input=new Scanner(System.in);
			int option;
			
			do
			{
				
				System.out.println("1. Employee Management");
				System.out.println("2. Customer Management");
				System.out.println("3. Customer Account Management");
				System.out.println("4. Account Transactions");
				System.out.println("5. Exit");
				option=input.nextInt();
				input.nextLine();
				
				if(option==1)
				{
					String name;
					String empId;
					double salary;
					Employee newEmployee=new Employee();
					System.out.println("1. Insert New Employee");
					System.out.println("2. Get Existing employee by Id");
					System.out.println("3. Show All Employees");
					option=input.nextInt();
					input.nextLine();
					
					
					if(option==1)
					{
						System.out.println("Enter employee Name");
						name=input.nextLine();
						newEmployee.setName(name);
						System.out.println("Enter employee's ID");
						empId=input.nextLine();
						newEmployee.setEmpId(empId);
						System.out.println("Enter employee's salary");
						salary=input.nextDouble();
						newEmployee.setSalary(salary);
						bank.insertEmployee(newEmployee);
					}
					
					
					else if(option==2)
					{
						System.out.println("Enter employee's ID");
						empId=input.nextLine();
						bank.EmployeebyID(bank.getEmployee(empId));
					}
					
					
					else if(option==3)
					{
						bank.showAllEmployees();
					}
					
					else
					
					{
						System.out.println("Please select another one");
					}
				}
				
				else if(option==2)
				{
					String name;
					int nid;
					Customer newCustomer=new Customer();
					System.out.println("1. Insert New Customer");
					System.out.println("2. Get Existing Customer by Id");
					System.out.println("3. Show All Customer");
					option=input.nextInt();
					input.nextLine();
					
					if(option==1)
					{
						System.out.println("Enter the name of customer");
						name=input.nextLine();
						newCustomer.setName(name);
						System.out.println("Enter customer's NID");
						nid=input.nextInt();
						input.nextLine();
						newCustomer.setNid(nid);
						bank.insertCustomer(newCustomer);
					}
					
					else if(option==2)
					{
						System.out.println("Enter customer's NID");
						nid=input.nextInt();
						input.nextLine();
						bank.CustomerbyID(bank.getCustomer(nid));
					}
					
					else if(option==3)
					{
						bank.showAllCustomers();
					}
					
					else
					{
						System.out.println("No such option");
					}
				}
				
				
				else if(option==3)
				{
					int accountNumber;
					double balance;
					double interestRate;
					int tenureYear;
					System.out.println("1. Insert New Account");
					System.out.println("2. Get Existing employee by Id");
					System.out.println("3. Show All Accounts");
					option=input.nextInt();
					input.nextLine();
					
					if(option==1)
					{
						System.out.println("1. Savings Account");
						System.out.println("2. Fixed Account");
						option=input.nextInt();
						input.nextLine();
						
						if(option==1)
						{
							SavingsAccount s=new SavingsAccount();
							System.out.println("Enter account number");
							accountNumber=input.nextInt();
							input.nextLine();
							s.setAccountNumber(accountNumber);
							System.out.println("Enter account's balance");
							balance=input.nextDouble();
							input.nextLine();
							s.setBalance(balance);
							System.out.println("Enter account's interest rate");
							interestRate=input.nextDouble();
							input.nextLine();
							s.setInterestRate(interestRate);
							existingCustomer.insertAccount(s);
						}
						
						else if(option==2)
						{
							FixedAccount f=new FixedAccount();
							System.out.println("Enter account number");
							accountNumber=input.nextInt();
							input.nextLine();
							f.setAccountNumber(accountNumber);
							System.out.println("Enter account's balance");
							balance=input.nextDouble();
							input.nextLine();
							f.setBalance(balance);
							System.out.println("Enter account's tenure year");
							tenureYear=input.nextInt();
							input.nextLine();
							f.setTenureYear(tenureYear);
							existingCustomer.insertAccount(f);
						}
					}
					
					
					else if(option==2)
					{
						System.out.println("Enter account number");
						accountNumber=input.nextInt();
						input.nextLine();
						existingCustomer.AccountbyID(existingCustomer.getAccount(accountNumber));
					}
					
					else if(option==3)
					{
						existingCustomer.showAllAccounts();
					}
					
					else
					{
						System.out.println("No option found ");
					}
				}
				
				
				else if(option==4)
				{
					int accountNumber;
					double amount;
					System.out.println("1. Deposit Money");
					System.out.println("2. Withdraw Money");
					System.out.println("3. Transfer Money");
					option=input.nextInt();
					input.nextLine();
					
					
					if(option==1)
					{
						System.out.println("Enter account number for deposit money");
						accountNumber=input.nextInt();
						input.nextLine();
						System.out.println("Enter amount to deposit");
						amount=input.nextDouble();
						input.nextLine();
						(existingCustomer.getAccount(accountNumber)).createDirectory();
						(existingCustomer.getAccount(accountNumber)).deposit(amount);
					}
					
					
					else if(option==2)
					{
						System.out.println("Enter account number for withdraw money");
						accountNumber=input.nextInt();
						input.nextLine();
						System.out.println("Enter amount to withdraw");
						amount=input.nextDouble();
						input.nextLine();
						(existingCustomer.getAccount(accountNumber)).createDirectory();
						(existingCustomer.getAccount(accountNumber)).withdraw(amount);
					}
					
					else if(option==3)
					{
						int transferFrom,transferTo;
						System.out.println("Enter account number from which you want to transfer money");
						transferFrom=input.nextInt();
						input.nextLine();
						System.out.println("Enter account number to which you want to transfer money");
						transferTo=input.nextInt();
						input.nextLine();
						System.out.println("Enter amount of money to transfer");
						amount=input.nextDouble();
						input.nextLine();
						(existingCustomer.getAccount(transferFrom)).createDirectory();
						(existingCustomer.getAccount(transferFrom)).transfer(existingCustomer.getAccount(transferTo), amount);
					}
					else
					{
						System.out.println("Please select another option");
					}
				}
				
				
				else
				{
					if(option!=5)
					{
						System.out.println("Please select another option");
					}
					
					else
					{
						System.out.println("Program exit ");
					}
				}

			}while(option!=5);
		}
		
		catch(Exception ex)
		{
			System.out.println("Program exit ");
		}
	}
}