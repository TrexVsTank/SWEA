import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Solution_SWEA_8931_제로_D3_김민섭_103ms

public class Solution_SWEA_8931_제로_D3_김민섭_103ms {
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) { // 테케 시작
			
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			
			for (int i = 0; i < N; i++) {
				if (arr[i] == 0) {
					for (int j = i-1; j >= 0; j--) {
						if (arr[j] != 0) {
							arr[j] = 0;
							break;
						}
						
					}
				}
			}
			
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += arr[i];
			}
			
			sb.append("#").append(t).append(" ").append(sum).append("\n");
			
		} // 테케 끝
		
		System.out.println(sb);
		
	} // end of main
} // end of class

