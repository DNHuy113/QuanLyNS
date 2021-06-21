package QLNS;

import java.text.NumberFormat;
import java.util.Locale;

public abstract class NhanSu {
	// 1.Attributes
	protected String maNS;
	protected String tenNS;
	protected int namS;
	protected String email;
	protected String sDT;
	protected String maPB;
	protected DanhSachTask oblTask;
	protected int soNgyLV;
	protected int Luong;

	// 2.Constructors
	public void init() {
		this.maPB = "-1";
		this.oblTask = new DanhSachTask();
	}

	public NhanSu() {
		init();
	}

	public NhanSu(String maNS, String tenNS, int namSinh, String email, String soDienThoai, String maPB, int songaylv) {
		init();
		this.maNS = maNS;
		this.tenNS = tenNS;
		this.namS = namSinh;
		this.email = email;
		this.sDT = soDienThoai;
		this.maPB = maPB;
		this.soNgyLV = songaylv;
	}

	// 3.business method
	public void xuatTenvaMa() {
		System.out.println("Mã: " + this.maNS + " \t Tên:" + this.tenNS);
	}

	public String chuyendoi(int k) {
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		String str1 = currencyVN.format(k);
		return str1;
	}

	public abstract void tinhLuong();

	// 4.Input output method
	public void output() {
		String temp = this.maPB;
		if (this.maPB.equalsIgnoreCase("-1")) {
			temp = "Chưa phân bổ phòng ban";
		}
		System.out.println(String.format("%1$" + -16 + "s", " ||MãNS: " + this.maNS)
				+ String.format("%1$" + -20 + "s", " ||TênNS: " + this.tenNS)
				+ String.format("%1$" + -20 + "s", " ||Năm sinh: " + this.namS)
				+ String.format("%1$" + -30 + "s", " ||Email: " + this.email)
				+ String.format("%1$" + -16 + "s", " ||SDT: " + this.sDT)
				+ String.format("%1$" + -40 + "s", " ||Mã phònng ban:" + temp)
				+ String.format("%1$" + -23 + "s", " ||Số ngày làm việc: " + this.soNgyLV)
				+ String.format("%1$" + -20 + "s", " ||Lương: " + chuyendoi(this.Luong)));

		if (this.oblTask.getListTask().size() > 0) {
			System.out.println(String.format("%1$" + -87 + "s", " ")+"Danh sách task cá nhân này thực hiện:");
			this.oblTask.output();
		}

	}

	// 5.GetSet method
	public String getmaNS() {
		return maNS;
	}

	public void setmaNS(String maNS) {
		this.maNS = maNS;
	}

	public String getTenNS() {
		return tenNS;
	}

	public void setTenNS(String tenNS) {
		this.tenNS = tenNS;
	}

	public int getNamS() {
		return namS;
	}

	public void setNamS(int namS) {
		this.namS = namS;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getsDT() {
		return sDT;
	}

	public void setsDT(String sDT) {
		this.sDT = sDT;
	}

	public String getMaPB() {
		return maPB;
	}

	public void setMaPB(String maPB) {
		this.maPB = maPB;
	}

	public DanhSachTask getOblTask() {
		return oblTask;
	}

	public void setOblTask(DanhSachTask oblTask) {
		this.oblTask = oblTask;
	}

	public int getSoNgyLV() {
		return soNgyLV;
	}

	public void setSoNgyLV(int soNgyLV) {
		this.soNgyLV = soNgyLV;
	}

	public int getLuong() {
		return Luong;
	}

	public void setLuong(int luong) {
		Luong = luong;
	}
}