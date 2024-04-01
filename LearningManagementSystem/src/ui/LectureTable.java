package ui;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

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
        String[] columnNames = { "Name", "Professor", "Credit", "Time", "Add Basket" };
        this.lectureModel = new DefaultTableModel(null, columnNames);
        this.setModel(lectureModel);

        // set cell renderer "Add Basket"
        TableColumn basketColumn = this.getColumnModel().getColumn(4);
        basketColumn.setCellRenderer(new BasketCellRenderer());

        this.addMouseListener(new BasketAddListener());

    }

    @Override
    public TableCellEditor getCellEditor(int row, int column) {
        // non-editable
        return null;
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
            row.add(""); // "Add Basket"
            this.lectureModel.addRow(row);
        }

        this.updateUI();
    }

    private class BasketCellRenderer extends JButton implements TableCellRenderer {

        public BasketCellRenderer() {
            setOpaque(true);
            setHorizontalAlignment(SwingConstants.CENTER);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(UIManager.getColor("Button.background"));
            }
            setText("Add");
            return this;
        }
    }

    private class BasketAddListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            int row = rowAtPoint(e.getPoint());
            int col = columnAtPoint(e.getPoint());
            // click "add" col
            if (col == 4) {
                ELecture lecture = lectures.get(row);
                // check add basket
                
            }
        }
    }
}
