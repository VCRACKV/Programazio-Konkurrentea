/*Ander Lopez
 * 27/09/2018
 * 8. Aurreko ariketa egokitu, exekuzioan zehar kotxeen abiadura aldatzen joateko.
	Hasieran “+” azkarrago doa eta bukaeran polikiago,
	eta “*” hasieran polikiago doa eta gero azkarrago.
	Argi ikusi behar da abiadura aldaketa.
 */
public class GurutzeIzartxoAbiadura3_8 extends Thread  {
	private char zein;
	private int kopurua, pos, denbora;
	private PantailaKotxea2 p;
	public GurutzeIzartxoAbiadura3_8(char s, int i, int j, PantailaKotxea2 pant){
		zein=s; pos=0; kopurua=j; denbora=i;
		p=pant;
	}
	public void run() {

		try {
			for (int i=0;i<kopurua;i++) {
				p.margotu(zein, pos);
				if(zein=='+') {
					if(denbora<=800)//800 milisegunditik ez pasatzeko
						denbora+=50;//Gurutzea mantsoagotu
				}else if(zein=='*'){
					if(denbora>=400)//400 milisegundutik ez jesteko
						denbora-=25;//Izartxoaren abiadura azkartu
				}
				if(denbora>0) {
					sleep(denbora);
				}
				pos++;
			}
		}
		catch (Exception e) {}
	}
}

class PantailaKotxea2 {
	private int pos1;
	private int pos2;
	public PantailaKotxea2() {
		pos1 = 0;
		pos2 = 0;
	}

	public void margotu(char s, int pos){//zein eta ze posiziotan
		if(s=='+') {
			pos1=pos;
		}else {
			pos2=pos;
		}
		String posk1 = " ";
		String posk2 = " ";
		for(int i=0; i<24; i++){System.out.println();}
		for(int i=0; i<pos1;i++) posk1+=" ";
		for(int i=0; i<pos2;i++) posk2+=" ";

		System.out.println(posk1+'+');
		System.out.println(posk2+'*');

	}
}
class KotxeApp2{
	public static void main (String args[]) {
		PantailaKotxea2 p = new PantailaKotxea2();
		GurutzeIzartxoAbiadura3_8 k1 = new GurutzeIzartxoAbiadura3_8('+',400,40,p);//Gurutzea azkarrago
		GurutzeIzartxoAbiadura3_8 k2 = new GurutzeIzartxoAbiadura3_8('*',800,40,p);//Izartxoa mantsoago hasi

		k1.start();
		k2.start();
	}
}
