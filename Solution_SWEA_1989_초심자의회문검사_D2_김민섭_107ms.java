import java.io.*;
import java.util.*;

// Solution_SWEA_1989_초심자의회문검사_D2_김민섭_107ms

public class Solution_SWEA_1989_초심자의회문검사_D2_김민섭_107ms {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		// 0. 입력
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			String wordInput = br.readLine();
			
		// 0. 입력
			
		// 1. 풀이
		
			int num1 = 0;
			
			for (int i = 0; i < wordInput.length()/2; i++) {
				if (wordInput.charAt(i) == wordInput.charAt(wordInput.length()-1-i)) {
					num1++;
				}
			}
			
			int result = 0;
			
			if (num1 == wordInput.length()/2) {
				result = 1;
			}
			
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
			
		// 1. 풀이
			
		} // end of teke 
			
		// 2. 출력
		
		System.out.println(sb);
		
		// 2. 출력
		
	} // end of main
} // end of class
