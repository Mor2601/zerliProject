package DataBase;

import java.sql.Connection;
import java.util.ArrayList;

import common.TransmissionPack;

public class MissionAnalyze {
	public static ArrayList<String> list = new ArrayList<String>();

	public static void MissionsAnalyze(TransmissionPack obj, Connection con) {

		switch (obj.getMission()) {
		case ADD_ORDER: {
			ServerQuaries.InsertOrderToDB(obj, con);
			break;
		}
		case EDIT_ORDER: {
			ServerQuaries.EditOrderOnDB(obj, con);
			break;
		}
		case GET_ORDERS: {
			ServerQuaries.GetOrderFromDB(obj, con);
			break;
		}
		case USER_LOGIN: {

			ServerQuaries.getUser(obj, con);
		}
		case GET_USER_ORDERS:
			ServerQuaries.GetUserOrders(obj,con);
		}

	}

}
