package MultiThreading;

public class MultiThreadingDemo {
//Join and iterrupt method can be called from main thread on child thread or vice versa
	//Sleep and Yield method can be called from same method (main thread on itself and same for child thread as well
	public static void main(String[] args)  {
		System.out.println(Thread.currentThread().getName()+" Thread is having priority of "+Thread.currentThread().getPriority());
		ChildThread th=new ChildThread();
		th.th=Thread.currentThread();
		System.out.println(th.getName());
		//th.setPriority(8);
		th.start();
		try {
			//th.join();
			//System.out.println("Inside Main thread's before sleep");
			th.join(5000);//Thread.sleep(2000);
			System.out.println("Inside Main thread's before interrupt");
			//th.interrupt();//Thread.sleep() means currently executing thread is sleeping but 
			System.out.println("Inside Main thread's after interrupt");				//th.interrupt() means main thread is calling interrupt on child thread so when child thread calls 
							//thread.sleep() method on itself that thread will be interrupted
		} catch (InterruptedException e) {
			System.out.println("Inside Main thread's interrupted exception");
		}//Main thread call join on child thread so always child thread will be executed followed by main thread
		
		for(int i=0;i<=8;i++){
			//Thread.yield();
			System.out.println("Main Thread : "+i);
			
		}

	}

}

class ChildThread extends Thread{
	
	public Thread th;
	
	public ChildThread(){
		
	}
	@Override
	public void run(){
		System.out.println("ABCD "+Thread.currentThread().getName()+" priority : "+Thread.currentThread().getPriority());
		//try {
			//Thread.sleep(50000);
			th.interrupt();
		//} catch (InterruptedException e) {
			//System.out.println("Inside child thread's interrupted exception");
			//return;//for loop won't be executed
		//}
		for(int i=0;i<=8;i++){
			//Thread.currentThread().interrupt();
			System.out.println("Child Thread : "+i);
		}
	}
}