package QLNS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DanhSachPhongBan implements Output {
	private ArrayList<PhongBan> listPB;

	public ArrayList<PhongBan> getListPB() {
		return listPB;
	}

	public void setListPB(ArrayList<PhongBan> listPB) {
		this.listPB = listPB;
	}

	@Override
	public void output() {
		for (PhongBan pb : this.listPB) {
			pb.output();
		}
	}

	public void soNgQL() {
		for (PhongBan pb : this.listPB) {
			pb.soNgQL();
		}
	}

	public DanhSachPhongBan() {
		listPB = new ArrayList<PhongBan>();
	}

	public void taoDuLieu() {
		try {
			FileReader reader = new FileReader("src/QLNS/data/PhongBan.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] listInfo = line.split(" # ");
				PhongBan pb = new PhongBan(listInfo[0], listInfo[1]);
				this.listPB.add(pb);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}