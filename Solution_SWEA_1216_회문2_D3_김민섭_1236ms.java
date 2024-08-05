import java.io.*;
import java.util.*;

//Solution_SWEA_1216_회문2_D3_김민섭_1236ms.java

public class Solution_SWEA_1216_회문2_D3_김민섭_1236ms {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		// 0. 입력

		int T = 10;
		
		for (int t = 1; t <= T; t++) {
			
			int teke = Integer.parseInt(br.readLine());
			
			int N = 100;
			
			int[][] arr = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = input.charAt(j)-'@';
				}
			}
			
		// 0. 입력
			
		// 1. 풀이
			
			// 가로
			int max1 = 0;
			
			for (int i = 100; i >= 1; i--) {
				for (int i2 = 0; i2 < N; i2++) {
					for (int j2 = 0; j2 < N-i; j2++) {
						int num1 = 0;
						for (int k = 0; k < i/2; k++) {
							if (arr[i2][j2+k] == arr[i2][j2+i-1-k]) {
								num1++;
							}
						}
						if ( (num1 == i/2) && (max1 < i) ) {
							max1 = i;
						}
					}
				}
			}
			
			// 세로
			int max2 = 0;
			
			for (int i = 100; i >= 1; i--) {
				for (int i2 = 0; i2 < N-i; i2++) {
					for (int j2 = 0; j2 < N; j2++) {
						int num2 = 0;
						for (int k = 0; k < i/2; k++) {
							if (arr[i2+k][j2] == arr[i2+i-1-k][j2]) {
								num2++;
							}
						}
						if ( (num2 == i/2) && (max2 < i) ) {
							max2 = i;
						}
					}
				}
			}
			
			int max = max1;
			
			if (max < max2) {
				max = max2;
			}
			
			sb.append("#" + teke + " " + max + "\n");
			
		// 1. 풀이
			
		} // end of testCase
		
		System.out.println(sb);
		
	} // end of main
} // end of class
