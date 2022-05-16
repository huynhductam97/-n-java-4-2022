package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.List;

public class NhanVienBUS implements CRUD<NhanVienDTO> {

  private NhanVienDAO nhanVienDAO;

  public NhanVienBUS() {
    nhanVienDAO = new NhanVienDAO();
  }

  @Override
  public void them(NhanVienDTO object) {
    nhanVienDAO.save(object);
  }

  @Override
  public void xoa(String ma) {
    nhanVienDAO.delete(ma);
  }

  @Override
  public void sua(NhanVienDTO object) {
    nhanVienDAO.update(object);
  }

  @Override
  public NhanVienDTO timKiem(String ma) {
    return nhanVienDAO.findOne(ma);
  }

  @Override
  public List<NhanVienDTO> findAll() {
    return nhanVienDAO.findAll();
  }

  public List<NhanVienDTO> findWithLikeCondition(String column, String data) {
    return nhanVienDAO.findWithLike(column, data);
  }
}
