package DTO;

public class ChiTietHoaDonDTO {

  private String maHoaDon;
  private String maSanPham;
  private String tenSanPham;
  private Double donGia;
  private Integer soLuong;
  private Double thanhTien;

  public String getMaHoaDon() {
    return maHoaDon;
  }

  public void setMaHoaDon(String maHoaDon) {
    this.maHoaDon = maHoaDon;
  }

  public String getMaSanPham() {
    return maSanPham;
  }

  public void setMaSanPham(String maSanPham) {
    this.maSanPham = maSanPham;
  }

  public String getTenSanPham() {
    return tenSanPham;
  }

  public void setTenSanPham(String tenSanPham) {
    this.tenSanPham = tenSanPham;
  }

  public Double getDonGia() {
    return donGia;
  }

  public void setDonGia(Double donGia) {
    this.donGia = donGia;
  }

  public Integer getSoLuong() {
    return soLuong;
  }

  public void setSoLuong(Integer soLuong) {
    this.soLuong = soLuong;
  }

  public Double getThanhTien() {
    return thanhTien;
  }

  public void setThanhTien(Double thanhTien) {
    this.thanhTien = thanhTien;
  }
}
