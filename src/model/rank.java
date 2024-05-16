package model;

public class rank {
    private String name;
    private int diem;
    private int xephang;

    public rank(String name, int diem, int xephang) {
        this.name = name;
        this.diem = diem;
        this.xephang = xephang;
    }

    // Các phương thức getter và setter (nếu cần thiết)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public int getXephang() {
        return xephang;
    }

    public void setXephang(int xephang) {
        this.xephang = xephang;
    }
}