package client_gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CustomerPageController {

	@FXML
	private Button cancelOrdersBtn;

	@FXML
	private Button compliantBtn;

	@FXML
	private Button logOutBtn;

	@FXML
	private Button viewCatalogBtn;

	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/CustomerPage.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Customer Menu");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}
	

	@FXML
	void cancelOrders(ActionEvent event) {

	}

	@FXML
	void compliant(ActionEvent event) {

	}

	@FXML
	void logOut(ActionEvent event) {

	}

	@FXML
	void viewCatalog(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		CatalogScreenController catalogScreen = new CatalogScreenController();
		catalogScreen.start(primaryStage);
	}

}
