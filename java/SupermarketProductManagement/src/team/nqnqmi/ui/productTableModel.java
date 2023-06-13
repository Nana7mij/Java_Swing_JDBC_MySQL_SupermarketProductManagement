package team.nqnqmi.ui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import team.nqnqmi.bean.products;

public class productTableModel extends AbstractTableModel {

	private String[] columnNames = null;// 表格头

	private ArrayList<products> products = null; // 表格体

	public String[] getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}

	public productTableModel(ArrayList<products> products) {
		this.columnNames = new String[] { "商品编号", "商品名称", "商品作者", "出版社", "code", "商品种类", "商品状态", "商品价格", "入库时间" };
		this.products = products;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String value = null;
		if (products.size() > 0) {
			products product = products.get(rowIndex);
			switch (columnIndex) {
			case 0:// 编号列
				value = String.valueOf(product.getproducts_id());
				break;
			case 1:// 书名列
				value = product.getproducts_name();
				break;
			case 2:// 作者列
				value = product.getproducts_author();
				break;
			case 3:// 出版社列
				value = product.getproducts_press();
				break;
			case 4:// code列
				value = String.valueOf(product.getproducts_code());
				break;
			case 5: // 类别列
				value = String.valueOf(product.getCategory_id());
				break;
			case 6:// 状态类
				value = product.getProducts_state();
				break;
			case 7: // 价格
				value = String.valueOf(product.getproducts_price());
				break;
			case 8: // 时间
				value = product.getStock_Date();
				break;
			default:
				value = "";
			}
		}
		return (Object) value;
	}

	@Override
	public int getRowCount() {
		// 返回模型中的行数。
		return products.size();
	}

	@Override
	public int getColumnCount() {
		// 返回模型中的列数。
		return columnNames.length;
	}

	/**
	 * 取指定列的列名
	 * 
	 * @param column
	 * @return
	 */
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

}
