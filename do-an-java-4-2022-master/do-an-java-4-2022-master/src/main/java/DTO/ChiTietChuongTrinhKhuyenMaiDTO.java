package DTO;

public class ChiTietChuongTrinhKhuyenMaiDTO {

  private String maChuongTrinh;
  private String maSanPham;
  private Double phanTramGiam;

  public String getMaChuongTrinh() {
    return maChuongTrinh;
  }

  public void setMaChuongTrinh(String maChuongTrinh) {
    this.maChuongTrinh = maChuongTrinh;
  }

  public String getMaSanPham() {
    return maSanPham;
  }

  public void setMaSanPham(String maSanPham) {
    this.maSanPham = maSanPham;
  }

  public Double getPhanTramGiam() {
    return phanTramGiam;
  }

  public void setPhanTramGiam(Double phanTramGiam) {
    this.phanTramGiam = phanTramGiam;
  }
}
