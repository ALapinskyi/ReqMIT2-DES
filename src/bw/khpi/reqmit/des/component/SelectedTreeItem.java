package bw.khpi.reqmit.des.component;

import javafx.scene.control.TreeItem;

public class SelectedTreeItem<T> extends TreeItem<T> {
	
	private boolean selectedRequirement;

	public boolean isSelectedRequirement() {
		return selectedRequirement;
	}

	public void setSelectedRequirement(boolean selectedRequirement) {
		this.selectedRequirement = selectedRequirement;
	}

	public SelectedTreeItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SelectedTreeItem(T value) {
		super(value);
		// TODO Auto-generated constructor stub
	}
	
	
	

}
