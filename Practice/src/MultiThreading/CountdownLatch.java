package MultiThreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class CountdownLatch {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch cl=new CountDownLatch(1);
		Semaphore sm=new Semaphore(2);//2 means at a time 2 threads ca acquire the lock..untill and unless those 2 threads realease the lock third one can not operate
		childThread2 ct1=new childThread2(cl,sm);
		childThread2 ct2=new childThread2(cl,sm);
		childThread2 ct3=new childThread2(cl,sm);
		ct1.start();
		ct2.start();
		ct3.start();
		cl.await();//without this it may first print main thread o/p then child thread
		System.out.println("Thread name is : "+Thread.currentThread().getName());
		
	}

}

class childThread2 extends Thread{
	public CountDownLatch cl;
	public Semaphore sm;
	
	public childThread2(CountDownLatch cl,Semaphore sm){
		this.cl=cl;
		this.sm=sm;
	}
	
	@Override
	public void run(){
		/*if(Thread.currentThread().getName().equals("Thead-0")){
			System.out.println("Thread having lock is : "+Thread.currentThread().getName());
		}
		else{
			System.out.println("Thread having lock is : "+Thread.currentThread().getName());
		}*/
		try {
			this.sm.acquire();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread Name is : "+Thread.currentThread().getName());
		this.sm.release();
		this.cl.countDown();//without this it wont print main thread output as countdown value never eaches 0
		//System.out.println("Thread Name is : "+Thread.currentThread().getName());
	}
}