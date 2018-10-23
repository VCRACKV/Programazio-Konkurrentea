/*Ander Lopez
 * 11/10/2018
 * 2. Basatien festa, baina orain sukaldariak
aldi bakoitzean 3 puska botatzen ditu
(eta lapikoan 3 puska baino gehiago sartzen dira).
 */

//SUKALDARIA = (bota -> SUKALDARIA).
public class Sukaldaria extends Thread{

	Lapikoa lapikoa;
	
	public Sukaldaria(Lapikoa l) {
		lapikoa = l;
	}
	
	@Override
	public void run() {
		try { 
			while(true) {
				sleep((long)(Math.random()*1000));
				lapikoa.bota();
			}
		}catch (InterruptedException e){}
	}
	
}
