package DAO;

import DTO.ChiTietHoaDonDTO;
import java.util.List;
import mapper.ChiTietHoaDonMapper;

public class ChiTietHoaDonDAO extends AbstractDAO<ChiTietHoaDonDTO> {
  // Do table là OneToMany nên xài findAllByMaPhieu thay findOne

//  public void save(ChiTietHoaDonDTO chiTietHoaDonDTO) {  //check
//    StringBuilder stringBuilder = new StringBuilder(
//        "INSERT INTO `cuahangtienloi`.`chitiethoadon` ");
//    stringBuilder.append(
//        " (MahoaDon, MaSanPham, DonGia, SoLuong, ThanhTien)");
//    stringBuilder.append(
//        " VALUES (?, ?, ?, ?, ?);");
//
//    insert(stringBuilder.toString(), chiTietHoaDonDTO.getMaHoaDon(),
//        chiTietHoaDonDTO.getMaSanPham(), chiTietHoaDonDTO.getDonGia(),
//        chiTietHoaDonDTO.getSoLuong(), chiTietHoaDonDTO.getThanhTien());
//  }

  public void save(ChiTietHoaDonDTO chiTietHoaDonDTO) {  //check
    String[] fields = {"MaHoaDon", "MaSanPham", "DonGia", "SoLuong", "ThanhTien"};
    super.save("chitiethoadon", fields, chiTietHoaDonDTO.getMaHoaDon(),
        chiTietHoaDonDTO.getMaSanPham(), chiTietHoaDonDTO.getDonGia(),
        chiTietHoaDonDTO.getSoLuong(), chiTietHoaDonDTO.getThanhTien());
  }

  public List<ChiTietHoaDonDTO> findAll() { //check
    return super.findAll("chitiethoadon", new ChiTietHoaDonMapper());
  }

  public List<ChiTietHoaDonDTO> findAllByMaHoaDon(String maHoaDon) { //check
    return findAllByCondition("chitiethoadon", "MaHoaDon", maHoaDon, new ChiTietHoaDonMapper());
  }

  public ChiTietHoaDonDTO findOne(String maHoaDon) { //check
    return super.findOne("chitiethoadon", "MaHoaDon", maHoaDon, new ChiTietHoaDonMapper());
  }

  public ChiTietHoaDonDTO findOne(String maHoaDon, String maSanPham) { //check
    return super.findOne("chitiethoadon", "MaHoaDon", maHoaDon, new ChiTietHoaDonMapper(),
        "MaSanPham", maSanPham);
  }

  public void update(
      ChiTietHoaDonDTO chiTietHoaDonDTO) { //do table quan hệ OneToMany nên khi sửa phải thêm mã sản phẩm trong where)
    String[] fields = {"DonGia", "SoLuong", "ThanhTien"};
    String[] condition = {"MaHoaDon", "MaSanPham"};
    super.update("chitiethoadon", fields, condition, chiTietHoaDonDTO.getDonGia(),
        chiTietHoaDonDTO.getSoLuong(),
        chiTietHoaDonDTO.getThanhTien(), chiTietHoaDonDTO.getMaHoaDon(),
        chiTietHoaDonDTO.getMaSanPham());
  }

  public void delete(String maHoaDon,
      String maSanPham) {  //do table quan hệ OneToMany nên khi xóa dính lỗi Duplicate(trùng)
    String[] condition = {"MaHoaDon", "MaSanPham"};
    delete("chitiethoadon", condition, maHoaDon, maSanPham);
  }

  public int count() {
    return findAll().size();
  }

  public int countByMaHoaDon(String maPhieu) {
    return findAllByMaHoaDon(maPhieu).size();
  }
}
