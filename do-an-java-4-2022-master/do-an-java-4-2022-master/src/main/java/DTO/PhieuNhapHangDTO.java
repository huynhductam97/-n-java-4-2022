package DTO;

import java.sql.Date;

public class PhieuNhapHangDTO {

  private String maPhieuNhapHang;
  private String maNhaCungCap;
  private String maNhanvien;
  private Date ngayLap;
  private Integer tongTien;

  public String getMaPhieuNhapHang() {
    return maPhieuNhapHang;
  }

  public void setMaPhieuNhapHang(String maPhieuNhapHang) {
    this.maPhieuNhapHang = maPhieuNhapHang;
  }

  public String getMaNhaCungCap() {
    return maNhaCungCap;
  }

  public void setMaNhaCungCap(String maNhaCungCap) {
    this.maNhaCungCap = maNhaCungCap;
  }

  public String getMaNhanvien() {
    return maNhanvien;
  }

  public void setMaNhanvien(String maNhanvien) {
    this.maNhanvien = maNhanvien;
  }

  public Date getNgayLap() {
    return ngayLap;
  }

  public void setNgayLap(Date ngayLap) {
    this.ngayLap = ngayLap;
  }

  public Integer getTongTien() {
    return tongTien;
  }

  public void setTongTien(Integer tongTien) {
    this.tongTien = tongTien;
  }
}
