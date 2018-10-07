
public class Idazlea4 extends Thread  {
	private String baiEz;
	private int denbora, kopurua;
	private Pantaila p;
	public Idazlea4(String s, int i, int j, Pantaila pant){
		baiEz=s; denbora=i; kopurua=j;
		p=pant;
	}
	public void run() {
		int i;
		for (i=0;i<kopurua;i++) {
			p.margotu(baiEz);
			try {sleep(denbora);}
			catch (InterruptedException e) {}
		}
		p.margotu(baiEz+" bukatu da");
	}
}
class Pantaila {
	public void margotu(String s){
		System.out.println(s);
	}
}
class BaiEz4App{
	public static void main (String args[]) {
		Pantaila p = new Pantaila();
		Idazlea4 bai = new Idazlea4("bai",1000,4,p);
		Idazlea4 ez = new Idazlea4("\tez",400,15,p);
		bai.start();
		ez.start();
	}
}
