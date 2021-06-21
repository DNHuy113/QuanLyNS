package QLNS;

import java.util.Collections;
import java.util.Scanner;

public class CongTy implements Output {
	// 1. attributes
	private String tenCongTy;
	private String maSoThue;
	private float tongLuong;
	private DanhSachNhanSu oblNhanSu;
	private DanhSachPhongBan oblPhongBan;
	private DanhSachTask oblTask;
	private DanhSachTruongPhong oblTruongPhong;

	// 2. get, set
	public String getTenCongTy() {
		return tenCongTy;
	}

	public void setTenCongTy(String tenCongTy) {
		this.tenCongTy = tenCongTy;
	}

	public String getMaSoThue() {
		return maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}

	public float getTongLuong() {
		return tongLuong;
	}

	public void setTongLuong(float tongLuong) {
		this.tongLuong = tongLuong;
	}

	public DanhSachNhanSu getOblNhanSu() {
		return oblNhanSu;
	}

	public void setOblNhanSu(DanhSachNhanSu oblNhanSu) {
		this.oblNhanSu = oblNhanSu;
	}

	public DanhSachPhongBan getOblPhongBan() {
		return oblPhongBan;
	}

	public void setOblPhongBan(DanhSachPhongBan oblPhongBan) {
		this.oblPhongBan = oblPhongBan;
	}

	public DanhSachTask getOblTask() {
		return oblTask;
	}

	public void setOblTask(DanhSachTask oblTask) {
		this.oblTask = oblTask;
	}

	public DanhSachTruongPhong getOblTruongPhong() {
		return oblTruongPhong;
	}

	public void setOblTruongPhong(DanhSachTruongPhong oblTruongPhong) {
		this.oblTruongPhong = oblTruongPhong;
	}

	public CongTy() {
		oblTruongPhong = new DanhSachTruongPhong();
	}

	@Override
	public void output() {

	}

	// 5.
	// Tạo dữ liêu giả
	public void taoDuLieu() {
		this.oblPhongBan = new DanhSachPhongBan();
		this.oblPhongBan.taoDuLieu();

		this.oblNhanSu = new DanhSachNhanSu();
		this.oblNhanSu.taoDuLieu();

		inputListTP();

		this.oblTask = new DanhSachTask();
		this.oblTask.taoDuLieu();

		update();
	}

	public void update() {
		for (Task t : this.oblTask.getListTask()) {
			for (NhanSu ns : this.oblNhanSu.getListNS()) {
				if (t.getMaNV().equalsIgnoreCase(ns.getmaNS())) {
					ns.oblTask.getListTask().add(t);

				}
			}
		}
		for (PhongBan pb : this.oblPhongBan.getListPB()) {
			for (NhanSu ns : this.oblNhanSu.getListNS()) {
				if (ns.getMaPB().equalsIgnoreCase(pb.getMaPhongBan())) {
					if (ns instanceof NhanVien) {
						pb.getOblNS().getListNS().add((NhanVien) ns);
					}
					if (ns instanceof TruongPhong) {
						pb.setTruongPhong((TruongPhong) ns);
					}
				}
			}
			pb.soNgQL();
		}
		for (NhanSu ns : this.oblNhanSu.getListNS()) {
			ns.tinhLuong();
		}
	}

	public void inputListTP() {
		for (NhanSu ns : this.oblNhanSu.getListNS()) {
			if (ns instanceof TruongPhong) {
				this.oblTruongPhong.getListTP().add((TruongPhong) ns);
			}
		}

	}

	// Xuất List
	public void xuatDSTask() {
		this.oblTask.output();
	}

	public void xuatDSNS() {
		this.oblNhanSu.output();

	}

	// 1.Phân Bổ Nhân Viên
	public void xuatDSPhongBanchoNV() {
		for (PhongBan pb : this.oblPhongBan.getListPB()) {
			pb.xuatTenvaMa();
		}
	}

	public void phanBoNhanVien() {
		Scanner scan = new Scanner(System.in);
		for (NhanSu ns : this.oblNhanSu.getListNS()) {
			if (ns.getMaPB() == "-1") {
				if (ns instanceof NhanVien) {
					boolean flag = true;
					do {
						System.out.println("Phân Bổ Nhân Viên về Phòng Ban: ");
						ns.xuatTenvaMa();
						System.out.println("Chọn 1 để phân bổ.Chọn 2 để bỏ qua");
						int chon = Integer.parseInt(scan.nextLine());
						switch (chon) {
						case 1:
							System.out.println("Đây là danh sách phong ban ban");
							xuatDSPhongBanchoNV();
							System.out.println("Mời chọn phòng ban>>");
							PhongBan pb;
							do {
								String maPhong = scan.nextLine();
								pb = layPhongBan(maPhong);
								if (pb != null) {
									ns.setMaPB(maPhong);
									pb.getOblNS().getListNS().add((NhanVien) ns);
									kiemtraTPcuaPB(maPhong);
								} else
									System.out.println("Phòng ban không tồn tại\nNhập lại");
							} while (pb == null);
							flag = false;
							break;
						case 2:
							flag = false;
							break;
						default:
							System.out.println("Chỉ chọn 1 hoặc 2");
						}
					} while (flag);
				}
			}
		}

	}

	public void kiemtraTPcuaPB(String maPhong) {
		for (PhongBan pb : this.oblPhongBan.getListPB()) {
			if (pb.getMaPhongBan().equalsIgnoreCase(maPhong)) {
				if (pb.getTruongPhong() != null) {
					pb.getTruongPhong().tangNhanVien();
				}
				
			}
		}
	}

	private PhongBan layPhongBan(String maPhong) {
		for (PhongBan pb : this.oblPhongBan.getListPB()) {
			if (pb.getMaPhongBan().equalsIgnoreCase(maPhong)) {
				return pb;
			}
		}
		return null;

	}

	// 2.chỉ định trưởng Phòng
	public void chiDinhTruongPhong() {
		Scanner scan = new Scanner(System.in);
		boolean k = true;
		for (TruongPhong tp : this.oblTruongPhong.getListTP()) {
			if (tp.getMaPB().equalsIgnoreCase("-1")) {
				boolean flag = true;
				do {
					System.out.println("Đây là Trưởng Phòng cần bổ nhiệm:");
					tp.xuatTenvaMa();
					System.out.println("Chọn 1 để chỉ định phòng ban.Chọn 2 để bỏ qua");
					int chon = Integer.parseInt(scan.nextLine());
					switch (chon) {
					case 1:
						k = xuatDSPhongBanchoTP();
						if (!k) {
							flag = false;
							break;
						}
						case1(scan, tp);
						flag = false;
						break;
					case 2:
						flag = false;
						break;
					default:
						System.out.println("Chỉ chọn 1 or 2");
					}
				} while (flag);
			}
			if (!k) {
				System.out.println("tất cả phòng ban đều đã có trưởng Phòng");
				break;
			}
		}
	}

	public boolean xuatDSPhongBanchoTP() {
		boolean f = false;
		for (PhongBan pb : this.oblPhongBan.getListPB()) {
			if (pb.getTruongPhong() == null) {
				pb.xuatTenvaMa();
				f = true;
			}
		}

		return f;
	}

	public boolean KtraDSPhongBanchoTP(String maPhong) {
		boolean f = true;
		for (PhongBan pb : this.oblPhongBan.getListPB()) {
			if (pb.getMaPhongBan().equalsIgnoreCase(maPhong)) {
				if (pb.getTruongPhong() == null) {
					f = false;
				}
			}
		}
		return f;
	}

	public void KtraNVtrongPB() {
		for (PhongBan pb : this.oblPhongBan.getListPB()) {
			if (pb.getOblNS().getListNS().size() > 0) {
				pb.soNgQL();
			}
		}
	}

	public void case1(Scanner scan, TruongPhong tp) {
		System.out.println("==========================Hãy chọn các phòng ban phía trên=============================");
		PhongBan pb = null;
		do {
			System.out.println("Mời chọn mã PB");
			boolean flag;
			do {
				String maPhong = scan.nextLine();
				flag = KtraDSPhongBanchoTP(maPhong);
				if (!flag) {
					pb = layPhongBan(maPhong);
					if (pb != null) {
						tp.setMaPB(maPhong);
						pb.setTruongPhong(tp);
						KtraNVtrongPB();
						tp.tinhLuong();
					}
					break;
				} else
					System.out.println("Chỉ chọn các phòng phía trên");

			} while (flag);

		} while (pb == null);
		System.out.println("===================================================================================");
	}

	// 3.Phân task
	public void phanTask(Scanner scan) {
		for (Task task : this.oblTask.getListTask()) {
			if (task.getMaNV() == "-1") {
				System.out.println("Task cần phân công:");
				task.xuatMavaTen();;
				System.out.println("1.Tiếp tục phân công\n2.Bỏ qua task này");
				boolean flag = true;
				do {
					int chon = Integer.parseInt(scan.nextLine());
					switch (chon) {
					case 1:
						case1task(scan, task);
						flag = false;
						break;
					case 2:
						flag = false;
						break;
					}
				} while (flag);
			}
		}
	}

	public void case1task(Scanner scan, Task task) {
		NhanSu ns = timNhanSuTheoMa(scan);
		boolean flag = true;
		do {
			System.out.println("Chọn 1 để phân bổ task.Chọn 2 để đổi nhân sự khác.Chọn 3 bỏ qua ko phân task này");
			int chon = Integer.parseInt(scan.nextLine());
			switch (chon) {
			case 1:
				task.setMaNV(ns.getmaNS());
				ns.getOblTask().getListTask().add(task);
				ns.tinhLuong();
				System.out.println("Phân task thành công!");
				flag = false;
				break;

			case 2:
				ns = timNhanSuTheoMa(scan);
				break;
			case 3:
				flag = false;
				break;
			default:
				System.out.println("Chỉ chọn 1 2 hoặc 3");
			}
		} while (flag);
	}

	public NhanSu timNhanSuTheoMa(Scanner scan) {
		NhanSu ns = null;
		do {
			System.out.println("Nhập mã nhân viên nhận task:");
			String ma = scan.nextLine();
			for (NhanSu nSu : this.oblNhanSu.getListNS()) {
				if (nSu.getmaNS().equalsIgnoreCase(ma)) {
					ns = nSu;
					System.out.println("Nhân Sự bạn chọn là : ");
					ns.xuatTenvaMa();
					break;
				}
			}
		} while (ns == null);
		return ns;
	}

	// 4.tìm Nhân Viên có nhiều task;
	public void NVconhieuTask(DanhSachNhanSu list) {
		NhanSu max = list.getListNS().get(0);
		int k = 0;
		for (int i = 1; i < list.getListNS().size(); i++) {
			if (list.getListNS().get(i).getOblTask().getListTask().size() > max.getOblTask().getListTask().size()) {
				max = list.getListNS().get(i);
				k = i;
			}
		}
		for (int j = k; j < list.getListNS().size(); j++) {
			if (list.getListNS().get(j).getOblTask().getListTask().size() == max.getOblTask().getListTask().size()) {
				list.getListNS().get(j).output();
			}
		}
	}

	// 5.tìm tuổi trẻ tài cao
	public void NVTuoiTreTaiCao() {
		DanhSachNhanSu listNVTT = listNVTuoiTreTaiCao();
		NVconhieuTask(listNVTT);
	}

	public DanhSachNhanSu listNVTuoiTreTaiCao() {
		int Tmin = this.oblNhanSu.getListNS().get(0).getNamS();
		for (NhanSu ns : this.oblNhanSu.getListNS()) {
			if (ns.getNamS() > Tmin) {
				Tmin = ns.getNamS();
			}
		}

		DanhSachNhanSu listNVTT = new DanhSachNhanSu();
		for (NhanSu ns : this.oblNhanSu.getListNS()) {
			if (ns.getNamS() == Tmin) {
				listNVTT.getListNS().add(ns);
			}
		}
		return listNVTT;
	}

	//6.PhongBan co NhanVien Tre Nhat
	public DanhSachNhanSu listNVcoPhongBan() {
		DanhSachNhanSu listNV = new DanhSachNhanSu();
		for (NhanSu ns : this.oblNhanSu.getListNS()) {
			if (ns instanceof NhanVien) {
				if (!ns.getMaPB().equalsIgnoreCase("-1")) {
					listNV.getListNS().add(ns);
				}
			}
		}
		return listNV;
	}

	public void NhungNamSinhLonNhat(DanhSachNhanSu list) {
		int max = list.getListNS().get(0).getNamS(), k = 0;
		for (int i = 1; i < list.getListNS().size(); i++) {
			if (list.getListNS().get(i).getNamS() > max) {
				max = list.getListNS().get(i).getNamS();
				k = i;
			}
		}
		PhongBan pb = null;
		for (int i = 1; i < list.getListNS().size(); i++) {
			if (list.getListNS().get(i).getNamS() == max) {
				pb = layPhongBan(list.getListNS().get(i).getMaPB());
				pb.output();
			}
		}
	}

	public void timPBcoNVTreNhat() {
		NhungNamSinhLonNhat(listNVcoPhongBan());
	}

//7.Quicksort
	public void quicksort(DanhSachNhanSu List, int left, int right) {
		int x, i, j;
		x = List.getListNS().get((left + right) / 2).getOblTask().getListTask().size();
		i = left;
		j = right;
		do {
			while (List.getListNS().get(i).getOblTask().getListTask().size() > x)
				i++;
			while (List.getListNS().get(j).getOblTask().getListTask().size() < x)
				j--;
			if (i <= j) {
				Collections.swap(List.getListNS(), i, j);
				i++;
				j--;
			}
		} while (i < j);
		if (left < j)
			quicksort(List, left, j);
		if (i < right)
			quicksort(List, i, right);

	}

	public void soft() {
		quicksort(this.getOblNhanSu(), 0, this.getOblNhanSu().getListNS().size() - 1);
		xuatDSNS();
	}

//8.Interchangesort{	
	public void Interchangesort(DanhSachNhanSu List) {
		int i, j;
		for (i = 0; i < List.getListNS().size(); i++)
			for (j = i + 1; j < List.getListNS().size(); j++) {
				NhanSu nsi = List.getListNS().get(i);
				NhanSu nsj = List.getListNS().get(j);
				if (nsj.getTenNS().compareToIgnoreCase(nsi.getTenNS()) < 0) {
					Collections.swap(List.getListNS(), i, j);
				}
			}
	}

	public void softi() {
		Interchangesort(this.oblNhanSu);
		xuatDSNS();
	}
	//9. Xóa
	public boolean KtraNS(String ma) {
		for(NhanSu ns : this.oblNhanSu.getListNS()) {
			if(ns.getmaNS().equalsIgnoreCase(ma)) {
				return false;	
			}
		}
		return true;
	}
	public void Xoa() {
		Scanner s = new Scanner(System.in);
		System.out.println("Nhập mã nhân viên muốn xóa");
		boolean flag = true;
		do {
			String ma = s.nextLine();
			flag = KtraNS(ma);
			if(!flag) {
				phanLoaiMa(ma);
			}else System.out.println("Mã không tông tại\n vui lòng nhập lại");
		}while(flag);
		
	}
	public void phanLoaiMa(String ma) {
		NhanSu ns;
		for (int i = 0; i < this.oblNhanSu.getListNS().size(); i++) {
			ns=this.oblNhanSu.getListNS().get(i);
			if(ns.getmaNS().equalsIgnoreCase(ma)) {
				if( ns instanceof NhanVien ) {
					XoaNhanVien(ns);
					this.oblNhanSu.getListNS().remove(ns);
				}
				if( ns instanceof TruongPhong) {
					XoaTP(ns);
					this.oblNhanSu.getListNS().remove(ns);
				}
			}
		}
	}
	
	public void XoaNhanVien(NhanSu ns) {
		if(ns.getOblTask().getListTask().size()>0) {
			for(Task t : ns.getOblTask().getListTask()) {
				t.setMaNV("-1");
			}
		}
		if(!ns.getMaPB().equalsIgnoreCase("-1")) {
			String maPB = ns.getMaPB();
			for (PhongBan pb : this.oblPhongBan.getListPB()) {
				if (pb.getMaPhongBan().equalsIgnoreCase(maPB)) {
					pb.getOblNS().getListNS().remove(ns);
					if(pb.getTruongPhong()!=null) {
						pb.getTruongPhong().giamNhanVien();						
					}
				}
			}
		}
	}
	public void XoaTP(NhanSu ns) {
		for(PhongBan pb :this.oblPhongBan.getListPB()) {
			if(pb.getTruongPhong() != null && !ns.getMaPB().equalsIgnoreCase("-1") ) {
				if(pb.getMaPhongBan().equalsIgnoreCase(ns.getMaPB())) {
					pb.setTruongPhong(null);
				}
			}
		}		
	}
	//Xoa Task
	public void XoaTask() {
		Scanner s = new Scanner(System.in);
		System.out.println("Nhập mã task muốn xóa");
		boolean flag = true;
		do {
			String maT = s.nextLine();
			flag = KtraT(maT);
			if(!flag) {
				ccc(maT);
			}else System.out.println("Mã không tông tại\n vui lòng nhập lại");
		}while(flag);
	}
	public void ccc(String ma) {
		for(NhanSu ns: this.oblNhanSu.getListNS()) {
			if(ns.getOblTask().getListTask().size()>0) {
				for(int i = 0; i < ns.getOblTask().getListTask().size();i++) {
//				for(Task t : ns.getOblTask().getListTask()) {
					Task t = ns.getOblTask().getListTask().get(i);
					if(t.getMaTask().equalsIgnoreCase(ma)) {
						t.setMaNV("-1");
						ns.getOblTask().getListTask().remove(t);
						ns.tinhLuong();
					}
				}
			}
		}
	}
	public boolean KtraT(String ma) {
		for(Task t : this.oblTask.getListTask()) {
			if(t.getMaTask().equalsIgnoreCase(ma)) {
				return false;	
			}
		}
		return true;
	}
}
