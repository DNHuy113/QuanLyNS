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
//		System.out.println("1.Nhập thông tin công ty");
//		System.out.println("2.Thêm hoặc xóa nhân sự");
//		System.out.println("3.Xuất thông tin toàn bộ công ty");
//		System.out.println("4.Tính tổng lương cho toàn bộ công ty");
//		System.out.println("5.Xuất nhân viên có lương cao nhất");
//		System.out.println("6.Phân bổ nhân viên chưa có ai quản lý");
//		System.out.println("7.Trưởng phòng có lượng nhân viên dưới quyền nhiều nhất");
//		System.out.println("8.Sắp Xếp nhân sự");
//		System.out.println("9.Tìm giám đốc có cổ phần cao nhất");
//		System.out.println("10.Xuất doanh thu giám đốc");
		System.out.println("0.Thoát");
	}
}