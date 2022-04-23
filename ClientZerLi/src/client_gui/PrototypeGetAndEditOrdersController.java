package client_gui;

import java.net.URL;
import java.util.ResourceBundle;

import client.ClientQuaries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import logic.PrototypeOrder;

public class PrototypeGetAndEditOrdersController implements Initializable {
	@FXML
	private TableColumn<PrototypeOrder, String> ColorColTbl;

	@FXML
	private TableColumn<PrototypeOrder, String> OrderNameColTbl;

	@FXML
	private TableColumn<PrototypeOrder, String> PriceColTbl;

	@FXML
	private Button backBtn;

	@FXML
	private TableColumn<PrototypeOrder, String> dOrderColTbl;

	@FXML
	private TableColumn<PrototypeOrder, String> dateColTbl;

	@FXML
	private Button editOrderBtn;

	@FXML
	private Button getOrdersBtn;

	@FXML
	private TableColumn<PrototypeOrder, String> greetingCardColTbl;

	@FXML
	private TableColumn<PrototypeOrder, String> orderDateColTbl;

	@FXML
	private TableColumn<PrototypeOrder, String> shopColTbl;

	@FXML
	private TableView<PrototypeOrder> table;

	@FXML
	private TextField lblEditColor;

	@FXML
	private TextField lblEditDate;
	@FXML
	private Label statusLabel;
	@FXML
	private TextField lblEditOrderNumber;

	ObservableList<PrototypeOrder> listView = FXCollections.observableArrayList();
	String[] list;

	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/GetOrders.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("ZerLi GetOrders");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		OrderNameColTbl.setCellValueFactory(new PropertyValueFactory<PrototypeOrder, String>("orderNumber"));
		PriceColTbl.setCellValueFactory(new PropertyValueFactory<PrototypeOrder, String>("price"));
		greetingCardColTbl.setCellValueFactory(new PropertyValueFactory<PrototypeOrder, String>("greetingCard"));
		ColorColTbl.setCellValueFactory(new PropertyValueFactory<PrototypeOrder, String>("color"));
		dOrderColTbl.setCellValueFactory(new PropertyValueFactory<PrototypeOrder, String>("dorder"));
		shopColTbl.setCellValueFactory(new PropertyValueFactory<PrototypeOrder, String>("shop"));
		dateColTbl.setCellValueFactory(new PropertyValueFactory<PrototypeOrder, String>("date"));
		orderDateColTbl.setCellValueFactory(new PropertyValueFactory<PrototypeOrder, String>("orderDate"));
	}

	@FXML
	void Back(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		PrototypeMenuPageController menuPage = new PrototypeMenuPageController();
		menuPage.start(primaryStage);
	}

	@FXML
	void GetOrders(ActionEvent event) {
		ClientQuaries.GET_ORDERS(listView, table, statusLabel, list);
	}

	@FXML
	void EditOrder(ActionEvent event) {
		ClientQuaries.EDIT_ORDER(statusLabel, lblEditColor, lblEditDate, lblEditOrderNumber);
	}

}
