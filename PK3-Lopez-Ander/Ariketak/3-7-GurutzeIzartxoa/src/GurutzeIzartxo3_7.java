/*Ander Lopez
 * 27/09/2018
 * 7. Ondoko programa inplementatu JAVA erabiliz:
	Bi kotxe (bi hari) izango ditugu.
	Kotxeak “+” eta “*” ikurrekin adieraziko dira eta ezkerretik eskuinera
	mugituko dira, bakoitza abiadura desberdina batekin.
 */
public class GurutzeIzartxo3_7 extends Thread  {
	private char zein;
	private int kopurua, pos, denbora;
	private PantailaKotxea p;
	public GurutzeIzartxo3_7(char s, int i, int j, PantailaKotxea pant){
		zein=s; pos=0; kopurua=j; denbora=i;
		p=pant;
	}
	public void run() {

		try {
			for (int i=0;i<kopurua;i++) {
				p.margotu(zein, pos);
				sleep(denbora);
				pos++;
			}
		}
		catch (Exception e) {}
	}
}

class PantailaKotxea {
	private int pos1;
	private int pos2;
	public PantailaKotxea() {
		pos1 = 0;
		pos2 = 0;
	}

	public void margotu(char s, int pos){//zein eta ze posiziotan
		if(s=='+') {
			pos1=pos;//Gurutzearen posizioa gordetzeko
		}else {
			pos2=pos; //Izartxoaren posizioa gordetzeko
		}
		String posk1 = " ";//Gurutzeak aurreratzeko
		String posk2 = " ";//Izartxoak aurreratzeko
		for(int i=0; i<24; i++){System.out.println();}
		for(int i=0; i<pos1;i++) posk1+=" ";//hutsune bat gehiago gehitu gurutzearen bideari
		for(int i=0; i<pos2;i++) posk2+=" ";//hutsune bat gehiago gehitu izarotxoaren bideari
			
		System.out.println(posk1+'+');
		System.out.println(posk2+'*');

	}
}
class KotxeApp{
	public static void main (String args[]) {
		PantailaKotxea p = new PantailaKotxea();
		GurutzeIzartxo3_7 k1 = new GurutzeIzartxo3_7('+',100,40,p);//Gurutzea azkarra
		GurutzeIzartxo3_7 k2 = new GurutzeIzartxo3_7('*',300,40,p);//Izartxoa mantsoa

		k1.start();
		k2.start();
	}
}
