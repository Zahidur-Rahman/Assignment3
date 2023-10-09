// Interface for BankingService
interface BankingService {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}

// Implementation of CheckingAccount
class CheckingAccount implements BankingService {
    private double balance;

    public CheckingAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited  " + amount + " into Checking Account");
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn " + amount + " from Checking Account");
        } else {
            System.out.println("Insufficient balance in Checking Account");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

// Implementation of SavingsAccount
class SavingsAccount implements BankingService {
    private double balance;

    public SavingsAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + " into Savings Account");
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn $" + amount + " from Savings Account");
        } else {
            System.out.println("Insufficient balance in Savings Account");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

// Implementation of InvestmentAccount
class InvestmentAccount implements BankingService {
    private double balance;

    public InvestmentAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + " into Investment Account");
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn $" + amount + " from Investment Account");
        } else {
            System.out.println("Insufficient balance in Investment Account");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

// Facade for Banking Service
class BankingFacade {
    private BankingService checkingAccount;
    private BankingService savingsAccount;
    private BankingService investmentAccount;

    public BankingFacade(double checkingInitialBalance, double savingsInitialBalance, double investmentInitialBalance) {
        checkingAccount = new CheckingAccount(checkingInitialBalance);
        savingsAccount = new SavingsAccount(savingsInitialBalance);
        investmentAccount = new InvestmentAccount(investmentInitialBalance);
    }

    public void depositToChecking(double amount) {
        checkingAccount.deposit(amount);
    }

    public void withdrawFromChecking(double amount) {
        checkingAccount.withdraw(amount);
    }

    public void depositToSavings(double amount) {
        savingsAccount.deposit(amount);
    }

    public void withdrawFromSavings(double amount) {
        savingsAccount.withdraw(amount);
    }

    public void depositToInvestment(double amount) {
        investmentAccount.deposit(amount);
    }

    public void withdrawFromInvestment(double amount) {
        investmentAccount.withdraw(amount);
    }

    public double getCheckingBalance() {
        return checkingAccount.getBalance();
    }

    public double getSavingsBalance() {
        return savingsAccount.getBalance();
    }

    public double getInvestmentBalance() {
        return investmentAccount.getBalance();
    }
}

public class Main {

    public static void main(String[] args) {
        // Create a banking facade
        BankingFacade bankingFacade = new BankingFacade(1000, 2000, 3000);

        // Perform banking operations
        bankingFacade.depositToChecking(500);
        bankingFacade.withdrawFromChecking(200);
        bankingFacade.depositToSavings(1000);
        bankingFacade.withdrawFromSavings(500);
        bankingFacade.depositToInvestment(2000);
        bankingFacade.withdrawFromInvestment(1000);

        // Get and display balances
        System.out.println("Checking Account Balance: " + bankingFacade.getCheckingBalance());
        System.out.println("Savings Account Balance: " + bankingFacade.getSavingsBalance());
        System.out.println("Investment Account Balance: " + bankingFacade.getInvestmentBalance());
    }
}
