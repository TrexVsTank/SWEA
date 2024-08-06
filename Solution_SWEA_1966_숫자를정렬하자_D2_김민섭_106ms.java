import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// Solution_SWEA_1966_숫자를정렬하자_D2_김민섭_106ms

public class Solution_SWEA_1966_숫자를정렬하자_D2_김민섭_106ms {
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 시작
		int T = Integer.parseInt(br.readLine());
		
		// 테케 시작
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
		// 입력 종료
			
			sb.append("#").append(t);
			
			Arrays.sort(arr);
			for (int i = 0; i < N; i++) {
				sb.append(" ").append(arr[i]);
			}
			
			sb.append("\n");
			
		}
		// 테케 종료
		
		System.out.println(sb);
		
	} // end of main
} // end  of cla