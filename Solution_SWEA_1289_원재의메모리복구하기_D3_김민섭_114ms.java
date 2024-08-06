import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Solution_SWEA_1289_원재의메모리복구하기_D3_김민섭_114ms

public class Solution_SWEA_1289_원재의메모리복구하기_D3_김민섭_114ms {
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 시작
		int T = Integer.parseInt(br.readLine());
		
		// 테케 시작
		for (int t = 1; t <= T; t++) {
			String str = br.readLine();
		// 입력 종료
			
			sb.append("#").append(t);
			int result = 0;
			// solve
			int idx = 0;
			while (idx < str.length()) {
				if (idx == 0 && str.charAt(idx) == '1') {
					result++;
				}
				if (idx > 0 && str.charAt(idx-1) != str.charAt(idx)) {
					result++;
				}
				idx++;
			}
			
			// solve
			sb.append(" ").append(result).append("\n");
		}
		// 테케 종료
		System.out.println(sb);
		
	} // end of main
} // end  of class
