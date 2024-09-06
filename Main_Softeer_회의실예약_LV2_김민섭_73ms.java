import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// 클래스
public class Main_Softeer_회의실예약_LV2_김민섭_73ms {
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// [입력]
		int N = Integer.parseInt(st.nextToken()); // 1 ~ 50
		int M = Integer.parseInt(st.nextToken()); // 1 ~ 100
		
		// [입력] 이름
		Map<String, room> rooms = new HashMap<>();
		for (int n = 0; n < N; n++) {
			String name = br.readLine();
			rooms.put(name, new room());
		}
		
		// [입력] 예약
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			String r = st.nextToken();
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			rooms.get(r).use(s, e);
		}
		
		List<String> keys = new ArrayList<>(rooms.keySet());
		Collections.sort(keys);
		
		StringBuilder sb = new StringBuilder();
		
		for (String k : keys) {
			room R = rooms.get(k);
			sb.append("Room ").append(k).append(":").append("\n");
			if (R.available.size() == 0) {
				sb.append("Not available").append("\n");
			} else {
				sb.append(R.available.size()).append(" available:").append("\n");
			}
			for (int[] t : R.available) {
				int S = t[0];
				int E = t[1];
				if (S < 10) {
					sb.append(0).append(S).append("-");
				} else {
					sb.append(S).append("-");
				}
				if (E < 10) {
					sb.append(0).append(E).append("\n");
				} else {
					sb.append(E).append("\n");
				}
			}
			
			if (!k.equals(keys.get(keys.size()-1))) {
				sb.append("-----").append("\n");
			}
		}
		
		System.out.println(sb);
		
	} // 메인 끝
	
	// 방
	private static class room {
		List<int[]> available;
		
		room () {
			available = new ArrayList<>();
			available.add(new int[] {9, 18});
		}
		
		void use(int start, int end) {
			List<int[]> temp = new ArrayList<>();
			for (int[] a : available) {
				if (a[0] < start&& end < a[1]) {
					int[] a1 = new int[] {a[0], start};
					int[] a2 = new int[] {end, a[1]};
					temp.add(a1);
					temp.add(a2);
				} else if (a[0] < end && end < a[1]) {
					int[] a1 = new int[] {end, a[1]};
					temp.add(a1);
				} else if (a[0] < start && start < a[1]) {
					int[] a1 = new int[] {a[0], start};
					temp.add(a1);
				} else if (start <= a[0] && a[1] <= end) {
					continue;
				} else {
					temp.add(a);
				}
			}
			available = temp;
		}
		
	} // 방 끝
	
} // 클래스 끝
