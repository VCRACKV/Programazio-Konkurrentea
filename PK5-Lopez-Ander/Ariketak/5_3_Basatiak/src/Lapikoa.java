/*Ander Lopez
 * 11/10/2018
 * 3. Basatien festa, baina orain
sukaldariak hainbat puska bota, eta
basatiek hainbat puska hartu, eta
bota edo hartu aurretik,
lapikoan zenbat dagoen begiratzen dute
 */
public class Lapikoa {
	
	Pantaila pantaila;
	int puskak;
	int PK;
	boolean begiratua;
	
	public Lapikoa(Pantaila p, int PK) {
		pantaila = p;
		puskak = 5;
		this.PK = PK;
		begiratua = false;
	}

	//when(i>0)           b[BR].hartu[h:1..i]   -> LAPIKOA[i-h][0]
	public synchronized void hartu(int id, int zenbat) throws InterruptedException {
		while (!(puskak > 0)) {
			wait();
		}
		puskak -=zenbat;
		begiratua = false;
		pantaila.margotu("hart:"+zenbat, id, puskak);
		notifyAll();
	}
	
	//when(i<PK)          s.bota[b:1..PK-i]     -> LAPIKOA[i+b][0]
	public synchronized void bota(int zenbat) throws InterruptedException {
		while (!(puskak<PK)) {
			wait();
		}
		puskak += zenbat;
		begiratua = false;
		pantaila.margotu("bota:"+zenbat, 0, puskak);
		notifyAll();
	}
	//when(blok==0)	   {s,b[BR]}.begiratu[i] -> LAPIKOA[i][1]
		public synchronized int begiratu(int id) throws InterruptedException {
			while (!(begiratua==false)) {
				wait();
			}
			begiratua = true;
			pantaila.margotu("begi:"+puskak, id, puskak);
			notifyAll();
			return puskak;
		}
	//{s,b[BR]}.askatu          -> LAPIKOA[i][0]).	
		public synchronized void askatu(int id) throws InterruptedException{
			begiratua = false;
			margotuInfo("askatu", id);
			notifyAll();
		}
		
		public int maxKop() {
			return PK;
		}
	
	public synchronized void margotuInfo(String s, int id) throws InterruptedException {
		pantaila.margotu(s, id, puskak);
	}
	
}
