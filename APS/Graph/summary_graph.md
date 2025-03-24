# 🔹 그래프 기본 (GRAPH BASIC)

---

## ① **그래프 기본 가이드**

- 아이템(사물 또는 추상적 개념)과 그 사이의 연결 관계 표현
- 정점의 집합과 간선의 집합으로 구성되는 자료구조
- 선형 자료구조나 트리로 표현하기 어려운 M:N 관계 표현
- V개의 정점을 가지는 그래프가 가진 간선 최대치: `V * (V - 1) / 2`

---

## ② **용어 정리**

- **정점 (node, vertex)**: 데이터가 담겨져 있는 개체
- **간선 (edge)**: 정점과 정점의 연결 관계
- **인접 (adjacent)**: 두 정점 사이에 간선이 존재
- **차수 (degree)**: 하나의 정점에 연결되어 있는 간선 개수

---

## ③ **그래프 예시**

- A-B, A-C, B-D, C-D, A-D 로 연결
- D 정점의 차수: 3 (간선 3개)
- 인접: A 와 B, A 와 C는 인접

---

## ④ **그래프 표현 방법**

- 간선의 정보를 저장하는 방식은 메모리 또는 성능 고려

### 1) **인접 행렬 (Adjacent Matrix)**
```
import java.util.Scanner;
public class 그래프_01_인접행렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//V,E의 개수를 입력받음
		int V = sc.nextInt(); // 정점의 개수 (0번 시작인지, 1번 시작인지 확인)
		int E = sc.nextInt(); // 간선의 개수
		int[][] adjArr = new int[V][V]; // 만약 시작 정점이 1이라면 V+1로 만들기~
		for (int i = 0; i<E; i++) {
			int A = sc.nextInt(); //연결된 두 개의 정점의 정보
			int B = sc.nextInt(); 
			int W = sc.nextInt(); //가중치값 : 없다면 1을 저장하시오
			adjArr[A][B] = 1; //가중치가 없다면 1을, 있다면 W 저장
			adjArr[B][A] = 1; //유향이라면 작성할 필요 없음
//			adjArr[A][B] = adjArr[B][A] = W; //대입연산자는 오른쪽에서 왼쪽으로 이동하는 것!
			//유향, 가중치, 변수에 저장도 싫어 (비 권장)
			adjArr[sc.nextInt()][sc.nextInt()] = sc.nextInt(); // 유향이니깐 가능한 것 (무향은 불가능해)
		}
	}//main
}
```

- 두 정점을 연결하는 간선의 유무를 행렬로 표현
- `V * V`개의 2차원 배열
- 행, 열 번호는 그래프 정점 번호
- 인접하면 1, 간선 없으면 0 표기 (u->v 가중치가 있다면 값)

#### 평가:
- 간선 개수가 많을 때 단순하고 가장 간단
- 전체가 인접하는지 여부 확인 O(1)
- 메모리 O(V^2)가 필요

#### 특징:
- 무향 그래프: i번째 행 합 = i번째 열 합 = V_i 차수
- 유향 그래프: i번째 행 합 = V_i 진출 차수, i번째 열 합 = V_i 진입 차수

### 2) **인접 리스트 (Adjacent List)**
```
public class 그래프_02_인접리스트 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); // 정점의 개수 (0번 시작인지, 1번 시작인지 확인)
		int E = sc.nextInt(); // 간선의 개수
		List<Integer>[] adjList = new ArrayList[V];
		for (int i = 0; i<V; i++) {
			adjList[i] = new ArrayList<>();
		}//미리 리스트 객체를 전부 생성해 두어야 한다
		for (int i = 0; i<E; i++) {
			int A = sc.nextInt(); //연결된 두 개의 정점의 정보
			int B = sc.nextInt(); 
			adjList[A].add(B);
			adjList[B].add(A);//무향이라면.. 필요 없다
			//만약 가중치를 같이 저장하고 싶다면
			//1. class 이용 저장
			//2. int[] 이용 저장
		}
	}//main
}
```

- 간선을 리스트로 관리
- 각 정점에 인접한 정점 목록 관리

#### 평가:
- 간선 적은 그래프에 유리
- 인접 정점 탐색 용이
- 메모리 O(V + E)

### 3) **간선 배열 (Edge Array)**

- 간선을 목록 형태로 관리 (start, end) 값 저장
- 가중치를 포함할 경우 (start, end, weight)

#### 평가:
- 간선 배열만 관리할 경우 가장 간단
- 간선 개수가 많을 때 유리

---

## ⑤ **정리 완료! 필요하면 연산 계산, 탐색 패턴 추가 정리 가능**

---

✨ 이어서 그래프 탐색 (DFS/BFS) 원하면 알려줘, 바로 정리해줄게! ✨

