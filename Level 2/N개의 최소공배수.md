# [문제](https://programmers.co.kr/learn/courses/30/lessons/12953)  
두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다. 예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다. n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.

## 제한 사항  
- arr은 길이 1이상, 15이하인 배열입니다.
- arr의 원소는 100 이하인 자연수입니다.
## 입출력 예  
|arr|return|
|-----|-----|
|[2,6,8,14]	|168|
|[1,2,3]	|6|

##   
풀이
## 코드  
1. 2 ~ max(arr)까지 %연산 결과가 0인 원소가 2개 이상일 때 common에 저장  
    1-1. common에 저장하는 값이 있으면 max(arr)값을 바꿔줌
1. max(arr)번 반복했음에도 불구하고 공배수가 없으면 arr와 common의 원소를 곱한 값 반환  
```python
from functools import reduce
def solution(arr):
    common = []
    while 1:
        max_ = max(arr)
        for i in range(2, max_+1):
            tmp = [x for x in arr if x % i == 0]
            if len(tmp) >1:
                arr = [x//i if x % i == 0 else x for x in arr ]
                common.append(i)
                break
        if i == max_:
            return reduce(lambda x, y: x * y, arr+common)
```
## + 리스트 원소 곱하기  
```python
from functools import reduce

reduce(lambda x, y: x * y, list)

```