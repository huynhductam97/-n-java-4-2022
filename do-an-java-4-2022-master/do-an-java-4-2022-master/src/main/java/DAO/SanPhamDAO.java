package DAO;

import DTO.SanPhamDTO;
import java.util.List;
import mapper.SanPhamMapper;

public class SanPhamDAO extends AbstractDAO<SanPhamDTO> {

  public void save(SanPhamDTO sanpham) {  //check
    String[] fields = {"MaSanPham", "TenSanPham", "DonGia", "DonViTinh", "SoLuong", "MaLoai",
        "MaNhaSanXuat"};
    super.save("sanpham", fields, sanpham.getMaSanPham(), sanpham.getTenSanPham(),
        sanpham.getDonGia(), sanpham.getDonViTinh(), sanpham.getSoLuong(), sanpham.getMaLoai(),
        sanpham.getMaNhaSanXuat());
  }

  public List<SanPhamDTO> findAll() { //check
    return super.findAll("sanpham", new SanPhamMapper());
  }

  //  public SanPhamDTO findOne(String maSanPham) { //check
//    StringBuilder sql = new StringBuilder("SELECT * FROM `cuahangtienloi`.`sanpham`");
//    sql.append(" WHERE MaSanPham = ?");
//    List<SanPhamDTO> resultList = query(sql.toString(), new SanPhamMapper(), maSanPham);
//    return resultList.isEmpty() ? null : resultList.get(0);
//  }
  public SanPhamDTO findOne(String maSanPham) { //check

    return super.findOne("sanpham", "MaSanPham", maSanPham, new SanPhamMapper());
  }

  public void update(SanPhamDTO sanPham) {
//    StringBuilder sql = new StringBuilder("UPDATE `cuahangtienloi`.`sanpham`");
//    sql.append(" SET  TenSanPham = ?, DonGia = ?, DonViTinh = ?, SoLuong = ?,");
//    sql.append(" MaLoai = ?, MaNhaSanXuat = ? WHERE MaSanPham = ?");
//    super.update(sql.toString(), sanPham.getTenSanPham(),
//        sanPham.getDonGia(), sanPham.getDonViTinh(), sanPham.getSoLuong(), sanPham.getMaSanPham());
    String[] fields = {"TenSanPham", "DonGia", "DonViTinh", "SoLuong", "MaLoai", "MaNhaSanXuat"};
    String[] condition = {"MaSanPham"};
    super.update("sanpham", fields, condition, sanPham.getTenSanPham(),
        sanPham.getDonGia(), sanPham.getDonViTinh(), sanPham.getSoLuong(), sanPham.getMaLoai(),
        sanPham.getMaNhaSanXuat(),
        sanPham.getMaSanPham());
  }

  public void delete(String maSanPham) {
    String[] condition = {"MaSanPham"};
    delete("sanpham", condition, maSanPham);
  }

  public int count() {
    return findAll().size();
  }

  public List<SanPhamDTO> findByCondition(String column, String data) {
    return super.findAllByCondition("sanpham", column, data, new SanPhamMapper());
  }

  public List<SanPhamDTO> findWithLike(String column, String data) {
    return findWithLike("sanpham", column, new SanPhamMapper(), data);
  }

}
