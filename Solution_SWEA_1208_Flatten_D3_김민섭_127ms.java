import java.io.*;
import java.util.*;

//Solution_SWEA_1208_Flatten_D3_김민섭_127ms.java

public class Solution_SWEA_1208_Flatten_D3_김민섭_127ms {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int T = 10;
		
		for (int t = 1; t <= T; t++) {
			
			// 0. 입력
			
			int D = Integer.parseInt(br.readLine());
			
			List<Integer> list = new ArrayList<>();
			int N = 100;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			// 0. 입력
			
			// 1. 풀이
			
			Collections.sort(list);
			
			int num1 = 0;

			// 아래
			int d1 = D;
			while (d1 > 0) {
				if (list.get(0) == list.get(99)) {
					break;
				}
				for (int i = 0; i < 99; i++) {
					if (list.get(i) < list.get(i+1)) {
						num1 = list.get(i)+1;
						list.set(i, num1);
						d1--;
						break;
					}
				}
			}
			
			// 위
			int d2 = D;
			while (d2 > 0) {
				if (list.get(0) == list.get(99)) {
					break;
				}
				for (int i = 99; i > 0; i--) {
					if (list.get(i) > list.get(i-1)) {
						num1 = list.get(i)-1;
						list.set(i, num1);
						d2--;
						break;
					}
				}
			}
			
			sb.append("#" + t + " " + (list.get(99)-list.get(0)) + "\n");
			
			// 1. 풀이
			
		} // end of testCase
		
		System.out.println(sb);
		
	} // end of main
} // end of class
