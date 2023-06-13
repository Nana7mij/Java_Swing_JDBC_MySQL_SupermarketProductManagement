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

	// ��������
	public Connection getConn() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);

		return conn;
	}

	// �ͷ���Դ
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

//	ִ�в�ѯ���
	public ResultSet execute(String sql, ArrayList params) {
		rs = null;
		ps = null;
		try {
			conn = this.getConn();
			// ����Ԥ�����������
			ps = conn.prepareStatement(sql);
			// ���ݴ��ε���������ã���ֵ ,pstat.setXXX()
			if (params != null) {
				int i = 0;
				for (Object param : params) {
					// ���ݲ��������ͷֱ���д���
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
			// ִ��SQL
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
	 * ִ��SQL�еĲ��롢�޸ĺ�ɾ��������������Ӱ�������
	 */
	public int upDate(String sql, ArrayList params) {
		ps = null;// ���Ԥ�����SQL����
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
	 * ִ��SQL�еĲ��롢�޸ĺ�ɾ��������������Ӱ�������
	 */
	public int executeSQL(String sql, ArrayList params) {
		ps = null;
		int num = 0;
		try {
			conn = this.getConn();
			// ����Ԥ�����������
			ps = conn.prepareStatement(sql);
			// ���ݴ��ε���������ã���ֵ ,pstat.setXXX()
			if (params != null) {
				int i = 0;
				for (Object param : params) {
					// ���ݲ��������ͷֱ���д���
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
			// ִ��SQL
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
