package ehu;

public class Kontrola {
	private int puskaKopurua;
	private int blok = 0;

	Kontrola()
	{puskaKopurua=0;}
	
	//when (i>0) b[BR].hartu[r:1..i] -> LAPIKOA[i-r][0]
	public synchronized void hartu(int id, String str, int puskak)throws InterruptedException{
		while (!(puskaKopurua>0)) wait();
		puskaKopurua = puskaKopurua - puskak;
		blok = 0;
		Pantaila.margotuBasatia(id,str, puskaKopurua, puskak);
		notifyAll();
	}
	
	//when (i<N) s.bota[b:1..N-i] -> LAPIKOA[i+b][0]
	public synchronized void bota(int puskak) throws InterruptedException{
		while(!(puskaKopurua < BasatiApp.Puskak)) wait();
		puskaKopurua = puskaKopurua + puskak;
		blok = 0;
		Pantaila.margotuSukaldaria(puskak, puskaKopurua);
		notifyAll();
	}
	
	//when (blok==0) {b[BR],s}.begiratu[i] -> LAPIKOA[i][1]
	public synchronized int begiratu(int id) throws InterruptedException{
		while(!(blok == 0)) wait();
		blok = 1;
		//Pantaila.margotuBegiratu(id);
		Pantaila.margotuBegiratu(id, puskaKopurua);
		notifyAll();
		return puskaKopurua;
	}
	
	//{b[BR],s}.askatu	-> LAPIKOA[i][0]
	public synchronized void askatu() throws InterruptedException{
		blok = 0;
		notifyAll();
	}
}
