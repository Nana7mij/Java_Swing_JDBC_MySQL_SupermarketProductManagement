package team.nqnqmi.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import team.nqnqmi.bean.Categorys;

public class CategoryService extends BaseDao {

	// 获得所有的类别
	public ArrayList<Categorys> getAll() {
		String sql = "SELECT * FROM category";

		ResultSet rs = this.execute(sql, null);

		ArrayList<Categorys> category = new ArrayList<>();
		try {
			while (rs.next()) {
				Categorys cg = new Categorys();
				cg.setCategory_id(rs.getInt("category_id"));
				cg.setCategory_name(rs.getString("category_name"));
				category.add(cg);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return category;
	}

}
