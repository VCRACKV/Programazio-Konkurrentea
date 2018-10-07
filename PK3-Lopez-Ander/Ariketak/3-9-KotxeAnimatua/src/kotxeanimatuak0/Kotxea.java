/*Ander Lopez
 * 27/09/2018
 * 9. Irakasleak inplementatutako kotxeen ariketaren bertsioa (irudiekin) egelatik jeitsi
	eta egokitu, kotxeen abiadura aldatzen joateko exekuzioan zehar: hasieran bat azkarrago
	doa eta bukaeran polikiago, eta bestea hasieran polikiago doa eta gero azkarrago.
 */
package kotxeanimatuak0;

class Kotxea extends Thread {
	private int kotxea;
	private double abiadura;
	private double azel;
	private int denbora;
	private Framea framea;
	
	public Kotxea(int kotx, double abiad, double azel, Framea f){
		kotxea=kotx;
		abiadura=abiad;
		framea=f;
		this.azel = azel;
	}
	
	public void run() {
		try {sleep(1000);}
		
		catch (InterruptedException e) {}
	
		for (int x=0;x<540;x++) {
			framea.panela.setX(kotxea,x);
			abiadura = abiadura*azel;
			denbora=(int)(1000/abiadura);
			try {sleep((denbora));}
			catch (InterruptedException e) {}
		}
		System.out.println(" Bukatuta ("+kotxea+")");
	}
}