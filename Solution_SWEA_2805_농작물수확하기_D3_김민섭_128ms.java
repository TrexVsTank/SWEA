import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Solution_SWEA_2805_농작물수확하기_D3_김민섭_128ms

public class Solution_SWEA_2805_농작물수확하기_D3_김민섭_128ms {
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 시작
		int T = Integer.parseInt(br.readLine());
		
		// 테케 시작
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j) - '0';
				}
			}
		// 입력 종료
			
			sb.append("#").append(t);
			
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (i <= N/2) {
					int space = N/2 - i;
					int get = 2*i + 1;
					for (int j = space; j < space+get; j++) {
						sum += arr[i][j];
					}
				} else {
					int space = i - N/2;
					int get = 2*N-1 - i*2;
					for (int j = space; j < space+get; j++) {
						sum += arr[i][j];
					}
				}
			}
			
			sb.append(" ").append(sum);
			
			sb.append("\n");
			
		}
		// 테케 종료
		
		System.out.println(sb);
		
	} // end of main
} // end  of cla