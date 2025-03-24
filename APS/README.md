

## ✅ **자료구조 핵심 요약**

### 📌 1. 배열 (Array)
- **특징:** 같은 자료형 연속 저장, 인덱스로 접근 O(1)
- **단점:** 크기 고정 → 늘리려면 복사 필요 (얕은 복사 vs 깊은 복사)
- **선언**
```java
int[] arr = new int[5];
int[] arr2 = new int[]{1, 2, 3};
int[] arr3 = {1, 2, 3}; // 초기화
```
---
##### 🛠️ **델타 탐색 (상하좌우 이동) - 핵심 패턴**
- 상하좌우 이동용 델타 배열 (방향 배열)
```java
int[] dx = {0, 0, -1, 1}; // 좌 우
int[] dy = {-1, 1, 0, 0}; // 상 하
```
- 탐색 패턴
```java
for (int d = 0; d < 4; d++) {
    int nx = x + dx[d];
    int ny = y + dy[d];
    
    if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
        // 경계 안쪽이면 처리
    }
}
```
##### 🛠️ **응용:** 대각선 추가하고 싶다면
```java
int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
```
##### 🛠️ ** 파리채 문제 패턴 (최대 합 구하기)**
- 핵심 아이디어: **M x M 영역 누적합**
```java
int max = 0;
for (int i = 0; i <= N - M; i++) {
    for (int j = 0; j <= N - M; j++) {
        int sum = 0;
        for (int k = 0; k < M; k++) {
            for (int l = 0; l < M; l++) {
                sum += map[i + k][j + l];
            }
        }
        max = Math.max(max, sum);
    }
}
System.out.println(max);
```
##### 🛠️ **이런 문제 유형이랑 똑같이 쓰임**
- 부분 격자 합 구하기
- 영역 내 최대/최소 구하기
- 주변 8방향 체크하는 문제들
---
##### 🛠️ **4. 실전에서 쓸 수 있는 델타 패턴 문제 예시**
| 문제 유형                 | 델타 이동 쓰임새                   | 예시 |
|--------------------------|-----------------------------------|------|
| 상하좌우 탐색              | BFS/DFS, 인접 탐색                 | 미로 탐색, 섬의 개수 |
| 대각선까지 탐색            | 주변 8칸 체크                       | 파리채, 농작물 수확 |
| 영역 탐색                  | MxM 탐색                           | 파리채, 최대/최소 합 |
| 방문 처리                 | visited 2D 배열 활용               | 최단거리 탐색 |
---


### 📌 문자열 (String)
- 문자들의 집합 **기초자료형이 아님**
- 자바에서는 `String`, `StringBuilder`, `StringBuffer`
- `charAt()`, `substring()`, `equals()`, `compareTo()` 등 자주 사용

##### 🛠️ 선언 방법
```
String b = "hello"
String c = new String("world")
boolean isEqual = b.equals(c)
```
##### 🛠️ 회문 : 문자열 뒤집기
1. 거꾸로 읽기   <----------
2. 절반만 뒤집기  | 3 | 2 | 1 | 1 | 2 | 3 |
3. reverse() 메서드 : 문자열 String이 아닌, StringBuilder("연결 할 때"+"좋아요").append("굳")나 StringBuffer에서 쓰임
   
##### 🛠️print(), println(), printf(){format 형식으로 %d, %f, %s} 메서드 && \n
##### 🛠️atoi(ASCII to INTEGER), itoa(Integer to ASCII)
1. Integer.parseInt("문자열")
2. String.valueOf(13)
##### 🛠️ 패턴매칭
1. 브루트포스 : 든 경우의 수를 전부 다 시도해보는 방법
2. 완전탐색
---

### 📌 스택 (Stack) - LIFO
```java
Stack<Integer> stack = new Stack<>();
stack.push(1);
stack.pop();
stack.peek();
```
- 활용: 괄호 검사, DFS

##### 🛠️ 구현 방법
1. 배열(1차원) | top | 2 | 3 |
2. 연결리스트  | top | -> | 2 | -> | 3 |
3. stack 클래스

##### 🛠️ 주요메서드 : push(), pop(), peek(), isEmpty(), ((isFull())
##### 🛠️ 활용 문제
1. 괄호검사
2. 시스템 스택
3. 뒤로/앞으로 가기
4. 계산기 (중위 -> 후위)
5. 재귀함수 (표현 방식) -> 시스템 스택 ? 상태공간 트리 
---

### 📌 큐 (Queue) - FIFO
```java
Queue<Integer> queue = new LinkedList<>();
queue.offer(1);
queue.poll();
queue.peek();
```
- 활용: BFS, 탐색 문제

---

### 📌 연결 리스트 (LinkedList)
```java
LinkedList<Integer> list = new LinkedList<>();
list.add(1);
list.removeFirst();
list.get(0);
```
- 활용: 삽입·삭제 많은 문제

---

### 📌 트리 (Tree)
- 이진 트리, 이진 탐색 트리 (BST), 힙 등
- 순회 방식: 전위, 중위, 후위
- 활용: DFS/BFS, 탐색 문제

---

### 📌 힙 (Heap) → 우선순위 큐로 활용
```java
PriorityQueue<Integer> pq = new PriorityQueue<>(); // 최소 힙
pq.offer(1);
pq.poll();
```
- 활용: 최소/최대값 찾기, 다익스트라

---

## ✅ **부분집합 / 조합 / 순열 핵심 패턴**

### ⭐ 부분집합 (Power Set)
- **비트마스킹 or 재귀로 구현**
```java
int n = arr.length;
for (int i = 0; i < (1 << n); i++) {
    for (int j = 0; j < n; j++) {
        if ((i & (1 << j)) != 0) {
            System.out.print(arr[j] + " ");
        }
    }
    System.out.println();
}
```

---

### ⭐ 조합 (Combination)
```java
void comb(int[] arr, int start, int depth, int r) {
    if (depth == r) {
        // 조합 완성
        return;
    }
    for (int i = start; i < arr.length; i++) {
        comb(arr, i + 1, depth + 1, r);
    }
}
```
- **중복 조합**
```java
void comb(int[] arr, int start, int depth, int r) {
    if (depth == r) {
        return;
    }
    for (int i = start; i < arr.length; i++) {
        comb(arr, i, depth + 1, r); // i + 1 → i로 변경
    }
}
```

---

### ⭐ 순열 (Permutation)
```java
void perm(int[] arr, boolean[] visited, int depth, int n, int r) {
    if (depth == r) {
        // 순열 완성
        return;
    }
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            visited[i] = true;
            perm(arr, visited, depth + 1, n, r);
            visited[i] = false;
        }
    }
}
```
- **중복 순열**
```java
void dupPerm(int[] arr, int depth, int n, int r) {
    if (depth == r) {
        // 중복 순열 완성
        return;
    }
    for (int i = 0; i < n; i++) {
        dupPerm(arr, depth + 1, n, r);
    }
}
```

---

## ✅ **백준 풀이용 마인드셋**
| 유형           | 주요 키워드/패턴                          | 백준 예시 문제 |
|----------------|----------------------------------------|---------------|
| 완전 탐색      | 순열, 조합, 부분집합, 비트마스킹            | N과 M, 부분집합 구하기 |
| DFS/BFS        | 스택, 큐, 재귀                            | 미로 탐색, 숨바꼭질 |
| 우선순위 큐    | 힙                                       | 절댓값 힙, 카드 합체 |
| 그리디         | 정렬, 우선순위 큐                          | 회의실 배정 |
| DP             | 배열 저장, 점화식                          | 1로 만들기 |
| 트리/그래프    | DFS/BFS, Union-Find                      | 트리의 부모 찾기 |

---
