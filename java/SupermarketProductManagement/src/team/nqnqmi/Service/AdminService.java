package team.nqnqmi.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import team.nqnqmi.bean.Admin;

public class AdminService extends BaseDao {

	// ͨ���û�ID��ȡ�û�
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

	// ���û����в�������
	public int AddAdmin(String adminName) {
		int results = 0;
		String sql = "INSERT INTO admin(admin_pwd) VALUES(?);";
		ArrayList params = new ArrayList();
		params.add(adminName);
		results = this.executeSQL(sql, params);
		return results;
	}

	// ��ѯadmin���һ�μ�������
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
