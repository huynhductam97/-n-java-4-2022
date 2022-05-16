package mapper;

import DTO.HoaDonDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HoanDonMapper implements RowMapper<HoaDonDTO> {

  @Override
  public HoaDonDTO mapRow(ResultSet resultSet) {
    HoaDonDTO hoaDonDTO = new HoaDonDTO();
    try {
      hoaDonDTO.setMaHoaDon(resultSet.getString("MaHoaDon"));
      hoaDonDTO.setMaKhachHang(resultSet.getString("MaKhachHang"));
      hoaDonDTO.setMaNhanVien(resultSet.getString("MaNhanVien"));
      hoaDonDTO.setNgayLap(resultSet.getDate("NgayLap"));
      hoaDonDTO.setTongTien(resultSet.getDouble("TongTien"));
      return hoaDonDTO;
    } catch (SQLException sqlException) {
      System.out.println("Lỗi ở hóa đơn mapper: " + sqlException.getMessage());
      return null;
    }
  }
}
