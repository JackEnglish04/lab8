public class StudentAccount extends BankAccount
{
    private double studentOverdraftLimit;

    public StudentAccount(String accountHolder, double balance, double studentOverdraftLimit)
    {
        super(accountHolder, balance);
        this.studentOverdraftLimit = studentOverdraftLimit;
    }

    @Override
    public String getAccountSummary()
    {
        return "Student Account - Holder: " + accountHolder + ", Balance: " + balance + ", Overdraft Limit: " + studentOverdraftLimit;
    }
}
