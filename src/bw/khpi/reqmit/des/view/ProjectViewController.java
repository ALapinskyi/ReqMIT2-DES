package bw.khpi.reqmit.des.view;

import javafx.event.ActionEvent;
import bw.khpi.reqmit.des.Main;
import bw.khpi.reqmit.des.model.Project;
import bw.khpi.reqmit.des.service.ServerService;
import bw.khpi.reqmit.des.service.ServerServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ProjectViewController {

    @FXML
    private TextField nameField;

    @FXML
    private Button createOrUpdateButton;

	private ServerService serverRepository = new ServerServiceImpl();

	private Main mainApp;
    
    public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
    
    @FXML
    private void initialize() {
    	
    }
    
    @FXML
    private void createOrUpdateActionPerformed(ActionEvent event){
    	Project prj = new Project();
    	prj.setName(nameField.getText());
    	
    	serverRepository.saveProject(prj);
    	
    	mainApp.refreshMainService();
    }
    
}
