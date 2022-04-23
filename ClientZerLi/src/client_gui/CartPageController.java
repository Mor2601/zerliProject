package client_gui;

import java.net.URL;
import java.util.ResourceBundle;

import entities.ItemInCart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CartPageController implements Initializable {

	@FXML
	private TableColumn<ItemInCart, String> ItemNameColTbl;

	@FXML
	private TableColumn<ItemInCart, Double> PriceColTbl;

	@FXML
	private TableColumn<ItemInCart, ImageView> ImgColTbl;

	@FXML
	private TableColumn<ItemInCart, Integer> QuantityColTbl;

	@FXML
	private Button backBtn;

	@FXML
	private Button confirmBtn;

	@FXML
	private Button removeBtn;

	@FXML
	private TableView<ItemInCart> table;

	ObservableList<ItemInCart> listView = FXCollections.observableArrayList();

	@FXML
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/gui/CartPage.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Cart Page");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@FXML
	void back(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		ItemNameColTbl.setCellValueFactory(new PropertyValueFactory<ItemInCart, String>("Name"));
		PriceColTbl.setCellValueFactory(new PropertyValueFactory<ItemInCart, Double>("Price"));
		ImgColTbl.setCellValueFactory(new PropertyValueFactory<ItemInCart, ImageView>("ImgSrc"));
		QuantityColTbl.setCellValueFactory(new PropertyValueFactory<ItemInCart, Integer>("Quantity"));

		ImageView imageView1 = new ImageView(new Image("file:src/javafx_images/Rose.png", 50, 200, true, true));
		ImageView imageView2 = new ImageView(new Image("file:src/javafx_images/Rose.png", 50, 200, true, true));

		listView.add(new ItemInCart("Rose", imageView1, 5.2, 5));
		listView.add(new ItemInCart("Cactus", imageView2, 10, 2));
		table.setItems(listView);

	}

	@FXML
	void confirm(ActionEvent event) {

	}

	@FXML
	void remove(ActionEvent event) {

	}
}