#basic
for x in range(0, 151):
    print(x)

#Multiples of Five 
for i in range(5,1001,5):
        print(i)

#Counting, the Dojo Way
for u in range(1,101):
    if u%10==0:
        print("coding Dojo")
    elif u%5==0:
        print("Coding")
    else:
        print(u)

#Whoa. That Sucker's Huge
sum=0
for y in range(1,500001,2):
    sum=y+sum
print(sum)

#Countdown by Fours
for i in range (2018,0,-4):
    print(i)

#Flexible Counter 
lowNum=2
highNum=9
mult=3
for i in range(lowNum,highNum+1):
    if i% mult==0:
        print(i)