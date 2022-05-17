package DAO;

import DTO.TaiKhoanDTO;
import java.util.List;
import mapper.TaiKhoanMapper;

public class TaiKhoanDAO extends AbstractDAO<TaiKhoanDTO> {

  public void save(TaiKhoanDTO taiKhoanDTO) {  //check
    String[] fields = {"MaTaiKhoan", "TenTaiKhoan", "MatKhau", "PhanQuyen", "MaNhanVien"};
    super.save("taikhoan", fields, taiKhoanDTO.getMaTaiKhoan(), taiKhoanDTO.getTenTaiKhoan(),
        taiKhoanDTO.getMatKhau(), taiKhoanDTO.getPhanQuyen(), taiKhoanDTO.getMaNhanVien());
  }

  public List<TaiKhoanDTO> findAll() { //check
    return super.findAll("taikhoan", new TaiKhoanMapper());
  }

  public TaiKhoanDTO findOne(String maTaiKhoan) { //check
    return super.findOne("taikhoan", "MaTaiKhoan", maTaiKhoan,
        new TaiKhoanMapper());
  }

  public void update(TaiKhoanDTO taiKhoanDTO) {
    String[] fields = {"TenTaiKhoan", "MatKhau", "PhanQuyen"};
    String[] condition = {"MaTaiKhoan", "MaNhanVien"};
    super.update("taikhoan", fields, condition, taiKhoanDTO.getTenTaiKhoan(),
        taiKhoanDTO.getMatKhau(), taiKhoanDTO.getPhanQuyen(),
        taiKhoanDTO.getMaTaiKhoan(), taiKhoanDTO.getMaNhanVien());
  }

  public void delete(String maTaiKhoan) {
    String[] condition = {"MaTaiKhoan"};
    delete("taikhoan", condition, maTaiKhoan);
  }

  public List<TaiKhoanDTO> findByCondition(String column, String data) {
    return super.findAllByCondition("taikhoan", column, data, new TaiKhoanMapper());
  }

  public List<TaiKhoanDTO> findWithLike(String column, String data) {
    return findWithLike("taikhoan", column, new TaiKhoanMapper(), data);
  }

  public int count() {
    return findAll().size();
  }
}
