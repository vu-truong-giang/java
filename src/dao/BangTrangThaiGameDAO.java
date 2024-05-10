package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.BangTrangThaiGame;

public class BangTrangThaiGameDAO implements DAOInterface<BangTrangThaiGame>{

	public static BangTrangThaiGameDAO getInstance() {
		return new BangTrangThaiGameDAO();
	}
	
	@Override
	public int insert(BangTrangThaiGame t) {
		
		int KetQua = 0;
		
		try {
			Connection con = JDBCUtil.getConnection();
			
			Statement st = con.createStatement();
			
			String sql = "INSERT INTO BangTrangThaiGame(Id_TrangThaiGame , Map , Ran ,Nhac , AmThanh) " +
			             "VALUES ('"+t.getId_TrangThaiGame()+"' , '"+t.getMap()+"' , '"+t.getRan()+"' , '"+t.getNhac()+"' , '"+t.getAmThanh()+"')";
			
			KetQua = st.executeUpdate(sql);
			
			System.out.println("Bạn đã thực thi :" + sql);
			System.out.println("Có " + KetQua + " dòng bị thay đổi.");
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BangTrangThaiGame t) {
		
		
		
		try {
			Connection con = JDBCUtil.getConnection();
			
			Statement st = con.createStatement();
			
			String sql = "UPDATE BangTrangThaiGame " +
			             "SET " +
					     "Id_TrangThaiGame = '"+t.getId_TrangThaiGame()+ "', " +
			             "Map = '"+t.getMap()+"', " +
					     "Ran = '"+t.getRan()+"', " +
			             "Nhac = '"+t.getNhac()+"', " +
					     "AmThanh = '"+t.getAmThanh()+"'";
			
			
			
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void updateMusicToDatabase(String nameuser, float currentVolume) {
	    try {
	        Connection con = JDBCUtil.getConnection();
	        
	        PreparedStatement ps = con.prepareStatement("UPDATE BangTrangThaiGame "
	                + "SET Nhac = ? "
	                + "WHERE Id_TrangThaiGame IN ("
	                + "    SELECT BangNguoiChoi.Id_TrangThaiGame "
	                + "    FROM BangNguoiChoi "
	                + "    JOIN BangNguoiDung ON BangNguoiDung.Id_NguoiDung = BangNguoiChoi.Id_NguoiDung "
	                + "    WHERE BangNguoiDung.TenDangNhap = ?)");
	        
	        ps.setFloat(1, currentVolume); // Thiết lập giá trị cho tham số ?
	        ps.setString(2, nameuser); // Thiết lập giá trị cho tham số ?
	        
	        int rowsAffected = ps.executeUpdate(); // Thực thi câu lệnh và lấy số hàng bị ảnh hưởng
	        
	        System.out.println("Number of rows affected: " + rowsAffected); // In số hàng bị ảnh hưởng
	        
	        JDBCUtil.closePreparedStatement(ps);
	        JDBCUtil.closeConnection(con);
	        
	        System.out.println("Update completed.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void updateVoiceToDatabase(String nameuser, int newMusicValue) {
	    try {
	        Connection con = JDBCUtil.getConnection();
	        
	        PreparedStatement ps = con.prepareStatement("UPDATE BangTrangThaiGame "
	                + "SET AmThanh = ? "
	                + "WHERE Id_TrangThaiGame IN ("
	                + "    SELECT BangNguoiChoi.Id_TrangThaiGame "
	                + "    FROM BangNguoiChoi "
	                + "    JOIN BangNguoiDung ON BangNguoiDung.Id_NguoiDung = BangNguoiChoi.Id_NguoiDung "
	                + "    WHERE BangNguoiDung.TenDangNhap = ?)");
	        
	        ps.setInt(1, newMusicValue); // Thiết lập giá trị cho tham số ?
	        ps.setString(2, nameuser); // Thiết lập giá trị cho tham số ?
	        
	        int rowsAffected = ps.executeUpdate(); // Thực thi câu lệnh và lấy số hàng bị ảnh hưởng
	        
	        System.out.println("Number of rows affected: " + rowsAffected); // In số hàng bị ảnh hưởng
	        
	        JDBCUtil.closePreparedStatement(ps);
	        JDBCUtil.closeConnection(con);
	        
	        System.out.println("Update completed.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}



	
	public void updateSnakeSetting(String nameuser, int map, int snake) {
		try {
		    Connection con = JDBCUtil.getConnection();
		    
		    PreparedStatement ps = con.prepareStatement("UPDATE BangTrangThaiGame "
		    		                                  + "SET Map = ? , Ran = ? "
		    		                                  + "WHERE Id_TrangThaiGame IN ("
		    		                                         + "SELECT BangNguoiChoi.Id_TrangThaiGame "
		    		                                         + "FROM BangNguoIChoi "
		    		                                         + "JOIN BangNguoiDung ON BangNguoiDung.Id_NguoiDung = BangNguoiChoi.Id_NguoiDung "
		    		                                         + "WHERE BangNguoiDung.TenDangNhap = N'?'");
		    ps.setInt(1, map); 
		    ps.setInt(2, snake);
		    ps.setString(3, nameuser); 
		    ps.executeUpdate();
		    
		    JDBCUtil.closePreparedStatement(ps);
		    JDBCUtil.closeConnection(con);
		    
		    System.out.println("update");
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	}

	
	


	@Override
	public int delete(BangTrangThaiGame t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<BangTrangThaiGame> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getValueScore(String nameuser) {
	    int result = 0; // Khởi tạo giá trị mặc định cho result

	    try {
	        Connection con = JDBCUtil.getConnection();
	        
	        PreparedStatement ps = con.prepareStatement("SELECT Nhac FROM BangTrangThaiGame "
	                                                     + "JOIN BangNguoiChoi ON BangNguoiChoi.Id_TrangThaiGame = BangTrangThaiGame.Id_TrangThaiGame\r\n"
	                                                     + ""
	                                                     + "JOIN BangNguoiDung ON BangNguoiDung.Id_NguoiDung = BangNguoiChoi.Id_NguoiDung\r\n"
	                                                     + ""
	                                                     + "WHERE BangNguoiDung.TenDangNhap = N'"+nameuser+"'");
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            result = rs.getInt("Nhac"); // Sử dụng getInt() để lấy giá trị từ cột Nhac
	        }
	        
	        JDBCUtil.closeResultSet(rs);
	        JDBCUtil.closePreparedStatement(ps);
	        JDBCUtil.closeConnection(con);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}
	
	public int getValueMusic(String nameuser) {
	    int result = 0; // Khởi tạo giá trị mặc định cho result

	    try {
	        Connection con = JDBCUtil.getConnection();
	        
	        PreparedStatement ps = con.prepareStatement("SELECT Nhac FROM BangTrangThaiGame "
	                                                     + "JOIN BangNguoiChoi ON BangNguoiChoi.Id_TrangThaiGame = BangTrangThaiGame.Id_TrangThaiGame\r\n"
	                                                     + ""
	                                                     + "JOIN BangNguoiDung ON BangNguoiDung.Id_NguoiDung = BangNguoiChoi.Id_NguoiDung\r\n"
	                                                     + ""
	                                                     + "WHERE BangNguoiDung.TenDangNhap = N'"+nameuser+"'");
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            result = rs.getInt("Nhac"); // Sử dụng getInt() để lấy giá trị từ cột Nhac
	        }
	        
	        JDBCUtil.closeResultSet(rs);
	        JDBCUtil.closePreparedStatement(ps);
	        JDBCUtil.closeConnection(con);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}
	
	public int getValueVoice(String nameuser) {
	    int result = 50; // Khởi tạo giá trị mặc định cho result

	    try {
	        Connection con = JDBCUtil.getConnection();
	        
	        PreparedStatement ps = con.prepareStatement("SELECT AmThanh FROM BangTrangThaiGame "
	                                                     + "JOIN BangNguoiChoi ON BangNguoiChoi.Id_TrangThaiGame = BangTrangThaiGame.Id_TrangThaiGame\r\n"
	                                                     + ""
	                                                     + "JOIN BangNguoiDung ON BangNguoiDung.Id_NguoiDung = BangNguoiChoi.Id_NguoiDung\r\n"
	                                                     + ""
	                                                     + "WHERE BangNguoiDung.TenDangNhap = ?");
	        ps.setString(1, nameuser);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            result = rs.getInt("AmThanh"); // Sử dụng getInt() để lấy giá trị từ cột Nhac
	        }
	        
	        JDBCUtil.closeResultSet(rs);
	        JDBCUtil.closePreparedStatement(ps);
	        JDBCUtil.closeConnection(con);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}
	
	public int getValueMap(String nameuser) {
	    int result = 0; // Khởi tạo giá trị mặc định cho result

	    try {
	        Connection con = JDBCUtil.getConnection();
	        
	        PreparedStatement ps = con.prepareStatement("SELECT Map FROM BangTrangThaiGame g "
	                                                     + "JOIN BangNguoiChoi c ON c.Id_TrangThaiGame = g.Id_TrangThaiGame "
	                                                     + "JOIN BangNguoidung d ON d.Id_NguoiDung = c.Id_NguoiDung "
	                                                     + "WHERE g.Id_TrangThaiGame = ?");
	        ps.setString(1, nameuser);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            result = rs.getInt("Map"); // Sử dụng getInt() để lấy giá trị từ cột Nhac
	        }
	        
	        JDBCUtil.closeResultSet(rs);
	        JDBCUtil.closePreparedStatement(ps);
	        JDBCUtil.closeConnection(con);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}
	
	public int getValueSnake(String nameuser) {
	    int result = 0; // Khởi tạo giá trị mặc định cho result

	    try {
	        Connection con = JDBCUtil.getConnection();
	        
	        PreparedStatement ps = con.prepareStatement("SELECT Ran FROM BangTrangThaiGame g "
	                                                     + "JOIN BangNguoiChoi c ON c.Id_TrangThaiGame = g.Id_TrangThaiGame "
	                                                     + "JOIN BangNguoidung d ON d.Id_NguoiDung = c.Id_NguoiDung "
	                                                     + "WHERE g.Id_TrangThaiGame = ?");
	        ps.setString(1, nameuser);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            result = rs.getInt("Ran"); // Sử dụng getInt() để lấy giá trị từ cột Nhac
	        }
	        
	        JDBCUtil.closeResultSet(rs);
	        JDBCUtil.closePreparedStatement(ps);
	        JDBCUtil.closeConnection(con);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}


	@Override
	public BangTrangThaiGame selectByID(BangTrangThaiGame t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BangTrangThaiGame> selectByConditon(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
