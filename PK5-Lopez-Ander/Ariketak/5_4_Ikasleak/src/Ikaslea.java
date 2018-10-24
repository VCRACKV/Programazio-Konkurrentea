/*Ander Lopez
 * 11/10/2018
 * 4. Ikasle jator batzuen pisuan gastuetarako bote bat dute.
Norberak ahal duen heinean botean dirua sartzen du,
eta behar duen neurrian hartu.
 */
 /* PERTSONA = (aukera[r:0..1]-> if(r==0) then (hartzera -> begiratu[kh:BO]->
							 		if(kh>0) then (harand[h:1..kh] -> hartu[h] -> askatu ->PERTSONA)
									else                                      (askatu -> PERTSONA))
							 else ( botatzera ->    begiratu[kb:BO]->
							 		if(kb<BM) then (botram[b:1..BM-kb] -> bota[b] -> askatu -> PERTSONA)
									else                                          (askatu -> PERTSONA))).
 */
public class Ikaslea extends Thread{

	Botea botea;
	int id;
	public Ikaslea(int i, Botea b) {
		id = i;
		botea = b;

	}

	@Override
	public void run() {
		try { 
			while(true) {
				int max = botea.maxKop();
				double aukera = Math.random();
				if(aukera<0.5) {

					sleep((long)(Math.random()*1000));
					botea.margotuInfo("hartz", id);
					sleep((long)(Math.random()*1000));
					int zenbatDiru=botea.begiratu(id);
					sleep((long)(Math.random()*1000));
					int zenbat = (int) (Math.random()*(zenbatDiru-1))+1;
					if(zenbatDiru>0) {
						sleep((long)(Math.random()*1000));
						botea.hartu(id, zenbat);
						botea.askatu(id);
					}else {
						sleep((long)(Math.random()*1000));
						botea.askatu(id);
					}
				}else {

					sleep((long)(Math.random()*1000));
					botea.margotuInfo("botatz", id);
					sleep((long)(Math.random()*1000));
					int zenbatDiru=botea.begiratu(id);
					sleep((long)(Math.random()*1000));
					int zenbat = (int) (Math.random()*(botea.maxKop()-zenbatDiru))+1;
					if(zenbatDiru<max) {
						sleep((long)(Math.random()*1000));
						botea.bota(zenbat, id);
						botea.askatu(id);
					}else {
						sleep((long)(Math.random()*1000));
						botea.askatu(id);
					}
				}
			}
		}catch (InterruptedException e){}
	}

}
