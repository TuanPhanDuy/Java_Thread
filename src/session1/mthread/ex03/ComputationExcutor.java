package session1.mthread.ex03;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ComputationExcutor {
	public static void main(String[] args) throws Exception{
		Callable<Long> call = new ComputationTask("long-last-computation");
		FutureTask<Long> task = new FutureTask<Long>(call);
		new Thread(task).start();
		long result = task.get();
		System.out.println("Result: "+ result);
	}
}
