import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 클래스
public class Solution_SWEA_2817_부분수열의합_D3_김민섭_223ms {
	
	static int N;
	static int K;
	static int arr[];
	static int count;
	static int sum;
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		// 테케 시작
		for (int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken()); // 1 ~ 20
			K = Integer.parseInt(st.nextToken()); // 1 ~ 1000
			
			arr = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken()); // 1 ~ 100
			}
			
			count = 0;
			sum = 0;
			
			case_counter(0);
			
			sb.append("#").append(t).append(" ").append(count).append("\n");
			
		} // 테케 끝
		
		System.out.println(sb);
		
	} // 메인 끝
	
	// 백트래킹 메서드
	static void case_counter(int index) {
		
		if (index == N) {
			return;
		}
		
		for (int i = index; i < N; i++) {
			sum += arr[i];
			if (sum == K) {
				count++;
			}
			case_counter(i+1);
			sum -= arr[i];
		}
		
	} // 백트래킹 메서드 끝
	
} // 클래스 끝