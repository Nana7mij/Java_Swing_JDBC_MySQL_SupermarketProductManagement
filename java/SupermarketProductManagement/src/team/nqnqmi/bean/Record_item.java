package team.nqnqmi.bean;

public class Record_item {
	
	private String reader_id;
	private String reader_name;
	private String product_id;
	private String product_name;
	private String Record_number;
	private String borrowing_time;
	private String return_time;

	public String getReader_name() {
		return reader_name;
	}

	public void setReader_name(String reader_name) {
		this.reader_name = reader_name;
	}

	public String getproduct_name() {
		return product_name;
	}

	public void setproduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getReader_id() {
		return reader_id;
	}

	public void setReader_id(String reader_id) {
		this.reader_id = reader_id;
	}

	public String getproduct_id() {
		return product_id;
	}

	public void setproduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getRecord_number() {
		return Record_number;
	}

	public void setRecord_number(String record_number) {
		Record_number = record_number;
	}

	public String getBorrowing_time() {
		return borrowing_time;
	}

	public void setBorrowing_time(String borrowing_time) {
		this.borrowing_time = borrowing_time;
	}

	public String getReturn_time() {
		return return_time;
	}

	public void setReturn_time(String return_time) {
		this.return_time = return_time;
	}

	public Record_item() {
	}

	public Record_item(String reader_id, String reader_name, String product_id, String product_name, String record_number,
			String borrowing_time, String return_time) {
		super();
		this.reader_id = reader_id;
		this.reader_name = reader_name;
		this.product_id = product_id;
		this.product_name = product_name;
		Record_number = record_number;
		this.borrowing_time = borrowing_time;
		this.return_time = return_time;
	}

}
