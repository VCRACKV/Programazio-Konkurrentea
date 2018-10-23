package ehu;

public class BasatiApp {
	final static int Puskak = 5;
	final static int Basatiak = 3;

	public static void main (String args[]) {
		/**
		 * @Izenburua: Basatien Festa
		 * @Describapena: 
		 * 					3. Basatien festa, baina orain
		 *						• sukaldariak hainbat puska bota eta
		 *						• basatiek hainbat puska hartu eta,
		 *						• bota edo hartu aurretik, lapikoan zenbat dagoen begiratzen dute
		 * @Egilea: Alain Barrero
		 * @Data: 2016/09/26
		 */
		
		//Pantaila sortzen dugu bertan datuak ikusi ahal izateko
		Pantaila p = new Pantaila();
		p.hasieratu(Basatiak);
		
		//Basatiak sortzego 
		Basatia basatiak[] = new Basatia[Basatiak];
		
		//Kotrola sortu
		Kontrola k = new Kontrola ();
		
		//Sukaldaria sortu eta hasiera heman
		Sukaldaria suk = new Sukaldaria(k);
		suk.start();
		
		//Basatiak sortu eta hasaiera hematen diegu
		for(int i = 0; i<Basatiak; i++){
			basatiak[i] = new Basatia(i, k);
		}
		for(int j = 0; j<Basatiak; j++){
			basatiak[j] .start();
		}
	}
}
