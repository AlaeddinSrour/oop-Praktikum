package business.Sporthalle;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import business.Buergeraemter.Buergeramt;
import fabrikMethode.ConcreteCsvCreator;
import fabrikMethode.Creator;
import fabrikMethode.Product;
import ownUtil.Observable;
import ownUtil.Observer;


public class SporthallenModel implements Observable{
	
	private static SporthallenModel instance;
	private ArrayList<Sporthalle> sporthallen = new ArrayList<Sporthalle>();
	private ArrayList <Observer> observers = new ArrayList<Observer>();
	BufferedWriter aus;
	
	public static SporthallenModel getInstance() {
		if(instance == null) {
			instance = new SporthallenModel();
		}
		return instance;
	}
	public void leseSporthallenAusCsvDatei()
			throws IOException{
			BufferedReader ein = new BufferedReader(
		 		new FileReader("Sporthallen.csv"));
			ArrayList<Sporthalle> ergebnis = new ArrayList<>(); 
			String zeileStr = ein.readLine();
			while(zeileStr != null) {
				String[] zeile = zeileStr.split(";");
		           ergebnis.add( 
					new Sporthalle(zeile[0], zeile[1], zeile[2]));
		           zeileStr = ein.readLine();
			}    
		 	ein.close();
		 	this.sporthallen = ergebnis;
		}
	
	
			


	
	private SporthallenModel() {
		super();
	}
	public ArrayList<Sporthalle> getSporthallen() {
		return sporthallen;
	}

	@Override
	public void addObserver(Observer obs) {
		// TODO Auto-generated method stub
		observers.add(obs);	

		
	}

	@Override
	public void removeObserver(Observer obs) {
		// TODO Auto-generated method stub
		observers.remove(obs);

		
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub

		for (Observer obs : observers) {
            obs.update();
		}

	}
	
}
