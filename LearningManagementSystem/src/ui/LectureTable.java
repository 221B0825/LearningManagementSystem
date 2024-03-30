package ui;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.CLecture;
import entity.ELecture;

public class LectureTable extends JTable {

	// service
	private CLecture cLecture;

	// real data
	private Vector<ELecture> lectures;

	// table model
	private DefaultTableModel lectureModel;

	public LectureTable() {
		// set service
		this.cLecture = new CLecture();

		// set table model
		String[] columnNames = { "Name", "Professor", "Credit", "Time" };
		this.lectureModel = new DefaultTableModel(null, columnNames);
		this.setModel(lectureModel);
	}

	public void refresh(String path) {
		// get row data
		this.lectures = this.cLecture.getItems(path);
		
		// clear
		this.lectureModel.setRowCount(0);
		
		// Edit row data
		for (ELecture lecture : this.lectures) {
			Vector<String> row = new Vector<String>();
			row.add(lecture.getName());
			row.add(lecture.getProfessorName());
			row.add(lecture.getCredit());
			row.add(lecture.getTime());
			this.lectureModel.addRow(row);
		}
		
		this.updateUI();
	}
}
