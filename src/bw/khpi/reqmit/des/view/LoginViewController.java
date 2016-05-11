package bw.khpi.reqmit.des.view;

import java.awt.event.ActionEvent;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

public class LoginViewController {

    @FXML
    private ComboBox<String> typeCombobox;
    
    @FXML
    private TextField usernameField;
    
    @FXML
    private TextField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Hyperlink createLocalButton;
    
    @FXML
    private void initialize() {
    	ObservableList<String> list = FXCollections.observableArrayList(
    	        "Local account"
    	    );
    	typeCombobox.setItems(list);
    	
    }
    @FXML
    private void loginActionPerformed(ActionEvent event){
    	
    }
    
    @FXML
    private void createLocalActionPerformed(ActionEvent event){
    	
    }
}
