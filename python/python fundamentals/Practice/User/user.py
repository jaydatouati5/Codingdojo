class User:
    def __init__(self, first_name, last_name,  email, age):
        self.first_name=first_name
        self.last_name=last_name
        self.email=email
        self.age=age
        self.gold_card_points = 0
        self.is_rewards_member = False

    def display_info(self):
        print(f"{self.first_name}\n{self.last_name}\n{self.email}\n{self.age}\n{self.gold_card_points}\n{self.is_rewards_member}")

    def enroll(self):
        self.gold_card_points=200
        self.is_rewards_member=True

    def spend_points(self, amount):
        self.gold_card_points -= amount


user_1=User("janne","tom","janne5@gmail.com",26)
user_1.display_info()
user_2=User("Aloulouu","catyyyy","Aloulou5@gmail.com",24)
user_2.display_info()
user_2.enroll()
user_2.display_info()
user_2.spend_points(150)
user_2.display_info()