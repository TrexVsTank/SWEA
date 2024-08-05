import java.io.*;
import java.util.*;

public class Solution_SWEA_1206_View_D3_김민섭_104ms {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			
			// 0. 입력
			
			int N = Integer.parseInt(br.readLine());
			
			int[] Arr = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				Arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 0. 입력
			
			// 1. 풀이
			
			int[] result = new int[N];
			
			for (int i = 0; i < N; i++) {
				if (Arr[i] > 0) {
					int maxNear = 0;
					for (int j = i-2; j <= i + 2; j++) {
						if (j != i) {
							if ( (j >= 0) && (j < N) ) {
								if (maxNear < Arr[j]) {
									maxNear = Arr[j];
								}
							}
						}
					}
					if (Arr[i] - maxNear > 0) {
						result[i] = Arr[i] - maxNear;
					}
				}
			}
			
			int sum = 0;
			
			for (int i = 0; i < N; i++) {
				sum += result[i];
			}
			
			// 1. 풀이
			
			System.out.println("#" + t + " " + sum);
		} // end of testCase
		
	} // end of main
} // end of class
