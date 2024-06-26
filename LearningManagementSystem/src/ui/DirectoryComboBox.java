package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

import control.CDirectory;
import entity.EDirectory;
import ui.panels.DirectoryPanel.SelectionHandler;

public class DirectoryComboBox extends JComboBox<String> {

	// service
	private CDirectory cDirectory;

	// real database
	private Vector<EDirectory> directories;

	// model data(to show as comboBoxList)
	private DefaultComboBoxModel<String> directoryList;

	public DirectoryComboBox(SelectionHandler selectionHandler) {
		// set attributes
		this.setPreferredSize(new Dimension(128, 32));
		
		// set service
		this.cDirectory = new CDirectory();

		// set model data
		this.directoryList = new DefaultComboBoxModel<String>();
		this.setModel(this.directoryList);

		// set ActionListener
		this.addItemListener(selectionHandler);
	}

	public String refresh(String path) {
		this.directories = this.cDirectory.getItems(path);
		this.directoryList.removeAllElements();

		for (EDirectory directory : directories) {
			this.directoryList.addElement(directory.getName());
		}

		// set default selection
		this.setSelectedIndex(0);
		this.updateUI();
		return this.directories.get(0).getHyperLink();
	}

	public String getSelectedHyperLink() {
		// if NON-Selected
		if (this.getSelectedIndex() == -1) {
			return this.directories.get(0).getHyperLink();
		} else {
			return this.directories.get(this.getSelectedIndex()).getHyperLink();
		}

	}
}
