package session1.mthread.ex04;

public class TestJoinThread {
	public static void main(String[] args) {
		new Thread(new YourTask()).start();	
	}
}
