package client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import client_gui.PrototypeMenuPageController;
import common.Mission;
import common.Response;
import common.TransmissionPack;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.PrototypeOrder;
import usersType.Login;

public class ClientQuaries {

	public static void INSERT_ORDER(TextField orderIdTxt, TextField priceTxt, TextField greetingCardTxt,
			TextField colorTxt, TextField dOrderTxt, TextField shopTxt, TextField dateTxt, TextField orderDate,
			Label statusTxt) {
		List<String> order = new ArrayList<>();
		order.addAll(Arrays.asList(orderIdTxt.getText(), priceTxt.getText(), greetingCardTxt.getText(),
				colorTxt.getText(), dOrderTxt.getText(), shopTxt.getText(), dateTxt.getText(), orderDate.getText()));
		TransmissionPack obj = new TransmissionPack(Mission.ADD_ORDER, null, order);
		ClientUI.chat.accept(obj);
		obj = ClientUI.chat.getObj();
		if (obj.getResponse() == Response.INSERT_ORDER_SUCCESS) {
			statusTxt.setTextFill(Color.GREEN);
			statusTxt.setText("Insert Success");
		} else {
			statusTxt.setTextFill(Color.RED);
			statusTxt.setText("Insert Failed");
		}
	}

	public static void GET_ORDERS(ObservableList<PrototypeOrder> listView, TableView<PrototypeOrder> table,
			Label statusLabel, String[] list) {
		TransmissionPack obj = new TransmissionPack(Mission.GET_ORDERS, null, null);
		ClientUI.chat.accept(obj);
		obj = ClientUI.chat.getObj();
		if (obj.getResponse() == Response.FOUND_ORDERS) {
			listView.clear();
			List<String> temp = new ArrayList();
			temp = (List<String>) obj.getInformation();
			for (int i = 0; i < temp.size(); i++) {
				list = (temp.get(i).split("\\s+"));
				listView.add(
						new PrototypeOrder(list[0], list[1], list[2], list[3], list[4], list[5], list[6], list[7]));
			}
			table.setItems(listView);
			statusLabel.setTextFill(Color.GREEN);
			statusLabel.setText("Upload Success");
		} else {
			statusLabel.setTextFill(Color.RED);
			statusLabel.setText("Upload Failed");
		}
	}

	public static void EDIT_ORDER(Label statusLabel, TextField lblEditColor, TextField lblEditDate,
			TextField lblEditOrderNumber) {
		List<String> order = new ArrayList<>();
		order.addAll(Arrays.asList(lblEditColor.getText(), lblEditDate.getText(), lblEditOrderNumber.getText()));
		TransmissionPack obj = new TransmissionPack(Mission.EDIT_ORDER, null, order);
		ClientUI.chat.accept(obj);
		obj = ClientUI.chat.getObj();
		if (obj.getResponse() == Response.EDIT_ORDER_FAILD) {
			statusLabel.setTextFill(Color.RED);
			statusLabel.setText("Edit Failed");
		} else {
			statusLabel.setTextFill(Color.GREEN);
			statusLabel.setText("Edit Success");
		}
	}

	public static void USER_LOGIN(TextField userTxt, TextField passwordTxt, Label errorLabel, MouseEvent event) {
		userTxt.setStyle(null);
		passwordTxt.setStyle(null);
		Login login = new Login(userTxt.getText(), passwordTxt.getText());
		if (checkLoginValidationFilling(login, userTxt, passwordTxt, errorLabel)) {
			TransmissionPack tp = new TransmissionPack(Mission.USER_LOGIN, null, login);
			ClientUI.chat.accept(tp);
			tp = ClientUI.chat.getObj();
			switch (tp.getResponse()) {
			case USER_NAME_OR_PASSWORD_INCORRECT: {
				errorLabel.setTextFill(Color.RED);
				errorLabel.setText("User name or password incorrect");
				break;
			}
			case USER_EXIST:
				((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
				Stage primaryStage = new Stage();
				PrototypeMenuPageController menu = new PrototypeMenuPageController();
				try {
					menu.start(primaryStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case USER_NOT_EXIST: {
				errorLabel.setTextFill(Color.RED);
				errorLabel.setText("User doesn't exist");
				break;
			}
			default:
				break;
			}
		}
	}

	private static boolean checkLoginValidationFilling(Login login, TextField userTxt, TextField passwordTxt,
			Label errorLabel) {
		if (login.getUserName().equals(""))
			userTxt.setStyle("-fx-border-color: red");
		if (login.getPassword().equals("")) { // checking if the user didn't enter both username and password.
			passwordTxt.setStyle("-fx-border-color: red");
		}
		if (login.getUserName().equals("") || login.getPassword().equals("")) {
			errorLabel.setText("Please fill all the fields on the screen");
			return false;
		} else
			return true;
	}

	public static void getClientOrders(ObservableList<PrototypeOrder> listView, TableView<PrototypeOrder> table,
			Label statusLabel, String[] list) {

	}
//		TransmissionPack obj = new TransmissionPack(Mission.GET_ORDERS, null, null);
//		ClientUI.chat.accept(obj);
//		obj = ClientUI.chat.getObj();
//		if (obj.getResponse() == Response.FOUND_ORDERS) {
//			listView.clear();
//			List<String> temp = new ArrayList();
//			temp = (List<String>) obj.getInformation();
//			for (int i = 0; i < temp.size(); i++) {
//				list = (temp.get(i).split("\\s+"));
//				listView.add(
//						new PrototypeOrder(list[0], list[1], list[2], list[3], list[4], list[5], list[6], list[7]));
//			}
//			table.setItems(listView);
//			
//			
//		} else {
//			statusLabel.setTextFill(Color.RED);
//			statusLabel.setText("No Orders Found!");
//		}
}
