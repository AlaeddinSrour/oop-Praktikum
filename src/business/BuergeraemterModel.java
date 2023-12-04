package business;

import java.io.*;
import java.util.LinkedList;

import fabrikMethode.ConcreteCsvCreator;
import fabrikMethode.ConcreteTxtCreator;
import fabrikMethode.Creator;
import fabrikMethode.Product;
import ownUtil.Observable;
import ownUtil.Observer;

public class BuergeraemterModel implements Observable{
 	
	LinkedList<Observer> liste = new LinkedList<Observer>();
	
	private static BuergeraemterModel instanz=null;
	
	public static BuergeraemterModel getInstanz() {
		if(instanz == null) {
			instanz = new BuergeraemterModel();
		}
		return instanz;
	}




	private BuergeraemterModel() {
		
	}




	private Buergeramt buergeramt;

	public Buergeramt getBuergeramt() {
		return this.buergeramt;
	}
	
	public void setBuergeramt(Buergeramt buergeramt) {
		this.buergeramt = buergeramt;
		notifyObservers();
	}

	public void schreibeBuergeraemterInCsvDatei()
	    throws IOException{
		Creator creator =new ConcreteCsvCreator();
		Product writer = creator.factoryMethod();
		writer.fuegeInDateiHinzu(buergeramt);
		writer.schliessDatei();

 	}
	public void schreibeBuergeraemterInTxtDatei()    throws IOException{
		Creator creator =new ConcreteTxtCreator();
		Product writer = creator.factoryMethod();
		writer.fuegeInDateiHinzu(buergeramt);
		writer.schliessDatei();
	}

	@Override
	public void addObserver(Observer obs) {
		// TODO Auto-generated method stub
		liste.add(obs);

	}

	@Override
	public void removeObserver(Observer obs) {
		// TODO Auto-generated method stub
		liste.remove(obs);

		
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(Observer o:liste) {
			o.update();
		}
		
	}
	
	

}


