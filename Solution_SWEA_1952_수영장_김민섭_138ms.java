import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 클래스
public class Solution_SWEA_1952_수영장_김민섭_138ms {
	
	static int price[];
	static int month[];
	
	static int sum;
	static int min;
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		// 테케
		for (int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// [입력] 가격표
			price = new int[4];
			for (int p = 0; p < 4; p++) {
				price[p] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			// [입력] 계획
			month = new int[12];
			for (int m = 0; m < 12; m++) {
				month[m] = Integer.parseInt(st.nextToken());
			}
			
			sum = 0;
			min = 1_000_000_000;
			pick(0);
			sb.append("#").append(t).append(" ").append(min).append("\n");
			
		} // 테케 끝
		
		// 출력
		System.out.println(sb);
		
	} // 메인 끝
	
	static void pick(int index) {
		if (index >= 12) {
			min = Math.min(min, sum);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (i == 0) {
				sum += month[index] * price[i];
				pick(index+1);
				sum -= month[index] * price[i];
			} else if (i == 1) {
				sum += price[i];
				pick(index+1);
				sum -= price[i];
				
			} else if (i == 2) {
				sum += price[i];
				pick(index+3);
				sum -= price[i];
			} else {
				sum += price[i];
				pick(index+12);
				sum -= price[i];
			}
		}
	}
	
} // 클래스 끝