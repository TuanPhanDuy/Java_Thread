package session1.mthread.ex07;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	public static void main(String[] args) {
		System.out.println("Press....");
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		Storage s = new Storage();
		
		service.execute(new Counter(s));
		service.execute(new Printer(s));
	}
}
