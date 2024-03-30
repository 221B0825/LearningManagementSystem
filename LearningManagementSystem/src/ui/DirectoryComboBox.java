package ui;

import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import control.CDirectory;
import entity.EDirectory;
import ui.panels.DirectoryPanel.SelectionHandler;

public class DirectoryComboBox extends JComboBox<String>{
	
	// service
	private CDirectory cDirectory;
	
	// real database
	private Vector<EDirectory> directories;
	
	// model data(to show as comboBoxList)
	private DefaultComboBoxModel<String> listData;
	
	
	public DirectoryComboBox(SelectionHandler selectionHandler) {
	
		// set service
		this.cDirectory = new CDirectory();
		
		// set model data
		this.listData = new DefaultComboBoxModel<String>();
		this.setModel(this.listData);
	
		// set ActionListener
		this.addItemListener(selectionHandler);
	}

	public String refresh(String path) {
		this.directories = this.cDirectory.getItems(path);
		this.listData.removeAllElements();
		
		for(EDirectory directory : directories) {
			this.listData.addElement(directory.getName());
		}
		// set default selection
		this.setSelectedIndex(0);
		this.updateUI();
		return this.directories.get(0).getHyperLink();
	}
	
	public String getSelectedHyperLink() {
		// if NON-Selected
		if(this.getSelectedIndex() == -1) {
			return this.directories.get(0).getHyperLink();
		}else {
			return this.directories.get(this.getSelectedIndex()).getHyperLink();	
		}
		
	}
}
