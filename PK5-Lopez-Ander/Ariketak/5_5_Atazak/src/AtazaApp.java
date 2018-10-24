/*Ander Lopez
 * 11/10/2018
 * 5*. Hainbat prozesu sinkronizatzen dira
denek batera ekintza jakin bat egiteko.
 */
public class AtazaApp {

	public static void main(String[] args) {

		final int AK = 3; 	//Ataza kopurua
		final int PK = 3;  	//Pertsona kopurua
		
		
		Pantaila pantaila = new Pantaila(PK);
		Kontrolatzailea kontrol = new Kontrolatzailea(pantaila, AK, PK);
		Pertsona p[] = new Pertsona[PK + 1];
		for(int i=0; i<PK;i++){
			p[i] = new Pertsona(i, kontrol);
			p[i].start();
		}
	}

}
