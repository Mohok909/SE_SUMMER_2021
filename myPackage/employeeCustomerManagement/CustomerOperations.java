package myPackage.employeeCustomerManagement;
import myPackage.accountManagement.Customer;

interface CustomerOperations
{
	void insertCustomer(Customer c);
	void CustomerbyID(Customer c);
	Customer getCustomer(int nid);
	void showAllCustomers();
}