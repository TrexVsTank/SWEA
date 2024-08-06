import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Solution_SWEA_1859_백만장자프로젝트_D2_김민섭_6102ms

public class Solution_SWEA_1859_백만장자프로젝트_D2_김민섭_6102ms {
	public static void main(String[] args) throws IOException {
		
//		long startTime = System.currentTimeMillis();
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 시작
		int T = Integer.parseInt(br.readLine());
		
		// 테케 시작
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			long[][] arr = new long[N][2];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i][0] = i;
				arr[i][1] = Long.parseLong(st.nextToken());
			}
		// 입력 종료
			
			sb.append("#").append(t);
			
			Arrays.sort(arr, (a, b) -> {
				return (int) (b[1] - a[1]);
			});
			
			long result = 0;
			
			for (int i = 1; i < N; i++) {
				long earn = 0;
				for (int j = 0; j < i; j++) {
					if (arr[i][0] < arr[j][0]) {
						if (earn < arr[j][1] - arr[i][1]) {
							earn = arr[j][1] - arr[i][1];
							break;
						}
					}
				}
				result += earn;
			}
			
			sb.append(" ").append(result);
			
			sb.append("\n");
			
		}
		// 테케 종료
		
		System.out.println(sb);
		
//		long stopTime = System.currentTimeMillis();
//		System.out.println("코드 실행 시간: " + (stopTime - startTime));
		
	} // end of main
} // end  of cla