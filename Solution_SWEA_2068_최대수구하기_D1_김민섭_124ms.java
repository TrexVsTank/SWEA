import java.io.*;
import java.util.*;

public class Solution_SWEA_2068_최대수구하기_D1_김민섭_124ms {
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
			
			
			System.out.println("#" + t + " " + arr[9]);
			
			// 1. 풀이
			
		} // end of testCase
		
	} // end of main
} // end of class
