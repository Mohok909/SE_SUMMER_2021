package myPackage.accountManagement;
import myPackage.transactionManagement.Account;

interface AccountOperations
{
	void insertAccount(Account a);
	void AccountbyID(Account a);
	Account getAccount(int accountNumber);
	void showAllAccounts();
}