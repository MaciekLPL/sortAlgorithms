package pl.lejczak.project.view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Maciek
 */
class CustomTableModel extends AbstractTableModel {

        private ArrayList<String> orgNumbers;
        private ArrayList<ArrayList<Integer>> data;
        
        CustomTableModel() {
            orgNumbers = new ArrayList<>();
            data = new ArrayList<>();
        }
        
        @Override
        public int getColumnCount() {
            return orgNumbers.size();
        }
		
        @Override
        public int getRowCount() {
            return data.size();
        }
        
        public void setColumns(ArrayList<Integer> array) {
            for (Integer i : array){
                orgNumbers.add(i.toString());
            }
        }
        
        public void addRow(ArrayList<Integer> array) {
            
            data.add(new ArrayList<>(array));
            int row = data.indexOf(array);
            fireTableRowsInserted(row, row);
            
        }

        @Override
        public String getColumnName(int col) {
            return orgNumbers.get(col);
        }


        @Override
        public Object getValueAt(int row, int col) {
            return data.get(row).get(col);
        }

        @Override
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            return false;
        }

        public void setValueAt(Integer value, int row, int col) {

            data.get(row).set(col, value);
            fireTableCellUpdated(row, col);
        }
}
