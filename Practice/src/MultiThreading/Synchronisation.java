package MultiThreading;
/*If in a class two synchronized methods are present and two diff threads are trying to execute one of the methods
 *  or two diff methods then the o/p is regular...but if one method is synchronized and other is non synchronized 
 *  then in the same case the o/p is irregular..
 * 
 * Exactly same for static sync or static nonsync methods
 * 
 * 
 */
public class Synchronisation {

	public static void main(String[] args) {
		MyThread1 t=new MyThread1();
		Display1 d=new Display1();
		t.start();
		/*try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		d.displayOdd();

	}

}

class MyThread1 extends Thread{
	Display1 d=new Display1();
	
	@Override
	public void run(){
		d.displayEven();
	}
}

class Display1{
	
	public static synchronized void displayEven(){
		for(int i=0;i<4;i++){
			if(i%2==0)
				System.out.println("Even no is : "+i);
		}
	}
	
	public static synchronized void displayOdd(){
		for(int i=0;i<4;i++){
			if(i%2!=0)
				System.out.println("Odd no is : "+i);
		}
	}
}