package client_gui;

import client.ClientQuaries;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController {
	@FXML
	private TextField passwordTxt;

	@FXML
	private TextField userTxt;

	@FXML
	private Label errorLabel;

	@FXML
	private Button loginBtn;

	@FXML
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/Login.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("ZerLi Login");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}

	@FXML
	void LoginClick(MouseEvent event) {
		ClientQuaries.USER_LOGIN(userTxt, passwordTxt, errorLabel, event);
	}
}
