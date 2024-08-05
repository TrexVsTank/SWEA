import java.io.*;
import java.util.*;

// Solution_SWEA_1210_Ladder1_D4_김민섭_152ms

public class Solution_SWEA_1210_Ladder1_D4_김민섭_152ms {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		// 0. 입력
		
		int T = 10;
		
		for (int t = 1; t <= T; t++) {
			
			int teke = Integer.parseInt(br.readLine());
			
			int[][] ladder = new int[100][100];
			
			int row2 = 0;
			int col2 = 0;
			
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
					if (ladder[i][j] == 2) {
						row2 = i;
						col2 = j;
					}
				}
			}
			
		// 0. 입력
			
		// 1. 풀이
			
			int myRow = row2;
			int myCol = col2;
			
			while (myRow > 0) {
				// 좌
				if (myCol-1 >= 0 && ladder[myRow][myCol-1] == 1) {
					while (myCol-1 >= 0 && ladder[myRow][myCol-1] == 1) {
						myCol--;
					}
					myRow--;
				// 우
				} else if (myCol+1 < 100 && ladder[myRow][myCol+1] == 1) {
					while (myCol+1 < 100 && ladder[myRow][myCol+1] == 1) {
						myCol++;
					}
					myRow--;
				// 상
				} else {
					myRow--;
				}
			}
			
			int result = myCol;
			
			sb.append("#").append(teke).append(" ").append(result).append("\n");
			
		// 1. 풀이
			
		} // end of teke 
			
		// 2. 출력
		
		System.out.println(sb);
		
		// 2. 출력
		
	} // end of main
} // end of class
