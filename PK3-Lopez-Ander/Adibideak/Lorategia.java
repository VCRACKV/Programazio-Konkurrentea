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
		System.out.println("Lorategian dauden pertsonak:"+kont);
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
				System.out.println(zein+":" + i);
				pertsonak.sartu();
				
			}
			System.out.println("Atea itxi da!");
		}
		catch (Exception e){}
	}
}
