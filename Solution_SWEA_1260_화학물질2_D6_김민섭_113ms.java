import java.io.*;
import java.util.*;

// Solution_SWEA_1260_화학물질2_D6_김민섭_113ms

public class Solution_SWEA_1260_화학물질2_D6_김민섭_113ms {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			// 0. 입력
			
			int N = Integer.parseInt(br.readLine());
			
			int[][] Arr = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					Arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 0. 입력
			
			// 1. 풀이
			
			// 1-1. 행렬 추출
			
			List<Integer> listA = new ArrayList<>();
			
			List<Integer> listB = new ArrayList<>();
			
			List<List<Integer>> list = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (Arr[i][j] != 0) {
						int numA = 0;
						while ( (i+numA < N) && (Arr[i+numA][j] != 0) ) {
							numA++;
						}
						int numB = 0;
						while ( (j+numB < N) && (Arr[i][j+numB] != 0) ) {
							numB++;
						}
						
						List<Integer> listTemp = new ArrayList<>();
						listTemp.add(numA);
						listTemp.add(numB);
						list.add(listTemp);
						
						for (int a = 0; a < numA; a++) {
							for (int b = 0; b < numB; b++) {
								Arr[i+a][j+b] = 0;
							}
						}
					}
				}
			}
			
			// 1-2. 정렬
			
			// 맨 앞
			
			for (int i = 0; i < list.size(); i++) {
				int numTemp1 = 0;
				int numTemp2 = 0;
				int numTemp3 = 0;
				for (int j = 0; j < list.size(); j++) {
					if (i != j && list.get(i).get(0) == list.get(j).get(1)) {
						numTemp1++;
					}
				}
				if (numTemp1 == 0) {
					for (int j = 0; j < list.size(); j++) {
						if (i != j && list.get(i).get(1) == list.get(j).get(0)) {
							numTemp2++;
						}
					}
					if (numTemp2 != 0) {
						Collections.swap(list, i, 0);
						break;
					}
				}
			}
			
			// 정렬
			
			for (int i = 0; i < list.size(); i++) {
				for (int j = i+1; j < list.size(); j++) {
					if (list.get(i).get(1) == list.get(j).get(0)) {
						Collections.swap(list, i+1, j);
						continue;
					}
				}
			}
			
			// 1-3. 최소값 계산
			
			int[][] arrCal = new int[list.size()][list.size()];
			
			// 큰 초기값 대입
			for (int i = 0; i < arrCal.length; i++) {
				for (int j = 0; j < arrCal.length; j++) {
					arrCal[i][j] = Integer.MAX_VALUE;
				}
			}
			
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < list.size()-i; j++) {
					// a부터 b까지
					int a = j;
					int b = j+i;
					if (a==b) {
						arrCal[a][b] = 0;
					} else {
						for (int k = a; k < b; k++) {
							int numTemp = arrCal[a][k] + arrCal[k+1][b] + list.get(a).get(0) * list.get(k).get(1) * list.get(b).get(1);
							if (arrCal[a][b] > numTemp) {
								arrCal[a][b] = numTemp;
							}
						}
					}
				}
			}
			
			// 1-4. 출력
			
			int result = arrCal[0][list.size()-1];
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
			
//			for (int i = 0; i < list.size(); i++) {
//				for (int j = 0; j < 2; j++) {
//					System.out.print(list.get(i).get(j) + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//			
//			for (int i = 0; i < arrCal.length; i++) {
//				for (int j = 0; j < arrCal.length; j++) {
//					System.out.print(arrCal[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			// 1. 풀이
			
		} // end of TestCase
		
		System.out.println(sb);
		
	} // end of main
} // end of class
