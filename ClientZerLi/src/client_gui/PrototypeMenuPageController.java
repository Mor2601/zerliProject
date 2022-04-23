package client_gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PrototypeMenuPageController {

	@FXML
	private Button addBtn;

	@FXML
	private Button getOrEditBtn;

	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/MenuPage.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("ZerLi Menu Prototype");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}

	@FXML
	void ADD(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding primary window
		Pane root = loader.load(getClass().getResource("/client_gui/AddOrder.fxml").openStream());
		Scene scene = new Scene(root); // create a scene
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Add Page");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}

	@FXML
	void GETOREDIT(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding primary window
		Pane root = loader.load(getClass().getResource("/client_gui/GetOrders.fxml").openStream());
		Scene scene = new Scene(root); // create a scene
		scene.getStylesheets().add(getClass().getResource("/client_gui/GetOrdersScreenDesign.css").toExternalForm());
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Get / Edit Page");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}
	
	
}