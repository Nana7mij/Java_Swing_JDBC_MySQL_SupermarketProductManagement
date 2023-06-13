package team.nqnqmi.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import team.nqnqmi.bean.Admin;

public class AdminService extends BaseDao {

	// 通过用户ID获取用户
	public Admin getAdminByid(int id) {
		Admin admin1 = null;
		String sql = "SELECT * FROM admin WHERE admin_id=?";
		ArrayList params = new ArrayList();
		params.add(id);
		ResultSet rs = this.execute(sql, params);

		try {
			while (rs.next()) {
				admin1 = new Admin();
				admin1.setAdmin_id(rs.getInt("admin_id"));
				admin1.setAdmin_pwd(rs.getString("admin_pwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return admin1;
	}

	// 向用户表中插入数据
	public int AddAdmin(String adminName) {
		int results = 0;
		String sql = "INSERT INTO admin(admin_pwd) VALUES(?);";
		ArrayList params = new ArrayList();
		params.add(adminName);
		results = this.executeSQL(sql, params);
		return results;
	}

	// 查询admin最后一次加入的语句
	public Admin getLastAdmin_id() {
		String sql = "SELECT * FROM admin ORDER BY admin_id DESC LIMIT 1;";
		Admin admin = null;
		ResultSet rs = this.execute(sql, null);

		try {
			while (rs.next()) {
				admin = new Admin();
				admin.setAdmin_id(rs.getInt("admin_id"));
				admin.setAdmin_pwd(rs.getString("admin_pwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;

	}

}
