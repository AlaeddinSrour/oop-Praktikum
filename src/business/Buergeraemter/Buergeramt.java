package business.Buergeraemter;

import java.util.ArrayList;

public class Buergeramt {
	
	// Name des Buergeramtes
    private String name;
    // Oeffnungszeiten
    private float geoeffnetVon;
    private float geoeffnetBis;
    // Strasse und Hausnummer des Buergeramtes
    private String strasseHNr;
    // Dienstleistungen des Buergeramtes
    private ArrayList<String> dienstleistungen = new ArrayList<String>();

    public Buergeramt(String name, float geoeffnetVon, float geoeffnetBis,
    	String strasseHNr, String[] dienstleistungen){
   		this.name = name;
  	    this.geoeffnetVon = geoeffnetVon;
   	    this.geoeffnetBis = geoeffnetBis;
   	    this.strasseHNr = strasseHNr;
   	    this.setDienstleistungAusStringArray(dienstleistungen);

    }
    
    private void setDienstleistungAusStringArray(String[] dienstleistungen) {
    	this.dienstleistungen = new ArrayList<String>();
    	
    	for (int i = 0; i < dienstleistungen.length; i++) {
    		this.dienstleistungen.add(dienstleistungen[i]);
			
		}
	}
    
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getGeoeffnetVon() {
		return geoeffnetVon;
	}

	public void setGeoeffnetVon(float geoeffnetVon) {
		this.geoeffnetVon = geoeffnetVon;
	}

	public float getGeoeffnetBis() {
		return geoeffnetBis;
	}

	public void setGeoeffnetBis(float geoeffnetBis) {
		this.geoeffnetBis = geoeffnetBis;
	}

	public String getStrasseHNr() {
		return strasseHNr;
	}

	public void setStrasseHNr(String strasseHNr) {
		this.strasseHNr = strasseHNr;
	}

	public ArrayList<String> getDienstleistungen() {
		return dienstleistungen;
	}

	public void setDienstleistungen(ArrayList<String> dienstleistungen) {
		this.dienstleistungen = dienstleistungen;
	}
	
	public String getDienstleistungenAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getDienstleistungen().size() -1 ; i++) {
			ergebnis = ergebnis + this.getDienstleistungen().get(i) + trenner; 
		}
		return ergebnis	+ this.getDienstleistungen().get(i);
	}
	
	public String gibBuergeramtZurueck(char trenner){
  		return this.getName() + trenner 
  			+ this.getGeoeffnetVon() + trenner
  		    + this.getGeoeffnetBis() + trenner
  		    + this.getStrasseHNr() + trenner + "\n"
  		    + this.getDienstleistungenAlsString(trenner) + "\n";
  	}
}
