package dao;

import java.sql.Connection;
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
		
		int KetQua = 0 ;
		
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
			
			KetQua = st.executeUpdate(sql);
			
			System.out.println("Bạn đã thực thi:" + sql);
			System.out.println("Có "+ KetQua+" dòng bị thay đổi.");
			
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return 0;
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
