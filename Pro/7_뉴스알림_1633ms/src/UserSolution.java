import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// 유저솔루션
class UserSolution {
	
	// 유저
	class User {
		int uId;
		List<Channel> uChan;
		List<News> uNews;
		User(int id) {
			this.uId = id;
			this.uChan = new ArrayList<>();
			this.uNews = new ArrayList<>();
		}
	} // 유저
	
	// 채널
	class Channel {
		int cId;
		List<User> cUser;
		List<News> cNews;
		Channel(int id) {
			this.cId = id;
			this.cUser = new ArrayList<>();
			this.cNews = new ArrayList<>();
		}
	} // 채널
	
	// 뉴스
	class News implements Comparable<News> {
		int nId;
		int nTime;
		Channel nChannel;
		List<User> nUser;
		News(int id, int time, Channel channel) {
			this.nId = id;
			this.nTime = time;
			this.nChannel = channel;
			this.nUser = new ArrayList<>();
		}
		@Override
		public int compareTo(News o) {
			return this.nTime == o.nTime ? o.nId - this.nId : o.nTime - this.nTime;
		}
	} // 뉴스
	
	// static //
	static int uTime;
	static Map<Integer, User> uUser;
	static Map<Integer, Channel> uCahnnel;
	static Map<Integer, News> uNews;
	// static //
	
	// 0. 시작
	void init(int N, int K) {
		uTime = 0;
		uUser = new HashMap<>();
		uCahnnel = new HashMap<>();
		uNews = new HashMap<>();
	} // 0. 시작
	
	// 1. 등록
	void registerUser(int mTime, int mUID, int mNum, int mChannelIDs[]) {
		uTime = mTime;
		
		if (uUser.get(mUID) == null) {
			uUser.put(mUID, new User(mUID));
		}
		User curr_User = uUser.get(mUID);
		
		for (int idx = 0; idx < mNum; idx++) {
			int curr_cId = mChannelIDs[idx];
			if (uCahnnel.get(curr_cId) == null) {
				uCahnnel.put(curr_cId, new Channel(curr_cId));
			}
			Channel curr_Channel = uCahnnel.get(curr_cId);
			curr_User.uChan.add(curr_Channel);
			curr_Channel.cUser.add(curr_User);
			for (News n : curr_Channel.cNews) {
				if (uTime < n.nTime) {
					curr_User.uNews.add(n);
					n.nUser.add(curr_User);
				}
			}
		}
		
	} // 1. 등록
	
	// 2. 제공
	int offerNews(int mTime, int mNewsID, int mDelay, int mChannelID) {
		uTime = mTime;
		
		Channel curr_Channel = uCahnnel.get(mChannelID);
		uNews.put(mNewsID, new News(mNewsID, mTime + mDelay, curr_Channel));
		News curr_News = uNews.get(mNewsID);
		curr_Channel.cNews.add(curr_News);
		for (User u : curr_Channel.cUser) {
			u.uNews.add(curr_News);
			curr_News.nUser.add(u);
		}
		
		return curr_Channel.cUser.size();
	} // 2. 제공
	
	// 3. 취소
	void cancelNews(int mTime, int mNewsID) {
		uTime = mTime;
		
		if (uNews.get(mNewsID) == null) {
			return;
		}
		
		News curr_News = uNews.get(mNewsID);
		curr_News.nChannel.cNews.remove(curr_News);
		for (User u : curr_News.nUser) {
			u.uNews.remove(curr_News);
		}
		uNews.remove(mNewsID);
	} // 3. 취소
	
	// 4. 체크
	int checkUser(int mTime, int mUID, int mRetIDs[]) {
		uTime = mTime;
		User curr_User = uUser.get(mUID);
		List<News> temp_List = new ArrayList<>();
		PriorityQueue<News> temp_PQ = new PriorityQueue<>();
		for (News n : curr_User.uNews) {
			if (n.nTime <= uTime) {
				temp_List.add(n);
				temp_PQ.offer(n);
			}
		}
		for (News n : temp_List) {
			curr_User.uNews.remove(n);
		}
		int index = 0;
		int num = temp_PQ.size();
		while (!temp_PQ.isEmpty() && index < 3) {
			mRetIDs[index] = temp_PQ.poll().nId;
			index++;
		}
		return num;
	} // 4. 체크
	
} // 유저솔루션