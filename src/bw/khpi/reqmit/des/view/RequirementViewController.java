package bw.khpi.reqmit.des.view;

import bw.khpi.reqmit.des.Main;
import bw.khpi.reqmit.des.model.Project;
import bw.khpi.reqmit.des.model.ProjectList;
import bw.khpi.reqmit.des.model.Requirement;
import bw.khpi.reqmit.des.utils.XMLUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RequirementViewController {

    @FXML
    private ComboBox<Project> projectCombobox;
    
    @FXML
    private TextField nameField;

    @FXML
    private TextArea descriptionArea;
    
    @FXML
    private Button createOrUpdateButton;

	private Main mainApp;
	
	private ProjectList projectList = XMLUtils.loadProjects();
    
    public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}

    
    @FXML
    private void initialize() {
    	
    	ObservableList<Project> list = FXCollections.observableArrayList(projectList.getProjects());
    	projectCombobox.setPromptText("Select project");
    	projectCombobox.setItems(list);
    }
    @FXML
    private void createOrUpdateActionPerformed(ActionEvent event){
    	Project project = projectCombobox.getValue();
    	project.getRequirements().add(new Requirement(1, project.getId(), nameField.getText(), descriptionArea.getText()));
    	XMLUtils.saveProjects(projectList);
    	mainApp.refreshMainService();
    }
    
}
