package team.nqnqmi.bean;

public class Categorys {
	private int category_id;// 类别ID
	private String category_name;// 类别名称

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public Categorys() {

	}

	public Categorys(int category_id, String category_name) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
	}

}
