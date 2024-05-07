package model;

public class BangNguoiDung {
	
	private String Id_NguoiDung;
	private String TenDangNhap;
	private String Matkhau;
	public BangNguoiDung() {
		super();
	}
	public BangNguoiDung(String id_NguoiDung, String tenDangNhap, String matkhau) {
		super();
		Id_NguoiDung = id_NguoiDung;
		TenDangNhap = tenDangNhap;
		Matkhau = matkhau;
	}
	public String getId_NguoiDung() {
		return Id_NguoiDung;
	}
	public void setId_NguoiDung(String id_NguoiDung) {
		Id_NguoiDung = id_NguoiDung;
	}
	public String getTenDangNhap() {
		return TenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		TenDangNhap = tenDangNhap;
	}
	public String getMatkhau() {
		return Matkhau;
	}
	public void setMatkhau(String matkhau) {
		Matkhau = matkhau;
	}
	
	

}
