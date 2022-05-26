package session1.mthread.ex07;

public class Printer implements Runnable{
	Storage s;
	
	
	
	public Printer(Storage s) {
		super();
		this.s = s;
	}



	@Override
	public void run() {
		while (true) {
			s.get();
		}
		
	}

}
