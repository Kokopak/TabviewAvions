package application.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.Avion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AvionOverviewController {
	
	 @FXML
	 private TableView<Avion> avionTable;
	
	 @FXML
	 private Label avionLabel;
	 
	 @FXML
	 private TableColumn<Avion, Number> codeColumn;
	 
	 @FXML
	 private TableColumn<Avion, String> nomColumn;
	 
	 @FXML
	 private TableColumn<Avion, Number> capaciteColumn;
	 
	 @FXML
	 private TableColumn<Avion, String> localisationColumn;
	 
	 @FXML
	 private void initialize() {
		 
		 codeColumn.setCellValueFactory(cellData -> cellData.getValue().getCode());
		 nomColumn.setCellValueFactory(cellData -> cellData.getValue().getNom());
		 capaciteColumn.setCellValueFactory(cellData -> cellData.getValue().getCapacite());
		 localisationColumn.setCellValueFactory(cellData -> cellData.getValue().getLocalisation());
		 avionTable.setItems(getAvionList());
	 }
	 
	 
	 public Connection getConnection() {
		 try {
	            Class.forName("org.postgresql.Driver");
	            System.out.println("Pilote chargé");
	            
	            String url = "jdbc:postgresql:gestion_vol";
	            String user = "postgres";
	            String password = "postgres";
	            
	            Connection conn = DriverManager.getConnection(url, user, password);
	            
	            return conn;
	        } catch (Exception e) {
	            System.err.println("Erreur : " + e.getMessage());
	            
	            return null;
	        }
	 }
	 
	 public ObservableList<Avion> getAvionList() {
		 ObservableList<Avion> avions = FXCollections.observableArrayList();
		 String requete = "select * from AVION";
		 Connection con = getConnection();
		 
		 Avion avion;
	        
	        try {
	            Statement stmt = null;
	            stmt = con.createStatement();
	        
	            ResultSet rset = stmt.executeQuery(requete);
	            
	            if (rset != null) {
	                while (rset.next()) {
	                	avion = new Avion(rset.getInt("avnum"), rset.getString("avnom"), rset.getInt("capacite"), rset.getString("localisation"));
	                	avions.add(avion);
	                }
	            } else {
	            	throw new SQLException("Echec lors de l'éxécution de la query !");  
	            }
	        
	            rset.close();
	            stmt.close();
	            
	            return avions;
	        } catch (SQLException e) {
	            System.err.println("Erreur: " + e.getMessage());
	            
	            return null;
	        } 
	 }
}
