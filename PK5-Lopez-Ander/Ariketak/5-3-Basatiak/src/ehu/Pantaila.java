package ehu;

public class Pantaila {
		public void hasieratu(int basatiKopurua){
			System.out.print("suk");
			for(int i = 0; i<basatiKopurua; i++){
				System.out.print("\t b[" + (i+1) + "]");
			}
			System.out.print("\t lapikoa");
			System.out.println("");
			
			for(int i = 0; i<basatiKopurua; i++){
				System.out.print("==============");
			}
			System.out.println("");
		}
	
		public static void margotuBasatia(int id, String ekintza, int puskaKopurua, int puskak){
			String tab = "\t";
			for(int i = 0; i<id; i++){
				tab += "\t";
			}
			String kop = "[";
			for(int j = 0; j<puskaKopurua; j++){
				kop += "*";
			}
			for(int k = 0; k<BasatiApp.Puskak-puskaKopurua; k++){
				kop+=" ";
			}
			kop += "]";
			String lap = "\t   ";
			while(id<BasatiApp.Basatiak-1){
				lap = "\t" + lap;
				id++;
			}
			System.out.println(tab + ekintza + puskak  + lap +  kop);
		}
		
		public static void margotuSukaldaria(int puskak, int puskaKopurua){
			String kop = "[";
			for(int i = 0; i<puskaKopurua; i++)kop += "*";
			for(int k = 0; k<BasatiApp.Puskak-puskaKopurua; k++){
				kop+=" ";
			}
			kop += "]";
			System.out.println("bota-"+ puskak + " \t\t\t\t   " + kop);
		}
		
		public static void margotu(int id, String ekintza){
			String tab = "";
			for(int i = 0; i<id; i++){
				tab += "\t";
			}
			System.out.println(tab + ekintza);
		}
		
		public static void margotuBegiratu(int id, int puskaKopurua){
			if(id>=0 && puskaKopurua!=0){
				String tab = "\t";
				for(int i = 0; i<id; i++){
					tab += "\t";
				}
				System.out.println(tab + "begiratu-" + puskaKopurua);
			}else{
				if(puskaKopurua<BasatiApp.Puskak)
					System.out.println("begiratu-" + puskaKopurua);
			}
		}
}
