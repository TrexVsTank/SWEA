import java.io.*;
import java.util.*;

//Solution_SWEA_2063_중간값찾기_D1_김민섭_127ms.java

public class Solution_SWEA_2063_중간값찾기_D1_김민섭_127ms {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arrInput = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < arrInput.length; i++) {
			arrInput[i] = Integer.parseInt(st.nextToken());
		}

		// 0. 입력
			
		// 1. 풀이
		
		Arrays.sort(arrInput);
		
		// 1. 풀이
			
		
		// 2. 출력
		
		System.out.println(arrInput[N/2]);
		
		// 2. 출력
		
	} // end of main
} // end of class



