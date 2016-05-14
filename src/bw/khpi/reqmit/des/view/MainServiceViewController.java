package bw.khpi.reqmit.des.view;

import bw.khpi.reqmit.des.Main;
import bw.khpi.reqmit.des.model.Project;
import bw.khpi.reqmit.des.model.ProjectList;
import bw.khpi.reqmit.des.model.Requirement;
import bw.khpi.reqmit.des.service.ServerRepository;
import bw.khpi.reqmit.des.service.ServerRepositoryImpl;
import bw.khpi.reqmit.des.utils.XMLUtils;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;

public class MainServiceViewController {

    @FXML
    private MenuItem logoutItem;

    @FXML
    private MenuItem exitItem;

    @FXML
    private MenuItem addProjectItem;

    @FXML
    private MenuItem addRequirementItem;
    
    @FXML
    private Button addProjectButton;
    
    @FXML
    private Button removeProjectButton;

    @FXML
    private TreeView<Object> projectTree;

    @FXML
    private TableView filesTable;

	private ServerRepository serverRepository = new ServerRepositoryImpl();
	
	private Main mainApp;
    
    public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
    private void initialize() {
		refreshList();
    }
    
    @FXML
    public void closeAction(ActionEvent event){
    	
    }

    
    @FXML
    public void logoutAction(ActionEvent event){
    	
    }
    
    @FXML
    public void addProjectAction(ActionEvent event){
    	mainApp.openAddProject();
    }
    
    @FXML
    public void addRequirementAction(ActionEvent event){
    	mainApp.openAddRequirement();
    }
    
    public void refreshList(){
    	TreeItem<Object> root = new TreeItem<Object>(new Project("Projects"));
    	root.setExpanded(true);
    	
    	ProjectList list = XMLUtils.loadProjects();
    	for(Project p : list.getProjects()){
        	TreeItem<Object> item = new TreeItem<Object>(p);
        	root.getChildren().add(item);
        	for(Requirement r : p.getRequirements()){
            	TreeItem<Object> req = new TreeItem<Object>(r);
            	item.getChildren().add(req);
        	}
        	item.setExpanded(true);
    	}
    	projectTree.setRoot(root);
    }
    
    
}
