package client_gui;

import Listeners.MyListener;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import logic.Item;

public class ItemInCatalogController {

	@FXML
	private ImageView itemImageScrollArea;

	@FXML
	private Label itemNameScrollArea;

	@FXML
	private Label itemPriceScrollArea;

	private Item item;
	private String CURRENCY = "¤";
	private MyListener myListener;

	@FXML
	private void clickItem(MouseEvent mouseEvent) {
		myListener.onClickListener(item);
	}

	public void setDataItem(Item tmpItem, MyListener tmpMyListner) {
		item = tmpItem;
		myListener = tmpMyListner;
		itemNameScrollArea.setText(item.getName());
		itemPriceScrollArea.setText(CURRENCY + item.getPrice());
		Image image = new Image(getClass().getResourceAsStream(item.getImgSrc()));
		itemImageScrollArea.setImage(image);
	}

}
