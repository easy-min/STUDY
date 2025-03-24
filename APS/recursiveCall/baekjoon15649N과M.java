
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon15649N과M {
	static int[] arr;
	static boolean[] visited;
	static int[] nums;
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		visited = new boolean[N];
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = i + 1;
		}
		backtracking(0);
		System.out.print(sb);
	}
	//"뽑은 개수(depth)와 순회 인덱스(i)는 완전히 다른 개념이다. depth는 '몇 개 뽑았나'만 관리하고, i는 매번 0부터 N-1까지 돈다."
	static void backtracking(int depth) {
		if (depth==M) {
			for (int i = 0; i < M; i++) {
	            sb.append(arr[i]);
	            if (i != M - 1) sb.append(" ");
	        }
	        sb.append("\n");  // 줄바꿈 추가
	        return;
		}
		for (int i = 0; i<N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = nums[i];
				backtracking(depth+1);
				visited[i] = false;
			}
		}
	}

}
