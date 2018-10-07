/*Ander Lopez
 * 27/09/2018
 * 6. BaiEz4 adibidearen Java inplementazioa egokitu, exekuzioan zehar
	harien abiadura aldatzeko.
	Hasieran “bai” azkar idazten du eta bukaeran poliki, eta “ez” hasieran poliki
	eta gero azkar. Argi ikusi behar da abiadura aldaketa.
 */
public class BaiEzAbiadura3_6 extends Thread {

	private String zein;
	private int denbora;
	private double azel;

	public BaiEzAbiadura3_6(String zein, int denbora, double azel) {
		this.zein=zein;
		this.denbora = denbora;
		this.azel = azel;
	}

	public void run() {


		try {
			for(int i=0; i<10; i++) {
				System.out.println(zein);//BAI edo EZ idazten du terminalean
				sleep(denbora);
				denbora=(int)Math.round(denbora*azel);//BAI eta EZ ren abiadura ALDATZEN da bere azel-en arabera
			}
			System.out.println(zein+" bukatu da");
		}
		catch (InterruptedException e){}

	}
}

class BaiEz1App36{
	public static void main (String args[]) {
		BaiEzAbiadura3_6 bai = new BaiEzAbiadura3_6("bai", 200, 1.4);
		BaiEzAbiadura3_6 ez = new BaiEzAbiadura3_6("\tez", 800, 0.8);
		bai.start();
		ez.start();
	}
}