package session1.mthread.ex04;

public class YourTask implements Runnable{

	@Override
	public void run() {
		try {
			Thread thread = new Thread(new AnotherTask("Another Task", 10));
			thread.start();
			for (int i = 0; i < 8; i++) {
				System.out.println("Your Task #" + i);
				if (i == 5) {
					thread.join();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}



	}
}