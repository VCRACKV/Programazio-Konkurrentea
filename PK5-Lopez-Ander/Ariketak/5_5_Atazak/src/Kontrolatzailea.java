/*Ander Lopez
 * 11/10/2018
 * 5*. Hainbat prozesu sinkronizatzen dira
denek batera ekintza jakin bat egiteko.
 */
public class Kontrolatzailea {
	
	Pantaila pantaila;
	int atazaKop;
	int pertsonaKop;
	int atazai = 0;
	int atazae = 0;
	int atazair = 0;
	public Kontrolatzailea(Pantaila p, int ak, int pk) {
		pantaila = p;
		atazaKop = ak;
		pertsonaKop = pk;
	}

	//when (i<N)  				   iritsi -> KONTROL[i+1][e][ir]
	public synchronized void iritsi(int id) throws InterruptedException {
		while (!(atazai < atazaKop)) {
			wait();
		}
		atazai++;
		pantaila.margotu("iritsi", id);
		notifyAll();
	}
	
	//when (i==N && e<N)   	    egin  -> KONTROL[i][e+1][ir]
	public synchronized void egin(int id) throws InterruptedException {
		while (!(atazai== atazaKop && atazae<atazaKop)) {
			wait();
		}
		atazae++;
		pantaila.margotu("egin", id);
		notifyAll();
	}
	// |when (i==N && e==N && ir<N)  irten -> KONTROL[i][e][ir+1]
   //  |when (ir==N-1)               irten -> KONTROL[0][0][0]).
		public synchronized void irten(int id) throws InterruptedException {
			while (!(atazai== atazaKop && atazae == atazaKop && atazair < atazaKop)) {
				wait();
			}
			atazair++;
			pantaila.margotu("irten", id);
			if(atazair == atazaKop) {
				atazai=0;
				atazae=0;
				atazair=0;
			}
			notifyAll();
		}
		

}
