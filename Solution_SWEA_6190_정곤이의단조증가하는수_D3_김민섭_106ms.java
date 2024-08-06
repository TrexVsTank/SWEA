import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Solution_SWEA_6190_정곤이의단조증가하는수_D3_김민섭_106ms

public class Solution_SWEA_6190_정곤이의단조증가하는수_D3_김민섭_106ms {
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
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
		// 입력 종료
			
			sb.append("#").append(t);
			int result = -1;
			
			//
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					int num = arr[i] * arr[j];
					String str = num+"";
					int checker = 1;
					for (int k = 0; k < str.length()-1; k++) {
						if (str.charAt(k) > str.charAt(k+1)) {
							checker = 0;
						}
					}
					if (checker == 1 && result < num) {
						result = num;
					}
				}
			}
			//
			
			sb.append(" ").append(result).append("\n");
		}
		// 테케 종료
		System.out.println(sb);
		
	} // end of main
} // end  of class
