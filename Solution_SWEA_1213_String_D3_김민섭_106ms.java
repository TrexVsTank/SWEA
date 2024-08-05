import java.io.*;
import java.util.*;

// Solution_SWEA_1213_String_D3_김민섭_106ms

public class Solution_SWEA_1213_String_D3_김민섭_106ms {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		// 0. 입력
		
		int T = 10;
		
		for (int t = 1; t <= T; t++) {
			
			int teke = Integer.parseInt(br.readLine());
			
			String wordToFind = br.readLine();
			
			String wordGiven = br.readLine();
			
		// 0. 입력
			
		// 1. 풀이
			
			int lenTF = wordToFind.length();
			
			int lenG = wordGiven.length();
			
			int result = 0;
			
			for (int i = 0; i < lenG-lenTF+1; i++) {
				int numTemp = 0;
				for (int j = 0; j < lenTF; j++) {
					if (wordToFind.charAt(j) == wordGiven.charAt(i+j)) {
						numTemp++;
					}
				}
				if (numTemp == lenTF) {
					result++;
				}
			}
			
			sb.append("#").append(teke).append(" ").append(result).append("\n");
			
		// 1. 풀이
			
		} // end of teke 
			
		// 2. 출력
		
		System.out.println(sb);
		
		// 2. 출력
		
	} // end of main
} // end of class
