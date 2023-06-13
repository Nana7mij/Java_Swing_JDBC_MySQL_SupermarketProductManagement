package team.nqnqmi.bean;

public class products {
	private int products_id;// 编号
	private String products_name;// 书名
	private String products_author;// 作者
	private String products_press;// 出版社
	private int products_code;// code
	private int category_id;// 种类
	private String Products_state;// 状态
	private int products_price;// 价格
	private String stock_Date;// 时间

	public int getproducts_id() {
		return products_id;
	}

	public void setproducts_id(int products_id) {
		this.products_id = products_id;
	}

	public String getproducts_name() {
		return products_name;
	}

	public void setproducts_name(String products_name) {
		this.products_name = products_name;
	}

	public String getproducts_author() {
		return products_author;
	}

	public void setproducts_author(String products_author) {
		this.products_author = products_author;
	}

	public String getproducts_press() {
		return products_press;
	}

	public void setproducts_press(String products_press) {
		this.products_press = products_press;
	}

	public int getproducts_code() {
		return products_code;
	}

	public void setproducts_code(int products_code) {
		this.products_code = products_code;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getProducts_state() {
		return Products_state;
	}

	public void setProducts_state(String Products_state) {
		this.Products_state = Products_state;
	}

	public int getproducts_price() {
		return products_price;
	}

	public void setproducts_price(int products_price) {
		this.products_price = products_price;
	}

	public String getStock_Date() {
		return stock_Date;
	}

	public void setStock_Date(String stock_Date) {
		this.stock_Date = stock_Date;
	}

	public products() {

	}

	public products(int products_id, String products_name, String products_author, String products_press, int products_code,
			int category_id, String Products_state, int products_price, String stock_Date) {
		this.products_id = products_id;
		this.products_name = products_name;
		this.products_author = products_author;
		this.products_press = products_press;
		this.products_code = products_code;
		this.category_id = category_id;
		this.Products_state = Products_state;
		this.products_price = products_price;
		this.stock_Date = stock_Date;
	}

//不带ID和事件的构造方法
	public products(String products_name, String products_author, String products_press, int products_code, int category_id,
			String Products_state, int products_price) {
		this.products_name = products_name;
		this.products_author = products_author;
		this.products_press = products_press;
		this.products_code = products_code;
		this.category_id = category_id;
		this.Products_state = Products_state;
		this.products_price = products_price;
	}

}
