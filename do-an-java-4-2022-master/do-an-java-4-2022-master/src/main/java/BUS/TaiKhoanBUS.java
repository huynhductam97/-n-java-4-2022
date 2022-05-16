package BUS;

import DTO.TaiKhoanDTO;
import DAO.TaiKhoanDAO;
import java.util.List;

public class TaiKhoanBUS implements CRUD<TaiKhoanDTO> {

  private TaiKhoanDAO taiKhoanDAO;

  public TaiKhoanBUS() {
    taiKhoanDAO = new TaiKhoanDAO();
  }

  @Override
  public void them(TaiKhoanDTO object) {
    taiKhoanDAO.save(object);
  }

  @Override
  public void xoa(String ma) {
    taiKhoanDAO.delete(ma);
  }

  @Override
  public void sua(TaiKhoanDTO object) {
    taiKhoanDAO.update(object);
  }

  @Override
  public TaiKhoanDTO timKiem(String ma) {
    return taiKhoanDAO.findOne(ma);
  }

  @Override
  public List<TaiKhoanDTO> findAll() {
    return taiKhoanDAO.findAll();
  }
}
