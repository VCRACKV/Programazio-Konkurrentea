/*Ander Lopez
 * 11/10/2018
 * 5*. Hainbat prozesu sinkronizatzen dira
denek batera ekintza jakin bat egiteko.
 */
public class Pantaila {
	
	int pertsonaMax;
	public Pantaila(int p) {
		pertsonaMax = p;
		System.out.print("p[0]");
		for (int i = 1; i < pertsonaMax; i++) {
			System.out.print("\t\tp[" + i + "]");
		}
		System.out.println("");
		System.out.println("========================================");
	}
	
	public synchronized void margotu(String s, int id) {
		for(int i = 0; i<id; i++) {
			System.out.print("\t\t");
		}
		System.out.println(s);
		/*if(id==0)System.out.println(s);
		if(id==1)System.out.println("\t\t"+s);
		if(id==2)System.out.println("\t\t\t\t"+s);*/
		


	
	}
	
}
