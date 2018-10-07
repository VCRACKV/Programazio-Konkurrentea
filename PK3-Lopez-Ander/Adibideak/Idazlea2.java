
public class Idazlea2 extends Thread{

	public void run() {
		int i;
		for (i=0;i<4;i++) {
			System.out.println("bai");
			try {sleep(1000);}
			catch (InterruptedException e) {}
		}
	}
}
class EzIdazlea2 extends Thread {
	public void run() {
		int i;
		for (i=0;i<20;i++) {
			System.out.println("ez");
			try {sleep(400);}
			catch (InterruptedException e) {}
		}
	}
}
class BaiEz2App{
	public static void main (String args[]) {
		Idazlea2 bai = new Idazlea2();
		EzIdazlea2 ez = new EzIdazlea2();
		bai.start();
		ez.start();
	}
}

