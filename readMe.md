# 코딩 테스트 대비 주요 알고리즘 코드

## 최대 공약수, 최소 공배수

유클리드 호제법으로 재귀함수를 만들어 최대공약수와 최소공배수를 구한다.

```python
def gcd(num1,num2):
    if num2==0:return num1
    return gcd(num2,num1%num2)
print(gcd(5,10))
print(5*10//gcd(5,10))
```

## 약수 구하기

```python
def divisor():
    n=int(input())
    divisors=[]
    pair=[]
    for i in range(1,int(n**(1/2))+1):
        if n%i==0:
            divisors.append(i)
            if i!=(n//i):
                pair.append(n//i)
    return divisors+pair
divisor()
```

## 소수

에라토스테네스의 체

n≤ num ≤m 의 소수 구하기

```python
def isPrime(num):
    if num==1:return False
    for i in range(2,int(num**0.5)+1):
        if num%i==0:
            return False
    return True
m,n=map(int,input().split())
for i in range(m, n+1):
    if isPrime(i):
        print(i)
```

## 순열 조합

```python
n,m=map(int,input().split())
arr=list(range(1,n+1))
visited=[False]*n
selected=[0]*m
def permutation(depth):
    if depth==m:
        print(selected)
        return
    for i in range(n):
        if not visited[i]:
            visited[i]=True
            selected[depth]=arr[i]
            permutation(depth+1)
            visited[i]=False

permutation(0)            
print("================")
visited=[False]*n
selected=[0]*m          
def combination(depth,start):
    if depth==m:
        print(selected)
        return
    for i in range(start,n):
        if not visited[i]:
            visited[i]=True
            selected[depth]=arr[i]
            combination(depth+1,i)
            visited[i]=False
combination(0,0)
```

## bfs dfs

```python
from collections import deque
graph = {
    1: [2,3,4],
    2: [5],
    3: [5],
    4: [],
    5: [6,7],
    6: [],
    7: [3],
}
visited=[]
def dfs(start):
    visited = []
    stack = [start]
    while stack:
        v = stack.pop()
        if v not in visited:
            visited.append(v)
            for w in graph[v]:
                stack.append(w)
    return visited
visited=[]
def bfs(start):
    visited = [start]
    q = deque([start])
    while q:
        v = q.popleft()
        for w in graph[v]:
            if w not in visited:
                visited.append(w)
                q.append(w)
    return visited
print(dfs(1))
print(bfs(1))
```

## 이분 탐색

```python
def binary_search(target, data):
    data.sort()
    start = 0
    end = len(data) - 1

    while start <= end:
        mid = (start + end) // 2

        if data[mid] == target:
            return mid
        elif data[mid] < target:
            start = mid + 1
        else:
            end = mid -1
    return None
arr = [i**2 for i in range(11)]
target=9
idx=binary_search(target,arr)
print(arr)
if idx:print(idx)
else:print("X".format(target))
```

## 플로이드 와샬

```python
from math import inf

n,m=map(int,input().split())

cost = [[inf] * n for _ in range(n)]
for _ in range(m):
    a, b, c = map(int, input().split())
    cost[a-1][b-1] = min(cost[a-1][b-1], c)

for k in range(n):
    cost[k][k] = 0
    for i in range(n):
        for j in range(n):
            cost[i][j] = min(cost[i][j], cost[i][k]+cost[k][j])

for row in cost:
    for i in range(n):
        if row[i] == inf:
            row[i] = 0
        print(row[i], end=" ")
    print()
```

## Union-Find

최소 스패닝 트리

```python
n,m=map(int,input().split())
p=[i for i in range(n+1)]
def find(x):
    if x==p[x]:return x
    y=find(p[x])
    p[x]=y
    return y
def union(x,y):
    a=find(x)
    b=find(y)
    if a==b:return
    if a<b:p[b]=a
    else:p[a]=b
for _ in range(m):
    a,b=map(int,input().split())
    union(a,b)
print(p)
```

## 배낭문제(DP)

```python
n,m=map(int,input().split())
dp=[0]*(m+1)
for _ in range(n):
    w,v=map(int,input().split())
    for i in range(m,w-1,-1):
        dp[i]=max(dp[i],dp[i-w]+v)
print(dp[m])
```

## 다익스트라

```python
import heapq
from math import inf
n,m,start=map(int,input().split())
distance=[inf]*(n+1)
graph=[[]for i in range(n+1)]
for _ in range(m):
    s,e,w = map(int,input().split())
    graph[s].append((e,w))

def dijkstra(start):
    q=[]
    heapq.heappush(q, (0,start))
    distance[start] = 0

    while q:
        dist,now=heapq.heappop(q)
        if distance[now]<dist:continue
        for node in graph[now]:
            cost = dist + node[1]
            if cost < distance[node[0]]:
                distance[node[0]] = cost
                heapq.heappush(q, (cost,node[0]))
dijkstra(start)
```