x = [ [5,2,3], [10,8,9] ] 
students = [
    {'first_name':  'Michael', 'last_name' : 'Jordan'},
    {'first_name' : 'John', 'last_name' : 'Rosales'}
]
sports_directory = {
    'basketball' : ['Kobe', 'Jordan', 'James', 'Curry'],
    'soccer' : ['Messi', 'Ronaldo', 'Rooney']
}
z = [ {'x': 10, 'y': 20} ]

# 1.Update Values in Dictionaries and Lists
x[1][0]=15
print(x)
students[0]['last_name']="Bryant"
print(students)
sports_directory['soccer'][0]= 'Andres'
print(sports_directory)



#2.Iterate Through a List of Dictionaries
students = [
        {'first_name':  'Michael', 'last_name' : 'Jordan'},
        {'first_name' : 'John', 'last_name' : 'Rosales'},
        {'first_name' : 'Mark', 'last_name' : 'Guillen'},
        {'first_name' : 'KB', 'last_name' : 'Tonel'}
]

def iterateDictionary(students): 
    for student in students:
        resualt=''
        for key , value in student.students:
            resualt+= f"{key}-{value},"
        print(resualt[:-2])

#3.Get Values From a List of Dictionaries
def iterateDictionary2(key_name, students):
    for x in students.key_name:
        return students.key_name
    print(students.key_name)
