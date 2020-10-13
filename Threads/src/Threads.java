public class Threads{
    public   static   void   main(String[]   args)   {
        Account acc =new Account(25.0, 111);
        AccountHolder john=new AccountHolder(acc);
        AccountHolder joe=new AccountHolder(acc);
        Thread t1=new Thread(john);
        Thread t2=new Thread(joe); t1.start();
        t2.start();
        }
}
class Account{
    private double balance;
    private int accountNo;
    public Account(double balance, int accountNo) {
        this.balance = balance;
        this.accountNo = accountNo;
    }
    public synchronized void checkBalance() {
        System.out.println("Account No: "+this.accountNo+"\n"+"Balance  is:  "+this.balance);
    }
    public synchronized void deposit(double amount) {
        this.balance+=amount;
    }
    public synchronized void withdraw(double amount) {
        if(amount<=this.balance)  {
            this.balance-=amount;
        }
    }
}
class AccountHolder implements Runnable{ Account account;
    public AccountHolder(Account account) {
        this.account = account;
    }
    @Override
    public void run() {
     this.account.deposit(100.0);
     this.account.withdraw(25.0);
     this.account.deposit(75.0);
     this.account.withdraw(100.0);
     this.account.checkBalance();
    }
}
