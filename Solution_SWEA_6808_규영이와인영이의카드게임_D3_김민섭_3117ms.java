import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 클래스
public class Solution_SWEA_6808_규영이와인영이의카드게임_D3_김민섭_3117ms {
	
	static int my_card[];
	static int your_card[];
	
	static int my_pick[];
	static boolean my_used[];
	
	static int score;
	static int win;
	static int lose;
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		// 테케 시작
		for (int t = 1; t <= T; t++) {
			
			int[] cards = new int[19];
			for (int i = 1; i <= 18; i++) {
				cards[i] = 1;
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			your_card = new int[10]; // 1 ~ 18
			for (int i = 1; i <= 9; i++) {
				your_card[i] = Integer.parseInt(st.nextToken());
				cards[your_card[i]] = 0;
			}
			
			my_card = new int[10];
			int idx = 1;
			int my_idx = 1;
			while (idx <= 18 && my_idx <= 9) {
				if (cards[idx] == 0) {
					idx++;
				} else {
					my_card[my_idx++] = idx++;
				}
			}
			
			my_used = new boolean[10];
			my_pick = new int[10];
			win = 0;
			lose = 0;
			
			func(1);
			
//			System.out.println(Arrays.toString(your_card));
//			System.out.println(Arrays.toString(my_card));
//			System.out.println();
			
			sb.append("#").append(t).append(" ").append(lose).append(" ").append(win).append("\n");
			
		} // 테케 끝
		
		System.out.println(sb);
		
	} // 메인 끝
	
	// 백트래킹
	static void func(int index) {
		if (index == 10) {
			score = 0;
			for (int i = 1; i <= 9; i++) {
				if (my_pick[i] > your_card[i]) {
					score += my_pick[i] + your_card[i];
				} else {
					score -= my_pick[i] + your_card[i];
				}
			}
			if (score > 0) {
				win++;
			} else if (score < 0) {
				lose++;
			}
			return;
		}
		for (int i = 1; i <= 9; i++) {
			if (!my_used[i]) {
				my_pick[index] = my_card[i];
				my_used[i] = true;
				func(index+1);
				my_used[i] = false;
			}
		}
	} // 백트래킹 끝
	
} // 클래스 끝