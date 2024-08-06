import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// Solution_SWEA_1225_암호생성기_D3_김민섭_134ms

public class Solution_SWEA_1225_암호생성기_D3_김민섭_134ms {
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 시작
		int T = 10;
		
		// 테케 시작
		for (int t = 1; t <= T; t++) {
			int teke = Integer.parseInt(br.readLine());
			int N = 8;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
		// 입력 종료
			
			sb.append("#").append(teke);
			
			int num = 1;
			
			while (num != 0) {
				for (int i = 1; i <= 5; i++) {
					if (list.get(0) <= i) {
						num = 0;
						list.remove(0);
						list.add(num);
						break;
					} else {
						num = list.get(0) - i;
						list.remove(0);
						list.add(num);
					}
				}
			}
			
			for (int i = 0; i < 8; i++) {
				sb.append(" ").append(list.get(i));
			}
			sb.append("\n");
			
			
		}
		// 테케 종료
		
		System.out.println(sb);
		
	} // end of main
} // end  of cla