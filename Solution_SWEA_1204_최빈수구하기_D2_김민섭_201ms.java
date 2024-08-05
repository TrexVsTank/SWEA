import java.io.*;
import java.util.*;

//Solution_SWEA_1204_최빈수구하기_D2_김민섭_201ms.java

public class Solution_SWEA_1204_최빈수구하기_D2_김민섭_201ms {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		// 0. 입력

		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			int teke = Integer.parseInt(br.readLine());
			
			int[] arrInput = new int[1000];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < 1000; i++) {
				arrInput[i] = Integer.parseInt(st.nextToken());
			}
			
		// 0. 입력
			
		// 1. 풀이
			
			int[][] arrCount = new int[101][2];
			
			for (int i = 0; i < 101; i++) {
				arrCount[i][0] = i;
			}
			
			for (int i = 0; i < 1000; i++) {
				arrCount[arrInput[i]][1]++;
			}
			
			Arrays.sort(arrCount, (a, b) -> {
				if (b[1] == a[1]) {
					return b[0] - a[0];
				} else {
					return b[1] - a[1];
				}
			});
			
			sb.append("#" + teke + " " + arrCount[0][0] + "\n");
			
		// 1. 풀이
			
		} // end of testCase
		
		// 2. 출력
		
		System.out.println(sb);
		
		// 2. 출력
		
	} // end of main
} // end of class
