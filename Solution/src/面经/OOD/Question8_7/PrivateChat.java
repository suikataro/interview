package 面经.OOD.Question8_7;

public class PrivateChat extends Conversation {
	//增加paticipants的功能是在Conversation下面实现
	//privatechat的constructor是用两个user

	public PrivateChat(User user1, User user2) {
		participants.add(user1);
		participants.add(user2);
	}
	
	public User getOtherParticipant(User primary) {
		if (participants.get(0) == primary) {
			return participants.get(1);
		} else if (participants.get(1) == primary) {
			return participants.get(0);
		}
		return null;
	}
}
