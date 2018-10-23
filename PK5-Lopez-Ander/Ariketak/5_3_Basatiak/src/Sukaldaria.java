/*Ander Lopez
 * 11/10/2018
 * 3. Basatien festa, baina orain
sukaldariak hainbat puska bota, eta
basatiek hainbat puska hartu, eta
bota edo hartu aurretik,
lapikoan zenbat dagoen begiratzen dute
 */



/*SUKALDARIA = (begiratu[k:PR]->
				if (k<PK) then (random[r:1..PK-k]-> bota[r] ->SUKALDARIA)
						  else                       (askatu->SUKALDARIA)
			).
			*/
public class Sukaldaria extends Thread{

	Lapikoa lapikoa;
	int zenbatPuska;
	public Sukaldaria(Lapikoa l) {
		lapikoa = l;
	}
	
	@Override
	public void run() {
		int zenbat = 0;
		try { 
			while(true) {
				int max = lapikoa.maxKop();
				sleep((long)(Math.random()*100));
				zenbatPuska = lapikoa.begiratu(0);
				sleep((long)(Math.random()*100));
				if(zenbatPuska<max) {
					zenbat = (int) (Math.random() * (max-zenbatPuska))+1;
					sleep((long)(Math.random()*100));
					lapikoa.bota(zenbat);
				}else {
					sleep((long)(Math.random()*100));
					lapikoa.askatu(0);
				}
				
			}
		}catch (InterruptedException e){}
	}
	
}
