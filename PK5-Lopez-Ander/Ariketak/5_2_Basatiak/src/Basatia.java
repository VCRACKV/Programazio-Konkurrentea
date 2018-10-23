/*Ander Lopez
 * 11/10/2018
 * 2. Basatien festa, baina orain sukaldariak
aldi bakoitzean 3 puska botatzen ditu
(eta lapikoan 3 puska baino gehiago sartzen dira).
 */

//BASATIA = (hartu -> jan -> lo ->BASATIA).
public class Basatia extends Thread{
	
	Lapikoa lapikoa;
	int id;
	
	public Basatia(int i, Lapikoa l) {
		id = i;
		lapikoa = l;
	}
	
	@Override
	public void run() {
		try { 
			while(true) {
				sleep((long)(Math.random()*1000));
				lapikoa.hartu(id);
				sleep((long)(Math.random()*1000));
				lapikoa.margotuInfo("jan", id);
				sleep((long)(Math.random()*1000));
				lapikoa.margotuInfo("lo", id);
			}
		}catch (InterruptedException e){}
	}
	
}
