
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * 각 테스트케이스마다 n을 1, 2, 3의 합으로 나타내는 방법의 수
 * 1. 중복 조합인가? -> 아니다 순열이다
 * 		종료 조건 : count == 4 (if arr합 ==N 출력)
 * 		반복 : arr[count] = num[i]
 * 			  arr[count] = num[i+1]
 * 
 * 개념	중복 허용	순서 고려	예시
	조합	X	X	{1, 2}와 {2, 1} 동일하게 셈
 중복조합	O	X	{1, 1, 2}와 {2, 1, 1} 동일하게 셈
    순열	X	O	(1,2)와 (2,1) 다르게 셈
 중복순열	O	O	(1,2)와 (2,1) 다르게 셈, 중복 선택도 가능
 */

public class baekjoon9095123더하기 {
	static int[] num = {1, 2, 3};
	static List<Integer> arr;
	static int N;
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test<=T; test++) {
			N = Integer.parseInt(br.readLine());
			arr = new ArrayList<Integer>();
			answer = 0;
			comb(0);
			System.out.println(answer);
		}
	}//main
	static void comb(int count) {
		if (count>N) return; // 가지칙
		if (count==N) {
			answer++;
			return;
		}
		for (int i = 0; i<3; i++) { // 중복 순열 구조라면 매 단계에서 1, 2, 3 모두 시도해야 한다.
			arr.add(num[i]);
			comb(count+num[i]);
			arr.remove(arr.size()-1); // 백트래킹 (stack 구조로 생각하자. 넣은 것을 빼야한다)
		}
	}
}
