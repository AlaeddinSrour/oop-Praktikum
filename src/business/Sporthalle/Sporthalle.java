package business.Sporthalle;

import java.io.IOException;
import java.util.ArrayList;

public class Sporthalle {





	// Name der Sporthalle
	private String name;
	// Groesse der Flaeche
	private int anzahlQuadratmeter;
	// Bodenbelag
	private String bodenbelag;

	public Sporthalle(String name, String anzahlQuadratmeter, 
			String bodenbelag)
	    	throws IOException{

			 	this.name = name;
	  	     	this.anzahlQuadratmeter 
					= Integer.parseInt(anzahlQuadratmeter);
	   	    	this.bodenbelag = bodenbelag;


	   	    	}
	    	


		public String getName() {
			return name;
		}






		public void setName(String name) {
			this.name = name;
		}






		public int getAnzahlQuadratmeter() {
			return anzahlQuadratmeter;
		}






		public void setAnzahlQuadratmeter(int anzahlQuadratmeter) {
			this.anzahlQuadratmeter = anzahlQuadratmeter;
		}






		public String getBodenbelag() {
			return bodenbelag;
		}






		public void setBodenbelag(String bodenbelag) {
			this.bodenbelag = bodenbelag;
		}






    public String gibSporthalleZurueck(char trenner){
        return this.getName() + trenner
                + this.getAnzahlQuadratmeter() + trenner
                + this.getBodenbelag() ;

    }
}
