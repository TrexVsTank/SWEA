import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Solution_SWEA_1218_괄호짝짓기_D4_105ms_김민섭

public class Solution_SWEA_1218_괄호짝짓기_D4_김민섭_105ms {
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		
		for (int t = 1; t <= T; t++) { // 테케 시작
			
			int N = Integer.parseInt(br.readLine());
			
			String word = br.readLine();
			
			int[] arr = new int[4];
			
			int result = 1;
			
			for (int n = 0; n < N; n++) {
				if (word.charAt(n) == '(') {
					arr[0]++;
				} else if (word.charAt(n) == '{') {
					arr[1]++;
				} else if (word.charAt(n) == '[') {
					arr[2]++;
				} else if (word.charAt(n) == '<') {
					arr[3]++;
					
				} else if (word.charAt(n) == ')') {
					if (arr[0] > 0) {
						arr[0]--;
					} else {
						 result = 0;
						 break;
					}
				} else if (word.charAt(n) == '}') {
					if (arr[1] > 0) {
						arr[1]--;
					} else {
						result = 0;
						break;
					}
				} else if (word.charAt(n) == ']') {
					if (arr[2] > 0) {
						arr[2]--;
					} else {
						result = 0;
						break;
					}
				} else if (word.charAt(n) == '>') {
					if (arr[3] > 0) {
						arr[3]--;
					} else {
						result = 0;
						break;
					}
				}
			}
			
			for (int i = 0; i < 4; i++) {
				if (arr[i] != 0) {
					result = 0;
				}
			}
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
			
		} // 테케 끝
		
		System.out.println(sb);
		
	} // end of main
} // end of class

