import java.io.*;
import java.util.*;

//Solution_SWEA_2001_파리퇴치_D2_김민섭_122ms.java

public class Solution_SWEA_2001_파리퇴치_D2_김민섭_122ms {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		// 0. 입력

		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			
			int M = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer stTemp = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(stTemp.nextToken());
				}
			}
			
		// 0. 입력
			
		// 1. 풀이
			
			int kl = N-M+1;
			
			int[][] kill = new int[kl][kl];
			
			for (int i = 0; i < kl; i++) {
				for (int j = 0; j < kl; j++) {
					for (int i2 = 0; i2 < M; i2++) {
						for (int j2 = 0; j2 < M; j2++) {
							kill[i][j] += arr[i+i2][j+j2];
						}
					}
				}
			}
			
			int max = kill[0][0];
			
			for (int i = 0; i < kl; i++) {
				for (int j = 0; j < kl; j++) {
					if (max < kill[i][j]) {
						max = kill[i][j];
					}
				}
			}
			
			sb.append("#"+t+" "+max+"\n");
			
		// 1. 풀이
			
		} // end of testCase
		
		System.out.println(sb);
		
	} // end of main
} // end of class
