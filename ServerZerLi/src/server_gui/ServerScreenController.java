package server_gui;

import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import server.ServerUI;

public class ServerScreenController implements Initializable {

	@FXML
	private Button BTNConnect;

	@FXML
	private Button BTNDisconnect;

	@FXML
	private Button BTNImport;

	@FXML
	private Pane ServerPane;

	@FXML
	private TextField TxtDataBase;

	@FXML
	private TextField TxtIp;

	@FXML
	private PasswordField TxtPassword;

	@FXML
	private TextField TxtPort;

	@FXML
	private TextField TxtUserName;

	@FXML
	private TextField portxt;

	@FXML
	private GridPane ConnectedUsers;

//    private Map<String,List<String>> clients=new HashMap<>();

	private List<String> data = new ArrayList<String>();
	private String hostName;
	private Label ServerManagerIp, ServerManagerStatus, ServerManagerHost;
	public static ObservableList<ClientDetails> clients;
	public static ArrayList<String> console;

	private String getport() {
		return TxtPort.getText();
	}

	static {
		ServerScreenController.console = new ArrayList<String>();
		ServerScreenController.clients = FXCollections.observableArrayList();
	}

	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/server_gui/ServerFXML.fxml"));
		Scene scene = new Scene(root);

		primaryStage.setTitle("ZerLi Server");
		primaryStage.setScene(scene);

		primaryStage.show();
		primaryStage.setResizable(false);
	}

	@FXML
	void Connect(ActionEvent event) {
		String p;
		data.add(TxtDataBase.getText());
		data.add(TxtUserName.getText());
		data.add(TxtPassword.getText());
		System.out.println(data.toString());
		p = getport();
		if (p.trim().isEmpty()) {
			System.out.println("You must enter a port number");
		} 
		else {
			if (ServerUI.runServer(p, data)) {
				BTNDisconnect.setDisable(false); // only if there is host connected he can press discon
				ServerManagerIp = new Label();
				ServerManagerIp.setText(TxtIp.getText());
				ConnectedUsers.add(ServerManagerIp, 0, 0);
				ServerManagerHost = new Label();
				ServerManagerHost.setText(hostName);
				ConnectedUsers.add(ServerManagerHost, 1, 0);
				ServerManagerStatus = new Label();
				ServerManagerStatus.setText("Connected-server");
				ConnectedUsers.add(ServerManagerStatus, 2, 0);
			}
		}
	}

	@FXML
	void Disconnect(ActionEvent event) {
		ConnectedUsers.getChildren().clear();
		ServerUI.stopServer();
		BTNDisconnect.setDisable(true);

	}

	@FXML
	void Import(ActionEvent event) {
		// to be continued
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadInformation();
	}

	private void loadInformation() {
		BTNDisconnect.setDisable(true);
		this.TxtPort.setText(String.valueOf(5556));
		try {
			this.TxtIp.setText(InetAddress.getLocalHost().getHostAddress());
			this.TxtIp.setDisable(true);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		this.TxtDataBase.setText("jdbc:mysql://localhost/zerli?serverTimezone=IST");
		this.TxtUserName.setText("root");
		this.TxtPassword.setText("************");
		this.BTNImport.setDisable(true);
		try {
			hostName = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
