/*Ander Lopez
 * 11/10/2018
 * 1. Basatien festa:
 Basati bakoitzak lapiko batetik misiolari-puska bat
hartzen du; puska hori jaten du eta lotara doa;
ondoren beste bat hartzen du...
 Basati sukaldariak, lapikoa hutsik dagoenean,
lapikoa betetzen du misiolari-puskekin.
Basatiak eta sukaldaria hariekin inplementatu.
Lapiko klasearen objektu bat sortu eta
pasatu behar zaie basatiei eta sukaldariari,
eta hariek objektu horren metodoei deiak egiten diete.
Idazketa guztiak Pantaila klase batek egiten ditu.
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

	//when (i>0)  b[BS].hartu  -> LAPIKO[i-1]
	public synchronized void hartu(int id) throws InterruptedException {
		while (!(puskak > 0)) {
			wait();
		}
		--puskak;
		pantaila.margotu("hartu", id, puskak);
		notify();
	}
	
	//|when (i==0) s.bete 		-> LAPIKO[i+1]). 
	public synchronized void bete() throws InterruptedException {
		while (!(puskak == 0)) {
			wait();
		}
		puskak = PK;
		pantaila.margotu("bete", 0, puskak);
		notify();
	}
	
	public synchronized void margotuInfo(String s, int id) throws InterruptedException {
		pantaila.margotu(s, id, puskak);
	}
	
}
