import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Solution_SWEA_3499_퍼펙트셔플_D3_김민섭_102ms

public class Solution_SWEA_3499_퍼펙트셔플_D3_김민섭_102ms {
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 시작
		int T = Integer.parseInt(br.readLine());
		
		// 테케 시작
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String[] arr = new String[N];
			for (int i = 0; i < N; i++) {
				arr[i] = st.nextToken();
			}
		// 입력 종료
			
			sb.append("#").append(t);
			
			// 홀
			if (N % 2 != 0) {
				for (int i = 0; i < N/2; i++) {
					sb.append(" ").append(arr[i]);
					sb.append(" ").append(arr[i+N/2+1]);
				}
				sb.append(" ").append(arr[N/2]);
			}
			// 짝
			else {
				for (int i = 0; i < N/2; i++) {
					sb.append(" ").append(arr[i]);
					sb.append(" ").append(arr[i+N/2]);
				}
			}
			
			sb.append("\n");
			
		}
		// 테케 종료
		
		System.out.println(sb);
		
	} // end of main
} // end  of cla