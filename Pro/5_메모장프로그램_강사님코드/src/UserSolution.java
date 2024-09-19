class Node {
	char data;
	Node prev;
	Node next;

	Node(char data) {
		this.data = data;
	}
}

class List {
	Node head;
	Node tail;
	int size;
	int ptr;
	Node ptrNode;
	int[] count;

	List() {
		head = new Node('H');
		tail = new Node('T');
		head.next = tail;
		tail.prev = head;
		ptrNode = head;
		ptr = 0;
		count = new int[26];
	}

	Node findNode(int index) {
		if (ptr == index)
			return ptrNode;
		Node pos;
		if (index < ptr) {
			if (index <= ptr - index) {
				// head ~ X
				pos = head;
				for (int i = 0; i < index; i++) {
					pos = pos.next;
				}
			} else {
				// X ~ ptr
				pos = ptrNode;
				for (int i = 0; i < ptr - index; i++) {
					pos = pos.prev;
				}
			}
		} else {
			if (index - ptr <= size - index + 1) {
				pos = ptrNode;
				for (int i = 0; i < index - ptr; i++) {
					pos = pos.next;
				}
			} else {
				pos = tail;
				for (int i = 0; i < size - index + 1; i++) {
					pos = pos.prev;
				}
			}
		}

		return pos;
	}

	// cursor 있는 위치에 삽입
	void add(int cursor, Node newNode) {

		count[newNode.data - 'a']++;

		Node pos = findNode(cursor);

		newNode.next = pos.next;
		newNode.prev = pos;
		pos.next.prev = newNode;
		pos.next = newNode;

		ptr = cursor + 1;
		ptrNode = newNode;

		size++;
	}

	Node pop() {

		Node pos = tail.prev;
		count[pos.data - 'a']--;

		pos.next.prev = pos.prev;
		pos.prev.next = pos.next;

		ptr = 0;
		ptrNode = head;

		size--;
		return pos;
	}
}

class UserSolution {
	int H, W, r, c, maxR, maxC;
	List[] text;

	void init(int _H, int _W, char mStr[]) {
		H = _H;
		W = _W;
		maxR = r = 1;
		maxC = c = 0;

		text = new List[H + 2];
		for (int i = 1; i < H + 2; i++) {
			text[i] = new List();
		}

		int i = 0;
		while (mStr[i] != 0) {
			insert(mStr[i++]);
		}

		r = 1;
		c = 0;
	}

	void insert(char mChar) {
		text[r].add(c++, new Node(mChar));

		int pos = r;
		while (text[pos].size > W) {
			Node popNode = text[pos++].pop();
			text[pos].add(0, popNode);
		}

		if (c == W) {
			c = 0;
			r++;
		}

		maxC++;
		if (maxC == W) {
			maxC = 0;
			maxR++;
		}
	}

	char moveCursor(int mRow, int mCol) {
		if (mRow > maxR || mRow == maxR && mCol > maxC) {
			r = maxR;
			c = maxC;
			return '$';
		}
		r = mRow;
		c = mCol - 1;
		return text[r].findNode(c + 1).data;
	}

	int countCharacter(char mChar) {
		int answer = 0;

		Node pos = text[r].findNode(c).next;

		while (pos != text[r].tail) {
			if (pos.data == mChar) {
				answer++;
			}
			pos = pos.next;
		}
		for (int i = r + 1; i <= maxR; i++) {
			answer += text[i].count[mChar - 'a'];
		}
		return answer;
	}

}