package mapper;

import DTO.ChiTietPhieuNhapHangDTO;
import java.sql.ResultSet;

public class ChiTietPhieuNhapHangMapper implements RowMapper<ChiTietPhieuNhapHangDTO> {

  @Override
  public ChiTietPhieuNhapHangDTO mapRow(ResultSet resultSet) {
    ChiTietPhieuNhapHangDTO chiTietPhieuNhapHangDTO = new ChiTietPhieuNhapHangDTO();
    try {
      chiTietPhieuNhapHangDTO.setMaPhieuNhapHang(resultSet.getString("MaPhieuNhap"));
      chiTietPhieuNhapHangDTO.setMaSanPham(resultSet.getString("MaSanPham"));
      chiTietPhieuNhapHangDTO.setSoLuong(resultSet.getInt("SoLuong"));
      chiTietPhieuNhapHangDTO.setDonGia(resultSet.getDouble("DonGia"));
      chiTietPhieuNhapHangDTO.setThanhTien(resultSet.getDouble("ThanhTien"));
      return chiTietPhieuNhapHangDTO;
    } catch (Exception e) {
      System.out.println("Lỗi ở chi tiết phiếu nhập hàng mapper: " + e.getMessage());
      return null;
    }
  }
}
