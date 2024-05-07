package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.BangNguoiChoi;

public class BangNguoiChoiDAO implements DAOInterface<BangNguoiChoi>{
	

	public static BangNguoiChoiDAO getInstance() {
		return new BangNguoiChoiDAO();
	}
	
	@Override
	public int insert(BangNguoiChoi t) {
		int KetQua = 0 ;
		try {
			Connection con = JDBCUtil.getConnection();
			
			Statement st = con.createStatement();
			
			String sql = "INSERT INTO BangNguoiChoi (Id_NguoiChoi , TenNguoiChoi , Id_NguoiDung , Id_TrangThaiGame , DiemSo) " +
		                 "VALUES ('" + t.getId_NguoiChoi() + "', '"+ t.getTenNguoiChoi() +"', '" + t.getId_NguoiDung() + "' , '"+ t.getId_TrangThaiGame()+"' , '"+t.getDiemSo()+"')";

			KetQua = st.executeUpdate(sql);
			
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có " +KetQua+ " dòng bị thay đổi.");
			
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(BangNguoiChoi t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(BangNguoiChoi t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<BangNguoiChoi> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BangNguoiChoi selectByID(BangNguoiChoi t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean selectByName(String name) {
	    boolean exists = false;
	    
	    try {
	        Connection con = JDBCUtil.getConnection();
	        PreparedStatement ps = con.prepareStatement("SELECT * FROM BangNguoiChoi WHERE TenNguoiChoi = ?");
	        
	        // Thiết lập tham số cho truy vấn
	        ps.setString(1, name);
	        
	        ResultSet rs = ps.executeQuery();
	        
	        // Nếu có kết quả trả về, đặt biến exists thành true
	        if (rs.next()) {
	            exists = true;
	        }
	        
	        // Đóng kết nối và tài nguyên
	        JDBCUtil.closeResultSet(rs);
	        JDBCUtil.closePreparedStatement(ps)
	        JDBCUtil.closeConnection(con);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return exists;
	}
	
	public String selectByNameReturnNameuser(String nameuser) {
	    String result = null; // Khởi tạo biến kết quả

	    try {
	        Connection con = JDBCUtil.getConnection();
	        PreparedStatement ps = con.prepareStatement("SELECT TenNguoiChoi FROM BangNguoiChoi t "
	                + " JOIN BangNguoiDung d ON t.Id_NguoiDung = d.Id_NguoiDung "
	                + "WHERE d.TenDangNhap = ?");
	        
	        ps.setString(1, nameuser); // Thiết lập tham số cho truy vấn
	        
	        ResultSet rs = ps.executeQuery();
	        
	        // Xử lý kết quả trả về từ ResultSet
	        if (rs.next()) {
	            // Lấy tên người chơi duy nhất
	            result = rs.getString("TenNguoiChoi");
	        }
	        
	        // Đóng kết nối và tài nguyên
	        JDBCUtil.closeResultSet(rs);
	        JDBCUtil.closePreparedStatement(ps);
	        JDBCUtil.closeConnection(con);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return result; // Trả về tên người chơi (hoặc null nếu không tìm thấy)
	}

	

	


	@Override
	public ArrayList<BangNguoiChoi> selectByConditon(String condition) {
		
		

		return null;
	}

	@Override
	public boolean selectByID(String Id) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
