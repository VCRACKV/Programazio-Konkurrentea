/*
 * Ander Lopez
 * 03/10/2018
 *1. Lorategiaren programa egokitu,
 zenbakiak idatzi beharrean,
 kopuruak izartxoekin adierazteko.
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
						System.out.print("*");
					}else {
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
			System.out.print(" ");
		}
		System.out.println("]");

	}
	synchronized void gehitu() {
		balioa++;
		System.out.print( "\t\t\t\t\t[");
		for (int i=1;i<=balioa;i++) {
			System.out.print("*");// izartxoa gehitzen du lorategian pertsona bat sartu delako
		}
		for(int j=1;j<=LorategiaApp.MAX*2-balioa;j++) {
			System.out.print(" ");//hutsuneak sortzen ditu "bektorearen" tamaina mantentzeko
		}
		System.out.println("]");
	}


}