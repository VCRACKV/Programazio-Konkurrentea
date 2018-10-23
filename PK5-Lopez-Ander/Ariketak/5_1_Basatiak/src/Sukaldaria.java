/*Ander Lopez
 * 11/10/2018
 * 1. Basatien festa:
 Basati bakoitzak lapiko batetik misiolari-puska bat
hartzen du; puska hori jaten du eta lotara doa;
ondoren beste bat hartzen du...
 Basati sukaldariak, lapikoa hutsik dagoenean,
lapikoa betetzen du misiolari-puskekin.
Basatiak eta sukaldaria hariekin inplementatu.
Lapiko klasearen objektu bat sortu eta
pasatu behar zaie basatiei eta sukaldariari,
eta hariek objektu horren metodoei deiak egiten diete.
Idazketa guztiak Pantaila klase batek egiten ditu.
*/

//SUKALDARIA = (bete -> SUKALDARIA).
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
				lapikoa.bete();
			}
		}catch (InterruptedException e){}
	}
	
}
