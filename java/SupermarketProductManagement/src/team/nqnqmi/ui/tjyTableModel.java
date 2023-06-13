package team.nqnqmi.ui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import team.nqnqmi.bean.Record_item;

public class tjyTableModel extends AbstractTableModel {
	private String[] columnNames;// ���ͷ
	private ArrayList<Record_item> reade = null;

	public ArrayList<Record_item> getReade() {
		return reade;
	}

	public void setReade(ArrayList<Record_item> reade) {
		this.reade = reade;
	}

	public tjyTableModel(ArrayList<Record_item> reade) {

		this.columnNames = new String[] { "���߱��", "��������", "��Ʒ���", "����", "���ʱ��", "����ʱ��" };
		this.reade = reade;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return reade.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		String value = null;
		if (reade.size() > 0) {
			Record_item item = reade.get(arg0);
			switch (arg1) {
			case 0:// �����
				value = item.getReader_id();
				break;
			case 1:// �����
				value = item.getReader_name();
				break;
			case 2:// ������
				value = item.getproduct_id();
				break;
			case 3:// �����
				value = item.getproduct_name();
				break;
	
			case 4:// ������
				value = item.getBorrowing_time();
				break;
			case 5:// ������
				value = item.getReturn_time();
				break;
			default:
				value = "";
			}
		}
		return (Object) value;
	}

	public String getColumnName(int column) {
		return columnNames[column];
	}
}
