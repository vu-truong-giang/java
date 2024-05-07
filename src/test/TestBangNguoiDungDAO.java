package test;

import dao.BangNguoiDungDAO;
import model.BangNguoiDung;

public class TestBangNguoiDungDAO {
    public static void main(String[] avgr) {
//    	BangNguoiDung bangnguoidung1 = new BangNguoiDung("01", "giang", "123" , "01");
//    	BangNguoiDungDAO.getInstance().insert(bangnguoidung1);
    	
//    	for(int i=0 ; i < 100 ; i++) {
//    		BangNguoiDung bangnguoidung = new BangNguoiDung("00"+i, "bangnguoidung "+i, "00"+i, "00"+i);
//    		BangNguoiDungDAO.getInstance().insert(bangnguoidung);
//    	}
    	
//    	BangNguoiDung bangnguoidung2 = new BangNguoiDung("01" , "TruongGiang", "123456", "01");
//    	BangNguoiDungDAO.getInstance().update(bangnguoidung2);
//    	
    	
    	for (int i=0 ; i < 100 ; i++) {
    		BangNguoiDung bangnguoidung = new BangNguoiDung("00"+i,"" ,"" ,"" );
    		BangNguoiDungDAO.getInstance().delete(bangnguoidung);
    	}
    	
    }
}
