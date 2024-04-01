package ui.panels;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

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
		comboBoxPanel.setLayout(new BoxLayout(comboBoxPanel, BoxLayout.X_AXIS));
		this.campusComboBox = new DirectoryComboBox(this.selectionHandler);
		this.collegeComboBox = new DirectoryComboBox(this.selectionHandler);
		this.departmentComboBox = new DirectoryComboBox(this.selectionHandler);
		
		// set comboBox attributes
		this.campusComboBox.setBorder(new EmptyBorder(0, 5, 0, 5));
		this.collegeComboBox.setBorder(new EmptyBorder(0,  5, 0, 5));
		this.departmentComboBox.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		comboBoxPanel.add(Box.createHorizontalGlue());
		
		comboBoxPanel.add(campusComboBox);
		comboBoxPanel.add(collegeComboBox);
		comboBoxPanel.add(departmentComboBox);
		
		comboBoxPanel.add(Box.createHorizontalGlue());
		// --------------------------
		
		// ----- Lecture Panel -----
		JPanel lecturePanel = new JPanel();
		this.lectureTable = new LectureTable();
		
		JScrollPane scrollpane = new JScrollPane();
		this.lectureTable = new LectureTable();
		scrollpane.setViewportView(this.lectureTable);
		scrollpane.setPreferredSize(new Dimension(672, 300));
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
