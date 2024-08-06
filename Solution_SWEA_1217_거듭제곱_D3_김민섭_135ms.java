import java.util.Scanner;

// Solution_SWEA_1217_거듭제곱_D3_김민섭_135ms

public class Solution_SWEA_1217_거듭제곱_D3_김민섭_135ms {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		
		for (int i = 1; i <= 10; i++) {
			
			int teke = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.println("#"+teke+" "+mult(N, M));
			
		}
		
	} // end of main
	
	static int mult(int n, int m) {
		if (m == 0) {
			return 1;
		} else {
			return mult(n, m-1) * n;
		}
	}
	
} // end  of cla