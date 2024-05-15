class BankAccount:
    balance = 0
    int_rate = 0.01
    def __init__(self, int_rate, balance): 
        self.int_rate= int_rate
        self.balance= balance


    def deposit(self, amount):
        self.balance += amount

    def withdraw(self, amount):
        if self.balance < amount:
            print("Insufficient funds: Charging a $5 fee")
            self.balance -= 5
        else:
            self.balance -= amount

    def display_account_info(self):
        print(f"Balance: ${self.balance}")


    def yield_interest(self):
        if self.balance > 0:
            self.balance = self.balance + self.int_rate * self.balance


account1 = BankAccount (BankAccount.int_rate , 150)
# print('************')
account1.display_account_info()
account1.yield_interest()
account1.display_account_info()
# print(BankAccount.withdraw(account1 ,300)) 
