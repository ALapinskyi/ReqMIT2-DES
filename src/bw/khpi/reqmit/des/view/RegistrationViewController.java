package bw.khpi.reqmit.des.view;

import bw.khpi.reqmit.des.Main;
import bw.khpi.reqmit.des.model.User;
import bw.khpi.reqmit.des.service.ServerService;
import bw.khpi.reqmit.des.service.ServerServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegistrationViewController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;
    
    @FXML
    private TextField passwordField;
    
    @FXML
    private TextField confirmPasswordField;

    @FXML
    private Button createButton;

    @FXML
    private Button cancelButton;

	private ServerService serverRepository = new ServerServiceImpl();
	
    private Main mainApp;
    
    public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	@FXML
    private void initialize() {
    	
    }
    @FXML
    private void createActionPerformed(ActionEvent event){
    	if(!"".equals(usernameField.getText())
    			&& !"".equals(passwordField.getText())
    			&& passwordField.getText().equals(confirmPasswordField.getText())){
        	User user = new User();
        	user.setUsername(usernameField.getText());
        	user.setPassword(passwordField.getText());
        	
        	serverRepository.saveUser(user);
        	mainApp.showMainView();
    	}
    	
    }
    
    @FXML
    private void cancelActionPerformed(ActionEvent event){
    	mainApp.showLoginView();
    }
}
