public abstract class BankAccount
{
    protected String accountHolder;
    protected double balance;

    public BankAccount(String accountHolder, double balance)
    {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public String getAccountHolder()
    {
        return accountHolder;
    }

    public double getBalance()
    {
        return balance;
    }

    public abstract String getAccountSummary();
}
