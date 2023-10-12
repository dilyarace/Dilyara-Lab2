package composite_design_pattern;

import java.util.ArrayList;
import java.util.List;

// Abstract base class representing an account
abstract class Account {
    public abstract float getBalance();
}

// Concrete class representing a deposit account
class DepositAccount extends Account {
    private String accountNo;
    private float accountBalance;

    public DepositAccount(String accountNo, float accountBalance) {
        super();
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    public float getBalance() {
        return accountBalance;
    }
}

// Concrete class representing a savings account
class SavingAccount extends Account {
    private String accountNo;
    private float accountBalance;

    public SavingAccount(String accountNo, float accountBalance) {
        super();
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    public float getBalance() {
        return accountBalance;
    }
}

// Composite class representing a composite account containing multiple accounts
class CompositeAccount extends Account {
    private float totalBalance;
    private List<Account> accountList = new ArrayList<Account>();

    public float getBalance() {
        totalBalance = 0;
        for (Account account : accountList) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }

    public void addAccount(Account account) {
        accountList.add(account);
    }

    public void removeAccount(Account account) {
        accountList.remove(account);
    }
}

public class CompositePattern {
    public static void main(String[] args) {
        CompositeAccount compositeAccount = new CompositeAccount();

        // Add deposit and savings accounts to the composite account
        compositeAccount.addAccount(new DepositAccount("DA001", 100));
        compositeAccount.addAccount(new DepositAccount("DA002", 150));
        compositeAccount.addAccount(new SavingAccount("SA001", 200));

        // Calculate and display the total balance of the composite account
        float totalBalance = compositeAccount.getBalance();
        System.out.println("Total Balance: " + totalBalance);
    }
}
