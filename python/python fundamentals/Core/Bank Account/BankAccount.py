class BankAccount:
    balance = 0
    int_rate = 0.01
    accounts =[]
    def __init__(self, int_rate , balance): 
        self.int_rate= int_rate
        self.balance= balance
        BankAccount.accounts.append(self)

    def deposit(self, amount):
        self.balance += amount
        return self

    def withdraw(self, amount):
        if self.balance < amount:
            print("Insufficient funds: Charging a $5 fee")
            self.balance -= 5
        else:
            self.balance -= amount
        return self

    def display_account_info(self):
        print(f"Balance: ${self.balance}")
        return self

    def yield_interest(self):
        if self.balance > 0:
            self.balance = self.balance + self.int_rate * self.balance
        return self

    @classmethod
    def show_all(cls):
        for account in cls.accounts:
            account.display_account_info()

account1 = BankAccount (BankAccount.int_rate ,BankAccount.balance)
account1.deposit(300).deposit(200).deposit(500).withdraw(720).yield_interest().display_account_info()

account2 = BankAccount (BankAccount.int_rate , BankAccount.balance)
account2.deposit(800).deposit(1200).withdraw(50).withdraw(20).withdraw(100).withdraw(40).yield_interest().display_account_info()

BankAccount.show_all()