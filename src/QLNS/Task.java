package QLNS;

public class Task {
	// 1.Attribute
	private String maTask;
	private String tenTask;
	private float gioThucHien;
	private String maNV;

	// 2.GetSet method
	public String getMaTask() {
		return maTask;
	}

	public void setMaTask(String maTask) {
		this.maTask = maTask;
	}

	public String getTenTask() {
		return tenTask;
	}

	public void setTenTask(String tenTask) {
		this.tenTask = tenTask;
	}

	public float getGioThucHien() {
		return gioThucHien;
	}

	public void setGioThucHien(float gioThucHien) {
		this.gioThucHien = gioThucHien;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	// 3. Constructors
	public Task() {
		this.maNV = "-1";
	}

	public Task(String maTask, String tenTask, float gioThucHien, String maNV) {
		this.maTask = maTask;
		this.tenTask = tenTask;
		this.gioThucHien = gioThucHien;
		this.maNV = maNV;
	}

	public Task(String maTask, String tenTask, float gioThucHien) {
		this.maNV = "-1";
		this.maTask = maTask;
		this.tenTask = tenTask;
		this.gioThucHien = gioThucHien;
	}

	// 4. Input , output
	public void output() {
		System.out.println(String.format("%1$" + -86 + "s", " ")
						+String.format("%1$" + -15 + "s", " ||Mã task: " + this.maTask)
						+ String.format("%1$" + -40 + "s", " ||Tên Task: " + this.tenTask)
						+ String.format("%1$" + -20 + "s", " ||Giờ thực hiện: " + this.gioThucHien));
	}
	public void xuatMavaTen() {
		System.out.println(String.format("%1$" + -15 + "s", " ||Mã task: " + this.maTask)
				+ String.format("%1$" + -40 + "s", " ||Tên Task: " + this.tenTask)
				+ String.format("%1$" + -20 + "s", " ||Giờ thực hiện: " + this.gioThucHien));
	}
}
	// 5 . Business methods


