/*Ander Lopez
 * 11/10/2018
 * 3. Basatien festa, baina orain
sukaldariak hainbat puska bota, eta
basatiek hainbat puska hartu, eta
bota edo hartu aurretik,
lapikoan zenbat dagoen begiratzen dute
 */
public class Pantaila {
	
	private int basatiMax;
	private int puskaMax;
	
	public Pantaila(int b, int p) {
		basatiMax = b;
		puskaMax = p;
		System.out.print("suk");
		for (int i = 1; i <= basatiMax; i++) {
			System.out.print("\t\tb[" + i + "]");
		}
		System.out.println("\t\tlapikoa");
		System.out.println("=============================================================" +
				"================================================================================");
		System.out.print("\t\t");
		for (int i = 1; i <= basatiMax; i++) {
			System.out.print("\t\t");
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
				System.out.print("\t\t");
			}
		}
		System.out.print(s);

		if (id == 0) {
			System.out.print("\t\t");
			for (int i = id; i < basatiMax; i++) {
				System.out.print("\t\t");
			}
		}else {
			for (int i = id; i <= basatiMax; i++) {
				System.out.print("\t\t");
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
