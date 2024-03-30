package ui.panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.GregorianCalendar;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import domain.Path;
import ui.DirectoryComboBox;
import ui.LectureTable;

public class DirectoryPanel extends JPanel {
	
	private SelectionHandler selectionHandler;
	
	private DirectoryComboBox campusComboBox;
	private DirectoryComboBox collegeComboBox;
	private DirectoryComboBox departmentComboBox;
	private LectureTable lectureTable;
	
	public DirectoryPanel() {
		
		// set attribute
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// set eventHandler
		this.selectionHandler = new SelectionHandler();
		
		// ----- ComboBox Panel -----
		JPanel comboBoxPanel = new JPanel();
		this.campusComboBox = new DirectoryComboBox(this.selectionHandler);
		this.collegeComboBox = new DirectoryComboBox(this.selectionHandler);
		this.departmentComboBox = new DirectoryComboBox(this.selectionHandler);
		
		comboBoxPanel.add(campusComboBox);
		comboBoxPanel.add(collegeComboBox);
		comboBoxPanel.add(departmentComboBox);
		// --------------------------
		
		// ----- Lecture Panel -----
		JPanel lecturePanel = new JPanel();
		this.lectureTable = new LectureTable();
		
		JScrollPane scrollpane = new JScrollPane();
		this.lectureTable = new LectureTable();
		scrollpane.setViewportView(this.lectureTable);
	
		lecturePanel.add(scrollpane);
		// -------------------------
		
		this.add(comboBoxPanel);
		this.add(lecturePanel);
		
		// refresh init
		this.selectionHandler.refresh(null);
	}
	
	public class SelectionHandler implements ItemListener{
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			refresh(e.getSource());			
		}

		private void refresh(Object source) {
			if(source == null) {
				String hyperLink = campusComboBox.refresh(Path.DATA_ROOT.getPath());
				hyperLink = collegeComboBox.refresh(Path.DATA_LECTURE.getPath()+hyperLink+".txt");
				hyperLink = departmentComboBox.refresh(Path.DATA_LECTURE.getPath()+hyperLink+".txt");
				lectureTable.refresh(Path.DATA_LECTURE.getPath()+hyperLink+".txt");
			}else if(source == campusComboBox) {
				String hyperLink = campusComboBox.getSelectedHyperLink();
				hyperLink = collegeComboBox.refresh(Path.DATA_LECTURE.getPath()+hyperLink+".txt");
				hyperLink = departmentComboBox.refresh(Path.DATA_LECTURE.getPath()+hyperLink+".txt");
				lectureTable.refresh(Path.DATA_LECTURE.getPath()+hyperLink+".txt");
			}else if(source == collegeComboBox) {
				String hyperLink = collegeComboBox.getSelectedHyperLink();
				hyperLink = departmentComboBox.refresh(Path.DATA_LECTURE.getPath()+hyperLink+".txt");
				lectureTable.refresh(Path.DATA_LECTURE.getPath()+hyperLink+".txt");
			}else if(source == departmentComboBox) {
				String hyperLink = departmentComboBox.getSelectedHyperLink();
				lectureTable.refresh(Path.DATA_LECTURE.getPath()+hyperLink+".txt");
			}
		}

		
	}
}
