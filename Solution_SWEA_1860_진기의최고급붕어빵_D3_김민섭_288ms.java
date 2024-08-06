import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// Solution_SWEA_1860_진기의최고급붕어빵_D3_김민섭_288ms

public class Solution_SWEA_1860_진기의최고급붕어빵_D3_김민섭_288ms {
	public static void main(String[] args) throws IOException {
		
		
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 시작
		int T = Integer.parseInt(br.readLine());
		
		// 테케 시작
		for (int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] arrInput = new int[N];
			StringTokenizer stN = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arrInput[i] = Integer.parseInt(stN.nextToken());
			}
			Arrays.sort(arrInput);
		// 입력 종료
			
			sb.append("#").append(t);
			String result = "Possible";
			
			int max = arrInput[arrInput.length-1];
			
			// cat
			int[] cat = new int[max];
			for (int i = 0; i < N; i++) {
				if (arrInput[i] == 0) {
					result = "Impossible";
				} else {
					cat[arrInput[i]-1]++;
				}
			}
			for (int i = 1; i < max; i++) {
				cat[i] += cat[i-1];
			}
			// cat
			
			// fish
			int[] fish = new int[max];
			for (int i = 0; i < max; i++) {
				fish[i] = (i+1)/M*K;
			}
			// fish
			
			for (int i = 0; i < max; i++) {
				if (fish[i] < cat[i]) {
					result = "Impossible";
					break;
				}
			}
			
			sb.append(" ").append(result).append("\n");
		}
		// 테케 종료
		System.out.println(sb);
		
//		f4(4);
	} // end of main
	
//	static void f4(int index) {
//		if (index > 6) {
//			System.out.println();
//			return;
//		} else if (index >= 0) {
//			f4(index-1);
//			System.out.print(7-index*(4) + " ");
//		}
//	}
	
} // end  of class
