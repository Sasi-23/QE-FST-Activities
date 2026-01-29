l1=[1,2,3,4,5,6]
l2=[7,8,9,10]
l13=[]
l24=[]

for i in l1:
    if i % 2 != 0:
       l13.append(i)
         
for j in l2:
    if j % 2 == 0:
       l24.append(j)
merged_list = l13 + l24
print("odd numbers:", l13)
print("Even Numbers:", l24)
print("Merged list:", merged_list)



        

        