import java.util.ArrayList;
import java.util.List;

// 클래스
class UserSolution {
	
	List<Character> uNotepad;
	int uCursor, uWidth, uLength;
	int[] uCounter;
	
	// [이닛]
	void init(int H, int W, char mStr[]) {
		uCounter = new int[26];
		uWidth = W; uLength = H * W; uCursor = 0; uNotepad = new ArrayList<>();
		int index = 0;
		while (index < uLength && mStr[index] != '\0') {
			uCounter[mStr[index]-'a']++;
			uNotepad.add(mStr[index++]);
		}
	} // [이닛 끝]
	
	// [삽입]
	void insert(char mChar) {
		uCounter[mChar-'a']++;
		uNotepad.add(uCursor++, mChar);
	} // [삽입 끝]
	
	// [무브커서]
	char moveCursor(int mRow, int mCol) {
		uCursor = Math.min((mCol-1) + (mRow - 1) * uWidth, uNotepad.size());
		return uCursor == uNotepad.size() ? '$' : uNotepad.get(uCursor);
	} // [무브커서 끝]
	
	// [카운트]
	int countCharacter(char mChar) {
		if (uCursor <= uNotepad.size()/2) {
			int sum = uCounter[mChar-'a'];
			for (int i = 0; i < uCursor; i++) {
				if (uNotepad.get(i) == mChar) {
					sum--;
				}
			}
			return sum;
		} else {
			int sum = 0;
			for (int i = uCursor; i < uNotepad.size(); i++) {
				if (uNotepad.get(i) == mChar) {
					sum++;
				}
			}
			return sum;
		}
	} // [카운트 끝]
	
} // 클래스 끝
