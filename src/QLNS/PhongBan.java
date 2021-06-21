package QLNS;

public class PhongBan implements Output {

	// 1. Attributes
	private String maPhongBan;
	private String tenPhongBan;
	private TruongPhong truongPhong;
	private DanhSachNhanSu oblNS;

	// 2. Get, set
	public DanhSachNhanSu getOblNS() {
		return oblNS;
	}

	public void setOblNS(DanhSachNhanSu oblNS) {
		this.oblNS = oblNS;
	}

	public String getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public String getTenPhongBan() {
		return tenPhongBan;
	}

	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}

	public TruongPhong getTruongPhong() {
		return truongPhong;
	}

	public void setTruongPhong(TruongPhong truongPhong) {
		this.truongPhong = truongPhong;
	}

	// 3. Constructor
	public PhongBan() {
		this.truongPhong = null;
		this.oblNS = new DanhSachNhanSu();
	}

	public PhongBan(String maPhongBan, String tenPhongBan) {
		this.maPhongBan = maPhongBan;
		this.tenPhongBan = tenPhongBan;
		this.oblNS = new DanhSachNhanSu();
	}

	// 4. Input, out
	@Override
	public void output() {
		System.out.println(
				"***************************************************************Đây là thông tin phòng ban**********************************************************************************************************");
		System.out.println(String.format("%1$" + -40 + "s", " ||Tên: " + this.tenPhongBan)
				+ String.format("%1$" + -20 + "s", " ||Mã: " + this.maPhongBan));
		if (this.truongPhong != null) {
			System.out.println("Trưởng phòng quản lý: ");
			this.truongPhong.output();
			System.out.println(
					"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		} else {
			System.out.println("Phòng này chưa có trưởng phòng quản lý");
		}
		for (NhanSu nv : this.oblNS.getListNS()) {
			nv.output();
		}
		System.out.println(
				"*************************************************************************End***********************************************************************************************************************");
	}

	public void xuatTenvaMa() {
		System.out.println("Mã: " + this.maPhongBan + " \t Tên:" + this.tenPhongBan);
	}

	public void soNgQL() {
		if (this.truongPhong != null && this.oblNS.getListNS() != null) {
			int k = 0;
			for (NhanSu ns : this.oblNS.getListNS()) {
				if (ns instanceof NhanVien) {
					k++;
				}
			}
			this.truongPhong.soNguoiQL = k;
		}
	}
//	public void xoaTP() {
//		this.truongPhong = null;
//	}
}