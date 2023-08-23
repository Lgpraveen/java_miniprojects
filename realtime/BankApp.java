package realtime;

class account
{
	int accno;
	double accbal;
	account(int accno, double accbal) 
	{
		System.out.println("Account Created successfully");
		this.accno = accno;
		this.accbal = accbal;
	}
	void deposit(double amt) {
		System.out.println("dummy");
	}
	void withdraw(double amt) {
		System.out.println("dummy");
	}
	void balanceenquiry() {
		System.out.println("your acc balance : "+ accbal);
	}
}
class savingaccount extends account
{
	savingaccount(int accno,double accbal)
	{
		super(accno,accbal);
		System.out.println("saving acc created sucessfully...");
		
	}
	void deposit(double amt)
	{
		System.out.println("deposit the savings account = "+amt);
		accbal = accbal+amt;
		System.out.println("youer savings accbal = "+ accbal);
	}
	
	void withdraw(double amt)
	{
		if(amt>0) {
			System.out.println("insufficient balance");
		}
		else{
			System.out.println("withdraw the savings account = "+amt);
			accbal = accbal-amt;
			System.out.println("youer savings accbal = "+ accbal);
		}
	}
}
class loanaccount extends account
{
	loanaccount(int accno,double accbal)
	{
		super(accno,accbal);
		System.out.println("loan acc created sucessfully...");
		
	}
	void deposit(double amt)
	{
		System.out.println("deposit the loan account = "+amt);
		accbal = accbal-amt;
		System.out.println("youer savings accbal = "+ accbal);
	}
	void withdraw(double amt)
	{
		System.out.println("withdraw the loan account = "+amt);
		accbal = accbal+amt;
		System.out.println("youer loan accbal = "+ accbal);
	}
}

public class BankApp
{
	public static void main(String[] args)
	{
		savingaccount sa1 = new savingaccount(12345,1000.0);
		sa1.balanceenquiry();
		sa1.deposit(1000.0);
		sa1.withdraw(5000.0);
	}
	

}
