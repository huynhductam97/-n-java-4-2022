package mapper;

import DTO.PhieuNhapHangDTO;
import java.sql.ResultSet;

public class PhieuNhapHangMapper implements RowMapper<PhieuNhapHangDTO> {

  @Override
  public PhieuNhapHangDTO mapRow(ResultSet resultSet) {
    PhieuNhapHangDTO phieuNhapHangDTO = new PhieuNhapHangDTO();
    try {
      phieuNhapHangDTO.setMaPhieuNhapHang(resultSet.getString("MaPhieuNhapHang"));
      phieuNhapHangDTO.setMaNhaCungCap(resultSet.getString("MaNhaCungCap"));
      phieuNhapHangDTO.setMaNhanvien(resultSet.getString("MaNhanVien"));
      phieuNhapHangDTO.setNgayLap(resultSet.getDate("NgayLap"));
      phieuNhapHangDTO.setTongTien(resultSet.getInt("TongTien"));
    } catch (Exception e) {
      System.out.println("Lỗi ở phiếu nhập hàng Mapper: " + e.getMessage());
      return null;
    }
    return phieuNhapHangDTO;
  }
}
