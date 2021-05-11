package MultiThreading;

public class InterThreadCommunication {

	public static void main(String[] args) {
		MyThread2 t=new MyThread2();
		t.start();
		synchronized(t){
			System.out.println("Inside main thread..before wait()");
			try {
				Thread.sleep(5000);
				t.wait(10);
				System.out.println("Inside main thread..after wait() immediately");
			} catch (InterruptedException e) {
				System.out.println("Inside main thread..caugt interrupted exception");
			}
			System.out.println("Inside main thread..after wait()");
		}

	}

}

class MyThread2 extends Thread{
	
	@Override
	public void run(){
		synchronized(this){
			System.out.println("Inside child thread..before notify()");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.out.println("Inside child thread..caugt interrupted exception");
			}
			this.notify();
			System.out.println("Inside child thread..after notify()");
			System.out.println("Inside child thread..after notify()");
			System.out.println("Inside child thread..after notify()");
			System.out.println("Inside child thread..after notify()");
			System.out.println("Inside child thread..after notify()");
			System.out.println("Inside child thread..after notify()");
			System.out.println("Inside child thread..after notify()");
			System.out.println("Inside child thread..after notify()");
			System.out.println("Inside child thread..after notify()");
		}
	}
}