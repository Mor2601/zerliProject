package client_gui;

import java.io.IOException;

import client.ClientQuaries;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PrototypeAddOrderController {

	@FXML
	private Button BackBtn;

	@FXML
	private Button addBtn;

	@FXML
	private TextField colorTxt;

	@FXML
	private TextField dOrderTxt;

	@FXML
	private TextField dateTxt;

	@FXML
	private TextField greetingCardTxt;

	@FXML
	private TextField orderIdTxt;

	@FXML
	private TextField orderDate;

	@FXML
	private TextField priceTxt;

	@FXML
	private TextField shopTxt;

	@FXML
	private Label statusTxt;

	@FXML
	void Back(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		PrototypeMenuPageController menuPage = new PrototypeMenuPageController();
		menuPage.start(primaryStage);
	}

	@FXML
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/AddOrder.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Add Order");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}

	@FXML
	void addOrder(ActionEvent event) {

		ClientQuaries.INSERT_ORDER(orderIdTxt, priceTxt, greetingCardTxt, colorTxt, dOrderTxt, shopTxt, dateTxt,
				orderDate, statusTxt);
	}
}
