package QLNS;

public class NhanVien extends NhanSu {
	final int LUONG_NGAY = 200000;
	final int PHU_CAP_1 = 300000;
	final int PHU_CAP_2 = 1000000;

	private float timeTask;

	public float getTimeTask() {
		return timeTask;
	}

	public void setTimeTask(float timeTask) {
		this.timeTask = timeTask;
	}

	public NhanVien() {
		super();
	}

	public NhanVien(String maNS, String tenNS, int namSinh, String email, String soDienThoai, String maPB,
			int songaylv) {
		super(maNS, tenNS, namSinh, email, soDienThoai, maPB, songaylv);
	}

	public void tinhTime() {
		if (this.getOblTask().getListTask() != null) {
			float tong = 0;
			for (Task t : this.getOblTask().getListTask()) {
				tong += t.getGioThucHien();
			}
			this.timeTask = tong;
		} else
			this.timeTask = 0;

	}

	@Override
	public void tinhLuong() {
		tinhTime();
		if (this.timeTask > 35.0f)
			this.Luong = this.getSoNgyLV() * LUONG_NGAY + PHU_CAP_1 + PHU_CAP_2;
		else
			this.Luong = this.getSoNgyLV() * LUONG_NGAY + PHU_CAP_1;

	}

}
