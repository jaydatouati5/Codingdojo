
#! *********BankAccount class*********
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

#!  *********User class************
class User():
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.account = BankAccount(int_rate=0.02, balance=0)

    def make_deposit(self, amount):
        self.account.deposit(amount)
        return self

    def make_withdrawal(self,amount):
        self.account.withdraw(amount)
        return self

    def display_user_balance(self):
        self.account.display_account_info()
        return self

jayda = User("jayda","jayda@gmail.com") 
jayda.make_deposit(200).make_deposit(450).make_withdrawal(50).display_user_balance()

