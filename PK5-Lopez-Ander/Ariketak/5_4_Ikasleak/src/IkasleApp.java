/*Ander Lopez
 * 11/10/2018
 * 4. Ikasle jator batzuen pisuan gastuetarako bote bat dute.
Norberak ahal duen heinean botean dirua sartzen du,
eta behar duen neurrian hartu.
 */
public class IkasleApp {

	public static void main(String[] args) {

		final int PK = 4; 	//Pertsona kopurua 
		final int BM = 10;  //Diru kopurua 
		
		
		Pantaila pantaila = new Pantaila(PK, BM);
		Botea botea = new Botea(pantaila, BM);
		Ikaslea p[] = new Ikaslea[PK + 1];
		for(int i=1; i<=PK;i++){
			p[i] = new Ikaslea(i, botea);
			p[i].start();
		}
	}

}
