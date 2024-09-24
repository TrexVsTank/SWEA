import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserSolution {
	
	static List<int[]> uDiff;
	
    public void playGame(int N) {
    	uDiff = new ArrayList<>();uDiff.add(new int[] {0, 0});
    	for (int i = 1; i < N*2; i++) {
			int left = 0;
			int right = N*2;
			while (left <= right) {
				int mid = (left+right)/2;
				if (Solution.checkCards(0, i, mid)) {
					right = mid-1;
				} else {
					left = mid+1;
				}
			}
			uDiff.add(new int[] {i, left});
		}
    	Collections.sort(uDiff, (a, b) -> { return a[1]-b[1]; } );
    	for (int i = 0; i < N*2-1; i++) {
			for (int j = i+1; j < N*2; j++) {
				if (uDiff.get(i)[1] == uDiff.get(j)[1]) {
					Solution.checkCards(uDiff.get(i)[0], uDiff.get(j)[0], 0);
				} else {
					break;
				}
			}
		}
    }
}
