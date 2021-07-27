package myPackage.transactionManagement;

import java.io.*;
import java.lang.*;

public abstract class Account implements ITransactions
{
	private int accountNumber;
	private double balance;
	
	public void setAccountNumber(int accountNumber)
	{
		this.accountNumber=accountNumber;
	}
	public void setBalance(double balance)
	{
		this.balance=balance;
	}
	public int getAccountNumber()
	{
		return this.accountNumber;
	}
	public double getBalance()
	{
		return this.balance;
	}
	abstract public void showInfo();

	File folder;
	File file;
	private FileWriter writer;
	private FileReader reader;
	private BufferedReader buffer;

	public void createDirectory()
	{
		try
		{
			folder=new File("F:/AIUB/3rd Semester/Java/FinalTerm/Project/project/Java Project/Transaction details");
			folder.mkdir();
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
		}
	}
	public void writeInFile(String s)
	{
		try
		{
			file = new File("Transaction details/Transactions.txt");
			file.createNewFile();
			writer = new FileWriter(file, true);
			writer.write(s+"\r\n");
			writer.flush();
			writer.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace() ;
		}
	}
	public void readFromFile()
	{
		try
		{
			reader = new FileReader(file);
			buffer = new BufferedReader(reader);
			String text=" ", temp;
			
			while((temp=buffer.readLine())!=null)
			{
				
				text=text+temp+"\r"+"\n";
			}
			System.out.print(text);
			reader.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}	
	}
	
	public void deposit(double amount)
	{
		writeInFile("Before deposit\n Balance of account number "+accountNumber+" : "+balance);
		this.balance=balance+amount;
		writeInFile(amount+" Deposited successfully\n New balance "+accountNumber+" : "+balance+"");
		readFromFile();
	}
	public void withdraw(double amount)
	{
		if(amount<=balance)
		{
			writeInFile("Before withdraw\nBalance of account number "+accountNumber+" : "+balance);
			this.balance=balance-amount;
			writeInFile(amount+" Withdrawn successfully\nNew balance of account number "+accountNumber+" : "+balance+" ");
			readFromFile();	
		}
		else
		{
			System.out.println("Withdraw failed\nThe account has insufficient money to withdraw");
		}
	}
	public void transfer(Account a, double amount)
	{
		if(amount<=balance)
		{
			writeInFile(" Before transfer ");
			writeInFile("Account number "+accountNumber+" Balance : "+balance);
			writeInFile("Account number "+a.accountNumber+" Balance : "+a.balance);
			this.balance=balance-amount;
			a.balance=a.balance+amount;
			writeInFile(amount+" Transfered successfully from account number "+accountNumber+" to "+a.accountNumber);
			writeInFile("New balance of account number "+accountNumber+" : "+balance);
			writeInFile("New balance of account number "+a.accountNumber+" : "+a.balance+" ");
			readFromFile();
		}
		else
		{
			System.out.println("Transfer failed\n Account "+accountNumber+" does not have enough money");
		}
	}
}