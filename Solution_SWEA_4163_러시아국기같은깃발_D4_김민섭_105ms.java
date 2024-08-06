import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Solution_SWEA_4163_러시아국기같은깃발_D4_김민섭_105ms

public class Solution_SWEA_4163_러시아국기같은깃발_D4_김민섭_105ms {
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 시작
		int T = Integer.parseInt(br.readLine());
		
		// 테케 시작
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][M];
			for (int n = 0; n < N; n++) {
				String str = br.readLine();
				for (int m = 0; m < M; m++) {
					if (str.charAt(m) == 'W') {
						arr[n][m] = 0;
					} else if (str.charAt(m) == 'B') {
						arr[n][m] = 1;
					} else {
						arr[n][m] = 2;
					}
				}
			}
		// 입력 종료
			
			sb.append("#").append(t);
			int result = N*M;
			
			// solve
			for (int w = 0; w < N-2; w++) {
				for (int r = w+2; r < N; r++) {
					
					int numW = 0;
					for (int i = 0; i <= w; i++) {
						for (int j = 0; j < M; j++) {
							if (arr[i][j] != 0) {
								numW++;
							}
						}
					}
					
					int numB = 0;
					for (int i = w+1; i <= r-1; i++) {
						for (int j = 0; j < M; j++) {
							if (arr[i][j] != 1) {
								numB++;
							}
						}
					}
					
					int numR = 0;
					for (int i = r; i < N; i++) {
						for (int j = 0; j < M; j++) {
							if (arr[i][j] != 2) {
								numR++;
							}
						}
					}
					int numSum = numW + numB + numR;
					if (numSum < result) {
						result = numSum;
					}
					
				}
			}
			// solve
			
			sb.append(" ").append(result).append("\n");
		}
		// 테케 종료
		System.out.println(sb);
		
	} // end of main
} // end  of class
