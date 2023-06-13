package team.nqnqmi.ui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import team.nqnqmi.bean.Reader;

public class UserTableModel extends AbstractTableModel {
	private String[] columnNames;// ���ͷ
	private ArrayList<Reader> reader = null;

	public String[] getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}

	public ArrayList<Reader> getReader() {
		return reader;
	}

	public void setReader(ArrayList<Reader> reader) {
		this.reader = reader;
	}

	public UserTableModel(ArrayList<Reader> reader) {
		this.columnNames = new String[] { "���", "����", "����", "��ַ", "�Ա�", "����" };
		this.reader = reader;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return reader.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		String value = null;
		if (reader.size() > 0) {
			Reader red = reader.get(arg0);
			switch (arg1) {
			case 0:// �����
				value = red.getReader_id();
				break;
			case 1:// ������
				value = red.getReader_name();
				break;
			case 2:// ������
				value = red.getBirthday();
				break;
			case 3:// ��ַ��
				value = red.getAddress();
				break;
			case 4: // �Ա���
				value = red.getSex();
				break;
			case 5: // ְλ��
				value = red.getReader_pwd();
				break;

			default:
				value = "";
			}
		}
		return (Object) value;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
}
