/*Ander Lopez
 * 11/10/2018
 * 4. Ikasle jator batzuen pisuan gastuetarako bote bat dute.
Norberak ahal duen heinean botean dirua sartzen du,
eta behar duen neurrian hartu.
 */
public class Botea {
	
	Pantaila pantaila;
	int dirua;
	int BM; //Boteko diru maximoa
	boolean begiratua;
	
	public Botea(Pantaila p, int BM) {
		pantaila = p;
		dirua = BM;
		this.BM = BM;
		begiratua = false;
	}

	//when (i>0)     p[PE].hartu[h:1..i]   -> BOTEA[i-h][0]
	public synchronized void hartu(int id, int zenbat) throws InterruptedException {
		while (!(dirua > 0)) {
			wait();
		}
		dirua -=zenbat;
		pantaila.margotu("hart:"+zenbat, id, dirua);
		notify();
	}
	
	//when (i<BM)    p[PE].bota[b:1..BM-i] -> BOTEA[i+b][0]
	public synchronized void bota(int zenbat, int id) throws InterruptedException {
		while (!(dirua<BM)) {
			wait();
		}
		dirua += zenbat;
		pantaila.margotu("bota:"+zenbat, id, dirua);
		notify();
	}
	//when (blok==0) p[PE].begiratu[i]	  -> BOTEA[i][1]
		public synchronized int begiratu(int id) throws InterruptedException {
			while (!(begiratua==false)) {
				wait();
			}
			pantaila.margotu("begi:"+dirua, id, dirua);
			begiratua = true;
			notify();
			return dirua;
		}
		//p[PE].askatu          -> BOTEA[i][0]).
		public synchronized void askatu(int id) throws InterruptedException{
			begiratua = false;
			margotuInfo("askatu", id);
			notifyAll();
		}
		
		public int maxKop() {
			return BM;
		}
		
		public int egoera() {
			return dirua;
		}
		
	
	public synchronized void margotuInfo(String s, int id) throws InterruptedException {
		pantaila.margotu(s, id, dirua);
	}
	
}
