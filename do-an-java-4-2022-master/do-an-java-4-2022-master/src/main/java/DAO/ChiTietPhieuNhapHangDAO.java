package DAO;

import DTO.ChiTietPhieuNhapHangDTO;
import java.util.List;
import mapper.ChiTietPhieuNhapHangMapper;

public class ChiTietPhieuNhapHangDAO extends
    AbstractDAO<ChiTietPhieuNhapHangDTO> { // Do table là OneToMany nên xài findAllByMaPhieu thay findOne

  public void save(ChiTietPhieuNhapHangDTO chiTietPhieuNhapHangDTO) {  //check
    String[] fields = {"MaPhieuNhap", "MaSanPham", "SoLuong", "DonGia", "ThanhTien"};
    super.save("chitietphieunhaphang", fields, chiTietPhieuNhapHangDTO.getMaPhieuNhapHang(),
        chiTietPhieuNhapHangDTO.getMaSanPham(), chiTietPhieuNhapHangDTO.getSoLuong(),
        chiTietPhieuNhapHangDTO.getDonGia(), chiTietPhieuNhapHangDTO.getThanhTien());
  }

  public List<ChiTietPhieuNhapHangDTO> findAll() { //check

    return super.findAll("chitietphieunhaphang", new ChiTietPhieuNhapHangMapper());
  }

  public List<ChiTietPhieuNhapHangDTO> findAllByMaPhieuNhapHang(String maPhieuNhapHang) { //check
//    StringBuilder sql = new StringBuilder(
//        "SELECT * FROM `cuahangtienloi`.`chitietphieunhaphang` WHERE MaPhieuNhap = ?");
//    return query(sql.toString(), new ChiTietPhieuNhapHangMapper(), maPhieuNhapHang);
    return findAllByCondition("chitietphieunhaphang", "MaPhieuNhap", maPhieuNhapHang,
        new ChiTietPhieuNhapHangMapper());
  }

  public ChiTietPhieuNhapHangDTO findOne(String maPhieuNhap) { //check
    return super.findOne("chitietphieunhaphang", "MaPhieuNhap", maPhieuNhap,
        new ChiTietPhieuNhapHangMapper());
  }

  public ChiTietPhieuNhapHangDTO findOne(String maPhieuNhap, String maSanPham) { //check
    return super.findOne("chitietphieunhaphang", "MaPhieuNhap", maPhieuNhap,
        new ChiTietPhieuNhapHangMapper(), "MaSanPham", maSanPham);
  }

  public void update(
      ChiTietPhieuNhapHangDTO chiTietPhieuNhapHangDTO) { //do table quan hệ OneToMany nên khi sửa phải thêm mã sản phẩm trong where)
//    StringBuilder sql = new StringBuilder("UPDATE `cuahangtienloi`.`chitietphieunhaphang`");
//    sql.append(
//        " SET SoLuong = ?, DonGia = ?, ThanhTien = ? WHERE MaPhieuNhap = ? AND MaSanPham = ?");
//    super.update(sql.toString(), chiTietPhieuNhapHangDTO.getSoLuong(),
//        chiTietPhieuNhapHangDTO.getDonGia(), chiTietPhieuNhapHangDTO.getThanhTien(),
//        chiTietPhieuNhapHangDTO.getMaPhieuNhapHang(), chiTietPhieuNhapHangDTO.getMaSanPham());
    String[] fields = {"SoLuong", "DonGia", "ThanhTien"};
    String[] condition = {"MaPhieuNhap", "MaSanPham"};
    super.update("chitietphieunhaphang", fields, condition, chiTietPhieuNhapHangDTO.getSoLuong(),
        chiTietPhieuNhapHangDTO.getDonGia(), chiTietPhieuNhapHangDTO.getThanhTien(),
        chiTietPhieuNhapHangDTO.getMaPhieuNhapHang(), chiTietPhieuNhapHangDTO.getMaSanPham());
  }

  public void delete(String maPhieuNhapHang,
      String maSanPham) {  //do table quan hệ OneToMany nên khi xóa dính lỗi Duplicate(trùng)
    String[] condition = {"MaPhieuNhap", "MaSanPham"};
    delete("chitietphieunhaphang", condition, maPhieuNhapHang, maSanPham);
  }

  public int count() {
    return findAll().size();
  }

  public int countByMaPhieuNhapHang(String maPhieu) {
    return findAllByMaPhieuNhapHang(maPhieu).size();
  }

}
