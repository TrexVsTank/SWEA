import java.io.*;
import java.util.*;

public class Solution_SWEA_1984_중간평균값구하기_D2_김민섭_124ms {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			// 0. 입력
			
			int N = 10;
			
			int[] arr = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 0. 입력
			
			// 1. 풀이
			
			Arrays.sort(arr);
			
			double sum = 0;
			
			for (int i = 1; i < 9; i++) {
				sum += arr[i];
			}
			sum /= 8;
			
			System.out.printf("#" + t + " " + "%.0f" + "\n", sum);
			
			// 1. 풀이
			
		} // end of testCase
		
	} // end of main
} // end of class
