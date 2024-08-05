import java.io.*;
import java.util.*;

// Solution_SWEA_1954_달팽이숫자_D2_김민섭_101ms.java

public class Solution_SWEA_1954_달팽이숫자_D2_김민섭_101ms {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			int N = Integer.parseInt(br.readLine());

		// 0. 입력
			
		// 1. 풀이
		
			int[][] snail = new int[N][N];
			
			int corR = 0;
			int corC = 0;
			
			// 동 남 서 북
			int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
			int dirN = 0;
			int number = 1;
			snail[0][0] = 1;
			
			for (int i = 1; i < N * N; i++) {
				// 범위 안쪽
				if ( (corR+dir[dirN][0] >= 0) && (corR+dir[dirN][0] < N) &&
						(corC+dir[dirN][1] >= 0)&& (corC+dir[dirN][1] < N) &&
						(snail[corR+dir[dirN][0]][corC+dir[dirN][1]] == 0) && (snail[corR+dir[dirN][0]][corC+dir[dirN][1]] == 0) ) {
					corR = corR+dir[dirN][0];
					corC = corC+dir[dirN][1];
					number++;
					snail[corR][corC] = number;
				// 범위 이탈 => 0이 아님
				} else {
					dirN = (dirN + 1) % 4;
					corR = corR+dir[dirN][0];
					corC = corC+dir[dirN][1];
					number++;
					snail[corR][corC] = number;
				}
			}
			
		// 1. 풀이
			
			sb.append("#").append(t).append("\n");
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(snail[i][j]).append(" ");
				}
				sb.append("\n");
			}
		
		
		} // end of testCase
		
		// 2. 출력
		
		System.out.print(sb);
		
		// 2. 출력
		
	} // end of main
} // end of class
