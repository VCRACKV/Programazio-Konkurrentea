/*
 * Ander Lopez
 * 03/10/2018
 * 3. Aurreko 4.2 ariketako programa egokitu (izartxo bakoitza idaztean HWInterrupt deia eta guzti) :
Pantailako idazketa guztiak Pantaila klase batean egin,
klase horretako idazketa metodoetan synchronized jarrita.
Egiaztatu horrela pantailako idazketetan ez dela interferentziarik gertatzen.
 */

class LorategiaApp{
	public final static int MAX = 6;
	public static void main (String args[]) {
		System.out.println("LORATEGIA: return sakatu hasteko");
		try{int c = System.in.read();}catch(Exception ex){}
		System.out.println("Aurre \t\tAtze \t\t\tGuztira");
		Pantaila p = new Pantaila();
		Kontagailua k = new Kontagailua(p);
		Atea aurrekoa = new Atea("",k,p);
		Atea atzekoa = new Atea("\t\t",k,p);
		aurrekoa.start();
		atzekoa.start();
	}
}
class Pantaila{//Pantaila klasea, bertan dauden metodoak terminalean idazketak egiteko balioko dute
	synchronized public void sartu1sartu2(int i, String atea) {//metodo bakoitzak synchronized edukiko du sinkronizatzeko
		System.out.print(atea + "[");
		for (int j = 1; j <= LorategiaApp.MAX; j++) {
			if (j <= i) {
				System.out.print("*");
				Simulatu.HWinterrupt();
			}else {
				
				System.out.print(" ");
			}
		}
		System.out.println("]");
	}

	synchronized public void gehituT(int balioa) {
		System.out.print( "\t\t\t\t\t[");
		for (int i=1;i<=balioa;i++) {
			System.out.print("*");
			Simulatu.HWinterrupt();
		}
		for(int j=1;j<=LorategiaApp.MAX*2-balioa;j++) {
			
			System.out.print(" ");
		}
		System.out.println("]");
	}
	
	synchronized public void hasieratu() {
		System.out.print("\t\t\t\t\t[");
		for (int i=1;i<=LorategiaApp.MAX*2;i++){
			
			System.out.print(" ");
		}
		System.out.println("]");
	}

}

class Atea extends Thread {
	Kontagailua jendea;
	String atea;
	int balioa = 0;
	Pantaila pantaila;

	public Atea (String zeinAte, Kontagailua k, Pantaila p){
		jendea=k; atea=zeinAte; this.pantaila=p;
	}
	public void run() {
		try{
			for (int i=1;i<=LorategiaApp.MAX;i++){
				sleep((long)(Math.random()*1000));
				pantaila.sartu1sartu2(i, atea);//Ateetatik sartzeko terminalean agertuko denaren metodoari deia
				jendea.gehitu();
			}
		} catch (InterruptedException e) {}
	}


}

class Kontagailua {
	Pantaila pantaila;
	static int balioa = 0;
	Kontagailua(Pantaila pantaila) {
		this.pantaila=pantaila;
		pantaila.hasieratu();

	}
	public void gehitu() {
		balioa++;
		pantaila.gehituT(balioa);
	}


}


class Simulatu {
	public static void HWinterrupt() {
		if (Math.random()<0.2)
			try{Thread.sleep(200);}
		catch(InterruptedException e){};
	}
}