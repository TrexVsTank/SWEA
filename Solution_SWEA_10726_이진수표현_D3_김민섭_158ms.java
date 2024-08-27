import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// class
public class Solution_SWEA_10726_D3_김민섭_158ms {
	
	// main
	public static void main(String[] args) throws IOException {
		
		// sb
		StringBuilder sb = new StringBuilder();
		
		// br
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// T
		int T = Integer.parseInt(br.readLine());
		
		// 테케 시작
		for (int t = 1; t <= T; t++) {
			
			// st
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			// N (1 ~ 30)
			int N = Integer.parseInt(st.nextToken());
			
			// M (1~10^8)
			long M = Long.parseLong(st.nextToken());
			
			String result = "ON";
			
			M -= M/pow(2, N)*pow(2, N);
			for (int i = N-1; i >= 0; i--) {
				long l = pow(2, i);
				if (M/l != 1) {
					result = "OFF";
					break;
				}
				M -= M/l*l;
			}
			
			// sb 어펜드
			sb.append("#").append(t).append(" ").append(result).append("\n");
			
		} // 테케 종료
		
		System.out.println(sb);
		
	} // end of main
	
	// pow (제곱)
	static long pow(long num, int p) {
		if (p == 0) {
			return 1;
		}
		return pow(num, p-1) * num;
	} // end of pow
	
} // end of class