package dao;

import java.util.ArrayList;

import model.BangNguoiChoi;

public interface DAOInterface<T> {
	
	public int insert(T t);
	
	public int update(T t);
	
	public int delete(T t);
	
	public ArrayList<T> selectAll();
	
	public boolean selectByID(String Id);
	
	public boolean selectByName(String name);
		
	public ArrayList<T> selectByConditon(String condition);

	BangNguoiChoi selectByID(BangNguoiChoi t);
	
	

}
