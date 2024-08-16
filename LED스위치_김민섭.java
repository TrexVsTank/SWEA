import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// class
public class LED스위치_김민섭 {
	
	// main
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[N+1];
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int counter = 0;
			for (int i = 1; i <= N; i++) {
				if (arr[i] == 1) {
					counter++;
					for (int j = 0; j < N/i; j++) {
						if (arr[i+j*i] == 0) {
							arr[i+j*i] = 1;
						} else {
							arr[i+j*i] = 0;
						}
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(counter).append("\n");
		}
		
		System.out.println(sb);
		
	} // end of main
	
} // end of class