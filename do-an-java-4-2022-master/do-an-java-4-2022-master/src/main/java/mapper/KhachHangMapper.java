package mapper;

import DTO.KhachHangDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KhachHangMapper implements RowMapper<KhachHangDTO> {

  @Override
  public KhachHangDTO mapRow(ResultSet resultSet) {
    KhachHangDTO khachHangDTO = new KhachHangDTO();
    try {
      khachHangDTO.setMaKhachHang(resultSet.getString("MaKhachHang"));
      khachHangDTO.setHoKhachHang(resultSet.getString("HoKhachHang"));
      khachHangDTO.setTenKhachHang(resultSet.getString("TenKhachHang"));
      khachHangDTO.setChungMinhNhanDan(resultSet.getString("CMND/CCCD"));
      khachHangDTO.setSoDienThoai(resultSet.getString("SdtKhachHang"));
      return khachHangDTO;
    } catch (SQLException e) {
      System.out.println("Lỗi ở khách hàng mapper: " + e.getMessage());
      return null;
    }
  }
}
