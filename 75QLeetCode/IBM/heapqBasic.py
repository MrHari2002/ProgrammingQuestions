import heapq

arr = [1,2,3]
heapq.heappush(arr, 1)
print(arr)

values = [5,1,3,7,4,2]
heapq.heapify(values)
print("Heap",values)

heapq.heappush(values, 6)
print("Heap after push:", values)

smallest = heapq.heappop(values)
 
# Print the smallest element and the updated heap
print("Smallest element:", smallest)
print("Heap after pop:", values)