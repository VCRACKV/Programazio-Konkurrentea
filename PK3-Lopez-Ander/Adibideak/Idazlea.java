public class Idazlea extends Thread {
	public void run() {
		while(true){
			System.out.println("bai");
			try {sleep(1000);}
			catch (InterruptedException e){}
		}
	}
}
class EzIdazlea extends Thread {
	public void run() {
		while(true){
			System.out.println("ez");
			try {sleep(400);}
			catch (InterruptedException e) {}
		}
	}
}
class BaiEz1App{
	public static void main (String args[]) {
		Idazlea bai = new Idazlea();
		EzIdazlea ez = new EzIdazlea();
		bai.start();
		ez.start();
	}
}