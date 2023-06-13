package team.nqnqmi.ui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import team.nqnqmi.bean.products;

public class productTableModel extends AbstractTableModel {

	private String[] columnNames = null;// ���ͷ

	private ArrayList<products> products = null; // �����

	public String[] getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}

	public productTableModel(ArrayList<products> products) {
		this.columnNames = new String[] { "��Ʒ���", "��Ʒ����", "��Ʒ����", "������", "code", "��Ʒ����", "��Ʒ״̬", "��Ʒ�۸�", "���ʱ��" };
		this.products = products;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String value = null;
		if (products.size() > 0) {
			products product = products.get(rowIndex);
			switch (columnIndex) {
			case 0:// �����
				value = String.valueOf(product.getproducts_id());
				break;
			case 1:// ������
				value = product.getproducts_name();
				break;
			case 2:// ������
				value = product.getproducts_author();
				break;
			case 3:// ��������
				value = product.getproducts_press();
				break;
			case 4:// code��
				value = String.valueOf(product.getproducts_code());
				break;
			case 5: // �����
				value = String.valueOf(product.getCategory_id());
				break;
			case 6:// ״̬��
				value = product.getProducts_state();
				break;
			case 7: // �۸�
				value = String.valueOf(product.getproducts_price());
				break;
			case 8: // ʱ��
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
		// ����ģ���е�������
		return products.size();
	}

	@Override
	public int getColumnCount() {
		// ����ģ���е�������
		return columnNames.length;
	}

	/**
	 * ȡָ���е�����
	 * 
	 * @param column
	 * @return
	 */
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

}
