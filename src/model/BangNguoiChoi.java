package model;

public class BangNguoiChoi {
	private String Id_NguoiChoi;
	private String TenNguoiChoi;
	private String Id_NguoiDung;
	private String Id_TrangThaiGame;
	private int DiemSo;
	
	
	public BangNguoiChoi() {
		super();
	}


	public BangNguoiChoi(String id_NguoiChoi, String tenNguoiChoi, String id_NguoiDung, String id_TrangThaiGame,
			int diemSo) {
		super();
		Id_NguoiChoi = id_NguoiChoi;
		TenNguoiChoi = tenNguoiChoi;
		Id_NguoiDung = id_NguoiDung;
		Id_TrangThaiGame = id_TrangThaiGame;
		DiemSo = diemSo;
	}


	public String getId_NguoiChoi() {
		return Id_NguoiChoi;
	}


	public void setId_NguoiChoi(String id_NguoiChoi) {
		Id_NguoiChoi = id_NguoiChoi;
	}


	public String getTenNguoiChoi() {
		return TenNguoiChoi;
	}


	public void setTenNguoiChoi(String tenNguoiChoi) {
		TenNguoiChoi = tenNguoiChoi;
	}


	public String getId_NguoiDung() {
		return Id_NguoiDung;
	}


	public void setId_NguoiDung(String id_NguoiDung) {
		Id_NguoiDung = id_NguoiDung;
	}


	public String getId_TrangThaiGame() {
		return Id_TrangThaiGame;
	}


	public void setId_TrangThaiGame(String id_TrangThaiGame) {
		Id_TrangThaiGame = id_TrangThaiGame;
	}


	public int getDiemSo() {
		return DiemSo;
	}


	public void setDiemSo(int diemSo) {
		DiemSo = diemSo;
	}
	
	

}
