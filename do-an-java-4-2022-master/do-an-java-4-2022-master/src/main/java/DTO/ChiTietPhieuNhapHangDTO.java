package DTO;

public class ChiTietPhieuNhapHangDTO {

  private String maPhieuNhapHang;
  private String maSanPham;
  private Integer soLuong;
  private Double donGia;
  private Double thanhTien;

  public String getMaPhieuNhapHang() {
    return maPhieuNhapHang;
  }

  public void setMaPhieuNhapHang(String maPhieuNhapHang) {
    this.maPhieuNhapHang = maPhieuNhapHang;
  }

  public String getMaSanPham() {
    return maSanPham;
  }

  public void setMaSanPham(String maSanPham) {
    this.maSanPham = maSanPham;
  }

  public Integer getSoLuong() {
    return soLuong;
  }

  public void setSoLuong(Integer soLuong) {
    this.soLuong = soLuong;
  }

  public Double getDonGia() {
    return donGia;
  }

  public void setDonGia(Double donGia) {
    this.donGia = donGia;
  }

  public Double getThanhTien() {
    return thanhTien;
  }

  public void setThanhTien(Double thanhTien) {
    this.thanhTien = thanhTien;
  }
}
