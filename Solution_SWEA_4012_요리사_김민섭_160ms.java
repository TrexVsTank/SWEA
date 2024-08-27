import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 클래스
public class Solution_SWEA_4012_요리사_김민섭_160ms {
	
	static int N;
	static int S[][];
	static int picked_one[];
	static int picked_two[];
	static int diff;
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		// 테케 시작
		for (int t = 1; t <= T; t++) {
			
			
			N = Integer.parseInt(br.readLine()); // 4 ~ 16 / 짝수
			
			S = new int[N][N]; // 1~20,000
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					S[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			picked_one = new int[N/2];
			picked_two = new int[N/2];
			diff = Integer.MAX_VALUE;
			
			picker(0, 0, 0);
			
			sb.append("#").append(t).append(" ").append(diff).append("\n");
			
		} // 테케 끝
		
		System.out.println(sb);
		
	} // 메인 끝
	
	// 백트래킹
	static void picker(int index, int one, int two) {
		
		if (one == N/2 && two == N/2) {
			
			int val_one = 0;
			for (int i = 0; i < N/2; i++) {
				for (int j = 0; j < N/2; j++) {
					val_one += S[picked_one[i]][picked_one[j]];
				}
			}
			int val_two = 0;
			for (int i = 0; i < N/2; i++) {
				for (int j = 0; j < N/2; j++) {
					val_two += S[picked_two[i]][picked_two[j]];
				}
			}
			if (Math.abs(val_two-val_one) < diff) {
				diff = Math.abs(val_two-val_one);
			}
			return;
		}
		
		if (one == N/2) {
			picked_two[two] = index;
			picker(index+1, one, two+1);
			return;
		}
		
		if (two == N/2) {
			picked_one[one] = index;
			picker(index+1, one+1, two);
			return;
		}
		
		picked_one[one] = index;
		picker(index+1, one+1, two);
		picked_two[two] = index;
		picker(index+1, one, two+1);
		return;
		
	} // 백트래킹 끝
	
} // 클래스 끝