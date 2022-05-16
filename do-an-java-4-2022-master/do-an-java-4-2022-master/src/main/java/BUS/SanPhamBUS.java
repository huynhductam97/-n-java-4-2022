package BUS;

import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import java.util.List;

public class SanPhamBUS implements CRUD<SanPhamDTO> {

  private SanPhamDAO sanPhamDAO;

  public SanPhamBUS() {
    sanPhamDAO = new SanPhamDAO();
  }

  @Override
  public void them(SanPhamDTO object) {
    sanPhamDAO.save(object);
  }

  @Override
  public void xoa(String ma) {
    sanPhamDAO.delete(ma);
  }

  @Override
  public void sua(SanPhamDTO object) {
    sanPhamDAO.update(object);
  }

  @Override
  public SanPhamDTO timKiem(String ma) {
    return sanPhamDAO.findOne(ma);
  }

  @Override
  public List<SanPhamDTO> findAll() {
    return sanPhamDAO.findAll();
  }

  public List<SanPhamDTO> findByCondition(String column, String data) {
    return sanPhamDAO.findByCondition(column, data);
  }

  public List<SanPhamDTO> findByConditionUseLike(String column, String data) {
    return sanPhamDAO.findWithLike(column, data);
  }

}
