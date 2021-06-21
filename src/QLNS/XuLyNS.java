package QLNS;

import java.util.Scanner;

public class XuLyNS {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		CongTy cty = new CongTy();
		cty.taoDuLieu();

		cty.getOblPhongBan().output();
		doMenu(cty);

	}

	private static void doMenu(CongTy cty) {
		boolean flag = true;
		Scanner s = new Scanner(System.in);
		do {
			inMenu();
			int chon = Integer.parseInt(s.nextLine());
			switch (chon) {
			case 1:
				cty.phanBoNhanVien();
				cty.getOblPhongBan().output();
				break;
			case 2:
				cty.chiDinhTruongPhong();
				cty.getOblPhongBan().output();
				break;
			case 3:
				cty.phanTask(s);
				cty.getOblPhongBan().output();
				break;
			case 4:
				 cty.NVconhieuTask(cty.getOblNhanSu());
				
				break;
			case 5:
				cty.NVTuoiTreTaiCao();
				break;
			case 6:
				cty.timPBcoNVTreNhat();

				break;
			case 7:
				cty.soft();
				break;
			case 8:
				cty.softi();
				break;
			case 9:
				cty.Xoa();
				cty.getOblPhongBan().output();
				break;
			case 10:
				cty.XoaTask();
				cty.xuatDSNS();
				break;
			case 0:
				flag = false;
				break;
			}
		} while (flag);
	}

	private static void inMenu() {
		System.out.println("Vui lòng chọn thực hiện");
		System.out.println("1.Phân Bổ Nhân Viên");
		System.out.println("2.Chỉ định trưởng Phòng");
		System.out.println("3.Phân công task");
		System.out.println("4.Tìm Nhân Viên có nhiều task");
		System.out.println("5.Tìm nhân viên trẻ tuổi có nhiều task nhất");
		System.out.println("6.Phòng ban có nhân viên trẻ nhất);
		System.out.println("7.Quicksort theo số lượng task");
		System.out.println("8.Interchangesort cho họ và tên");
		System.out.println("9.Xóa nhân sự theo mã ");
		System.out.println("10.Hủy task theo mã");
		System.out.println("0.Thoát");
	}
}
