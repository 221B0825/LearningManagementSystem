package ui.panels;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JPanel;

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
		this.selectionHandler = new SelectionHandler();
		
		this.campusComboBox = new DirectoryComboBox(this.selectionHandler);
		this.collegeComboBox = new DirectoryComboBox(this.selectionHandler);
		this.departmentComboBox = new DirectoryComboBox(this.selectionHandler);
		this.lectureTable = new LectureTable();
	
		this.add(campusComboBox);		
		this.add(collegeComboBox);
		this.add(departmentComboBox);
		
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
			}else if(source == campusComboBox) {
				String hyperLink = campusComboBox.getSelectedHyperLink();
				hyperLink = collegeComboBox.refresh(Path.DATA_LECTURE.getPath()+hyperLink+".txt");
				hyperLink = departmentComboBox.refresh(Path.DATA_LECTURE.getPath()+hyperLink+".txt");
			}else if(source == collegeComboBox) {
				String hyperLink = collegeComboBox.getSelectedHyperLink();
				hyperLink = departmentComboBox.refresh(Path.DATA_LECTURE.getPath()+hyperLink+".txt");
			}
		}

		
	}
}
