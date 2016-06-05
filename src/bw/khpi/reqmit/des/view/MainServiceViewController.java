package bw.khpi.reqmit.des.view;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import bw.khpi.reqmit.des.Main;
import bw.khpi.reqmit.des.component.RequirementsTreeCell;
import bw.khpi.reqmit.des.component.SelectedTreeItem;
import bw.khpi.reqmit.des.model.DOI;
import bw.khpi.reqmit.des.model.DOITable;
import bw.khpi.reqmit.des.model.Event;
import bw.khpi.reqmit.des.model.Project;
import bw.khpi.reqmit.des.model.ProjectList;
import bw.khpi.reqmit.des.model.Requirement;
import bw.khpi.reqmit.des.service.ServerService;
import bw.khpi.reqmit.des.service.ServerServiceImpl;
import bw.khpi.reqmit.des.utils.XMLUtils;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

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
	private Button refreshTableButton;

	@FXML
	private TreeView projectTree;

	@FXML
	private TableColumn fileName;

	@FXML
	private TableColumn eom;

	@FXML
	private TableColumn tom;

	@FXML
	private TableView<DOITable> filesTable;

	private ServerService serverRepository = new ServerServiceImpl();

	private Main mainApp;

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
	private void initialize() {
		refreshList();
		projectTree.setCellFactory(new Callback<TreeView<Object>, TreeCell<Object>>() {
			@Override
			public TreeCell<Object> call(TreeView<Object> p) {

				return new RequirementsTreeCell();
			}
		});

		projectTree.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				if (newValue != null && ((TreeItem) newValue).getValue() instanceof Requirement) {
					Requirement req = (Requirement) ((TreeItem) newValue).getValue();
					DOI events = serverRepository.listAllByRequirement(req.getProjectId(), req.getId());

					initFileTable(events);
				}
			}

		});
	}

	@FXML
	public void closeAction(ActionEvent event) {

	}

	@FXML
	public void logoutAction(ActionEvent event) {

	}

	@FXML
	public void addProjectAction(ActionEvent event) {
		mainApp.openAddProject();
	}

	@FXML
	public void addRequirementAction(ActionEvent event) {
		mainApp.openAddRequirement();
	}

	@FXML
	public void refreshTableAction(ActionEvent event) {
		if (((TreeItem) projectTree.getSelectionModel().getSelectedItem()).getValue() instanceof Requirement) {
			Requirement req = (Requirement) ((TreeItem) projectTree.getSelectionModel().getSelectedItem()).getValue();
			DOI events = serverRepository.listAllByRequirement(req.getProjectId(), req.getId());
			initFileTable(events);
		}

	}

	public void initFileTable(DOI doi) {
		filesTable.getItems().clear();

		fileName.setCellValueFactory(new PropertyValueFactory<DOI, String>("fileName"));

		eom.setCellValueFactory(new PropertyValueFactory<DOI, String>("eom"));

		tom.setCellValueFactory(new PropertyValueFactory<DOI, String>("tom"));

		List<DOITable> tableData = FXCollections.observableArrayList();
		for(int i = 0; i < doi.getEom().size(); i++){
			try{
				NumberFormat formatter = new DecimalFormat("#0.00");   
			tableData.add(new DOITable(doi.getEom().get(i).getFileName(), 
					String.valueOf(formatter.format(doi.getEom().get(i).getDoi())), 
					String.valueOf(formatter.format(doi.getTom().get(i).getDoi()))));
			}catch(IndexOutOfBoundsException e){
				//e.printStackTrace();
			}
		}
		
		ObservableList<DOITable> data = FXCollections.observableArrayList(tableData);   
		
		filesTable.setItems(data);
	}

	public void refreshList() {
		TreeItem<Object> root = new TreeItem<Object>(new Project("Projects"));
		root.setExpanded(true);

		ProjectList list = serverRepository.listAllProjects();
		for (Project p : list.getProjects()) {
			TreeItem<Object> item = new TreeItem<Object>(p);
			root.getChildren().add(item);
			p.setRequirements(serverRepository.listAllRequirementsByProject(p.getId()));
			for (Requirement r : p.getRequirements()) {
				if (r.getProjectId().equals(p.getId())) {
					SelectedTreeItem<Object> req = new SelectedTreeItem<Object>(r);
					item.getChildren().add(req);

				}
			}
			item.setExpanded(true);
		}
		projectTree.setRoot(root);

		XMLUtils.saveProjects(list);
	}

}
