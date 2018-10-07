/*Ander Lopez
 * 27/09/2018
 * 9. Irakasleak inplementatutako kotxeen ariketaren bertsioa (irudiekin) egelatik jeitsi
	eta egokitu, kotxeen abiadura aldatzen joateko exekuzioan zehar: hasieran bat azkarrago
	doa eta bukaeran polikiago, eta bestea hasieran polikiago doa eta gero azkarrago.
 */
package kotxeanimatuak0;

public class KotxeAnimatuak  {
	
	public static void main (String args[]) {
	
		Framea framea = new Framea();
		framea.setVisible(true);
		
		Kotxea k1 = new Kotxea(1, 100, 0.999, framea);
		Kotxea k2 = new Kotxea(2, 50, 1.005, framea);
						
		k1.start();
		k2.start();
	}
}



