package team.nqnqmi.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BaseDao {

	ResourceBundle rb = ResourceBundle.getBundle("jdbc");

	String driver = rb.getString("Driver");
	String url = rb.getString("url");
	String user = rb.getString("user");
	String password = rb.getString("password");

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	// 建立连接
	public Connection getConn() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);

		return conn;
	}

	// 释放资源
	public void closeAll() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

//	执行查询语句
	public ResultSet execute(String sql, ArrayList params) {
		rs = null;
		ps = null;
		try {
			conn = this.getConn();
			// 创建预编译的语句对象
			ps = conn.prepareStatement(sql);
			// 根据传参的情况，设置？的值 ,pstat.setXXX()
			if (params != null) {
				int i = 0;
				for (Object param : params) {
					// 根据参数的类型分别进行处理
					if (param instanceof Integer) {
						ps.setInt(++i, ((Integer) param).intValue());
					} else if (param instanceof Double) {
						ps.setDouble(++i, ((Double) param).doubleValue());
					} else if (param instanceof String) {
						ps.setString(++i, param.toString());
					} else if (param instanceof Boolean) {
						ps.setBoolean(++i, ((Boolean) param).booleanValue());
					}
				}
			}
			// 执行SQL
			rs = ps.executeQuery();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// this.closeAll();
		}
		return rs;
	}

	/*
	 * 执行SQL中的插入、修改和删除操作，返回受影响的行数
	 */
	public int upDate(String sql, ArrayList params) {
		ps = null;// 获得预编译的SQL对象
		int num = 0;
		try {
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			if (params != null) {
				int i = 0;
				for (Object param : params) {
					if (param instanceof Integer) {
						ps.setInt(++i, ((Integer) param).intValue());
					} else if (param instanceof String) {
						ps.setString(++i, param.toString());
					} else if (param instanceof Double) {
						ps.setDouble(1, ((Double) param).doubleValue());
					}

				}
				num = ps.executeUpdate();

			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return num;
	}

	/*
	 * 执行SQL中的插入、修改和删除操作，返回受影响的行数
	 */
	public int executeSQL(String sql, ArrayList params) {
		ps = null;
		int num = 0;
		try {
			conn = this.getConn();
			// 创建预编译的语句对象
			ps = conn.prepareStatement(sql);
			// 根据传参的情况，设置？的值 ,pstat.setXXX()
			if (params != null) {
				int i = 0;
				for (Object param : params) {
					// 根据参数的类型分别进行处理
					if (param instanceof Integer) {
						ps.setInt(++i, ((Integer) param).intValue());
					} else if (param instanceof Double) {
						ps.setDouble(++i, ((Double) param).doubleValue());
					} else if (param instanceof String) {
						ps.setString(++i, param.toString());
					} else if (param instanceof Boolean) {
						ps.setBoolean(++i, ((Boolean) param).booleanValue());
					}
				}
			}
			// 执行SQL
			num = ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return num;
	}

}
