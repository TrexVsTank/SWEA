import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_12712_파리퇴치3_D2_김민섭_109 {
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			StringTokenizer stNM = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(stNM.nextToken());
			int M = Integer.parseInt(stNM.nextToken());
			
			int[][] fly = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer stTemp = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					fly[i][j] = Integer.parseInt(stTemp.nextToken());
				}
			}
			
			// 파리 죽이기
			int result = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					int killCountP = -fly[i][j];
					int killCountX = -fly[i][j];
					
					for (int m = -M+1; m < M; m++) {
						if (i+m >= 0 && i+m < N) {
							killCountP += fly[i+m][j];
						}
						if (j+m >= 0 && j+m < N) {
							killCountP += fly[i][j+m];
						}
						if (i+m >= 0 && i+m < N && j+m >= 0 && j+m < N) {
							killCountX += fly[i+m][j+m];
						}
						if (i-m >= 0 && i-m < N && j+m >= 0 && j+m < N) {
							killCountX += fly[i-m][j+m];
						}
					}
					if (result < killCountP) {
						result = killCountP;
					}
					if (result < killCountX) {
						result = killCountX;
					}
					
				}
			}
			// 파리 죽이기
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
}