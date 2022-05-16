package mapper;

import DTO.ChiTietHoaDonDTO;
import java.sql.ResultSet;

public class ChiTietHoaDonMapper implements RowMapper<ChiTietHoaDonDTO> {

  @Override
  public ChiTietHoaDonDTO mapRow(ResultSet resultSet) {
    ChiTietHoaDonDTO chiTietHoaDonDTO = new ChiTietHoaDonDTO();
    try {
      chiTietHoaDonDTO.setMaHoaDon(resultSet.getString("MaHoaDon"));
      chiTietHoaDonDTO.setMaSanPham(resultSet.getString("MaSanPham"));
      chiTietHoaDonDTO.setTenSanPham(resultSet.getString("TenSanPham"));
      chiTietHoaDonDTO.setDonGia(resultSet.getDouble("DonGia"));
      chiTietHoaDonDTO.setSoLuong(resultSet.getInt("SoLuong"));
      chiTietHoaDonDTO.setThanhTien(resultSet.getDouble("ThanhTien"));
      return chiTietHoaDonDTO;
    } catch (Exception e) {
      System.out.println("Lỗi ở Chi tiết hóa đơn mapper: " + e.getMessage());
      return null;
    }
  }
}
