package common;

public enum Mission {
	GET_ORDERS("GET_ORDERS",0),
	ADD_ORDER("ADD_ORDER",1),
	EDIT_ORDER("EDIT_ORDER",2),
	USER_LOGIN("USER_LOGIN",3),
	GET_USER_ORDERS("GET_USER_ORDERS",4),
	CANCEL_OREDERS("CANCEL_OREDRS",5);
	
	private Mission (final String mission,final int serialNumber ) {
	}
}
