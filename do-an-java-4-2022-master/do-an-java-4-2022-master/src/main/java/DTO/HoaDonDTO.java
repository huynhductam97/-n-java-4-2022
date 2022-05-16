package DTO;

import java.sql.Date;

public class HoaDonDTO {

  private String maHoaDon;
  private String maNhanVien;
  private String maKhachHang;
  private Date ngayLap;
  private Double tongTien;

  public String getMaHoaDon() {
    return maHoaDon;
  }

  public void setMaHoaDon(String maHoaDon) {
    this.maHoaDon = maHoaDon;
  }

  public String getMaNhanVien() {
    return maNhanVien;
  }

  public void setMaNhanVien(String maNhanVien) {
    this.maNhanVien = maNhanVien;
  }

  public String getMaKhachHang() {
    return maKhachHang;
  }

  public void setMaKhachHang(String maKhachHang) {
    this.maKhachHang = maKhachHang;
  }

  public Date getNgayLap() {
    return ngayLap;
  }

  public void setNgayLap(Date ngayLap) {
    this.ngayLap = ngayLap;
  }

  public Double getTongTien() {
    return tongTien;
  }

  public void setTongTien(Double tongTien) {
    this.tongTien = tongTien;
  }
}
