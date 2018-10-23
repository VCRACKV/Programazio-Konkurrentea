/*Ander Lopez
 * 11/10/2018
 * 3. Basatien festa, baina orain
sukaldariak hainbat puska bota, eta
basatiek hainbat puska hartu, eta
bota edo hartu aurretik,
lapikoan zenbat dagoen begiratzen dute
 */

/*BASATIA = (begiratu[k:PR]->
				if(k>0) then( random[r:1..k]->hartu[r]-> jan -> lo ->	BASATIA)
						else                   (askatu->BASATIA)
			).
*/
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
				sleep((long)(Math.random()*600));
				int zenbatPuska=lapikoa.begiratu(id);
				sleep((long)(Math.random()*600));
				if(zenbatPuska>0) {
					
					int zenbat = (int) (Math.random()*zenbatPuska+1);
					sleep((long)(Math.random()*700));
					lapikoa.hartu(id, zenbat);
					sleep((long)(Math.random()*700));
					lapikoa.margotuInfo("jan", id);
					sleep((long)(Math.random()*700)+500);
					lapikoa.margotuInfo("lo", id);
					sleep((long)(Math.random()*700));
					
				}else {
					sleep((long)(Math.random()*700));
					lapikoa.askatu(id);
					sleep((long)(Math.random()*700));
				}
			}
		}catch (InterruptedException e){}
	}

}
