package client_gui;

import java.net.URL;
import java.util.ResourceBundle;

import client.ClientQuaries;
import entities.ItemInCart;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import usersType.Customer;

public class CancelOrdersController implements Initializable {

	@FXML
	private TableColumn<ItemInCart, String> OrderDateColTbl;

	@FXML
	private TableColumn<ItemInCart, String> OrderNumberColTbl;

	@FXML
	private TableColumn<ItemInCart, String> PriceColTbl;

	@FXML
	private TableColumn<ItemInCart, String> StatusColTbl;

	@FXML
	private Button cancelBtn;

	@FXML
	private Button backBtn;
	
	@FXML
	private Label statusLabel;

	@FXML
	private TableView<ItemInCart> table;

	ObservableList<ItemInCart> listView = FXCollections.observableArrayList();
	
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/CancelOrders.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Cancel Orders Page");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		OrderNumberColTbl.setCellValueFactory(new PropertyValueFactory<ItemInCart, String>("orederNumber"));
		OrderDateColTbl.setCellValueFactory(new PropertyValueFactory<ItemInCart, String>("orderDate"));
		PriceColTbl.setCellValueFactory(new PropertyValueFactory<ItemInCart, String>("price"));
		StatusColTbl.setCellValueFactory(new PropertyValueFactory<ItemInCart, String>("status"));
		Customer c1 = new Customer("Omri", "Shalev", "315838540", "0544987908", "shalevomri10@gmail.com", "1111111111111111");
		
	//	ClientQuaries.GET_ORDERS(listView, table, statusLabel, list); GET THE USER OREDERS

	}

	@FXML
	void CancelOrder(ActionEvent event) {

	}

	@FXML
	void Back(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		PrototypeMenuPageController menuPage = new PrototypeMenuPageController();
		menuPage.start(primaryStage);
	}

}
