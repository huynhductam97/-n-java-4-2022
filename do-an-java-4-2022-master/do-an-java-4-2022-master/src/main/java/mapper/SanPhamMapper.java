package mapper;

import DTO.SanPhamDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SanPhamMapper implements RowMapper<SanPhamDTO> {

  @Override
  public SanPhamDTO mapRow(ResultSet resultSet) {
    SanPhamDTO sanPham = new SanPhamDTO();
    try {
      sanPham.setMaSanPham(resultSet.getString("MaSanPham"));
      sanPham.setTenSanPham(resultSet.getString("TenSanPham"));
      sanPham.setDonViTinh(resultSet.getString("DonViTinh"));
      sanPham.setDonGia(resultSet.getDouble("DonGia"));
      sanPham.setMaLoai(resultSet.getString("MaLoai"));
      sanPham.setSoLuong(resultSet.getInt("SoLuong"));
      sanPham.setMaNhaSanXuat(resultSet.getString("MaNhaSanXuat"));
      return sanPham;
    } catch (SQLException throwables) {
      System.out.println("Lỗi ở SanPhamMapper: " + throwables.getMessage());
      return null;
    }
  }
}
