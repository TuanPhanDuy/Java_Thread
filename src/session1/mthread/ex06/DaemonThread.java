package session1.mthread.ex06;

public class DaemonThread extends Thread{
	public void run() {
		System.out.println("Entering run method");
		try {
			System.out.println("In run method: currentThread() is" + Thread.currentThread());
			while (true) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException x) {
					
				}
				System.out.println("In run method: woke up again");
			}
		} finally {
			System.out.println("Leaving run Method");
		} 
	}
	
	public static void main(String[] args) throws Exception{
		System.out.println("Entering main Method");
		DaemonThread thread  = new DaemonThread();
		thread.setDaemon(true);
		thread.start();
		Thread.sleep(3000);
		System.out.println("Leaving main Method");
	}
}
