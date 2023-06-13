package team.nqnqmi.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import team.nqnqmi.bean.products;
import team.nqnqmi.bean.Record_item;

public class LendService extends BaseDao {

	// ����Ѿ����������
	public ArrayList<Record_item> getAllitem() {
		String sql = "SELECT i.reader_id,r.reader_name,i.products_id,b.products_name,i.borrowing_time,i.return_time  FROM record_item i JOIN products b on i.products_id=b.products_id JOIN reader r on i.reader_id=r.reader_id;";
		ArrayList params = new ArrayList();
		ResultSet rs = this.execute(sql, null);
//		System.out.println(rs);
		ArrayList<Record_item> re = new ArrayList<Record_item>();
		System.out.println(re);
		try {
			while (rs.next()) {
				Record_item r = new Record_item();
				r.setReader_id(rs.getString("i.reader_id"));
				
				System.out.println(rs.getString("i.reader_id"));
				
				r.setReader_name(rs.getString("r.reader_name"));
				r.setproduct_id(rs.getString("i.products_id"));
				r.setproduct_name(rs.getString("b.products_name"));
				r.setBorrowing_time(rs.getString("i.borrowing_time"));
				r.setReturn_time(rs.getString("i.return_time"));
				re.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;

	}

	// ͨ��id��ѯ�Ѿ��������Ʒ
	public Record_item getitembyReaderid(String id) {
		String sql = "SELECT i.reader_id,r.reader_name,i.products_id,b.products_name,i.borrowing_time,i.return_time  FROM\r\n"
				+ "record_item i  JOIN products b on i.products_id=b.products_id\r\n"
				+ "JOIN reader r on i.reader_id=r.reader_id\r\n" + "where r.reader_id=?;";
		ArrayList params = new ArrayList();
		params.add(id);
		ResultSet rs = this.execute(sql, params);
		Record_item r = null;
		try {
			while (rs.next()) {
				r = new Record_item();
				r.setReader_id(rs.getString("i.reader_id"));
				r.setReader_name(rs.getString("r.reader_name"));
				r.setproduct_id(rs.getString("i.products_id"));
				r.setproduct_name(rs.getString("b.products_name"));

				r.setBorrowing_time(rs.getString("i.borrowing_time"));
				r.setReturn_time(rs.getString("i.return_time"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

//������ƷID��ѯ�������Ʒ
	public Record_item getitembyproductid(String id) {
		String sql = "SELECT i.reader_id,r.reader_name,i.products_id,b.products_name,i.borrowing_time,i.return_time  FROM\r\n"
				+ "record_item i JOIN reader r on i.reader_id=r.reader_id\r\n"
				+ "JOIN products b on i.products_id=b.products_id\r\n" + "where b.products_id=?;\r\n" + "";
		ArrayList params = new ArrayList();
		params.add(id);
		ResultSet rs = this.execute(sql, params);
		Record_item r = null;
		try {
			while (rs.next()) {
				r = new Record_item();
				r.setReader_id(rs.getString("i.reader_id"));
				r.setReader_name(rs.getString("r.reader_name"));
				r.setproduct_id(rs.getString("i.products_id"));
				r.setproduct_name(rs.getString("b.products_name"));

				r.setBorrowing_time(rs.getString("i.borrowing_time"));
				r.setReturn_time(rs.getString("i.return_time"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	// ɾ��
	public int deleteLend(String id) {
		String sql = "delete from record_item where reader_id=?";
		ArrayList params = new ArrayList();
		params.add(id);
		int result = this.executeSQL(sql, params);
		return 0;
	}
}
