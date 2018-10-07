/*Ander Lopez
 * 27/09/2018
 * 10. Lorategi batean bi ate daude. Pertsona bat sartzen den bakoitzean ate horrek kontagailu
	bat inkrementatzen du jakiteko zenbat sartu diren guztira.
	Pertsonak sartuko dira lorategira beteta egon arte. Pertsonak ez dira aterako, soilik sartu.
	Prozesu aktiboak (eta hariak) ateak izango dira. Suposatu ahal dugu ate bakoitzean dagoen
	sensoreak jakinarazten duela norbait sartzean.
 */
class Lorategia{
	public static void main (String args[]){
		Kontagailua k = new Kontagailua();

		Atea atea1 = new Atea("atea1",k);
		Atea atea2 = new Atea ("atea2",k);
		atea1.start();
		atea2.start();
	}
	
}

class Kontagailua{
	public static final int MaxKop = 8;//ate bakoitzetik sartu daitezkeen pertsona kopuru maximoa
	int kont = 0;
	public Kontagailua() {
		System.out.println("Lorategian dauden pertsonak:"+kont);
	}
	
	public void sartu() {
		kont++;
		System.out.println("Lorategian dauden pertsonak:"+kont);//Inprimatu atetik sartu ondoren zenbat pertsona dauden lorategian
	}
}

class Atea extends Thread {
	Kontagailua pertsonak;
	String zein;
	public Atea (String zein, Kontagailua p){
		pertsonak = p;
		this.zein = zein;
	}

	public void run(){
		try{
			System.out.println(zein+":" + pertsonak.kont);
			for (int i = 1; i<=Kontagailua.MaxKop; i++){
				sleep(1000);
				System.out.println(zein+":" + i); //zein atetik ze pertsona sartu den
				pertsonak.sartu();//pertsona sartzeko
				
			}
			System.out.println("Atea itxi da!");
		}
		catch (Exception e){}
	}
}
