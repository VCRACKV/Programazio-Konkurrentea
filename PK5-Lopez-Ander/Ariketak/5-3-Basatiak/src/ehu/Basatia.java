package ehu;


public class Basatia extends Thread{
	Kontrola lapikoa;
	private int id;
	
	Basatia(int id, Kontrola l){
		lapikoa = l;
		this.id = id;
	}
	
	/*
	BASATIA = ( begiratu[k:0..N] -> 
								if (k>0) then ( erabaki[r:1..k] -> hartu[r] -> BASATIA ) 
								else          ( askatu 						-> BASATIA)							
	).
	*/
	public void run() {
		while (true) {
			try {	
				int begiratu = lapikoa.begiratu(id);
				if(begiratu>0){
					int hartuPuskak = (int)(Math.random()*begiratu + 1);
					lapikoa.hartu(id, "hartu-", hartuPuskak);
					sleep((long) (Math.random() * 3000));
				}else{
					lapikoa.askatu();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
