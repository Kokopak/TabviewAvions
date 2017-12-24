package application;
	
import java.io.IOException;

import application.controllers.AvionOverviewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
    private BorderPane rootLayout;
    private Stage primaryStage;
    
	@Override
	public void start(Stage primaryStage) {
		try {
			
			this.primaryStage = primaryStage;
			
			initRootLayout();
			showAvionOverview();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initRootLayout() {
	    try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/templates/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void showAvionOverview() {
	    try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/templates/AvionOverview.fxml"));
            AnchorPane avionOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(avionOverview);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
