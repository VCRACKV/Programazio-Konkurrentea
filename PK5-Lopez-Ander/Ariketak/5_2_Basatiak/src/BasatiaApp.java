/*Ander Lopez
 * 11/10/2018
 * 2. Basatien festa, baina orain sukaldariak
aldi bakoitzean 3 puska botatzen ditu
(eta lapikoan 3 puska baino gehiago sartzen dira).
 */
public class BasatiaApp {

	public static void main(String[] args) {

		final int BK = 3; 	//Basati kopurua
		final int PK = 7;  	//Puska kopurua 
		Pantaila pantaila = new Pantaila(BK, PK);
		
		Lapikoa lapikoa = new Lapikoa(pantaila, PK);
		
		Basatia b[] = new Basatia[BK + 1];
		for(int i=1; i<=BK;i++){
			b[i] = new Basatia(i, lapikoa);
			b[i].start();
		}
		
		Sukaldaria s = new Sukaldaria(lapikoa);
		s.start();

	}

}
