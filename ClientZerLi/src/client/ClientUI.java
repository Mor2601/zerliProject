package client;

import client_gui.ConnectToServerController;
import client_gui.CustomerPageController;
import javafx.application.Application;
import javafx.stage.Stage;

public class ClientUI extends Application {
	public static ClientController chat; // only one instance

	public static void main(String args[]) throws Exception {
		launch(args);
	} // end main

	@Override
	public void start(Stage primaryStage) throws Exception {
//		ConnectToServerController ConnectToServer = new ConnectToServerController();
//		ConnectToServer.start(primaryStage);
//		CatalogScreenController catalogScreen = new CatalogScreenController();
//		catalogScreen.start(primaryStage);
		CustomerPageController customerPage = new CustomerPageController();
		customerPage.start(primaryStage);
		
	}
}
