package team.nqnqmi.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import team.nqnqmi.bean.products;

public class productsService extends BaseDao {

	/**
	 * ������е���Ʒ
	 * 
	 * @return
	 */
	public ArrayList<products> getAll() {

		String sql = "SELECT * FROM products";
		ResultSet rs = this.execute(sql, null);

		ArrayList<products> products = new ArrayList<>();
		try {
			while (rs.next()) {
				products product = new products();
				product.setproducts_id(rs.getInt("products_id"));
				product.setproducts_name(rs.getString("products_name"));
				product.setproducts_author(rs.getString("products_author"));
				product.setproducts_press(rs.getString("products_press"));
				product.setproducts_code(rs.getInt("products_code"));
				product.setCategory_id(rs.getInt("category_id"));
				product.setProducts_state(rs.getString("Products_state"));
				product.setproducts_price(rs.getInt("products_price"));
				product.setStock_Date(rs.getString("stock_Date"));

				System.out.println(rs.getString("stock_Date"));

				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products;

	}

//ͨ��������ѯ��Ʒ
	public products getproductsByproductsName(String name) {
		products product = null;
		String sql = "SELECT * FROM products WHERE products_name=?";
		ArrayList params = new ArrayList();
		params.add(name);
		ResultSet rs = this.execute(sql, params);

		try {
			while (rs.next()) {
				product = new products();
				product.setproducts_id(rs.getInt("products_id"));
				product.setproducts_name(rs.getString("products_name"));
				product.setproducts_author(rs.getString("products_author"));
				product.setproducts_press(rs.getString("products_press"));
				product.setproducts_code(rs.getInt("products_code"));
				product.setCategory_id(rs.getInt("category_id"));
				product.setProducts_state(rs.getString("Products_state"));
				product.setproducts_price(rs.getInt("products_price"));
				product.setStock_Date(rs.getString("stock_Date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return product;
	}

	// ͨ��code��ѯ��Ʒ
	public products getproductsBycode(int code) {
		products product = null;
		String sql = "SELECT * FROM products WHERE products_code=?";
		ArrayList params = new ArrayList();
		params.add(code);
		ResultSet rs = this.execute(sql, params);
		System.out.println("---" + rs);
		try {
			while (rs.next()) {
				product = new products();
				product.setproducts_id(rs.getInt("products_id"));
				product.setproducts_name(rs.getString("products_name"));
				product.setproducts_author(rs.getString("products_author"));
				product.setproducts_press(rs.getString("products_press"));
				product.setproducts_code(rs.getInt("products_code"));
				product.setCategory_id(rs.getInt("category_id"));
				product.setProducts_state(rs.getString("Products_state"));
				product.setproducts_price(rs.getInt("products_price"));
				product.setStock_Date(rs.getString("stock_Date"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return product;
	}

	// ���в������
	public int Addproducts(products product) {
		String sql = "INSERT INTO products(products_name,products_author,products_press,products_code,category_id,Products_state,products_price) VALUES(?,?,?,?,?,?,?)";
		ArrayList params = new ArrayList();
		params.add(product.getproducts_name());
		params.add(product.getproducts_author());
		params.add(product.getproducts_press());
		params.add(product.getproducts_code());
		params.add(product.getCategory_id());
		params.add(product.getProducts_state());
		params.add(product.getproducts_price());
		int result = this.executeSQL(sql, params);
		return result;
	}

	// ͨ�����ֽ����޸Ĳ���
	public int UpdateByproductName(products product) {
		String sql = "UPDATE products SET products_name=?,products_author=?,products_press=?,category_id=?,Products_state=?,products_price=? WHERE products_code=?;";
		ArrayList params = new ArrayList();
		params.add(product.getproducts_name());
		params.add(product.getproducts_author());
		params.add(product.getproducts_press());
		params.add(product.getCategory_id());
		params.add(product.getProducts_state());
		params.add(product.getproducts_price());
		params.add(product.getproducts_code());
		int result = this.executeSQL(sql, params);

		return result;

	}

	// ͨ��code�����޸Ĳ���
	public int UpdateByproductcode(products product) {
		String sql = "UPDATE products SET products_name=?,products_author=?,products_press=?,category_id=?,Products_state=?,products_price=? WHERE products_code=?;";
		ArrayList params = new ArrayList();
		params.add(product.getproducts_name());
		params.add(product.getproducts_author());
		params.add(product.getproducts_press());
		params.add(product.getCategory_id());
		params.add(product.getProducts_state());
		params.add(product.getproducts_price());
		params.add(product.getproducts_code());
		int result = this.executeSQL(sql, params);

		return result;

	}

	/**
	 * ɾ����Ʒͨ����Ʒ����
	 * 
	 * @param ɾ����Ʒ
	 * @return ��Ӱ�����Ʒ
	 */
	public int deleteproduct(String productName) {
		String sql = "DELETE FROM products WHERE products_name=?";
		ArrayList params = new ArrayList();
		params.add(productName);
		int result = this.executeSQL(sql, params);
		return result;
	}

	/**
	 * ɾ����Ʒͨ����Ʒ����
	 * 
	 * @param ɾ����Ʒ
	 * @return ��Ӱ�����Ʒ����
	 */
	public int deleteproduct(int productcode) {
		String sql = "DELETE FROM products WHERE products_code=?";
		ArrayList params = new ArrayList();
		params.add(productcode);
		int result = this.executeSQL(sql, params);
		return result;
	}

	// ͨ����Ʒ���ֽ��н���
	public int lendByproductsName(String productName) {
		String sql = "UPDATE products SET Products_state=? WHERE products_code=?;";
		ArrayList params = new ArrayList();

		int result = this.executeSQL(sql, params);

		return result;

	}

	// ͨ��coded����Ʒ���н���
	public int lendByproductscode(products product) {
		String sql = "UPDATE products SET products_name=?,products_author=?,products_press=?,category_id=?,Products_state=?,products_price=? WHERE products_code=?;";
		ArrayList params = new ArrayList();
		params.add(product.getproducts_name());
		params.add(product.getproducts_author());
		params.add(product.getproducts_press());
		params.add(product.getCategory_id());
		params.add(product.getProducts_state());
		params.add(product.getproducts_price());
		params.add(product.getproducts_code());
		int result = this.executeSQL(sql, params);

		return result;

	}

	// ���������Ʒͬʱ�����Ʒ���
	public ArrayList<products> getAllAndCategoryName() {

		String sql = "SELECT products_id ,products_name ,products_press , products_code , c.category_name ,products_price,stock_Date FROM products b JOIN category c ON b.category_id=c.category_id;";
		ResultSet rs = this.execute(sql, null);

		ArrayList<products> products = new ArrayList<>();
		try {
			while (rs.next()) {
				products product = new products();
				product.setproducts_id(rs.getInt("products_id"));
				product.setproducts_name(rs.getString("products_name"));
				product.setproducts_author(rs.getString("products_author"));
				product.setproducts_press(rs.getString("products_press"));
				product.setproducts_code(rs.getInt("products_code"));
				product.setCategory_id(rs.getInt("category_id"));
				product.setProducts_state(rs.getString("Products_state"));
				product.setproducts_price(rs.getInt("products_price"));
				product.setStock_Date(rs.getString("stock_Date"));

				System.out.println(rs.getString("stock_Date"));

				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products;

	}

}
