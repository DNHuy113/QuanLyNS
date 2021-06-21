package QLNS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DanhSachNhanSu implements Output {
	// 1.Attributes
	private ArrayList<NhanSu> listNS;

	// 2.constructors
	public DanhSachNhanSu() {
		this.listNS = new ArrayList<NhanSu>();
	}

	// 3.get set method
	public ArrayList<NhanSu> getListNS() {
		return listNS;
	}

	public void setListNS(ArrayList<NhanSu> listNS) {
		this.listNS = listNS;
	}

	// 4.input output method
	public void output() {
		for (NhanSu ns : this.listNS) {
			ns.output();
		}
	}

	public void tinLuong() {
		for (NhanSu ns : this.listNS) {
			ns.tinhLuong();
			ns.tinhLuong();
		}
	}

	// 5.Busibess method
	public void taoDuLieu() {
		try {
			FileReader read = new FileReader("src/QLNS/data/DSNV.txt");
			BufferedReader buf = new BufferedReader(read);
			String line;
			while ((line = buf.readLine()) != null) {
				String[] listInfo = line.split(" # ");
				NhanSu ns;
				if (listInfo[listInfo.length - 1].equalsIgnoreCase("true")) {
					ns = new TruongPhong();
				} else {
					ns = new NhanVien();
				}
				ns.setmaNS(listInfo[0]);
				ns.setTenNS(listInfo[1]);
				ns.setNamS(Integer.parseInt(listInfo[2]));
				ns.setEmail(listInfo[3]);
				ns.setsDT(listInfo[4]);
				this.listNS.add(ns);
			}
			read.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			FileReader read = new FileReader("src/QLNS/data/DSNV1.txt");
			BufferedReader buf = new BufferedReader(read);
			String line;
			while ((line = buf.readLine()) != null) {
				String[] listInfo = line.split(" # ");
				NhanSu ns;
				if (listInfo[5].equalsIgnoreCase("true")) {
					// String maNS, String tenNS, int namSinh, String email,String
					// soDienThoai,String maPB,int songaylv)
					ns = new TruongPhong();
				} else {
					ns = new NhanVien();
				}
				ns.setmaNS(listInfo[0]);
				ns.setTenNS(listInfo[1]);
				ns.setNamS(Integer.parseInt(listInfo[2]));
				ns.setEmail(listInfo[3]);
				ns.setsDT(listInfo[4]);
				ns.setMaPB(listInfo[6]);
				ns.setSoNgyLV(Integer.parseInt(listInfo[7]));
				this.listNS.add(ns);
			}
			read.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
