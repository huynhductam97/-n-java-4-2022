package DAO;

import DTO.LoaiSanPhamDTO;
import DTO.NhaSanXuatDTO;
import java.util.List;
import mapper.LoaiSanPhamMapper;
import mapper.NhaSanXuatMapper;

public class LoaiSanPhamDAO extends AbstractDAO<LoaiSanPhamDTO> {

  public void save(LoaiSanPhamDTO loaiSanPhamDTO) {  //check
    String [] fields = {"MaLoai", "TenLoai"};
    super.save("loaisanpham",fields, loaiSanPhamDTO.getMaLoai(), loaiSanPhamDTO.getTenLoai());
  }

  public List<LoaiSanPhamDTO> findAll() { //check
    return super.findAll("loaisanpham", new LoaiSanPhamMapper());
  }

  public LoaiSanPhamDTO findOne(String maLoai) { //check
    return super.findOne("loaisanpham", "MaLoai", maLoai, new LoaiSanPhamMapper());
  }

  public void update(LoaiSanPhamDTO loaiSanPhamDTO) {
    String[] fields = {"TenLoai"};
    String[] condition = {"MaLoai"};
    super.update("loaisanpham", fields, condition, loaiSanPhamDTO.getTenLoai(), loaiSanPhamDTO.getMaLoai());
  }

  public void delete(String maLoai) {
    String[] condition = {"MaLoai"};
    delete("loaisanpham", condition, maLoai);
  }

  public int count() {
    return findAll().size();
  }

}
