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
