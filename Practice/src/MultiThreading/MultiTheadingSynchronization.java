package MultiThreading;

/*1. As Display object is same "d" for both the thread so by using Synchronized keyword on display() it will give regular o/p
 *2. Without Synchronized keyword irregular o/p(same case as 1)
 *3. If there are 2 display object for two thread then in both the cases(with synchronized or without synchronized) it will give
 *irregular o/p as both threads are operating on two different objects..
 * 4.In case of static method(class level method)
 * 		2 diff objects & 2 diff threads   one non synchronized static method   irregular o/p
 * 		2 diff objects & 2 diff threads   one  synchronized static method       regular o/p
 * 		1 object & 2 diff threads        one non synchronized static method   irregular o/p
 *      1 object & 2 diff threads        one  synchronized static method   		regular o/p
 */
public class MultiTheadingSynchronization {

	public static void main(String[] args) {
		Display d1=new Display();
		Display d2=new Display();
		MyThread t1=new MyThread(d1,"Alka");
		MyThread t2=new MyThread(d1,"Neha");
		
		t1.start();
		t2.start();

	}

}
class Display{
	
	public static void display(String name){
		for(int i=0;i<3;i++){
			System.out.println("name is : "+name);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Caught interrupted exception...");
			}
		}
	}
}
class MyThread extends Thread{
	
	private Display d;
	private String name;
	public MyThread(Display d,String name){
		this.d=d;
		this.name=name;
	}
	@Override
	public void run(){
		this.d.display(this.name);
	}
}