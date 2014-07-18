package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.management.Query;

import org.hibernate.Session;

import paqeteEntity.Usuarios;

import com.opensymphony.xwork2.ActionSupport;

import tools.*;

public class LoginDao {
	public static boolean validate(String name, String pass) {		
//		boolean status = false;
//		Connection conn = null;
//		PreparedStatement pst = null;
//		ResultSet rs = null;
//		String passmd5;
//
//		String url = "jdbc:mysql://localhost:3306/";
//		String dbName = "episunsa_gradesTracker";
//		String driver = "com.mysql.jdbc.Driver";
//		String userName = "root";
//		String password = "root";
//		try {
//			passmd5 =MD5Encryption.getMD5(pass);
//			System.out.println(passmd5);
//			
//			Class.forName(driver).newInstance();
//			conn = DriverManager
//					.getConnection(url + dbName, userName, password);
//
//			pst = conn
//					.prepareStatement("select * from usuarios where username=? and password=?");
//			pst.setString(1, name);
//			pst.setString(2, passmd5);
//
//			rs = pst.executeQuery();
//			status = rs.next();
//
//		} catch (Exception e) {
//			System.out.println(e);
//		} finally {
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (pst != null) {
//				try {
//					pst.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return status;
		Session session = HibernateUtil.getsesSessionFactory().openSession();
		
		String SQL_QUERY = " select u from Usuarios u where u.username = '"+name+"' and u.password = '"+
		pass + "'";
		System.out.println(SQL_QUERY);
		org.hibernate.Query query = session.createQuery(SQL_QUERY);
		Iterator<Usuarios> it = query.iterate();
		List<Usuarios> list = query.list();
		if(list.size()> 0){
			session.close();
			return true;
		}
		session.close();
		return false;
	
	}
}