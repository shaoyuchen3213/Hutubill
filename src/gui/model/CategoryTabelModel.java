package gui.model;

import java.util.List;
 
import javax.swing.table.AbstractTableModel;

import entity.Category;
import service.CategoryService;

public class CategoryTabelModel extends AbstractTableModel{
	String []columnNames = new String[] {"分类名称","消费次数"};
	public List<Category> cs = new CategoryService().list();
	
	@Override
	public int getRowCount() {
		return cs.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return columnNames[columnIndex];
	}



	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Category h = cs.get(rowIndex);
		if(columnIndex == 0)
			return h.name;
		if(columnIndex == 1)
			return h.recordNumber;
		
		return null;
	}
	
}
