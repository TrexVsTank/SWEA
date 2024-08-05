import java.io.*;
import java.util.*;

// Solution_SWEA_1209_Sum_D3_김민섭_155ms.java

public class Solution_SWEA_1209_Sum_D3_김민섭_155ms {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		for (int t = 0; t < 10; t++) {
			
		// 0. 입력
		
			int teke = Integer.parseInt(br.readLine());
			
			int[][] arrInput = new int[100][100];
			
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					arrInput[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
		// 0. 입력
			
		// 1. 풀이
		
			// 행 합
			
			int maxR = 0;
			for (int i = 0; i < 100; i++) {
				int temp = 0;
				for (int j = 0; j < 100; j++) {
					temp += arrInput[i][j];
				}
				if (maxR < temp) {
					maxR = temp;
				}
			}
			
			// 열 합
			
			int maxC = 0;
			for (int i = 0; i < 100; i++) {
				int temp = 0;
				for (int j = 0; j < 100; j++) {
					temp += arrInput[j][i];
				}
				if (maxC < temp) {
					maxC = temp;
				}
			}
			
			// 대각 합
			
			int maxX = 0;
			for (int i = 0; i < 2; i++) {
				int temp = 0;
				for (int j = 0; j < 100; j++) {
					if (i == 0) {
						temp += arrInput[j][j];
					} else {
						temp += arrInput[99-j][j];
					}
				}
				if (maxX < temp) {
					maxX = temp;
				}
			}
			
			int maxF = maxR;
			
			if (maxF < maxC) {
				maxF = maxC;
			}
			
			if (maxF < maxX) {
				maxF = maxX;
			}
			
			sb.append("#").append(teke).append(" ").append(maxF).append("\n");
			
		// 1. 풀이
			
		} // end of teke 
			
		// 2. 출력
		
		System.out.println(sb);
		
		// 2. 출력
		
	} // end of main
} // end of class
