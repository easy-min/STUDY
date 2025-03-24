

## ✅ **자료구조 핵심 요약**

### 📌 배열 (Array)
- **특징:** 같은 자료형 연속 저장, 인덱스로 접근 O(1)
- **단점:** 크기 고정 → 늘리려면 복사 필요 (얕은 복사 vs 깊은 복사)
- **선언**
```java
int[] arr = new int[5];
int[] arr2 = new int[]{1, 2, 3};
int[] arr3 = {1, 2, 3}; // 초기화
```

---

### 📌 문자열 (String)
- 문자들의 집합
- 자바에서는 `String`, `StringBuilder`, `StringBuffer`
- `charAt()`, `substring()`, `equals()`, `compareTo()` 등 자주 사용

---

### 📌 스택 (Stack) - LIFO
```java
Stack<Integer> stack = new Stack<>();
stack.push(1);
stack.pop();
stack.peek();
```
- 활용: 괄호 검사, DFS

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
