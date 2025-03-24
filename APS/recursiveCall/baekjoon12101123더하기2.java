
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon12101123더하기2 {
	static int N;
	static int K;
	static int answer;
	static boolean find;
	static List<Integer> arr;
	public static void main(String[] args) throws IOException {
		// 정수 n과 k가 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법 중에서 k번째로 오는 식을 구하는 프로그램을 작성하시오.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // n은 양수이며 11보다 작음
		K = Integer.parseInt(st.nextToken());
		answer = 0;
		find = false;
		permutation(0);
		if (!find) System.out.println(-1);
	}
	static void permutation(int sum) {
		if (sum>N) return;
		if (sum==N) {
			answer++;
			if (answer == K) {
				for (int i = 0; i<arr.size(); i++) {
					System.out.print(arr.get(i));
					if (i!=arr.size()-1) System.out.print("+");
				}
				find = true;
			}
			return;
		}
		for (int i = 1; i<=3; i++) {
			arr.add(i);
			permutation(sum+i);
			arr.remove(arr.size()-1);
		}
	}

}
