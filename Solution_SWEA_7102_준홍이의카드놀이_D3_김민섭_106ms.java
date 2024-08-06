import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// Solution_SWEA_7102_준홍이의카드놀이_D3_김민섭_106ms

public class Solution_SWEA_7102_준홍이의카드놀이_D3_김민섭_106ms {
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 시작
		int T = Integer.parseInt(br.readLine());
		
		// 테케 시작
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
		// 입력 종료
			
			sb.append("#").append(t);
			
			if (N <= M) {
				for (int i = 0; i < M-N+1; i++) {
					sb.append(" ").append(N+1+i);
				}
			} else {
				for (int i = 0; i < N-M+1; i++) {
					sb.append(" ").append(M+1+i);
				}
			}
			
			sb.append("\n");
			
			
		}
		// 테케 종료
		
		System.out.println(sb);
		
	} // end of main
} // end  of cla