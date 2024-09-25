public class BankTest {
    public static void main(String[] args){
        // Create 3 bank accounts
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();
        BankAccount account3 = new BankAccount();
        // Deposit Test
        // - deposit some money into each bank account's checking or savings account and display the balance each time
        account1.deposit("checking", 200);
        account1.getBalance();
        
        account2.deposit("saving",250);
        account2.getBalance();
        
        account3.deposit("checking", 1000);
        account3.getBalance();
        // - each deposit should increase the amount of totalMoney
        // Withdrawal Test
        // - withdraw some money from each bank account's checking or savings account and display the remaining balance
        account1.withdraw("checking", 150);
        account1.getBalance();

        account2.withdraw("saving", 300);
        account2.getBalance();

        account3.withdraw("checking", 50);
        account3.getBalance();
        // - each withdrawal should decrease the amount of totalMoney
        // Static Test (print the number of bank accounts and the totalMoney)
        System.out.println(BankAccount.getTotalMoney());
    }
}
