package logic;

public class PrototypeOrder {
	
	private String orderNumber,price,greetingCard,color,dorder,shop,date,orderDate;

	public PrototypeOrder(String orderNumber, String price, String greetingCard, String color, String dorder,
			String shop, String date, String orderDate) {
		this.orderNumber = orderNumber;
		this.price = price;
		this.greetingCard = greetingCard;
		this.color = color;
		this.dorder = dorder;
		this.shop = shop;
		this.date = date;
		this.orderDate = orderDate;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public String getPrice() {
		return price;
	}

	public String getGreetingCard() {
		return greetingCard;
	}

	public String getColor() {
		return color;
	}

	public String getDorder() {
		return dorder;
	}

	public String getShop() {
		return shop;
	}

	public String getDate() {
		return date;
	}

	public String getOrderDate() {
		return orderDate;
	}
}
