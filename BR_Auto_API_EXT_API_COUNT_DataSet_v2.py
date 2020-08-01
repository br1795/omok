import pefile
import pandas as pd
import numpy as np

pro = open('C:\\Users\\br179\\exe_freq\\pro_name.txt', 'r').read().split('\n')
total_api=[]

for k in range(1,13):
    list_file = open('C:\\Users\\br179\\exe_freq\\freq' + str(k) + '_addr_name.txt', 'r').read().split('\n')

    api_add = []
    for i in range(0, len(list_file) - 1):
        if (i % 2 == 0):
            api_add.append(list_file[i])

    api_name = []
    for i in range(0, len(list_file)):
        if (i % 2 == 1):
            api_name.append(list_file[i])

    for i in api_name:
        if(i not in total_api):
            total_api.append(i)

data_set = pd.DataFrame(index=pro, columns=total_api)

for k in range(1,13):
    print(k)
    list_file = open('C:\\Users\\br179\\exe_freq\\freq'+str(k)+'_addr_name.txt', 'r').read().split('\n')

    api_add=[]
    for i in range(0,len(list_file)-1):
        if(i%2 == 0):
            api_add.append(list_file[i])

    api_name=[]
    for i in range(0,len(list_file)):
        if(i%2 == 1):
            api_name.append(list_file[i])

    list_file2 = open('C:\\Users\\br179\\exe_freq\\freq'+str(k)+'.txt', 'r').read().split('\n')
    for i in range(0,len(list_file2)):
        list_file2[i] = list_file2[i].split(', ')

    for i in range(0,len(list_file2)):
        for j in range(0,len(api_name)):
            if(list_file2[i][0]== api_add[j]):
                list_file2[i][0]=api_name[j]

    file = open("C:\\Users\\br179\\api\\freq\\API_Count"+str(k)+".txt", 'w') # API_name.txt를 생성
    for i in list_file2:
        file.write(str(i)+"\n")
    file.close()

    api_name2=[]
    for i in range(0,len(list_file2)-1):
        api_name2.append(list_file2[i][0])

    for i in range(0,len(total_api)):
        for j in range(0,len(list_file2)-1):
            if(total_api[i] == list_file2[j][0] ):
                data_set.loc[pro[k-1],list_file2[j][0]] = list_file2[j][1]

    data_set = data_set.fillna(0)

    data_set.to_csv("C:\\Users\\br179\\api\\freq\\API_Count_DataSet.csv")

print("----------")
print(" complete ")
print("----------")