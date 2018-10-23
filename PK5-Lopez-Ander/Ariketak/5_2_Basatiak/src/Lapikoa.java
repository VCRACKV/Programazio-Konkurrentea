/*Ander Lopez
 * 11/10/2018
 * 2. Basatien festa, baina orain sukaldariak
aldi bakoitzean 3 puska botatzen ditu
(eta lapikoan 3 puska baino gehiago sartzen dira).
 */
public class Lapikoa {
	
	Pantaila pantaila;
	int puskak;
	int PK;
	
	public Lapikoa(Pantaila p, int PK) {
		pantaila = p;
		puskak = 0;
		this.PK = PK;
	}

	//when (i>0)          b[BS].hartu -> LAPIKO[i-1]
	public synchronized void hartu(int id) throws InterruptedException {
		while (!(puskak > 0)) {
			wait();
		}
		--puskak;
		pantaila.margotu("hartu", id, puskak);
		notify();
	}
	
	//|when (i<Puskak-2)   s.bota      -> LAPIKO[i+3]). 
	public synchronized void bota() throws InterruptedException {
		while (!(puskak<PK-2)) {
			wait();
		}
		puskak += 3;
		pantaila.margotu("bota", 0, puskak);
		notify();
	}
	
	public synchronized void margotuInfo(String s, int id) throws InterruptedException {
		pantaila.margotu(s, id, puskak);
	}
	
}
