package client_gui;

import client.ClientController;
import client.ClientUI;
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

public class ConnectToServerController {
	private String ip, port;
	@FXML
	private Label ConnectStatusLabel;

	@FXML
	private TextField IpTxt;
	@FXML
	private Button ConfirmDetails;

	@FXML
	private TextField PortTxt;

	@FXML
	void ConfirmClick(ActionEvent event) throws Exception {
		ip = IpTxt.getText();
		port = PortTxt.getText();
		ClientUI.chat = new ClientController(ip, Integer.parseInt(port));
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		LoginController login = new LoginController();
		login.start(primaryStage);
	}

	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/ConnectToServer.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("ZerLi Connect To Server");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}

}
