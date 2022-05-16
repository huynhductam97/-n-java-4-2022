import DAO.ChiTietChuongTrinhKhuyenMaiDAO;
import DAO.ChiTietHoaDonDAO;
import DAO.ChiTietPhieuNhapHangDAO;
import DAO.ChuongTrinhKhuyenMaiDAO;
import DAO.HoaDonDAO;
import DAO.KhachHangDAO;
import DAO.LoaiSanPhamDAO;
import DAO.NhaCungCapDAO;
import DAO.NhaSanXuatDAO;
import DAO.NhanVienDAO;
import DAO.PhieuNhapHangDAO;
import DAO.SanPhamDAO;
import DAO.TaiKhoanDAO;
import DTO.ChiTietChuongTrinhKhuyenMaiDTO;
import DTO.ChiTietHoaDonDTO;
import DTO.ChiTietPhieuNhapHangDTO;
import DTO.ChuongTrinhKhuyenMaiDTO;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.LoaiSanPhamDTO;
import DTO.NhaCungCapDTO;
import DTO.NhaSanXuatDTO;
import DTO.NhanVienDTO;
import DTO.PhieuNhapHangDTO;
import DTO.SanPhamDTO;
import DTO.TaiKhoanDTO;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class HamMain {

  public static void main(String[] args) {
    SanPhamDTO sanPhamDTO = new SanPhamDTO();
    SanPhamDAO sanPhamDAO = new SanPhamDAO();
//    sanPhamDTO.setMaSanPham("spjava");
//    sanPhamDTO.setTenSanPham("ducku fuck you");
//    sanPhamDTO.setMaNhaSanXuat("NSX6");
//    sanPhamDTO.setMaLoai("L5");
//    sanPhamDTO.setSoLuong(10);
//    sanPhamDTO.setDonGia(15000);
//    sanPhamDTO.setDonViTinh("con");
//    sanPhamDAO.update(sanPhamDTO); //check
    //sanPhamDAO.delete("spjava");
//    sanPhamDTO = sanPhamDAO.findOne("SP10");

    //List<SanPhamDTO> list = sanPhamDAO.findAll();
    PhieuNhapHangDTO phieuNhapHangDTO = new PhieuNhapHangDTO();
    PhieuNhapHangDAO phieuNhapHangDAO = new PhieuNhapHangDAO();
//    phieuNhapHangDTO = phieuNhapHangDAO.findOne("PNH100");

//    phieuNhapHangDTO.setMaPhieuNhapHang("PNH100");
//    phieuNhapHangDTO.setMaNhanvien("NV3");
//    phieuNhapHangDTO.setMaNhaCungCap("NCC6");
//    phieuNhapHangDTO.setNgayLap(java.sql.Date.valueOf("2002-01-15"));
//    phieuNhapHangDTO.setTongTien(100000000);
//    phieuNhapHangDAO.update(phieuNhapHangDTO);
    //phieuNhapHangDAO.delete("PNH100");
//    List<PhieuNhapHangDTO> list = phieuNhapHangDAO.findAll();


   NhaSanXuatDTO nhaSanXuatDTO = new NhaSanXuatDTO();
    NhaSanXuatDAO nhaSanXuatDAO = new NhaSanXuatDAO();
//    nhaSanXuatDTO.setTenNhaSanXuat("lai la duc kuuuuu 1");
//    nhaSanXuatDTO.setMaNhaSanXuat("NSX15");
//    nhaSanXuatDTO.setSoDienThoai("0912835868");
//    nhaSanXuatDTO.setDiaChi("hahahahahaha");
//    nhaSanXuatDAO.update(nhaSanXuatDTO);
//    nhaSanXuatDTO = nhaSanXuatDAO.findOne("NSX10");
//    nhaSanXuatDAO.delete("NSX12");
//    List<NhaSanXuatDTO> list = nhaSanXuatDAO.findAll();

    NhanVienDTO nhanVienDTO = new NhanVienDTO();
    NhanVienDAO nhanVienDAO = new NhanVienDAO();
//    nhanVienDTO.setMaNhanVien("NV5");
//    nhanVienDTO.setTenNhanVien("Huỳnh Đức Kuuuu");
//    nhanVienDTO.setSoDienThoai("0933128368");
//    nhanVienDTO.setLuong(15000000);
//    nhanVienDTO.setViTri("Lao công co trach nhiem");
//    nhanVienDTO.setEmail("haha@gmail.com");
//    nhanVienDTO.setNgayVaoLam(java.sql.Date.valueOf("2002-01-15"));
//    nhanVienDAO.update(nhanVienDTO);
    //nhanVienDTO = nhanVienDAO.findOne("NV5");
//      List<NhanVienDTO> list = nhanVienDAO.findAll();
    //nhanVienDAO.delete("NV5");


    NhaCungCapDTO nhaCungCapDTO = new NhaCungCapDTO();
    NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO();
//    nhaCungCapDTO.setMaNhaCungCap("NCC30");
//    nhaCungCapDTO.setTenNhaCungCap("van la duc kuuuuu");
//    nhaCungCapDTO.setSdt("0933128368");
//    nhaCungCapDTO.setEmail("haha@gmail.com");
//    nhaCungCapDTO.setDiaChi("3198389");
//    nhaCungCapDAO.update(nhaCungCapDTO);
   // nhaCungCapDTO = nhaCungCapDAO.findOne("NCC30");
//    List<NhaCungCapDTO> list = nhaCungCapDAO.findAll();
//    nhaCungCapDAO.delete("NCC30");

    LoaiSanPhamDTO loaiSanPhamDTO = new LoaiSanPhamDTO();
    LoaiSanPhamDAO loaiSanPhamDAO = new LoaiSanPhamDAO();
//    loaiSanPhamDTO.setMaLoai("L6");
//    loaiSanPhamDTO.setTenLoai("Qua troi cuttt luonn");
//    loaiSanPhamDAO.update(loaiSanPhamDTO);
   // loaiSanPhamDTO = loaiSanPhamDAO.findOne("L6");
//    List<LoaiSanPhamDTO> list = loaiSanPhamDAO.findAll();
//      loaiSanPhamDAO.delete("L6");

    KhachHangDTO khachHangDTO = new KhachHangDTO();
    KhachHangDAO khachHangDAO = new KhachHangDAO();
//    khachHangDTO.setTenKhachHang("lai la duc kuuuuuu" );
//    khachHangDTO.setMaKhachHang("KH30");
//    khachHangDAO.update(khachHangDTO);
   // khachHangDTO = khachHangDAO.findOne("KH30");
//    List<KhachHangDTO> list = khachHangDAO.findAll();
//    khachHangDAO.delete("KH30");

   HoaDonDTO hoaDonDTO = new HoaDonDTO();
    HoaDonDAO hoaDonDAO = new HoaDonDAO();
//    hoaDonDTO.setMaHoaDon("HD100");
//    hoaDonDTO.setMaNhanVien("NV5");
//    hoaDonDTO.setMaKhachHang("KH3");
//    hoaDonDTO.setNgayLap(java.sql.Date.valueOf("2022-04-15"));
//    hoaDonDTO.setTongTien(100000);
//    hoaDonDAO.update(hoaDonDTO);
  //  hoaDonDTO = hoaDonDAO.findOne("HD100");
//    List<HoaDonDTO> list = hoaDonDAO.findAll();
    //hoaDonDAO.delete("HD10");

//    Locale locale = new Locale("vi", "VN");
//    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
    //System.out.println("Money: " + currencyFormatter.format(hoaDonDTO.getTongTien()));
//    for(HoaDonDTO hoaDonDTO1: hoaDonDAO.findAll()) {
//      System.out.println("Mã hóa đơn: " + hoaDonDTO1.getMaHoaDon());
//      System.out.println("Mã nhân viên: " + hoaDonDTO1.getMaNhanVien());
//      System.out.println("Mã khách hàng: " + hoaDonDTO1.getMaKhachHang());
//      System.out.println("Ngày lập: " + hoaDonDTO1.getNgayLap());
//      System.out.println("Tổng tiền: " + currencyFormatter.format(hoaDonDTO1.getTongTien()));
//      System.out.println("========================================");
//    }
    // hoaDonDTO = hoaDonDAO.findOne("HD100");
//    hoaDonDAO.delete("HD100");
//    System.out.println("Tổng số hóa đơn: " + hoaDonDAO.count());


     ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO = new ChuongTrinhKhuyenMaiDTO();
     ChuongTrinhKhuyenMaiDAO chuongTrinhKhuyenMaiDAO  = new ChuongTrinhKhuyenMaiDAO();
//    chuongTrinhKhuyenMaiDTO.setMaChuongTrinh("CT100");
//    chuongTrinhKhuyenMaiDTO.setTenKhuyenMai("khuyến mãi đức ku đẹp trai hehehe lan thu 2");
//    chuongTrinhKhuyenMaiDTO.setNgayBatDau(java.sql.Date.valueOf("2022-04-24"));
//    chuongTrinhKhuyenMaiDTO.setNgayKetThuc(java.sql.Date.valueOf("2002-04-30"));
//    chuongTrinhKhuyenMaiDAO.update(chuongTrinhKhuyenMaiDTO);
   // chuongTrinhKhuyenMaiDTO = chuongTrinhKhuyenMaiDAO.findOne("CT100");
    //chuongTrinhKhuyenMaiDAO.delete("CT100");
//    List<ChuongTrinhKhuyenMaiDTO> list = chuongTrinhKhuyenMaiDAO.findAll();
//    for(ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO1 : chuongTrinhKhuyenMaiDAO.findAll()) {
//      System.out.println("Mã chương trình: " + chuongTrinhKhuyenMaiDTO1.getMaChuongTrinh());
//      System.out.println("Tên khuyến mãi: " + chuongTrinhKhuyenMaiDTO1.getTenKhuyenMai());
//      System.out.println("Ngày bắt đầu: " + chuongTrinhKhuyenMaiDTO1.getNgayBatDau());
//      System.out.println("Ngày kết thúc: " + chuongTrinhKhuyenMaiDTO1.getNgayKetThuc());
//      System.out.println("===========================");
//    }
//    System.out.println("Tổng số lượng: " + chuongTrinhKhuyenMaiDAO.count());

    ChiTietPhieuNhapHangDTO chiTietPhieuNhapHangDTO = new ChiTietPhieuNhapHangDTO();
    ChiTietPhieuNhapHangDAO chiTietPhieuNhapHangDAO = new ChiTietPhieuNhapHangDAO();
 //   chiTietPhieuNhapHangDTO = chiTietPhieuNhapHangDAO.findOne("PNH1", "SP5");
//    chiTietPhieuNhapHangDAO.delete("PNH10", "SP17");
//    System.out.println("Tổng hàng: " + chiTietPhieuNhapHangDAO.countByMaPhieuNhapHang("PNH10"));
//    chiTietPhieuNhapHangDTO.setMaPhieuNhapHang("PNH10");
//    chiTietPhieuNhapHangDTO.setMaSanPham("SP17");
//    chiTietPhieuNhapHangDTO.setSoLuong(1500);
//    chiTietPhieuNhapHangDTO.setDonGia(20000);
//    chiTietPhieuNhapHangDTO.setThanhTien(chiTietPhieuNhapHangDTO.getSoLuong() * chiTietPhieuNhapHangDTO.getDonGia());
//    chiTietPhieuNhapHangDAO.update(chiTietPhieuNhapHangDTO);
//    chiTietPhieuNhapHangDTO = chiTietPhieuNhapHangDAO.findOne("PNH10", "SP20");
 //   chiTietPhieuNhapHangDAO.delete("PNH10", "SP17");
//    List<ChiTietPhieuNhapHangDTO> list = chiTietPhieuNhapHangDAO.findAllByMaPhieuNhapHang("PNH10");


    ChiTietHoaDonDTO chiTietHoaDonDTO = new ChiTietHoaDonDTO();
    ChiTietHoaDonDAO chiTietHoaDonDAO = new ChiTietHoaDonDAO();
//    chiTietHoaDonDTO.setMaHoaDon("HD1");
//    chiTietHoaDonDTO.setMaSanPham("SP1");
//    chiTietHoaDonDTO.setDonGia(15000);
//    chiTietHoaDonDTO.setSoLuong(130);
//    chiTietHoaDonDTO.setThanhTien(chiTietHoaDonDTO.getSoLuong() * chiTietHoaDonDTO.getDonGia());
//    chiTietHoaDonDAO.update(chiTietHoaDonDTO);
//   chiTietHoaDonDTO = chiTietHoaDonDAO.findOne("HD1", "SP15");
    //chiTietHoaDonDAO.delete("HD1", "SP1");
//    List<ChiTietHoaDonDTO> list = chiTietHoaDonDAO.findAllByMaHoaDon("HD1");

    //  chiTietHoaDonDTO = chiTietHoaDonDAO.findOne("HD1", "SP15");
//    for (ChiTietHoaDonDTO chiTietHoaDonDTO1 : chiTietHoaDonDAO.findAllByMaHoaDon("HD12")) {
//      System.out.printf("%-20s %-20s %-20d %-20d %-20d\n", chiTietHoaDonDTO1.getMaHoaDon(), chiTietHoaDonDTO1.getMaSanPham(),
//          chiTietHoaDonDTO1.getDonGia(), chiTietHoaDonDTO1.getSoLuong(),
//          chiTietHoaDonDTO1.getThanhTien());
//    }
   // chiTietHoaDonDAO.delete("HD1", "SP15");

    ChiTietChuongTrinhKhuyenMaiDTO chiTietChuongTrinhKhuyenMaiDTO = new ChiTietChuongTrinhKhuyenMaiDTO();
    ChiTietChuongTrinhKhuyenMaiDAO chiTietChuongTrinhKhuyenMaiDAO = new ChiTietChuongTrinhKhuyenMaiDAO();
//    chiTietChuongTrinhKhuyenMaiDTO.setMaChuongTrinh("CT1");
//    chiTietChuongTrinhKhuyenMaiDTO.setMaSanPham("SP5");
//    chiTietChuongTrinhKhuyenMaiDTO.setPhanTramGiam(15f);
//    chiTietChuongTrinhKhuyenMaiDAO.update(chiTietChuongTrinhKhuyenMaiDTO);
//    chiTietChuongTrinhKhuyenMaiDTO  = chiTietChuongTrinhKhuyenMaiDAO.findOne("CT1", "SP20");
//    for(ChiTietChuongTrinhKhuyenMaiDTO chiTietChuongTrinhKhuyenMaiDTO1 : chiTietChuongTrinhKhuyenMaiDAO.findAllByMaChuongTrinh("CT1")) {
//      System.out.println("Mã chương trình: " + chiTietChuongTrinhKhuyenMaiDTO1.getMaChuongTrinh());
//      System.out.println("Mã sản phẩm: " + chiTietChuongTrinhKhuyenMaiDTO1.getMaSanPham());
//      System.out.println("% Giảm: " + chiTietChuongTrinhKhuyenMaiDTO1.getPhanTramGiam());
//      System.out.println("================");
//    }
//   chiTietChuongTrinhKhuyenMaiDTO = chiTietChuongTrinhKhuyenMaiDAO.findOne("CT1", "SP20");
//    List<ChiTietChuongTrinhKhuyenMaiDTO> list = chiTietChuongTrinhKhuyenMaiDAO.findAllByMaChuongTrinh("CT1");
//    chiTietChuongTrinhKhuyenMaiDAO.delete("CT1", "SP20");
      //chiTietChuongTrinhKhuyenMaiDAO.delete("CT1", "SP5");
//    System.out.println("Tổng số chương trình có mã CT1: " + chiTietChuongTrinhKhuyenMaiDAO.countByMaChuongTrinh("CT1"));
    TaiKhoanDTO taiKhoanDTO = new TaiKhoanDTO();
    TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();

    taiKhoanDTO.setMaTaiKhoan("TK5");
    taiKhoanDTO.setTenTaiKhoan("duckuuuu rat la ngu");
    taiKhoanDTO.setPhanQuyen("admin");
    taiKhoanDTO.setMatKhau("123456");
    taiKhoanDTO.setMaNhanVien("NV4");
//    taiKhoanDAO.update(taiKhoanDTO); //1 nhân viên có thể có nhiều tài khoản ?
   taiKhoanDAO.findOne("TK5");
  }
}
