import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BankSystem
{
    private final List<BankAccount> accounts = new ArrayList<>();

    public void addAccount(BankAccount account)
    {
        accounts.add(account);
    }

    public void loadAccountsFromFile(String filename) throws IOException
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            String line;
            
            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split(";");
                String type = parts[0];
                String name = parts[1];
                double balance = Double.parseDouble(parts[2]);

                if (type.equalsIgnoreCase("Student"))
                {
                    double overdraft = Double.parseDouble(parts[3]);
                    addAccount(new StudentAccount(name, balance, overdraft));
                }
                else if (type.equalsIgnoreCase("Current"))
                {
                    double fee = Double.parseDouble(parts[3]);
                    addAccount(new CurrentAccount(name, balance, fee));
                }
            }
        }
    }

    public List<BankAccount> filterAccountsByNameRegex(String regex) {
        Pattern pattern = Pattern.compile(regex);
        return accounts.stream()
                .filter(acc -> pattern.matcher(acc.getAccountHolder()).matches())
                .collect(Collectors.toList());
    }

    public List<String> transformAccounts(Function<BankAccount, String> transformer) {
        return accounts.stream()
                .map(transformer)
                .collect(Collectors.toList());
    }
}
