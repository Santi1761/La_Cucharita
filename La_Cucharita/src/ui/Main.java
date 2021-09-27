package ui;
import model.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	private static LaCucharita GH= new LaCucharita();;
	private static ControllerClassGUI controllerClassGUI;
	
	public static void main(String[] args) {
		
		try {
			
			GH.loadUsers();
			GH.loadProductsData();
			GH.loadClient();
			GH.loadCodes();
			GH.loadDates();
			GH.loadIngredients();
			GH.loadIngredientsEnabled();
			GH.loadOrders();
			GH.loadProductsEnabledData();
			GH.loadTypes();
			
		} catch (FileNotFoundException e) {
		System.out.println("no");
		} catch (ClassNotFoundException e) {
			System.out.println("si");
		} catch (IOException e) {
			System.out.println("sn");
		}
		System.out.println(GH.getUsers().toString());
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
		controllerClassGUI = new ControllerClassGUI(GH);
	    fxmlLoader.setController(controllerClassGUI);
	    Parent root = fxmlLoader.load();
	    
	    Scene scene = new Scene(root);
	    primaryStage.setScene(scene);
	    primaryStage.setMinHeight(718.0);
	    primaryStage.setMinWidth(1250.0);
	    primaryStage.setTitle("Login");
	    primaryStage.show();
		
	}
	

}