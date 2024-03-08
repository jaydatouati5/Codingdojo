# # ********************************************1st*************************************************
# def countsDown(a):
#     list_count=[]
#     for i in range(a,-1,-1):
#         list_count.append(i)
#     return list_count
# print(countsDown(7))

# # ********************************************2nd*************************************************

# def printAndReturn(a,b):
#     list_1=[a,b]
#     print(list_1[0])
#     return list_1[1]
# print(printAndReturn(99,26))

# # *********************************************3rd************************************************

# def FirstPlusLength(passingasarrgument):
#     for i in passingasarrgument:
#         x= passingasarrgument[0]+len(passingasarrgument)
#         return x
# li=[700,32,25] 
# print(FirstPlusLength(li ))

# # **********************************************4th***********************************************

# def Values_Greater_than_Second(listOfValues):
#     new_Li=[]
#     for i in listOfValues:
#         if (i>listOfValues[1]):
#             new_Li.append(i)
#     if len(new_Li)>= 2:
#         print(len(new_Li))
#     else:
#         return False
#     return new_Li
# li=[100,25,2,36]
# print(Values_Greater_than_Second(li))


# # **********************************************5th***********************************************


# def This_Length_That_Value(a,b):
#     new_list=[]
#     for i in range(0,a):
#         new_list.append(b)
#     return new_list
# print(This_Length_That_Value(10,99))