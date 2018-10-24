/*Ander Lopez
 * 11/10/2018
 * 4. Ikasle jator batzuen pisuan gastuetarako bote bat dute.
Norberak ahal duen heinean botean dirua sartzen du,
eta behar duen neurrian hartu.
 */
public class Pantaila {
	
	private int ikasleMax;
	private int diruMax;
	
	public Pantaila(int p, int d) {
		ikasleMax = p;
		diruMax = d;
		System.out.print("i[1]");
		for (int i = 2; i <= ikasleMax; i++) {
			System.out.print("\t\ti[" + i + "]");
		}
		System.out.println("\t\t\tbotea");
		System.out.println("=============================================================" +
				"===============================================================================================");
		System.out.print("\t\t\t");
		for (int i = 1; i <= ikasleMax; i++) {
			System.out.print("\t\t\t\t");
		}
		System.out.print("[");
		for (int i = 1; i <= diruMax; i++) {
				System.out.print("*");
			
		}
		System.out.println("]");
	}
	
	public synchronized void margotu(String s, int id, int dirua) {
		if (id > 0) {
			//System.out.print("\t");
			for (int i = 1; i < id; i++) {
				System.out.print("\t\t");
			}
		}
		System.out.print(s);

		if (id == 0) {
			//System.out.print("\t");
			for (int i = id; i < ikasleMax; i++) {
				System.out.print("\t\t");
			}
		}else {
			for (int i = id; i <= ikasleMax; i++) {
				System.out.print("\t\t");
			}
		}
		System.out.print("[");
		for (int i = 1; i <= diruMax; i++) {
			if (i <= dirua)
				System.out.print("*");
			else
				System.out.print(" ");
		}
		System.out.println("]");
	}
	
}
