package application.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class AvionOverviewController {
	
	 @FXML
	 private TableView<Object> avionTable;
	
	 @FXML
	 private Label avionLabel;
	 
	 @FXML
	 private void initialize() {
		 avionLabel.setText("niquel");
		 
	 }
}
