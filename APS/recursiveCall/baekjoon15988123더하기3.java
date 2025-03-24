
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon15988123더하기3 {
	static int[] dp = new int[1000001];
	static int MOD = 1000000009;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		makeDP();
		for (int test = 1; test<=T; test++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(dp[N]);
			
		}

	}
	static void makeDP() {
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i<1000001; i++) {
			dp[i] = ((dp[i-1] + dp[i-2])%MOD + dp[i-3])%MOD;
		}
	}

}
