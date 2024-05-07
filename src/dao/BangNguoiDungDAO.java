package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.BangNguoiDung;

public class BangNguoiDungDAO implements DAOInterface<BangNguoiDung>{

	public static BangNguoiDungDAO getInstance() {
		return new BangNguoiDungDAO();
	}
	
	@Override
	public int insert(BangNguoiDung t) {
		int KetQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			
			Statement st = con.createStatement();
			
			String sql = "INSERT INTO BangNguoiDung(Id_NguoiDung , TenDangNhap , MatKhau)" +
			             "VALUES ('"+t.getId_NguoiDung()+"', '"+t.getTenDangNhap()+"', '"+t.getMatkhau()+"' )";
			
			KetQua = st.executeUpdate(sql);
			
			System.out.println("Bạn đã thực thi:" + sql);
			System.out.println("Có "+ KetQua+" dòng bị thay đổi.");
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(BangNguoiDung t) {
		int KetQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			
			Statement st = con.createStatement();
			
			String sql = "UPDATE BangNguoiDung " +
		             "SET "+
		             "Id_NguoiDung='" +t.getId_NguoiDung()+ "', "+
		             "TenDangNhap='" +t.getTenDangNhap()+ "', "+
		             "MatKhau='" +t.getMatkhau()+ "', "+
		             "WHERE Id_NguoiDung = '"+t.getId_NguoiDung()+"'";

			
			KetQua = st.executeUpdate(sql);
			
			System.out.println("Bạn đã thực thi:" + sql);
			System.out.println("Có "+ KetQua+" dòng bị thay đổi.");
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		return 0;
	}

	@Override
	public int delete(BangNguoiDung t) {
		int KetQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			
			Statement st = con.createStatement();
			
			String sql = "DELETE FROM BangNguoiDung " +
		                 "WHERE Id_NguoiDung = '" + t.getId_NguoiDung() + "'";


			
			KetQua = st.executeUpdate(sql);
			
			System.out.println("Bạn đã thực thi:" + sql);
			System.out.println("Có "+ KetQua+" dòng bị thay đổi.");
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return 0;		
	}

	@Override
	public ArrayList<BangNguoiDung> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean isValidLogin(String username, char[] passwordChars) {
        boolean isValid = false;
        
        // Chuyển đổi mật khẩu từ mảng char[] sang String để so sánh
        String password = new String(passwordChars);
        
        try {
            Connection con = JDBCUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM BangNguoiDung WHERE TenDangNhap = ? AND MatKhau = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                isValid = true;
            }
            
            JDBCUtil.closeResultSet(rs);
            JDBCUtil.closePreparedStatement(ps);
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return isValid;
    }
      
	public boolean selectById(String id) {
	    boolean exists = false;

	    String query = "SELECT * FROM BangNguoiDung WHERE Id_NguoiDung = ?";
	    
	    try (Connection con = JDBCUtil.getConnection();
	         PreparedStatement ps = con.prepareStatement(query)) {

	        ps.setString(1, id);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                exists = true;
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return exists;
	}

	
	public boolean selectByName(String name) {
	    boolean exists = false;
	    
	    try {
	        Connection con = JDBCUtil.getConnection();
	        PreparedStatement ps = con.prepareStatement("SELECT * FROM BangNguoiDung WHERE TenDangNhap = ?");
	        
	        // Thiết lập tham số cho truy vấn
	        ps.setString(1, name);
	        
	        ResultSet rs = ps.executeQuery();
	        
	        // Nếu có kết quả trả về, đặt biến exists thành true
	        if (rs.next()) {
	            exists = true;
	        }
	        
	        // Đóng kết nối và tài nguyên
	        JDBCUtil.closeResultSet(rs);
	        JDBCUtil.closePreparedStatement(ps);
	        JDBCUtil.closeConnection(con);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return exists;
	}



	@Override
	public ArrayList<BangNguoiDung> selectByConditon(String condition) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public boolean selectByID(String Id) {
		// TODO Auto-generated method stub
		return false;
	}

}
