# [문제](https://programmers.co.kr/learn/courses/30/lessons/42895)  
아래와 같이 5와 사칙연산만으로 12를 표현할 수 있습니다.

- 12 = 5 + 5 + (5 / 5) + (5 / 5)
- 12 = 55 / 5 + 5 / 5
- 12 = (55 + 5) / 5

5를 사용한 횟수는 각각 6,5,4 입니다. 그리고 이중 가장 작은 경우는 4입니다.
이처럼 숫자 N과 number가 주어질 때, N과 사칙연산만 사용해서 표현 할 수 있는 방법 중 N 사용횟수의 최솟값을 return 하도록 solution 함수를 작성하세요.

## 제한 사항  
- N은 1 이상 9 이하입니다.
- number는 1 이상 32,000 이하입니다.
- 수식에는 괄호와 사칙연산만 가능하며 나누기 연산에서 나머지는 무시합니다.
- 최솟값이 8보다 크면 -1을 return 합니다.
## 입출력 예  
![image](https://user-images.githubusercontent.com/59672592/144597070-b76da10f-373a-4c0a-aa55-996098884e0e.png)


## 풀이  
1. [[ N * i ] x 8]인 이중 리스트 생성
1. 1 ~ 8번까지 N을 사용해서 사칙연산으로 만들 수 있는 수를 구함
    - 4이상의 경우 1+i뿐만이니라 2+2의 경우도 N을 4번 사용하는 경우이므로 모든 경우를 생각해 줘야 됨
1. 중간에 number와 같은 수가 있을 시 i를 리턴


## 코드  

```python
def solution(N, number):
    if N == number:
        return 1
    answer = [[]]+ [[int(str(N)*i)] for i in range(1,9)]
    for i in range(2,9):
        for j in range(1,i):
            for k in answer[j]:
                for l in answer[i-j]:
                    answer[i].append(k+l)
                    answer[i].append(max(k,l) - min(k,l))
                    answer[i].append(k*l)
                    if l != 0:
                        answer[i].append(k//l)
        if number in answer[i]:
            return i
        answer[i] = list(set(answer[i]))
    return -1
```
