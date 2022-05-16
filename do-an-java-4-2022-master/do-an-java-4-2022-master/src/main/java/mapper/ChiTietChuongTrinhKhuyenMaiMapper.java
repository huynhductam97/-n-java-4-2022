package mapper;

import DTO.ChiTietChuongTrinhKhuyenMaiDTO;
import java.sql.ResultSet;

public class ChiTietChuongTrinhKhuyenMaiMapper implements
    RowMapper<ChiTietChuongTrinhKhuyenMaiDTO> {

  @Override
  public ChiTietChuongTrinhKhuyenMaiDTO mapRow(ResultSet resultSet) {
    try {
      ChiTietChuongTrinhKhuyenMaiDTO chiTietChuongTrinhKhuyenMaiDTO = new ChiTietChuongTrinhKhuyenMaiDTO();
      chiTietChuongTrinhKhuyenMaiDTO.setMaChuongTrinh(resultSet.getString("MaChuongTrinh"));
      chiTietChuongTrinhKhuyenMaiDTO.setMaSanPham(resultSet.getString("MaSanPham"));
      chiTietChuongTrinhKhuyenMaiDTO.setPhanTramGiam(resultSet.getDouble("%Giam"));
      return chiTietChuongTrinhKhuyenMaiDTO;
    } catch (Exception e) {
      System.out.println("Lỗi ở chi tiết chương trình khuyến mãi mapper: " + e.getMessage());
      return null;
    }
  }
}
