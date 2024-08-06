import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Solution_SWEA_1974_스도쿠검정_D2_김민섭_113ms

public class Solution_SWEA_1974_스도쿠검정_D2_김민섭_113ms {
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 시작
		int T = Integer.parseInt(br.readLine());
		
		// 테케 시작
		for (int t = 1; t <= T; t++) {
			int N = 9;
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		// 입력 종료
			
			sb.append("#").append(t);
			
			int result = 1;
			
			int[] nums = new int[9];
			
			// 가로
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					nums[j] = arr[i][j];
				}
				Arrays.sort(nums);
				if (!(Arrays.equals(nums, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}))) {
					result = 0;
				}
			}
			// 세로
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					nums[j] = arr[j][i];
				}
				Arrays.sort(nums);
				if (!(Arrays.equals(nums, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}))) {
					result = 0;
				}
			}
			// 9칸씩
			for (int i3 = 0; i3 < 9; i3+=3) {
				for (int j3 = 0; j3 < 9; j3+=3) {
					for (int i1 = 0; i1 < 3; i1++) {
						for (int j1 = 0; j1 < 3; j1++) {
							nums[3*i1+j1] = arr[i3+i1][j3+j1];
						}
					}
					Arrays.sort(nums);
					if (!(Arrays.equals(nums, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}))) {
						result = 0;
					}
				}
			}
			
			sb.append(" ").append(result);
			
			sb.append("\n");
			
		}
		// 테케 종료
		
		System.out.println(sb);
		
	} // end of main
} // end  of cla