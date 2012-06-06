package window;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

class MyTableModel extends AbstractTableModel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8153734387717482523L;
	private ArrayList<String> columnNames;
    private ArrayList<ArrayList<Object>> data;


    public MyTableModel(ArrayList<ArrayList<Object>> data, ArrayList<String> columnNames) {
    	this.columnNames = columnNames;
    	this.data = data;
    }
    
    public int getColumnCount() {
        return columnNames.size();
    }

    public int getRowCount() {
        return data.size();
    }

    public String getColumnName(int col) {
        return columnNames.get(col);
    }

    public Object getValueAt(int row, int col) {
        return data.get(row).get(col);
    }

    public Class<?> getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }

	public void clear() {
		data.clear();
		columnNames.clear();
		fireTableDataChanged();
		fireTableStructureChanged();
	}
}
