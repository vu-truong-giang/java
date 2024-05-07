package model;

public class BangTrangThaiGame {
	private String Id_TrangThaiGame;
	private int Map;
	private int Ran;
	private int Nhac;
	private int AmThanh;
	public BangTrangThaiGame() {
		super();
	}
	public BangTrangThaiGame(String id_TrangThaiGame, int map, int ran, int nhac, int amThanh) {
		super();
		Id_TrangThaiGame = id_TrangThaiGame;
		Map = map;
		Ran = ran;
		Nhac = nhac;
		AmThanh = amThanh;
	}
	public String getId_TrangThaiGame() {
		return Id_TrangThaiGame;
	}
	public void setId_TrangThaiGame(String id_TrangThaiGame) {
		Id_TrangThaiGame = id_TrangThaiGame;
	}
	public int getMap() {
		return Map;
	}
	public void setMap(int map) {
		Map = map;
	}
	public int getRan() {
		return Ran;
	}
	public void setRan(int ran) {
		Ran = ran;
	}
	public int getNhac() {
		return Nhac;
	}
	public void setNhac(int nhac) {
		Nhac = nhac;
	}
	public int getAmThanh() {
		return AmThanh;
	}
	public void setAmThanh(int amThanh) {
		AmThanh = amThanh;
	}
	
	

}
