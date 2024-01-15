package gui.guiStaedtischeEinrichtungen;

import java.io.IOException;

import business.Buergeraemter.BuergeraemterModel;
import business.Sporthalle.SporthallenModel;
import gui.guiBuergeraemter.BuergeraemterView;
import javafx.stage.Stage;
import ownUtil.Observer;
import java.io.*;


public class StaedtischeEinrichtungenControl implements Observer {
	
	private StaedtischeEinrichtungenView staedtischeEinrichtungenView;
	private BuergeraemterModel buergeraemterModel;
	private SporthallenModel sporthallenModel;
	

	public StaedtischeEinrichtungenControl(Stage primaryStage){
		this.buergeraemterModel = BuergeraemterModel.getInstanz();
		sporthallenModel=SporthallenModel.getInstance();
		this.staedtischeEinrichtungenView = new StaedtischeEinrichtungenView(this, primaryStage,buergeraemterModel, sporthallenModel);
		buergeraemterModel.addObserver(this);
	}

	public void leseSporthallenAusCsv()  {
		System.out.println("SportControl");

		try {
			sporthallenModel.leseSporthallenAusCsvDatei();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			staedtischeEinrichtungenView.zeigeInformationsfensterAn("Fehler beim lesen aus der CSV Datei");		
			}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		staedtischeEinrichtungenView.zeigeBuergeraemterAn();

		
	}
}
	
	

