/**
 * 
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author wben 
 *
 */
public class DBHelper {
	public String url = "jdbc:mysql://localhost:3306/search?useUnicode=true&characterEncoding=UTF-8";
//	public String url = "jdbc:mysql://localhost/login?useUnicode=true&characterEncoding=UTF-8";
	public String username = "root";
	public String password = "root";
	public static DBHelper instance = null;

	// 闂侇偅淇虹换鍐濞嗘劧鎷锋担宄版暕闁活喕绀佸鈥斥枖閵娿儱鏂�闁轰胶澧楀畵浣规償閹剧儵鏀抽柛鏃戠厜缁辨繃绌卞┑濠勬婵炲鍔岄崬浠嬪矗椤忓懎鈷旈悶娑樺缁旀潙鈻庨敓锟�
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private DBHelper() {
	}

	/**
	 * 闁兼儳鍢茬欢杈╃尵鐠囪尙鏉藉〒姘炬嫹
	 * 
	 * @return
	 */
	public static DBHelper getInstance() {
		// 缂備焦鐟х悮顐﹀礉閻樼粯鏁�,闂傚啫寮堕娑氱棯鐠恒劉鏌ゆ鐐舵硾瑜帮拷
		synchronized (DBHelper.class) {
			if (instance == null) {
				instance = new DBHelper();
			}
		}
		return instance;
	}

	/**
	 * 闁兼儳鍢茬欢杈ㄦ交閻愭潙澶�
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	/**
	 * 闁稿繑濞婂Λ瀛樻交閻愭潙澶�
	 * 
	 * @param conn
	 * @param st
	 * @param rs
	 */
	public static void closeConnection(Connection conn, Statement st,
			ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
