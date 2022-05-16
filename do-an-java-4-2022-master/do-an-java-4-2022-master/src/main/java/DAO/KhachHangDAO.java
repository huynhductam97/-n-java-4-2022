package DAO;

import DTO.KhachHangDTO;
import java.util.List;
import mapper.KhachHangMapper;

public class KhachHangDAO extends AbstractDAO<KhachHangDTO> {

  public void save(KhachHangDTO khachHangDTO) {  //check
    String[] fields = {"MaKhachHang", "TenKhachHang"};
    super.save("khachhang", fields, khachHangDTO.getMaKhachHang(), khachHangDTO.getTenKhachHang());
  }

  public List<KhachHangDTO> findAll() { //check

    return super.findAll("khachhang", new KhachHangMapper());
  }

  public KhachHangDTO findOne(String maKhachHang) { //check
    return super.findOne("khachhang", "MaKhachHang", maKhachHang, new KhachHangMapper());
  }

  public void update(KhachHangDTO khachHangDTO) {
    String[] fields = {"TenKhachHang"};
    String[] condition = {"MaKhachHang"};
    super.update("khachhang", fields, condition, khachHangDTO.getTenKhachHang(),
        khachHangDTO.getMaKhachHang());
  }

  public void delete(String maKhachHang) {
    String[] condition = {"MaKhachHang"};
    delete("khachhang", condition, maKhachHang);
  }

  public int count() {
    return findAll().size();
  }

}
