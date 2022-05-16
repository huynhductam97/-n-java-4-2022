package DAO;

import DTO.PhieuNhapHangDTO;
import java.util.List;
import mapper.PhieuNhapHangMapper;

public class PhieuNhapHangDAO extends AbstractDAO<PhieuNhapHangDTO> {

  public void save(PhieuNhapHangDTO phieuNhapHangDTO) {  //check
    String[] fields = {"MaPhieuNhapHang", "MaNhaCungCap", "MaNhanVien", "NgayLap", "TongTien"};
    super.save("phieunhaphang", fields, phieuNhapHangDTO.getMaPhieuNhapHang(),
        phieuNhapHangDTO.getMaNhaCungCap(), phieuNhapHangDTO.getMaNhanvien(),
        phieuNhapHangDTO.getNgayLap(), phieuNhapHangDTO.getTongTien());
  }

  public List<PhieuNhapHangDTO> findAll() { //check

    return super.findAll("phieunhaphang", new PhieuNhapHangMapper());
  }

  public PhieuNhapHangDTO findOne(String maPhieuNhapHang) { //check
    return super.findOne("phieunhaphang", "maphieunhaphang", maPhieuNhapHang,
        new PhieuNhapHangMapper());
  }

  public void update(PhieuNhapHangDTO phieuNhapHangDTO) {
//    StringBuilder sql = new StringBuilder("UPDATE `cuahangtienloi`.`phieunhaphang`");
//    sql.append(
//        " SET MaNhaCungCap = ?, MaNhanVien = ?, NgayLap = ?, TongTien = ? WHERE MaPhieuNhapHang = ?");
//    super.update(sql.toString(),
//        phieuNhapHangDTO.getMaNhaCungCap(), phieuNhapHangDTO.getMaNhanvien(),
//        phieuNhapHangDTO.getNgayLap(), phieuNhapHangDTO.getTongTien(),
//        phieuNhapHangDTO.getMaPhieuNhapHang());
    String[] fields = {"MaNhaCungCap", "MaNhanVien", "NgayLap", "TongTien"};
    String[] condition = {"MaPhieuNhapHang"};
    super.update("phieunhaphang", fields, condition, phieuNhapHangDTO.getMaNhaCungCap(),
        phieuNhapHangDTO.getMaNhanvien(),
        phieuNhapHangDTO.getNgayLap(), phieuNhapHangDTO.getTongTien(),
        phieuNhapHangDTO.getMaPhieuNhapHang());
  }

  public void delete(String maPhieuNhangHang) {
    String [] condition = {"MaPhieuNhapHang"};
    delete("phieunhaphang", condition, maPhieuNhangHang);
  }

  public int count() {
    return findAll().size();
  }
}
