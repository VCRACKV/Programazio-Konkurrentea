/*Ander Lopez
 * 11/10/2018
 * 5*. Hainbat prozesu sinkronizatzen dira
denek batera ekintza jakin bat egiteko.
 */
public class Pertsona extends Thread{

	Kontrolatzailea kontrol;
	int id;
	public Pertsona(int i, Kontrolatzailea k) {
		id = i;
		kontrol = k;

	}

	@Override
	public void run() {
		try { 
			while(true) {

					sleep((long)(Math.random()*1000));
					kontrol.iritsi(id);
					sleep((long)(Math.random()*1000));
					kontrol.egin(id);
					sleep((long)(Math.random()*1000));
					kontrol.irten(id);
				}
			}catch (InterruptedException e){}
		}

	}
