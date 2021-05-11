package MultiThreading;

import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLock {

	public static void main(String[] args) {
		ReentrantLock l=new ReentrantLock();
		childThread1 ct1=new childThread1(l);
		childThread1 ct2=new childThread1(l);
		ct1.start();
		ct2.start();
		

	}

}

class childThread1 extends Thread{
	private ReentrantLock r;
	public childThread1(ReentrantLock l){
		this.r=l;
	}
	@Override
	public void run(){
		if(this.r.tryLock()){
			System.out.println("Thread having lock is : "+Thread.currentThread().getName()+" count : "+this.r.getHoldCount());
			/*this.r.lock();
			this.r.lock();
			this.r.lock();
			System.out.println("Thread having inner lock is : "+Thread.currentThread().getName()+"count : "+this.r.getHoldCount());
			this.r.unlock();
			System.out.println("Thread having inner lock is : "+Thread.currentThread().getName()+"count : "+this.r.getHoldCount());
			this.r.unlock();
			this.r.unlock();
			this.r.unlock();
			System.out.println("Thread having inner lock is : "+Thread.currentThread().getName()+"count : "+this.r.getHoldCount());
			System.out.println("Thread having inner lock is : "+Thread.currentThread().getName());*/
			
		try {
			this.r.lockInterruptibly();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else{
			System.out.println("Thread with no lock is : "+Thread.currentThread().getName());
		}
	}
}