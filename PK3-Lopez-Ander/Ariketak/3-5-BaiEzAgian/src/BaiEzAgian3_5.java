/*Ander Lopez
 * 27/09/2018
 * 5. BaiEz4 adibidearen Java inplementazioa egokitu,
	bi hari sortu beharrean, hiru sortzeko:
	“bai”, “ez” eta “agian”
 */
public class BaiEzAgian3_5 extends Thread {
	private String baiEz;
	private int denbora, kopurua;
	private Pantaila2 p;
	public BaiEzAgian3_5(String s, int i, int j, Pantaila2 pant){
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
class Pantaila2 {
	public void margotu(String s){
		System.out.println(s);
	}
}
class BaiEzAgianApp{
	public static void main (String args[]) {
		Pantaila2 p = new Pantaila2();
		BaiEzAgian3_5 bai = new BaiEzAgian3_5("bai",1000,4,p);
		BaiEzAgian3_5 ez = new BaiEzAgian3_5("\tez",400,15,p);
		BaiEzAgian3_5 agian = new BaiEzAgian3_5("\t\tagian", 600, 10, p);//agian gehitu 3 zutabean
		bai.start();
		ez.start();
		agian.start();
	}
}