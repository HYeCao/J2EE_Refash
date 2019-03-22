package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import utils.DBHelper;
public class UserDAO {
	private UserDAO() {
	}
	
	public static UserDAO getInstance() {
		return new UserDAO();
	}
	
	public int logIn(String username,String password) {
		int type= -2;
		try {
			String passwd = "";
			String  per=" ";
			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select * from user_table where user_name = '" + username + "'";

			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next()) {
				passwd = rs.getString("user_password");	
				per=rs.getString("user_permission");
				
			}
			System.out.println(per);
//			System.out.println(password);
//			System.out.println(username);
			if(passwd.equals(password)) {
				//type = rs.getInt("type");
				if(per.equals("1"))	{
					return 1;//普通用户
					}
				else return 2;//管理员
				
			}
			else {
				return type;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return type;
	}
	
	public int register(String username,String password) {
		try {
			
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();//创建连接
			String passwd="";
			String sqlcheck = "select * from user_table where user_name = '" + username + "'";

			ResultSet rs = s.executeQuery(sqlcheck);
			
			if(!rs.next()) {
				
			String sql = "insert into user_table(user_name,user_password,user_permission) values(?,?,1)";			
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
	    	int flag = ps.executeUpdate();
			System.out.println(flag);
			if (flag > 0) {
				DBHelper.closeConnection(c, ps,null);
				System.out.print("1");
				return 1; //成功
			}
			else {
				DBHelper.closeConnection(c, ps,null);
				System.out.print("-1");
				return -1;//没有插入表格
			}
			
		    }
			
			else			
			{
				System.out.print("-2");
				return -2;//用户名重复
			}
		
		}
		catch(Exception e){
			e.printStackTrace();
		}


		return -1;
	}

	}