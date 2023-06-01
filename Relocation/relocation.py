first = input()
companyNum, queryNum = first.split()
second = input()
companyList = [int(num) for num in second.split()]
queryList = []

for i in range(int(queryNum)):
    query = input()
    queryList.append(query)

for query in queryList:
    id, A, B = query.split()
    if id == '1':
        C = int(A)
        X = int(B)
        companyList[C-1] = X
    
    if id == '2':
        print(abs(companyList[int(A)-1]-companyList[int(B)-1]))