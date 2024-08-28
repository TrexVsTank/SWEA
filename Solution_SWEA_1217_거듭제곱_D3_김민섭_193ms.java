import java.util.Scanner;

// 클래스 시작
public class Solution_SWEA_1217_거듭제곱_D3_김민섭_193ms {
	
	// 메인 시작
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 테케 시작
		for (int t = 1; t <= 10; t++) {
			
			int tc = sc.nextInt();
			
			System.out.println("#"+tc+" "+pow(sc.nextInt() ,sc.nextInt()));
			
		} // 테케 끝
		
	} // 메인 끝
	
	// 거듭제곱 시작
	private static int pow(int num, int time) {
		if (time == 0) {
			return 1;
		}
		if (time == 1) {
			return num;
		}
		if (time % 2 == 0) {
			int temp = pow(num, time/2);
			return temp * temp;
		} else {
			int temp = pow(num, time/2);
			return temp * temp * num; 
		}
	}
	// 거듭제곱 끝
	
} // 클래스 끝
