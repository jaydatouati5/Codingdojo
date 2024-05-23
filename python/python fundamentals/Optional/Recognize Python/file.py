#- variable declaration/ number
num1 = 42             

#  variable declaration/ decima_float
num2 = 2.3           

#  variable declaration/boolean
boolean = True        

#type check
string = 'Hello World' 

#Data Types Composite List initialize 
pizza_toppings = ['Pepperoni', 'Sausage', 'Jalepenos', 'Cheese', 'Olives']       

#Data Types Composite Dictionary initialize 
person = {'name': 'John', 'location': 'Salt Lake', 'age': 37, 'is_balding': False}      

#Data Types Composite tuples initialize 
fruit = ('blueberry', 'strawberry', 'banana')

#variable declaration log statement type check
print(type(fruit))

#variable declaration log statement length check
print(pizza_toppings[1])

#tuple add value
pizza_toppings.append('Mushrooms')

#variable declaration log statement length check
print(person['name'])

# tuple change value
person['name'] = 'George'
person['eye_color'] = 'blue'

#variable declaration log statement length check
print(fruit[2])

#conditional if statement
if num1 > 45:
#log statement
    print("It's greater")

#conditional else statement
else:

#log statement
    print("It's lower")

#conditional if statement length check
if len(string) < 5:

#log statement
    print("It's a short word!")

#conditional else statement length check
elif len(string) > 15:

#logo statement
    print("It's a long word!")

#conditional else statement
else:

#log statement
    print("Just right!")

#for loop start
for x in range(5):

#log statement
    print(x)

#for loop start/stop
for x in range(2,5):

#log statement
    print(x)

#for loop start/stop/increment
for x in range(2,10,3):

#log statement
    print(x)

#while loop
x = 0
while(x < 5):

#log statement
    print(x)
    x += 1

#tuple delete value
pizza_toppings.pop()
pizza_toppings.pop(1)

#log statement
print(person)

#tuple delete value
person.pop('eye_color')

#log statement
print(person)

#for loop
for topping in pizza_toppings:

#conditional if statement
    if topping == 'Pepperoni':

#for loop continue
        continue
#log statement
    print('After 1st if statement')

#conditional if statement
    if topping == 'Olives':
#for loop break
        break

#function
def print_hello_ten_times():

#for loop start
    for num in range(10):

#log statement
        print('Hello')
print_hello_ten_times()

#function
def print_hello_x_times(x):

#for loop start
    for num in range(x):

#log statement
        print('Hello')

print_hello_x_times(4)

def print_hello_x_or_ten_times(x = 10):
    for num in range(x):
        print('Hello')

print_hello_x_or_ten_times()
print_hello_x_or_ten_times(4)


"""
Bonus section
"""

# print(num3)

#NameError: name <variable name> is not defined
# num3 = 72

#IndexError: list index out of range
# fruit[0] = 'cranberry'

#IndexError: list index out of range

#- KeyError: 'favorite_team'
# print(person['favorite_team'])

#IndexError: list index out of range
# print(pizza_toppings[7])

#IndentationError: unexpected indent
#   print(boolean)

#AttributeError: 'tuple' object has no attribute 'append'
# fruit.append('raspberry')

#AttributeError: 'tuple' object has no attribute 'pop'
# fruit.pop(1)