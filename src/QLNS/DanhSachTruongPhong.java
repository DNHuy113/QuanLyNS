package QLNS;

import java.util.ArrayList;

public class DanhSachTruongPhong implements Output {
	private ArrayList<TruongPhong> listTP;

	public ArrayList<TruongPhong> getListTP() {
		return listTP;
	}

	public void setListTP(ArrayList<TruongPhong> listTP) {
		this.listTP = listTP;
	}

	public DanhSachTruongPhong() {
		listTP = new ArrayList<TruongPhong>();
	}

	@Override
	public void output() {
		for (TruongPhong tp : this.listTP) {
			tp.output();
		}
	}
}
