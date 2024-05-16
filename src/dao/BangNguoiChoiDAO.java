package dao;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.rank;
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
	
	public void updateScoreToDatabase(String nameuser, int score) {
	    try {
	        Connection con = JDBCUtil.getConnection();

	        PreparedStatement ps = con.prepareStatement("UPDATE BangNguoiChoi " +
	                "SET DiemSo = CASE " +
	                "WHEN DiemSo < ? THEN ? " +
	                "ELSE DiemSo " +
	                "END " +
	                "WHERE Id_NguoiChoi IN ( " +
	                "SELECT Id_NguoiDung " +
	                "FROM BangNguoiDung " +
	                "WHERE BangNguoiDung.TenDangNhap = ?)");
	        
	        ps.setInt(1, score);
	        ps.setInt(2, score);
	        ps.setString(3, nameuser);
	        
	        int rowsUpdated = ps.executeUpdate();
	        System.out.println("Số dòng được cập nhật: " + rowsUpdated);
	        
	        JDBCUtil.closePreparedStatement(ps);
	        JDBCUtil.closeConnection(con);
	    } catch (SQLException e) {
	        System.err.println("Lỗi khi cập nhật điểm số: " + e.getMessage());
	        e.printStackTrace();
	    }
	}


	@Override
	public int delete(BangNguoiChoi t) {
		// TODO Auto-generated method stub
		return 0;
	}

	 

	    public ArrayList<rank> insertTop10() {
	        ArrayList<rank> rankList = new ArrayList<>();

	        try {
	            Connection con = JDBCUtil.getConnection();
	            String sql = "SELECT \r\n"
	            		+ "    [TenNguoiChoi],\r\n"
	            		+ "    [DiemSo],\r\n"
	            		+ "    ROW_NUMBER() OVER (ORDER BY [DiemSo] DESC) AS XepHang\r\n"
	            		+ "FROM \r\n"
	            		+ "    [Ran].[dbo].[BangNguoiChoi]\r\n"
	            		+ "ORDER BY \r\n"
	            		+ "    [DiemSo] DESC\r\n"
	            		+ "OFFSET 0 ROWS\r\n"
	            		+ "FETCH NEXT 10 ROWS ONLY;";

	            PreparedStatement pstmt = con.prepareStatement(sql);
	            ResultSet rs = pstmt.executeQuery();

	            while (rs.next()) {
	                String tenNguoiChoi = rs.getString("TenNguoiChoi");
	                int diem = rs.getInt("DiemSo");
	                int xepHang = rs.getInt("XepHang");

	                rank player = new rank(tenNguoiChoi, diem, xepHang);
	                rankList.add(player);
	            }

	            JDBCUtil.closeConnection(con);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return rankList;
	    }
	    
	    public rank InsertRankUser(String Name) {
	    	rank player = null;
	    	try {
				Connection con = JDBCUtil.getConnection();
				
				String sql = "WITH RankedPlayers AS (\r\n"
						+ "    SELECT \r\n"
						+ "        [TenNguoiChoi],\r\n"
						+ "        [DiemSo],\r\n"
						+ "        ROW_NUMBER() OVER (ORDER BY [DiemSo] DESC) AS XepHang\r\n"
						+ "    FROM \r\n"
						+ "        [Ran].[dbo].[BangNguoiChoi]\r\n"
						+ ")\r\n"
						+ "SELECT [TenNguoiChoi],\r\n"
						+ "        [DiemSo], XepHang\r\n"
						+ "FROM RankedPlayers\r\n"
						+ "WHERE TenNguoiChoi = '"+Name+"';";
				PreparedStatement pstmt = con.prepareStatement(sql);
	            ResultSet rs = pstmt.executeQuery();

	            while (rs.next()) {
	                String tenNguoiChoi = rs.getString("TenNguoiChoi");
	                int diem = rs.getInt("DiemSo");
	                int xepHang = rs.getInt("XepHang");

	                player = new rank(tenNguoiChoi, diem, xepHang);
	            }
				
				JDBCUtil.closeConnection(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return player;
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
	        JDBCUtil.closePreparedStatement(ps);
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

	@Override
	public ArrayList<BangNguoiChoi> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
