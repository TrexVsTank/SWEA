import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 클래스
public class Solution_SWEA_14510_나무높이_D2_김민섭_113ms {
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 30 이하
		int T = Integer.parseInt(br.readLine());
		
		// 테케
		for (int t = 1; t <= T; t++) {
			
			// 100 이하
			int N = Integer.parseInt(br.readLine());
			
			int max = 0;
			
			// 120 이하
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if (max < arr[i]) {
					max = arr[i];
				}
			}
			
			int d1 = 0;
			int d2 = 0;
			
			for (int i = 0; i < N; i++) {
				int diff = max-arr[i];
				d2 += diff/2;
				d1 += diff%2;
			}
			
			int time = 0;
			
			while (d1 > 0 && d2 > 0) {
				d1--;
				d2--;
				time+=2;
			}
			
			while (d2 >= 3) {
				d2 -= 3;
				time += 4;
			}
			
			if (d2 == 2) {
				d2 = 0;
				time += 3;
			}
			if (d2 == 1) {
				d2 = 0;
				time += 2;
			}
			
			if (d1 > 0) {
				time += d1*2-1;
				d1 = 0;
			}
			
			sb.append("#").append(t).append(" ").append(time).append("\n");
			
		} // 테케 끝
		
		System.out.println(sb);
		
	} // 메인 끝
	
} // 클래스 끝