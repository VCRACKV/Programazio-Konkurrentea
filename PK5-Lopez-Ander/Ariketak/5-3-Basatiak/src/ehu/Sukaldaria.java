package ehu;

public class Sukaldaria extends Thread{
	Kontrola lapikoa;
	int sukaldaria = -1;
	Sukaldaria(Kontrola l){
		lapikoa = l;
	}
	
	/*
	SUKALDARIA = ( begiratu[k:0..N] ->
									if 	(k<N) then  ( erabaki[r:1..N-k] -> bota[r]  -> SUKALDARIA)
 									else 			( askatu 						-> SUKALDARIA)
	). 
	*/
	public void run() {
		try { while(true) {
				int begiratu = lapikoa.begiratu(sukaldaria);
				if(begiratu<BasatiApp.Puskak){
					int botaPuskak = 1 + (int)(Math.random() * (BasatiApp.Puskak-begiratu)); 
					lapikoa.bota(botaPuskak);
				}else{
					lapikoa.askatu();
				}
			}
		} catch (InterruptedException e){}
	}
}
