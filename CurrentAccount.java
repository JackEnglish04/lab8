public class CurrentAccount extends BankAccount
{
    private double transactionFee;

    public CurrentAccount(String accountHolder, double balance, double transactionFee)
    {
        super(accountHolder, balance);
        this.transactionFee = transactionFee;
    }

    @Override
    public String getAccountSummary()
    {
        return "Current Account - Holder: " + accountHolder + ", Balance: " + balance + ", Transaction Fee: " + transactionFee;
    }
}
