package bw.khpi.reqmit.des.component;

import bw.khpi.reqmit.des.currentInfo.SelectedRequirement;
import bw.khpi.reqmit.des.model.Requirement;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class RequirementsTreeCell extends TreeCell<Object> {

	private TextField textField;
	private ContextMenu requirementMenu = new ContextMenu();
	private ContextMenu projectMenu = new ContextMenu();

	@SuppressWarnings("unchecked")
	public RequirementsTreeCell() {
		MenuItem renameMenuItem = new MenuItem("Rename");
		projectMenu.getItems().add(renameMenuItem);
		renameMenuItem.setOnAction(new EventHandler() {
			public void handle(Event t) {
			}
		});
		
		MenuItem deleteMenuItem = new MenuItem("Delete");
		projectMenu.getItems().add(deleteMenuItem);
		deleteMenuItem.setOnAction(new EventHandler() {
			public void handle(Event t) {
			}
		});
		
		
		MenuItem selectMenuItem = new MenuItem("Select");
		requirementMenu.getItems().add(selectMenuItem);
		selectMenuItem.setOnAction(new EventHandler() {
			public void handle(Event t) {
				setSelection();
			}
		});

		setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if (mouseEvent.getClickCount() == 2) {
					setSelection();
				}
			}
		});
	}

	private void setSelection() {
		String text = getText();
		if (text.startsWith("(selected) ")) {
			setText(text.substring(11));
			((SelectedTreeItem<Object>) getTreeItem()).setSelectedRequirement(false);
			SelectedRequirement.setRequirement(null);
		} else {
			if (hasSelected()) {
				setText("(selected) " + text);
				((SelectedTreeItem<Object>) getTreeItem()).setSelectedRequirement(true);
				SelectedRequirement.setRequirement((Requirement)getTreeItem().getValue());
			}
		}
	}

	@Override
	public void startEdit() {
		super.startEdit();

		if (textField == null) {
			createTextField();
		}
		setText(null);
		setGraphic(textField);
		textField.selectAll();
	}

	@Override
	public void cancelEdit() {
		super.cancelEdit();

		setText((String) getItem());
		setGraphic(getTreeItem().getGraphic());
	}

	@Override
	public void updateItem(Object item, boolean empty) {
		super.updateItem(item, empty);

		if (empty) {
			setText(null);
			setGraphic(null);
		} else {
			setText(getString());
			setGraphic(getTreeItem().getGraphic());
			if (getTreeItem().isLeaf() && getTreeItem().getParent() != null
					&& getTreeItem().getParent().getParent() != null && hasSelected()) {
				setContextMenu(requirementMenu);
			} else if (getTreeItem().getParent() != null
					&& getTreeItem().getParent().getParent() == null){
				setContextMenu(projectMenu);
				
			}
		}
	}

	private boolean hasSelected() {
		ObservableList<TreeItem<Object>> list = getTreeView().getRoot().getChildren();
		for (TreeItem<Object> item : list) {
			ObservableList<TreeItem<Object>> childrenList = item.getChildren();
			for (TreeItem<Object> child : childrenList) {
				if (((SelectedTreeItem<Object>) child).isSelectedRequirement()) {
					return false;
				}
			}
		}
		return true;
	}

	private void createTextField() {
		textField = new TextField(getString());
		textField.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent t) {
				if (t.getCode() == KeyCode.ENTER) {
					commitEdit(textField.getText());
				} else if (t.getCode() == KeyCode.ESCAPE) {
					cancelEdit();
				}
			}
		});

	}

	private String getString() {
		return getItem() == null ? "" : getItem().toString();
	}
}
