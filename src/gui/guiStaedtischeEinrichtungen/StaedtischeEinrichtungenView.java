package gui.guiStaedtischeEinrichtungen;

import business.Buergeraemter.BuergeraemterModel;
import business.Buergeraemter.Buergeramt;
import business.Sporthalle.Sporthalle;
import business.Sporthalle.SporthallenModel;
import gui.guiBuergeraemter.BuergeraemterControl;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class StaedtischeEinrichtungenView {
	
	
		
		private BuergeraemterModel buergeraemterModel;
		private StaedtischeEinrichtungenControl staedtischeEinrichtungenControl;
		
		private SporthallenModel sporthallenModel;
	
	
    	
    	private Pane pane = new  Pane();
    	private Label lblAnzeigeBuergeraeamter = new Label("Anzeige Bürgerämter");
    	private TextArea txtAnzeigeBuergeraeamter  = new TextArea();
    	private Button btnAnzeigeBuergeraeamter = new Button("Anzeige");
    	
    	private Label lblAnzeigeSporthallen = new Label("Anzeige Sporthalle");
    	private TextArea txtAnzeigeSporthallen  = new TextArea();
    	private Button btnAnzeigeSporthallen = new Button("csv-Import und Anzeige");
    	
    	
    	
    
    	public StaedtischeEinrichtungenView(StaedtischeEinrichtungenControl staedtischeEinrichtungenControl,Stage primaryStage, 
    		BuergeraemterModel buergeraemterModel, SporthallenModel sporthallenModel){
    		Scene scene = new Scene(this.pane, 560, 340);
    		primaryStage.setScene(scene);
    		primaryStage.setTitle("Anzeige von städtischen " + "Einrichtungen");
    		primaryStage.show();
    		this.staedtischeEinrichtungenControl = staedtischeEinrichtungenControl;
        	this.buergeraemterModel = buergeraemterModel;
        	this.sporthallenModel = sporthallenModel;
    		this.initKomponenten();
    		this.initListener();
    		this.initKomponentenSporthallen();
    		this.initListenerSporthallen();
        	}

        	private void initKomponenten(){
        		// Label
        		Font font = new Font("Arial", 20);
        		lblAnzeigeBuergeraeamter.setLayoutX(310);
        		lblAnzeigeBuergeraeamter.setLayoutY(40);
        		lblAnzeigeBuergeraeamter.setFont(font);
        		lblAnzeigeBuergeraeamter.setStyle("-fx-font-weight: bold;"); 
        		pane.getChildren().add(lblAnzeigeBuergeraeamter);    
            	



        		txtAnzeigeBuergeraeamter.setEditable(false);
        		txtAnzeigeBuergeraeamter.setLayoutX(310);
        		txtAnzeigeBuergeraeamter.setLayoutY(90);
        		txtAnzeigeBuergeraeamter.setPrefWidth(220);
        		txtAnzeigeBuergeraeamter.setPrefHeight(185);
           	pane.getChildren().add(txtAnzeigeBuergeraeamter);        	
            	// Button
           	btnAnzeigeBuergeraeamter.setLayoutX(310);
           	btnAnzeigeBuergeraeamter.setLayoutY(290);
            	pane.getChildren().add(btnAnzeigeBuergeraeamter); 
       }
       
        	private void initKomponentenSporthallen(){
        		// Label
        		Font font = new Font("Arial", 20);
        		lblAnzeigeSporthallen.setLayoutX(20);
        		lblAnzeigeSporthallen.setLayoutY(40);
        		lblAnzeigeSporthallen.setFont(font);
        		lblAnzeigeSporthallen.setStyle("-fx-font-weight: bold;"); 
        		pane.getChildren().add(lblAnzeigeSporthallen);    
            	



        		txtAnzeigeSporthallen.setEditable(false);
        		txtAnzeigeSporthallen.setLayoutX(20);
        		txtAnzeigeSporthallen.setLayoutY(90);
        		txtAnzeigeSporthallen.setPrefWidth(220);
        		txtAnzeigeSporthallen.setPrefHeight(185);
           	pane.getChildren().add(txtAnzeigeSporthallen);        	
            	// Button
           	btnAnzeigeSporthallen.setLayoutX(20);
           	btnAnzeigeSporthallen.setLayoutY(290);
            	pane.getChildren().add(btnAnzeigeSporthallen); 
       }
            private void initListener() {
         	   btnAnzeigeBuergeraeamter.setOnAction(new EventHandler<ActionEvent>() {
     	    		@Override
     	        	public void handle(ActionEvent e) {
     	            	zeigeBuergeraemterAn();
     	        	} 
        	    });
         }

            private void initListenerSporthallen() {
          	   btnAnzeigeSporthallen.setOnAction(new EventHandler<ActionEvent>() {
      	    		@Override
      	        	public void handle(ActionEvent e) {
      	            	zeigeSporthallenAn();
      	        	} 
         	    });
          }
   
	    public void zeigeBuergeraemterAn() {
	        if (buergeraemterModel.getBuergeraemterList().size()>0) {
	        		
	     	   StringBuffer text = new StringBuffer(); 
	        		
	        		for (Buergeramt buergeramt : buergeraemterModel.getBuergeraemterList()) {
	                text.append(buergeramt.gibBuergeramtZurueck(' ')).append("\n");
	            }
	            this.txtAnzeigeBuergeraeamter.setText(text.toString());
	        } else {
	            zeigeInformationsfensterAn("Bisher wurde kein Buergeramt aufgenommen!");
	        }
	    }
	    
	    public void zeigeSporthallenAn()
	    {
	    	staedtischeEinrichtungenControl.leseSporthallenAusCsv();
	        if (sporthallenModel.getSporthallen().size()>0) {
	        		
	     	   StringBuffer text = new StringBuffer(); 
	        		
	        		for (Sporthalle sporthalle : sporthallenModel.getSporthallen()) {
	                text.append(sporthalle.gibSporthalleZurueck(' ')).append("\n");
	            }
	            this.txtAnzeigeSporthallen.setText(text.toString());
	        } else {
	            zeigeInformationsfensterAn("Bisher wurde kein Sporthallen aufgenommen!");
	        }
	    }
   
   void zeigeInformationsfensterAn(String meldung){
    	  	new MeldungsfensterAnzeiger(AlertType.INFORMATION,"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
}


