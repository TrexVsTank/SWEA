import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 클래스
public class Solution_SWEA_1970_쉬운거스름돈_D2_김민섭_110ms {
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		
		// [입력]
		int T = Integer.parseInt(br.readLine());
		
		// 테케
		for (int t = 1; t <= T; t++) {
			
			// [입력] 10 ~ 1,000,000
			int cost = Integer.parseInt(br.readLine());
			
			// 계산 & 어펜드
			int[] count = new int[8];
			for (int i = 0; i < 8; i++) {
				count[i] = cost / money[i];
				cost -= cost / money[i] * money[i];
			}
			sb.append("#" + t + "\n");
			for (int i = 0; i < 8; i++) {
				sb.append(count[i] + " ");
			}
			sb.append("\n");
			
		} // 테케 끝
		
		// 출력
		System.out.println(sb);
		
	} // 메인 끝
	
} // 클래스 끝