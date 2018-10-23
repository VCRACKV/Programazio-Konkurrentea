/*Ander Lopez
 * 11/10/2018
 * 2. Basatien festa, baina orain sukaldariak
aldi bakoitzean 3 puska botatzen ditu
(eta lapikoan 3 puska baino gehiago sartzen dira).
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
				"=================================================================================================");
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
