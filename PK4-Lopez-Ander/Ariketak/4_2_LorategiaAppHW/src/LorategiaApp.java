/*
 * Ander Lopez
 * 03/10/2018
 * 2. Aurreko programa egokitu:
 HWInterrupt dei bat jarri
 izartxo bat idazten den bakoitzean.
 Ikusi gertatzen den interferentzia.
 (Kasu! HWInterrupt deia
 eskatzen den lekuan egon behar du,
 hau da, izartxo bat idazten den bakoitzean!)

 */

class LorategiaApp{
	public final static int MAX = 6;
	public static void main (String args[]) {
		System.out.println("LORATEGIA: return sakatu hasteko");
		try{int c = System.in.read();}catch(Exception ex){}
		System.out.println("Aurre \t\tAtze \t\t\tGuztira");
		Kontagailua k = new Kontagailua();
		Atea aurrekoa = new Atea("",k);
		Atea atzekoa = new Atea("\t\t",k);
		aurrekoa.start();
		atzekoa.start();
	}
}

class Atea extends Thread {
	Kontagailua jendea;
	String atea;
	int balioa = 0;

	public Atea (String zeinAte, Kontagailua k){
		jendea=k; atea=zeinAte;
	}
	public void run() {
		try{
			for (int i=1;i<=LorategiaApp.MAX;i++){
				sleep((long)(Math.random()*1000));
				System.out.print(atea + "[");
				for (int j = 1; j <= LorategiaApp.MAX; j++) {
					if (j <= i) {
						Simulatu.HWinterrupt();//Izartxo bat eta zuriune bat sartzean HWinterrupt egitea
						System.out.print("*");
					}else {
						Simulatu.HWinterrupt();
						System.out.print(" ");
					}
				}
				System.out.println("]");
				jendea.gehitu();
			}
		} catch (InterruptedException e) {}
	}


}

class Kontagailua {

	static int balioa = 0;
	Kontagailua() {
		System.out.print("\t\t\t\t\t[");
		for (int i=1;i<=LorategiaApp.MAX*2;i++){
			Simulatu.HWinterrupt();
			System.out.print(" ");
		}
		System.out.println("]");

	}
	synchronized void gehitu() {
		balioa++;
		System.out.print( "\t\t\t\t\t[");
		for (int i=1;i<=balioa;i++) {
			Simulatu.HWinterrupt();
			System.out.print("*");
		}
		for(int j=1;j<=LorategiaApp.MAX*2-balioa;j++) {
			Simulatu.HWinterrupt();
			System.out.print(" ");
		}
		System.out.println("]");
	}


}


class Simulatu {//HWinterrupt egiteko klasea
	public static void HWinterrupt() {
		if (Math.random()<0.2)
			try{Thread.sleep(200);}
		catch(InterruptedException e){};
	}
}