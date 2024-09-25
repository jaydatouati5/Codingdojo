import java.util.Random;
public class BankAccount {
    // MEMBER VARIABLES
    private double checkingBalance;
    private double savingsBalance;
    private static int accounts;
    private static double totalMoney; // refers to the sum of all bank account checking and savings balances
    private long accountNumber;

    // CONSTRUCTOR
    // Be sure to increment the number of accounts
    public BankAccount(){
        accounts++;
        this.accountNumber = getRandomAccountNumber();
    }
    // GETTERS
    // for checking, savings, accounts, and totalMoney
    //! Getter for Checking : 
    public double getCheckingBalance(){
        return this.checkingBalance;
    }
    //! Getter for Savings : 
    public double getSavingsBalance(){
        return this.savingsBalance;
    }
    //! Getter for accounts :
    public static int getAccounts(){
        return accounts;
    }
    //! Getter for TotalMoney : 
    public static double getTotalMoney(){
        return totalMoney;
    }
    // METHODS
    // deposit
    // - users should be able to deposit money into their checking or savings account
    public void deposit(String type , double amount){
        if (type=="checking") {
            this.checkingBalance+=amount;
        }else{
            this.savingsBalance+=amount;
        }
        totalMoney+=amount;
    }
    // withdraw 
    // - users should be able to withdraw money from their checking or savings account
    // - do not allow them to withdraw money if there are insufficient funds
    // - all deposits and withdrawals should affect totalMoney
    public void withdraw(String type , double amount){
        if (type=="checking") {
            if (this.checkingBalance>amount) {
                this.checkingBalance-=amount;
                totalMoney-=amount;
            }else{
                System.out.println("insufficient funds");
            }
        } else {
            if (this.savingsBalance>amount) {
                this.savingsBalance-=amount;
                totalMoney-=amount;
            }else{
                System.out.println("insufficient funds");
            }
        }
    }
    // getBalance
    // - display total balance for checking and savings of a particular bank account
    public void getBalance(){
        System.out.println(this.accountNumber);
        System.out.printf("This is the CheckingBalance : %.2f\n",this.checkingBalance);
        System.out.printf("This is the SavingsBalance : %.2f\n",this.savingsBalance);
    }

    //! Ninja Bouns 2 : 
    private long getRandomAccountNumber(){
        Random r = new Random();
        return r.nextLong(1000000000L,9999999999L);
    }
}
