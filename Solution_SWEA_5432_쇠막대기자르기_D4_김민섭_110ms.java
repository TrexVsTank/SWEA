import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Solution_SWEA_5432_쇠막대기자르기_D4_김민섭_110ms

public class Solution_SWEA_5432_쇠막대기자르기_D4_김민섭_110ms {
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) { // 테케 시작
			
			String stickString = br.readLine();
			
			int len = stickString.length();
			
			List<Integer> stickInt = new ArrayList<>();
			
			int num = 0;
			int sum = 0;
			int i = 0;
			while (i < len) {
				if (i+1 < len && stickString.substring(i, i+2).equals("()")) {
					if (stickInt.size() > 0) {
						sum += stickInt.get(stickInt.size()-1);
					}
					i+=2;
				} else if (stickString.charAt(i) == '(') {
					num++;
					stickInt.add(num);
					i++;
				} else if (stickString.charAt(i) == ')') {
					sum++;
					num--;
					stickInt.add(num);
					i++;
				}
			}
			
			sb.append("#").append(t).append(" ").append(sum).append("\n");
			
		} // 테케 끝
		
		System.out.println(sb);
		
	} // end of main
} // end of class

