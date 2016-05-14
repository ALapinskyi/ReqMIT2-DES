package bw.khpi.reqmit.des.view;

import bw.khpi.reqmit.des.Main;
import bw.khpi.reqmit.des.model.User;
import bw.khpi.reqmit.des.service.ServerRepository;
import bw.khpi.reqmit.des.service.ServerRepositoryImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginViewController {

	@FXML
	private ComboBox<String> typeCombobox;

	@FXML
	private TextField usernameField;

	@FXML
	private PasswordField passwordField;

	@FXML
	private Button loginButton;

	@FXML
	private Hyperlink createLocalButton;

	private ServerRepository serverRepository = new ServerRepositoryImpl();
	
	private Main mainApp;
	

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
	private void initialize() {
		ObservableList<String> list = FXCollections.observableArrayList("Local account");
		typeCombobox.setPromptText("Select type");
		typeCombobox.setItems(list);
	}

	@FXML
	public void loginActionPerformed(ActionEvent event) {
		User user = new User();
		user.setUsername(usernameField.getText());
		user.setPassword(passwordField.getText());

		User authUser = serverRepository.getAuthentication(user);

		if (authUser != null) {
			mainApp.setUser(authUser);
			mainApp.showMainView();
		}
		
	}

	@FXML
	private void createLocalActionPerformed(ActionEvent event) {
		mainApp.openRegistration();
	}
}
