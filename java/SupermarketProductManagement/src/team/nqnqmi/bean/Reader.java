package team.nqnqmi.bean;

public class Reader {
	private String reader_id;// ���߱��
	private String reader_name;// ��������
	private String birthday;// ��������
	private String address;// ��ַ
	private String sex;// �Ա�
	private String reader_pwd;// ����

	public String getReader_id() {
		return reader_id;
	}

	public void setReader_id(String reader_id) {
		this.reader_id = reader_id;
	}

	public String getReader_name() {
		return reader_name;
	}

	public void setReader_name(String reader_name) {
		this.reader_name = reader_name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getReader_pwd() {
		return reader_pwd;
	}

	public void setReader_pwd(String reader_pwd) {
		this.reader_pwd = reader_pwd;
	}

	public Reader() {

	}

	public Reader(String reader_id, String reader_name, String birthday, String address, String sex,
			String reader_pwd) {
		super();
		this.reader_id = reader_id;
		this.reader_name = reader_name;
		this.birthday = birthday;
		this.address = address;
		this.sex = sex;
		this.reader_pwd = reader_pwd;

	}

}
