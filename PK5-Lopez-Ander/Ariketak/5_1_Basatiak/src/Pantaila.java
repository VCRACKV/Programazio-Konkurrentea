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
public class Pantaila {
	
	private int basatiMax;
	private int puskaMax;
	
	public Pantaila(int b, int p) {
		basatiMax = b;
		puskaMax = p;
		System.out.print("suk");
		for (int i = 1; i <= basatiMax; i++) {
			System.out.print("\t\tbasat[" + i + "]");
		}
		System.out.println("\t\tlapikoa");
		System.out.println("=============================================================" +
				"=========================================================================================");
		System.out.print("\t\t");
		for (int i = 1; i <= basatiMax; i++) {
			System.out.print("\t\t\t");
		}
		System.out.print("[");
		for (int i = 1; i <= puskaMax; i++) {
			System.out.print(" ");
		}
		System.out.println("]");
	}
	
	public synchronized void margotu(String s, int id, int puskak) {
		if (id > 0) {
			System.out.print("\t\t");
			for (int i = 1; i < id; i++) {
				System.out.print("\t\t\t");
			}
		}
		System.out.print(s);
		if (id == 0) {
			System.out.print("\t\t");
			for (int i = id; i < basatiMax; i++) {
				System.out.print("\t\t\t");
			}
		}else {
			for (int i = id; i <= basatiMax; i++) {
				System.out.print("\t\t\t");
			}
		}
		System.out.print("[");
		for (int i = 1; i <= puskaMax; i++) {
			if (i <= puskak)
				System.out.print("*");
			else
				System.out.print(" ");
		}
		System.out.println("]");
	}
	
}
