package team.nqnqmi.Service;


import java.awt.print.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale.Category;

import team.nqnqmi.bean.Admin;
import team.nqnqmi.bean.Reader;
 
public class UserService extends BaseDao{
         //数据读者的插入
	public int addReader(Reader r) {
		String sql="insert into reader(reader_id,reader_name,birthday,address,sex,reader_pwd) values(?,?,?,?,?,?)";
		ArrayList params=new ArrayList();
		params.add(r.getReader_id());
		params.add(r.getReader_name());
		params.add(r.getBirthday());
		params.add(r.getAddress());
		params.add(r.getSex());
		params.add(r.getReader_pwd());
		int result=this.executeSQL(sql, params);
		return result;	
	}

	//根据id查读者
	public Reader getAllreader(String id) {
		String sql="select * from reader where reader_id=?";
		ArrayList params=new ArrayList();
		params.add(id);
		ResultSet rs= this.execute(sql, params);
		Reader red=null;
		try {
			while(rs.next()) {
			   red=new Reader();
			   red.setReader_id(rs.getString("reader_id"));
			   red.setReader_name(rs.getString("reader_name"));
			   red.setBirthday(rs.getString("birthday"));
			   red.setAddress(rs.getString("address"));
			   red.setSex(rs.getString("sex"));
			   red.setReader_pwd(rs.getString("reader_pwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return red;
	}

	//根据姓名查询用户
		public  ArrayList<Reader> getReaderByName(String name) {
			String sql="select * from reader where reader_name=?";
			ArrayList params=new ArrayList();
			params.add(name);
			ResultSet rs=this.execute(sql, params);
			ArrayList<Reader> re2=new ArrayList<Reader>();
			Reader reader=null;
			try {
				while(rs.next()) {
					reader=new Reader();
					reader.setReader_id(rs.getString("reader_id"));
					reader.setReader_name(rs.getString("reader_name"));
					reader.setBirthday(rs.getString("birthday"));
					reader.setAddress(rs.getString("address"));
					reader.setSex(rs.getString("sex"));
					reader.setReader_pwd(rs.getString("reader_pwd"));
					re2.add(reader);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return re2;
	 	}
		
	//查询全部用户
	public ArrayList<Reader> getAllreader() {
		String sql="select * from reader";
		ResultSet rs= this.execute(sql, null);
		ArrayList<Reader> reade=new ArrayList<Reader>();
		try {
			while(rs.next()) {
				Reader r=new Reader();
				r.setReader_id(rs.getString("reader_id"));
				 r.setReader_name(rs.getString("reader_name"));
				  r.setBirthday(rs.getString("birthday"));
				 r.setAddress(rs.getString("address"));
				 r.setSex(rs.getString("sex"));
 				 r.setReader_pwd(rs.getString("reader_pwd"));
				 reade.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reade;
		
	}
 

	  //删除用户
		public int deleteUser(String id) {
			String sql="delete from reader where reader_id=?";
			ArrayList params=new ArrayList();
			params.add(id);
			int result=this.executeSQL(sql, params);
			return 0;
	 	}
		//修改用户信息
		public int updateuser(Reader re) {
			String sql="update reader set reader_name=?,birthday=?,address=?,sex=?,reader_pwd=? where reader_id=?";
			ArrayList params=new ArrayList();	 
			params.add(re.getReader_name());
			params.add(re.getBirthday());
			params.add(re.getAddress());
			params.add(re.getSex()); 
			params.add(re.getReader_pwd());
			params.add(re.getReader_id());
			int result=this.executeSQL(sql, params);
			return result;		
		}
		 
		 
}
