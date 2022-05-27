import DTO.ChuongTrinhKhuyenMaiDTO;
import DTO.NhaCungCapDTO;
import DTO.NhaSanXuatDTO;
import DTO.NhanVienDTO;
import DTO.SanPhamDTO;
import DTO.TaiKhoanDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ReadDataFromExcel {


  public static List<?> readData(String sheetName) throws IOException {
    List results = null;
    String workingDir = System.getProperty("user.dir");
    final File excelPath = new File(workingDir + "/" + sheetName + ".xlsx");
    // final String excelPath = workingDir + "/data.xlsx";
    InputStream inputStream = new FileInputStream(excelPath);
    Workbook workbook = new HSSFWorkbook(inputStream);
    Sheet sheet = workbook.getSheetAt(0);

    Iterator<Row> iterator = sheet.iterator();
    Object data;
    if (sheetName.startsWith("chuongtrinhkhuyenmai")) {
      results = new ArrayList<SanPhamDTO>();
      //dòng
      while (iterator.hasNext()) {
        Row row = iterator.next();
        if (row.getRowNum() == 0) {
          continue; //header
        }
        //cột
        Iterator<Cell> cellIterator = row.cellIterator();
        data = new ChuongTrinhKhuyenMaiDTO();
        while (cellIterator.hasNext()) {
          Cell cell = cellIterator.next();
          if (cell.getColumnIndex() == 0) {
            ((ChuongTrinhKhuyenMaiDTO) data).setMaChuongTrinh(cell.getStringCellValue());
          } else if (cell.getColumnIndex() == 1) {
            ((ChuongTrinhKhuyenMaiDTO) data).setTenKhuyenMai(cell.getStringCellValue());
          } else if (cell.getColumnIndex() == 2) {
            ((ChuongTrinhKhuyenMaiDTO) data).setNgayBatDau(
                Date.valueOf(cell.getStringCellValue()));
          } else if (cell.getColumnIndex() == 3) {
            ((ChuongTrinhKhuyenMaiDTO) data).setNgayKetThuc(
                Date.valueOf(cell.getStringCellValue()));
          }
        }
        results.add(data);
      }
    } else if (sheetName.equals("sanpham")) {
      results = new ArrayList<SanPhamDTO>();
    } else if (sheetName.equals("nhanvien")) {
      results = new ArrayList<NhanVienDTO>();
    } else if (sheetName.equals("taikhoan")) {
      results = new ArrayList<TaiKhoanDTO>();
    } else if (sheetName.equals("nhacungcap")) {
      results = new ArrayList<NhaCungCapDTO>();
    } else if (sheetName.equals("nhasanxuat")) {
      results = new ArrayList<NhaSanXuatDTO>();
    }

//    while (iterator.hasNext()) {
//      Row row = iterator.next();
//      if (row.getRowNum() == 0) {
//        continue; //header
//      }
//      Iterator<Cell> cellIterator = row.cellIterator();
//      if (isChuongTrinhKhuyenMai == true) {
//        data = new ChuongTrinhKhuyenMaiDTO();
//        while (cellIterator.hasNext()) {
//          Cell cell = cellIterator.next();
//          if (cell.getColumnIndex() == 0) {
//            ((ChuongTrinhKhuyenMaiDTO) data).setMaChuongTrinh(cell.getStringCellValue());
//          } else if (cell.getColumnIndex() == 1) {
//            ((ChuongTrinhKhuyenMaiDTO) data).setTenKhuyenMai(cell.getStringCellValue());
//          } else if (cell.getColumnIndex() == 2) {
//            ((ChuongTrinhKhuyenMaiDTO) data).setNgayBatDau(Date.valueOf(cell.getStringCellValue()));
//          } else if (cell.getColumnIndex() == 3) {
//            ((ChuongTrinhKhuyenMaiDTO) data).setNgayKetThuc(
//                Date.valueOf(cell.getStringCellValue()));
//          }
//          results.add(data);
//        }
//
//      } else if (isSanPham == true) {
//        data = new SanPhamDTO();
//      } else if (isNhanVien == true) {
//        data = new NhanVienDTO();
//      } else if (isTaiKhoan == true) {
//        data = new TaiKhoanDTO();
//      } else if (isNhaCungCap == true) {
//        data = new NhaCungCapDTO();
//      } else if (isNhaSanXuat == true) {
//        data = new NhaSanXuatDTO();
//      }
//    }

    return results;
  }

}
