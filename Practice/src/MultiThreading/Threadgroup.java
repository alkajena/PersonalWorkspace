package MultiThreading;

import java.util.concurrent.CountDownLatch;

public class Threadgroup {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
		System.out.println(Thread.currentThread().getThreadGroup().getParent().getMaxPriority());
		childThread3 ct=new childThread3();
		ct.start();
	}

}

class childThread3 extends Thread{
	
	
	@Override
	public void run(){
		ThreadGroup tg=new ThreadGroup(Thread.currentThread().getThreadGroup().getParent(),"child");
		System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
		Thread t=new Thread(tg,"alka");
		t.start();
		ThreadGroup tg1=new ThreadGroup(tg,"childThreadGroup");
		//tg1.setDaemon(true);
		System.out.println(tg.getParent().getName()+" count : "+tg.activeCount()+" group count : "+tg.activeGroupCount());
		System.out.println(tg1.isDaemon());
		
		Thread[] thArr=new Thread[tg.activeCount()];
		ThreadGroup[] tgArr=new ThreadGroup[tg.activeGroupCount()];
		tg.enumerate(thArr);
		tg.enumerate(tgArr);
		for(Thread t2:thArr){
			System.out.println(t2.getName());
		}
		
		for(ThreadGroup t2:tgArr){
			System.out.println(t2.getName());
		}
		
	}
				
}