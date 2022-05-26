package session1.mthread.ex07;

public class Counter implements Runnable{
	Storage s;
	
	
	
	public Counter(Storage s) {
		super();
		this.s = s;
	}



	@Override
	public void run() {
		while (true) {
			for (int i = 0; i < 5; i++) {
				s.put(i);			
			}
			break;
		}
		
	}

}
