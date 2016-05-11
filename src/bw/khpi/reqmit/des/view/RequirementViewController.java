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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RequirementViewController {

    @FXML
    private ComboBox<String> projectCombobox;
    
    @FXML
    private TextField nameField;

    @FXML
    private TextArea descriptionArea;
    
    @FXML
    private Button createOrUpdateButton;

    
    @FXML
    private void initialize() {
    	ObservableList<String> list = FXCollections.observableArrayList(
    	        "Project 1"
    	 );
    	projectCombobox.setItems(list);
    	
    }
    @FXML
    private void createOrUpdateActionPerformed(ActionEvent event){
    	
    }
    
}
