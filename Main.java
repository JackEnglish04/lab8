import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BankSystem system = new BankSystem();

        system.addAccount(new StudentAccount("Alice", 1500.0, 1000.0));
        
        system.addAccount(new CurrentAccount("Bob", 3000.0, 1.5));

        system.addAccount(new StudentAccount("Adam", 500.0, 800.0));

        System.out.println("Accounts starting with 'A':");
        var filtered = system.filterAccountsByNameRegex("^A.*");
        filtered.forEach(acc -> System.out.println(acc.getAccountHolder()));

        System.out.println("\nLowercase Holder Names:");
        var lowercaseNames = system.transformAccounts(acc -> acc.getAccountHolder().toLowerCase());
        lowercaseNames.forEach(System.out::println);

        System.out.println("\nAccount Summaries:");
        var summaries = system.transformAccounts(BankAccount::getAccountSummary);
        summaries.forEach(System.out::println);
    }
}
