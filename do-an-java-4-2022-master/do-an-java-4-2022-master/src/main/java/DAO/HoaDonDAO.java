package DAO;

import DTO.HoaDonDTO;
import java.util.List;
import mapper.HoanDonMapper;

public class HoaDonDAO extends AbstractDAO<HoaDonDTO> {

  public void save(HoaDonDTO hoaDonDTO) {  //check
    String[] fields = {"MaHoaDon", "MaNhanVien", "MaKhachHang", "NgayLap", "TongTien"};

    super.save("hoadon", fields, hoaDonDTO.getMaHoaDon(), hoaDonDTO.getMaNhanVien(),
        hoaDonDTO.getMaKhachHang(), hoaDonDTO.getNgayLap(), hoaDonDTO.getTongTien());
  }

  public List<HoaDonDTO> findAll() { //check
    return super.findAll("hoadon", new HoanDonMapper());
  }

  public HoaDonDTO findOne(String MaHoaDon) { //check
    return super.findOne("hoadon", "MaHoaDon", MaHoaDon, new HoanDonMapper());
  }

  public void update(HoaDonDTO hoaDonDTO) {
//    StringBuilder sql = new StringBuilder("UPDATE `cuahangtienloi`.`hoadon`");
//    sql.append(
//        " SET  MaNhanVien = ?, MaKhachHang = ?, NgayLap = ?, TongTien = ? WHERE MaHoaDon = ?");
//    super.update(sql.toString(), hoaDonDTO.getMaNhanVien(), hoaDonDTO.getMaKhachHang(),
//        hoaDonDTO.getNgayLap(), hoaDonDTO.getTongTien(), hoaDonDTO.getMaHoaDon());
    String[] fields = {"MaNhanVien", "MaKhachHang", "NgayLap", "TongTien"};
    String[] condition = {"MaHoaDon"};
    super.update("hoadon", fields, condition, hoaDonDTO.getMaNhanVien(), hoaDonDTO.getMaKhachHang(),
        hoaDonDTO.getNgayLap(), hoaDonDTO.getTongTien(), hoaDonDTO.getMaHoaDon());
  }

  public void delete(String maHoaDon) {
   String[] condition = {"MaHoaDon"};
   delete("hoadon", condition, maHoaDon);
  }

  public int count() {
    return findAll().size();
  }
}
