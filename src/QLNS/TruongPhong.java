package QLNS;

public class TruongPhong extends NhanSu {
	final int LUONGNGAY = 300000;
	final int PC = 200000;
	public int soNguoiQL;

	public int getSoNguoiQL() {
		return soNguoiQL;
	}

	public void setSoNguoiQL(int soNguoiQL) {
		this.soNguoiQL = soNguoiQL;
	}

	public TruongPhong() {
		super();
	}

	public TruongPhong(String maNS, String tenNS, int namSinh, String email, String soDienThoai, String maPB,
			int songaylv) {
		super(maNS, tenNS, namSinh, email, soDienThoai, maPB, songaylv);
	}

	
	@Override
	public void tinhLuong() {
		this.Luong = this.soNgyLV * LUONGNGAY + PC * this.soNguoiQL;
	}
	public void tangNhanVien() {
		this.soNguoiQL++;
		tinhLuong();
	}
	public void giamNhanVien() {
		this.soNguoiQL--;
		tinhLuong();
		
	}
}
