package DAO;

import DTO.NhanVienDTO;
import java.util.List;
import mapper.NhanVienMapper;

public class NhanVienDAO extends AbstractDAO<NhanVienDTO> {

  public void save(NhanVienDTO nhanVienDTO) {  //check
    String[] fields = {"MaNhanVien", "HoNhanVien", "TenNhanVien", "NgayVaoLam", "ViTri", "Luong",
        "SoDienThoai",
        "Email"};
    super.save("nhanvien", fields, nhanVienDTO.getMaNhanVien(), nhanVienDTO.getHoNhanVien(),
        nhanVienDTO.getTenNhanVien(),
        nhanVienDTO.getNgayVaoLam(), nhanVienDTO.getViTri(), nhanVienDTO.getLuong(),
        nhanVienDTO.getSoDienThoai(), nhanVienDTO.getEmail());
  }

  public List<NhanVienDTO> findAll() { //check
    return super.findAll("nhanvien", new NhanVienMapper());
  }

  public NhanVienDTO findOne(String maNhanVien) { //check
    return super.findOne("nhanvien", "MaNhanVien", maNhanVien, new NhanVienMapper());
  }

  public void update(NhanVienDTO nhanVienDTO) {
//    StringBuilder sql = new StringBuilder("UPDATE `cuahangtienloi`.`nhanvien`");
//    sql.append(" SET  TenNhanVien = ?, NgayVaoLam = ?, ViTri = ?, Luong = ?,");
//    sql.append(" SoDienThoai = ?, Email = ? WHERE MaNhanVien = ?");
//    super.update(sql.toString(), nhanVienDTO.getTenNhanVien(), nhanVienDTO.getNgayVaoLam(),
//        nhanVienDTO.getViTri(), nhanVienDTO.getLuong(), nhanVienDTO.getSoDienThoai(),
//        nhanVienDTO.getEmail(), nhanVienDTO.getMaNhanVien());
    String[] fields = {"HoNhanVien", "TenNhanVien", "NgayVaoLam", "ViTri", "Luong", "SoDienThoai",
        "Email"};
    String[] condition = {"MaNhanVien"};
    super.update("nhanvien", fields, condition, nhanVienDTO.getHoNhanVien(),
        nhanVienDTO.getTenNhanVien(),
        nhanVienDTO.getNgayVaoLam(),
        nhanVienDTO.getViTri(), nhanVienDTO.getLuong(), nhanVienDTO.getSoDienThoai(),
        nhanVienDTO.getEmail(), nhanVienDTO.getMaNhanVien());
  }

  public void delete(String maNhanVien) {
    String[] condition = {"MaNhanVien"};
    delete("nhanvien", condition, maNhanVien);
  }

  public List<NhanVienDTO> findWithLike(String column, String data) {
    return findWithLike("nhanvien", column, new NhanVienMapper(), data);
  }


  public int count() {
    return findAll().size();
  }
}
