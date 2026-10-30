import java.time.Year;
import java.util.Scanner;

public class QuanLySach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "UTF-8");

        // ===== NHẬP DỮ LIỆU =====
        System.out.print("Nhập mã sách: ");
        String maSach = sc.nextLine();

        System.out.print("Nhập tên sách: ");
        String tenSach = sc.nextLine();

        System.out.print("Nhập tác giả: ");
        String tacGia = sc.nextLine();

        System.out.print("Nhập năm xuất bản: ");
        int namXB = sc.nextInt();

        System.out.print("Nhập đơn giá: ");
        double donGia = sc.nextDouble();

        System.out.print("Nhập số lượng: ");
        int soLuong = sc.nextInt();

        System.out.println("\nChọn loại sách:");
        System.out.println("1. Sách giáo khoa");
        System.out.println("2. Sách tham khảo");
        System.out.println("3. Sách chuyên ngành");
        System.out.println("4. Sách khác");
        System.out.print("Nhập lựa chọn (1-4): ");
        int chon = sc.nextInt();

        // ===== Bài 1: Kiểm tra dữ liệu hợp lệ =====
        int namHienTai = Year.now().getValue();
        if (donGia <= 0) {
            System.out.println("\nDữ liệu không hợp lệ: đơn giá phải > 0.");
            return;
        } else if (soLuong < 0) {
            System.out.println("\nDữ liệu không hợp lệ: số lượng phải >= 0.");
            return;
        } else if (namXB <= 0 || namXB > namHienTai) {
            System.out.println("\nDữ liệu không hợp lệ: năm xuất bản phải từ 1 đến " + namHienTai + ".");
            return;
        }

        // ===== Tính tiền =====
        double thanhTien = donGia * soLuong;
        double phiVanChuyen = thanhTien * 0.05;
        double tongTienNhap = thanhTien + phiVanChuyen;

        // ===== Bài 2: Phân loại giá =====
        String loaiGia;
        if (donGia < 50000) {
            loaiGia = "Sách giá thấp";
        } else if (donGia <= 100000) {
            loaiGia = "Sách giá trung bình";
        } else if (donGia <= 200000) {
            loaiGia = "Sách giá cao";
        } else {
            loaiGia = "Sách giá đặc biệt";
        }

        // ===== Bài 3: Phân loại tồn kho =====
        String tonKho;
        if (soLuong == 0) {
            tonKho = "Hết sách";
        } else if (soLuong <= 5) {
            tonKho = "Sắp hết";
        } else if (soLuong <= 20) {
            tonKho = "Còn ít";
        } else {
            tonKho = "Còn nhiều";
        }

        // ===== Bài 4: switch chọn loại sách =====
        String loaiSach;
        switch (chon) {
            case 1:
                loaiSach = "Sách giáo khoa";
                break;
            case 2:
                loaiSach = "Sách tham khảo";
                break;
            case 3:
                loaiSach = "Sách chuyên ngành";
                break;
            case 4:
                loaiSach = "Sách khác";
                break;
            default:
                loaiSach = "Lựa chọn không hợp lệ";
        }

        // ===== IN KẾT QUẢ MỘT LẦN =====
        System.out.println("\n===== THÔNG TIN SÁCH =====");
        System.out.println("Mã sách       : " + maSach);
        System.out.println("Tên sách      : " + tenSach);
        System.out.println("Tác giả       : " + tacGia);
        System.out.println("Năm xuất bản  : " + namXB);
        System.out.printf("Đơn giá       : %,.0f%n", donGia);
        System.out.println("Số lượng      : " + soLuong);
        System.out.println("Loại sách     : " + loaiSach);
        System.out.println("Phân loại giá : " + loaiGia);
        System.out.println("Tồn kho       : " + tonKho);
        System.out.printf("Thành tiền      : %,.0f%n", thanhTien);
        System.out.printf("Phí vận chuyển  : %,.0f%n", phiVanChuyen);
        System.out.printf("Tổng tiền nhập  : %,.0f%n", tongTienNhap);

        sc.close();
    }
}