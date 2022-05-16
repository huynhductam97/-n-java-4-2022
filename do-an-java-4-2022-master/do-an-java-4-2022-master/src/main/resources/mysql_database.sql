-- Tạo database
CREATE SCHEMA `cuahangtienloi` DEFAULT CHARACTER SET utf8 ;

-- Tạo bảng 

-- sản phẩm
CREATE TABLE `cuahangtienloi`.`sanpham` (
  `MaSanPham` VARCHAR(10) NOT NULL,
  `TenSanPham` VARCHAR(50) NOT NULL,
  `DonGia` INT NOT NULL,
  `DonViTinh` VARCHAR(45) NOT NULL,
  `SoLuong` INT NOT NULL,
  `MaLoai` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`MaSanPham`));


-- loại sản phẩm
CREATE TABLE `cuahangtienloi`.`loaisanpham` (
  `MaLoai` VARCHAR(10) NOT NULL,
  `TenLoai` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`MaLoai`));


-- nhà cung cấp
CREATE TABLE `cuahangtienloi`.`nhacungcap` (
  `MaNhaCungCap` VARCHAR(10) NOT NULL,
  `TenNhaCungCap` VARCHAR(100) NOT NULL,
  `DiaChi` VARCHAR(200) NULL,
  `Sdt` VARCHAR(15) NULL,
  `Email` VARCHAR(50) NULL,
  PRIMARY KEY (`MaNhaCungCap`));

-- phiếu nhập hàng
CREATE TABLE `cuahangtienloi`.`phieunhaphang` (
  `MaPhieuNhapHang` VARCHAR(10) NOT NULL,
  `MaNhaCungCap` VARCHAR(10) NOT NULL,
  `MaNhanVien` VARCHAR(10) NOT NULL,
  `NgayLap` DATE NOT NULL,
  `TongTien` INT NOT NULL,
  PRIMARY KEY (`MaPhieuNhapHang`));

-- chi tiết phiếu nhập
CREATE TABLE `cuahangtienloi`.`chitietphieunhaphang` (
  `MaPhieuNhap` VARCHAR(10) NOT NULL,
  `MaSanPham` VARCHAR(10) NOT NULL,
  `SoLuong` INT NOT NULL,
  `DonGia` INT NOT NULL,
  `ThanhTien` INT NOT NULL,
  PRIMARY KEY (`MaPhieuNhap`));

-- hóa đơn
CREATE TABLE `cuahangtienloi`.`hoadon` (
  `MaHoaDon` VARCHAR(10) NOT NULL,
  `MaNhanVien` VARCHAR(10) NOT NULL,
  `MaKhachHang` VARCHAR(10) NOT NULL,
  `NgayLap` DATE NOT NULL,
  `TongTien` INT NOT NULL,
  PRIMARY KEY (`MaHoaDon`));

-- chi tiết hóa đơn
CREATE TABLE `cuahangtienloi`.`chitiethoadon` (
  `MaHoaDon` VARCHAR(10) NOT NULL,
  `MaSanPham` VARCHAR(10) NOT NULL,
  `DonGia` INT NOT NULL,
  `SoLuong` INT NOT NULL,
  `ThanhTien` INT NOT NULL,
  PRIMARY KEY (`MaHoaDon`));

-- nhân viên
CREATE TABLE `cuahangtienloi`.`nhanvien` (
  `MaNhanVien` VARCHAR(10) NOT NULL,
  `TenNhanVien` VARCHAR(50) NOT NULL,
  `NgayVaoLam` DATE NOT NULL,
  `ViTri` VARCHAR(50) NOT NULL,
  `Luong` INT NOT NULL,
  `SoDienThoai` VARCHAR(20) NULL,
  `Email` VARCHAR(100) NULL,
  PRIMARY KEY (`MaNhanVien`));

-- khách hàng
CREATE TABLE `cuahangtienloi`.`khachhang` (
  `MaKhachHang` VARCHAR(10) NOT NULL,
  `TenKhachHang` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`MaKhachHang`));

-- chương trình khuyến mãi
CREATE TABLE `cuahangtienloi`.`chuongtrinhkhuyenmai` (
  `MaChuongTrinh` VARCHAR(10) NOT NULL,
  `TenKhuyenMai` VARCHAR(100) NOT NULL,
  `NgayBatDau` DATE NOT NULL,
  `NgayKetThuc` DATE NOT NULL,
  PRIMARY KEY (`MaChuongTrinh`));

-- chi tiết chương trình khuyến mãi
CREATE TABLE `cuahangtienloi`.`chitietchuongtrinhkhuyenmai` (
  `MaChuongTrinh` VARCHAR(10) NOT NULL,
  `MaSanPham` VARCHAR(10) NULL,
  `%Giam` FLOAT NULL,
  PRIMARY KEY (`MaChuongTrinh`));

-- tài khoản
CREATE TABLE `cuahangtienloi`.`taikhoan` (
  `MaTaiKhoan` VARCHAR(10) NOT NULL,
  `TenTaiKhoan` VARCHAR(50) NOT NULL,
  `MatKhau` VARCHAR(50) NOT NULL,
  `Email` VARCHAR(50) NULL,
  `SoDienThoai` VARCHAR(20) NULL,
  `MaKhachHang` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`MaTaiKhoan`));

-- nhà sản xuất
CREATE TABLE `cuahangtienloi`.`nhasanxuat` (
  `MaNhaSanXuat` INT NOT NULL,
  `TenNhaSanXuat` VARCHAR(50) NOT NULL,
  `DiaChi` VARCHAR(100) NOT NULL,
  `SoDienThoai` VARCHAR(20) NULL,
  PRIMARY KEY (`MaNhaSanXuat`));


-- liên kết khóa ngoại

ALTER TABLE `cuahangtienloi`.`phieunhaphang` 
ADD INDEX `fk_PNH_NCC_idx` (`MaNhaCungCap` ASC) VISIBLE;
;
ALTER TABLE `cuahangtienloi`.`phieunhaphang` 
ADD CONSTRAINT `fk_PNH_NCC`
  FOREIGN KEY (`MaNhaCungCap`)
  REFERENCES `cuahangtienloi`.`nhacungcap` (`MaNhaCungCap`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;


ALTER TABLE `cuahangtienloi`.`chitietphieunhaphang` 
ADD CONSTRAINT `fk_CTPNH_PNH`
  FOREIGN KEY (`MaPhieuNhap`)
  REFERENCES `cuahangtienloi`.`phieunhaphang` (`MaPhieuNhapHang`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;


ALTER TABLE `cuahangtienloi`.`chitietphieunhaphang` 
ADD INDEX `fk_CTPNH_SP_idx` (`MaSanPham` ASC) VISIBLE;
;
ALTER TABLE `cuahangtienloi`.`chitietphieunhaphang` 
ADD CONSTRAINT `fk_CTPNH_SP`
  FOREIGN KEY (`MaSanPham`)
  REFERENCES `cuahangtienloi`.`sanpham` (`MaSanPham`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;


ALTER TABLE `cuahangtienloi`.`phieunhaphang` 
ADD INDEX `fk_PNH_NV_idx` (`MaNhanVien` ASC) VISIBLE;
;
ALTER TABLE `cuahangtienloi`.`phieunhaphang` 
ADD CONSTRAINT `fk_PNH_NV`
  FOREIGN KEY (`MaNhanVien`)
  REFERENCES `cuahangtienloi`.`nhanvien` (`MaNhanVien`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;


ALTER TABLE `cuahangtienloi`.`hoadon` 
ADD INDEX `fk_HD_NV_idx` (`MaNhanVien` ASC) VISIBLE;
;
ALTER TABLE `cuahangtienloi`.`hoadon` 
ADD CONSTRAINT `fk_HD_NV`
  FOREIGN KEY (`MaNhanVien`)
  REFERENCES `cuahangtienloi`.`nhanvien` (`MaNhanVien`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;


ALTER TABLE `cuahangtienloi`.`hoadon` 
ADD INDEX `fk_HD-KH_idx` (`MaKhachHang` ASC) VISIBLE;
;
ALTER TABLE `cuahangtienloi`.`hoadon` 
ADD CONSTRAINT `fk_HD-KH`
  FOREIGN KEY (`MaKhachHang`)
  REFERENCES `cuahangtienloi`.`khachhang` (`MaKhachHang`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;


ALTER TABLE `cuahangtienloi`.`chitiethoadon` 
ADD CONSTRAINT `fk_CTHD_HD`
  FOREIGN KEY (`MaHoaDon`)
  REFERENCES `cuahangtienloi`.`hoadon` (`MaHoaDon`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;


ALTER TABLE `cuahangtienloi`.`chitietchuongtrinhkhuyenmai` 
ADD CONSTRAINT `fk_CTCTKM_CTKM`
  FOREIGN KEY (`MaChuongTrinh`)
  REFERENCES `cuahangtienloi`.`chuongtrinhkhuyenmai` (`MaChuongTrinh`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;


ALTER TABLE `cuahangtienloi`.`taikhoan` 
ADD INDEX `fk_TK_KH_idx` (`MaKhachHang` ASC) VISIBLE;
;
ALTER TABLE `cuahangtienloi`.`taikhoan` 
ADD CONSTRAINT `fk_TK_KH`
  FOREIGN KEY (`MaKhachHang`)
  REFERENCES `cuahangtienloi`.`khachhang` (`MaKhachHang`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;


ALTER TABLE `cuahangtienloi`.`sanpham` 
ADD INDEX `fk_SP_LSP_idx` (`MaLoai` ASC) VISIBLE;
;
ALTER TABLE `cuahangtienloi`.`sanpham` 
ADD CONSTRAINT `fk_SP_LSP`
  FOREIGN KEY (`MaLoai`)
  REFERENCES `cuahangtienloi`.`loaisanpham` (`MaLoai`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;


ALTER TABLE `cuahangtienloi`.`chitietchuongtrinhkhuyenmai` 
ADD INDEX `fk_CTCTKM_SP_idx` (`MaSanPham` ASC) VISIBLE;
;
ALTER TABLE `cuahangtienloi`.`chitietchuongtrinhkhuyenmai` 
ADD CONSTRAINT `fk_CTCTKM_SP`
  FOREIGN KEY (`MaSanPham`)
  REFERENCES `cuahangtienloi`.`sanpham` (`MaSanPham`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;


ALTER TABLE `cuahangtienloi`.`sanpham` 
ADD COLUMN `MaNhaSanXuat` VARCHAR(10) NOT NULL AFTER `MaLoai`;


ALTER TABLE `cuahangtienloi`.`nhasanxuat` 
CHANGE COLUMN `MaNhaSanXuat` `MaNhaSanXuat` VARCHAR(10) NOT NULL ;

ALTER TABLE `cuahangtienloi`.`sanpham` 
ADD INDEX `fk_SP_NSX_idx` (`MaNhaSanXuat` ASC) VISIBLE;
;
ALTER TABLE `cuahangtienloi`.`sanpham` 
ADD CONSTRAINT `fk_SP_NSX`
  FOREIGN KEY (`MaNhaSanXuat`)
  REFERENCES `cuahangtienloi`.`nhasanxuat` (`MaNhaSanXuat`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `cuahangtienloi`.`sanpham` 
CHANGE COLUMN `TenSanPham` `TenSanPham` VARCHAR(200) NOT NULL ;


-- thêm dữ liệu vào

INSERT INTO `cuahangtienloi`.`loaisanpham` (`MaLoai`, `TenLoai`) VALUES ('L1', 'Kem và các loại nước giải khát');
INSERT INTO `cuahangtienloi`.`loaisanpham` (`MaLoai`, `TenLoai`) VALUES ('L2', 'Bánh kẹo và các loại sữa ');
INSERT INTO `cuahangtienloi`.`loaisanpham` (`MaLoai`, `TenLoai`) VALUES ('L3', 'Đồ ăn nhanh');
INSERT INTO `cuahangtienloi`.`loaisanpham` (`MaLoai`, `TenLoai`) VALUES ('L4', 'Thực phẩm khô, gia vị');
INSERT INTO `cuahangtienloi`.`loaisanpham` (`MaLoai`, `TenLoai`) VALUES ('L5', 'Hóa mỹ phẩm');


INSERT INTO `cuahangtienloi`.`nhasanxuat` (`MaNhaSanXuat`, `TenNhaSanXuat`, `DiaChi`, `SoDienThoai`) VALUES ('NSX1', 'Hóa Mỹ Phẩm COCOSAVON - Công Ty TNHH COCOSAVON', '89 Đường Dương Khuê, Phường Hiệp Tân, Quận Tân Phú, Tp. Hồ Chí Minh (TPHCM)', '0984037903');
INSERT INTO `cuahangtienloi`.`nhasanxuat` (`MaNhaSanXuat`, `TenNhaSanXuat`, `DiaChi`, `SoDienThoai`) VALUES ('NSX2', 'Công ty cổ phần bánh kẹo Marine Việt Nam', '3 Cao Bá Nhạ, Phường Nguyễn Cư Trinh, Quận 1, Thành phố Hồ Chí Minh', '0867342458');
INSERT INTO `cuahangtienloi`.`nhasanxuat` (`MaNhaSanXuat`, `TenNhaSanXuat`, `DiaChi`, `SoDienThoai`) VALUES ('NSX3', 'Công ty cổ phần thực phẩm Sữa TH True Milk', '24 Trần Đình Xu, Phường Cô Giang, Quận 1, Thành phố Hồ Chí Minh', '0434651248');
INSERT INTO `cuahangtienloi`.`nhasanxuat` (`MaNhaSanXuat`, `TenNhaSanXuat`, `DiaChi`, `SoDienThoai`) VALUES ('NSX4', 'CÔNG TY CỔ PHẦN THỰC PHẨM ĐÔNG LẠNH KIDO', 'Lô A2 -7, Đường số N4, KCN Tây Bắc Củ Chi, Thành phố Hồ Chí Minh', '0934675734');
INSERT INTO `cuahangtienloi`.`nhasanxuat` (`MaNhaSanXuat`, `TenNhaSanXuat`, `DiaChi`, `SoDienThoai`) VALUES ('NSX5', 'Công ty cổ phần Omachi Việt nam', '186 Phú Định, Phường 16, Quận 8, Thành phố Hồ Chí Minh', '0725153654');
INSERT INTO `cuahangtienloi`.`nhasanxuat` (`MaNhaSanXuat`, `TenNhaSanXuat`, `DiaChi`, `SoDienThoai`) VALUES ('NSX6', 'Công ty cổ phần dầu thực vật Tường An', '75 Đ. Vĩnh Hội, Phường 4, Quận 4, Thành phố Hồ Chí Minh', '0852135478');
INSERT INTO `cuahangtienloi`.`nhasanxuat` (`MaNhaSanXuat`, `TenNhaSanXuat`, `DiaChi`, `SoDienThoai`) VALUES ('NSX7', 'CTCP Hàng tiêu dùng Masan', 'Tầng 12, Toà nhà MPlaza Saigon, số 39 Lê Duẩn, Phường Bến Nghé, Quận 1, Thành phố Hồ Chí Minh', '0302017440');
INSERT INTO `cuahangtienloi`.`nhasanxuat` (`MaNhaSanXuat`, `TenNhaSanXuat`, `DiaChi`, `SoDienThoai`) VALUES ('NSX8', 'Công ty đường kính trắng Toàn Phát', '453/111 Lê Văn Sỹ, Phường 12, Quận 3, Thành phố Hồ Chí Minh', '0254623566');


INSERT INTO `cuahangtienloi`.`sanpham` (`MaSanPham`, `TenSanPham`, `DonGia`, `DonViTinh`, `SoLuong`, `MaLoai`, `MaNhaSanXuat`) VALUES ('SP1', 'Kem socola hạnh nhân vani King\'s Grand 70ml', '15000', 'Que', '50', 'L1', 'NSX4');
INSERT INTO `cuahangtienloi`.`sanpham` (`MaSanPham`, `TenSanPham`, `DonGia`, `DonViTinh`, `SoLuong`, `MaLoai`, `MaNhaSanXuat`) VALUES ('SP2', 'Kem Dâu Vinamilk hộp 450ml', '45000', 'Hộp', '35', 'L1', 'NSX4');
INSERT INTO `cuahangtienloi`.`sanpham` (`MaSanPham`, `TenSanPham`, `DonGia`, `DonViTinh`, `SoLuong`, `MaLoai`, `MaNhaSanXuat`) VALUES ('SP3', 'Kem ly trà sữa trân châu Celano 100ml', '25000', 'Ly', '15', 'L1', 'NSX4');


INSERT INTO `cuahangtienloi`.`sanpham` (`MaSanPham`, `TenSanPham`, `DonGia`, `DonViTinh`, `SoLuong`, `MaLoai`, `MaNhaSanXuat`) VALUES ('SP4', 'Sữa tươi tiệt trùng nguyên chất TH True Milk hộp 1 lít', '36000', 'Hộp', '20', 'L2', 'NSX3');
INSERT INTO `cuahangtienloi`.`sanpham` (`MaSanPham`, `TenSanPham`, `DonGia`, `DonViTinh`, `SoLuong`, `MaLoai`, `MaNhaSanXuat`) VALUES ('SP5', 'Sữa tươi tiệt trùng vị tự nhiên TH true MILK Hilo 180ml', '10000', 'Hộp', '100', 'L2', 'NSX3');
INSERT INTO `cuahangtienloi`.`sanpham` (`MaSanPham`, `TenSanPham`, `DonGia`, `DonViTinh`, `SoLuong`, `MaLoai`, `MaNhaSanXuat`) VALUES ('SP6', 'Lốc 4 hộp sữa chua ít đường TH True Yogurt 100g', '24000', 'Lốc', '40', 'L2', 'NSX3');

INSERT INTO `cuahangtienloi`.`sanpham` (`MaSanPham`, `TenSanPham`, `DonGia`, `DonViTinh`, `SoLuong`, `MaLoai`, `MaNhaSanXuat`) VALUES ('SP7', 'Thùng 30 gói mì khoai tây Omachi xốt bò hầm 80g', '235000', 'Thùng', '10', 'L3', 'NSX5');
INSERT INTO `cuahangtienloi`.`sanpham` (`MaSanPham`, `TenSanPham`, `DonGia`, `DonViTinh`, `SoLuong`, `MaLoai`, `MaNhaSanXuat`) VALUES ('SP8', 'Mì Omachi 102 lẩu thả hải sản cay gói 108g', '18000', 'Gói', '200', 'L3', 'NSX5');
INSERT INTO `cuahangtienloi`.`sanpham` (`MaSanPham`, `TenSanPham`, `DonGia`, `DonViTinh`, `SoLuong`, `MaLoai`, `MaNhaSanXuat`) VALUES ('SP9', 'Mì trộn Omachi xốt Spaghetti hộp 105g', '15000', 'Hộp', '150', 'L3', 'NSX5');

INSERT INTO `cuahangtienloi`.`sanpham` (`MaSanPham`, `TenSanPham`, `DonGia`, `DonViTinh`, `SoLuong`, `MaLoai`, `MaNhaSanXuat`) VALUES ('SP10', 'Dầu thực vật Tường An Cooking Oil can 5 lít', '250000', 'Bình', '20', 'L4', 'NSX6');
INSERT INTO `cuahangtienloi`.`sanpham` (`MaSanPham`, `TenSanPham`, `DonGia`, `DonViTinh`, `SoLuong`, `MaLoai`, `MaNhaSanXuat`) VALUES ('SP11', 'Nước mắm Nam Ngư 10 độ đạm chai 900ml', '50000', 'Chai', '30', 'L4', 'NSX7');
INSERT INTO `cuahangtienloi`.`sanpham` (`MaSanPham`, `TenSanPham`, `DonGia`, `DonViTinh`, `SoLuong`, `MaLoai`, `MaNhaSanXuat`) VALUES ('SP12', 'Đường kính trắng Toàn Phát gói 500g', '12000', 'Túi', '25', 'L4', 'NSX8');

INSERT INTO `cuahangtienloi`.`sanpham` (`MaSanPham`, `TenSanPham`, `DonGia`, `DonViTinh`, `SoLuong`, `MaLoai`, `MaNhaSanXuat`) VALUES ('SP13', 'Bột giặt OMO Comfort tinh dầu thơm ngất ngây xoáy bay vết bẩn và hương thơm bền lâu 5.5kg', '225000', 'Túi', '5', 'L5', 'NSX1');
INSERT INTO `cuahangtienloi`.`sanpham` (`MaSanPham`, `TenSanPham`, `DonGia`, `DonViTinh`, `SoLuong`, `MaLoai`, `MaNhaSanXuat`) VALUES ('SP14', 'Nước lau nhà Sunlight tinh dầu thảo mộc hương chanh yuzu và sả ngăn côn trùng can 3.6kg', '85000', 'Chai', '10', 'L5', 'NSX1');
INSERT INTO `cuahangtienloi`.`sanpham` (`MaSanPham`, `TenSanPham`, `DonGia`, `DonViTinh`, `SoLuong`, `MaLoai`, `MaNhaSanXuat`) VALUES ('SP15', 'Bánh gạo ngọt vị phô mai bắp One One gói 118g', '25000', 'Túi', '25', 'L2', 'NSX2');


INSERT INTO `cuahangtienloi`.`khachhang` (`MaKhachHang`, `TenKhachHang`) VALUES ('KH1', 'Thiều Anh Sang');


INSERT INTO `cuahangtienloi`.`taikhoan` (`MaTaiKhoan`, `TenTaiKhoan`, `MatKhau`, `Email`, `SoDienThoai`, `MaKhachHang`) VALUES ('TK1', 'thieuanhsang', '123456', 'thieuanhsang@gmail.com', '0372844439', 'KH1');


INSERT INTO `cuahangtienloi`.`nhanvien` (`MaNhanVien`, `TenNhanVien`, `NgayVaoLam`, `ViTri`, `Luong`, `SoDienThoai`, `Email`) VALUES ('NV1', 'Nguyễn Bảo Tân', '2022-04-19', 'Nhân viên', '1500000', '0945768329', 'tan@gmail.com');


INSERT INTO `cuahangtienloi`.`chuongtrinhkhuyenmai` (`MaChuongTrinh`, `TenKhuyenMai`, `NgayBatDau`, `NgayKetThuc`) VALUES ('CT1', 'Khuyến mãi 5% cho sữa hộp TH true milk', '2022-04-20', '2022-05-20');


INSERT INTO `cuahangtienloi`.`chitietchuongtrinhkhuyenmai` (`MaChuongTrinh`, `MaSanPham`, `%Giam`) VALUES ('CT1', 'SP5', '5');


INSERT INTO `cuahangtienloi`.`hoadon` (`MaHoaDon`, `MaNhanVien`, `MaKhachHang`, `NgayLap`, `TongTien`) VALUES ('HD1', 'NV1', 'KH1', '2022-04-19', '15000');


INSERT INTO `cuahangtienloi`.`chitiethoadon` (`MaHoaDon`, `MaSanPham`, `DonGia`, `SoLuong`, `ThanhTien`) VALUES ('HD1', 'SP1', '15000', '1', '15000');


INSERT INTO `cuahangtienloi`.`nhacungcap` (`MaNhaCungCap`, `TenNhaCungCap`, `DiaChi`, `Sdt`, `Email`) VALUES ('NCC1', 'Đại Lý Sữa Giao Linh', '20P Nguyễn Thị Tần, Phường 3, Quận 8, Thành phố Hồ Chí Minh', '0458795632', 'suagiaolinh@gmail.com');


INSERT INTO `cuahangtienloi`.`phieunhaphang` (`MaPhieuNhapHang`, `MaNhaCungCap`, `MaNhanVien`, `NgayLap`, `TongTien`) VALUES ('PNH1', 'NCC1', 'NV1', '2022-04-19', '900000');


INSERT INTO `cuahangtienloi`.`chitietphieunhaphang` (`MaPhieuNhap`, `MaSanPham`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES ('PNH1', 'SP5', '100', '9000', '900000');


INSERT INTO `cuahangtienloi`.`nhasanxuat` (`MaNhaSanXuat`, `TenNhaSanXuat`, `DiaChi`, `SoDienThoai`) VALUES ('NSX9', 'Công ty TNHH nước giải khát Cocacola Việt Nam', '485 Song Hành XL Hà Nội, Phường Linh Trung, Thủ Đức,  Thành phố Hồ Chí Minh', '0987452365');


INSERT INTO `cuahangtienloi`.`sanpham` (`MaSanPham`, `TenSanPham`, `DonGia`, `DonViTinh`, `SoLuong`, `MaLoai`, `MaNhaSanXuat`) VALUES ('SP16', 'Nước ngọt Coca Cola chai 390ml', '7500', 'Chai', '100', 'L1', 'NSX9');


INSERT INTO `cuahangtienloi`.`nhasanxuat` (`MaNhaSanXuat`, `TenNhaSanXuat`, `DiaChi`, `SoDienThoai`) VALUES ('NSX10', 'Công ty TNHH nước giải khát PepsiCo Việt Nam', '22 Đào Duy Anh, Phường 9, Phú Nhuận, Thành phố Hồ Chí Minh', '0854526547');


INSERT INTO `cuahangtienloi`.`sanpham` (`MaSanPham`, `TenSanPham`, `DonGia`, `DonViTinh`, `SoLuong`, `MaLoai`, `MaNhaSanXuat`) VALUES ('SP17', 'Nước ngọt Pepsi Cola chai 390ml', '7000', 'Chai', '50', 'L1', 'NSX10');


INSERT INTO `cuahangtienloi`.`sanpham` (`MaSanPham`, `TenSanPham`, `DonGia`, `DonViTinh`, `SoLuong`, `MaLoai`, `MaNhaSanXuat`) VALUES ('SP18', 'Snack tôm cay đặc biệt Oishi gói 39g', '5200', 'Gói', '40', 'L2', 'NSX2');


INSERT INTO `cuahangtienloi`.`nhasanxuat` (`MaNhaSanXuat`, `TenNhaSanXuat`, `DiaChi`, `SoDienThoai`) VALUES ('NSX11', 'Công ty TNHH thực phẩm Orion Vina', 'Trung tâm thương mại Sài Gòn, 2Bis 4-6 Lê Thánh Tôn, Phường Bến Nghé, Quận 1, HCM', '0983837488');


INSERT INTO `cuahangtienloi`.`sanpham` (`MaSanPham`, `TenSanPham`, `DonGia`, `DonViTinh`, `SoLuong`, `MaLoai`, `MaNhaSanXuat`) VALUES ('SP19', 'Bánh Choco-pie hộp 660g (20 cái)', '68000', 'Hộp', '30', 'L2', 'NSX11');


INSERT INTO `cuahangtienloi`.`nhasanxuat` (`MaNhaSanXuat`, `TenNhaSanXuat`, `DiaChi`, `SoDienThoai`) VALUES ('NSX12', 'Công ty cổ phần chăn nuôi C.P Việt Nam', 'KCN Biên Hòa II, P.Long Bình Tân, Tp.Biên Hòa, T.Đồng Nai', '0968722472');


INSERT INTO `cuahangtienloi`.`sanpham` (`MaSanPham`, `TenSanPham`, `DonGia`, `DonViTinh`, `SoLuong`, `MaLoai`, `MaNhaSanXuat`) VALUES ('SP20', 'Xúc xích heo tiệt trùng C.P gói 100g', '12000', 'Gói', '25', 'L3', 'NSX12');


INSERT INTO `cuahangtienloi`.`nhanvien` (`MaNhanVien`, `TenNhanVien`, `NgayVaoLam`, `ViTri`, `Luong`, `SoDienThoai`, `Email`) VALUES ('NV2', 'Mai Ngọc Cảnh', '2022-04-20', 'Quản lý', '3000000', '0869532474', 'canh@gmail.com');
INSERT INTO `cuahangtienloi`.`nhanvien` (`MaNhanVien`, `TenNhanVien`, `NgayVaoLam`, `ViTri`, `Luong`, `SoDienThoai`, `Email`) VALUES ('NV3', 'Huỳnh Đức Tâm', '2022-04-21', 'Nhân viên', '1400000', '0995863215', 'tam@gmail.com');
INSERT INTO `cuahangtienloi`.`nhanvien` (`MaNhanVien`, `TenNhanVien`, `NgayVaoLam`, `ViTri`, `Luong`, `SoDienThoai`, `Email`) VALUES ('NV4', 'Lai Quang Vinh', '2022-04-22', 'Nhân viên', '1800000', '0878456258', 'vinh@gmail.com');


INSERT INTO `cuahangtienloi`.`khachhang` (`MaKhachHang`, `TenKhachHang`) VALUES ('KH2', 'Nguyễn Thị Phương Anh');
INSERT INTO `cuahangtienloi`.`khachhang` (`MaKhachHang`, `TenKhachHang`) VALUES ('KH3', 'Nguyễn Thanh Vũ');
INSERT INTO `cuahangtienloi`.`khachhang` (`MaKhachHang`, `TenKhachHang`) VALUES ('KH4', 'Phạm Nguyễn Phương Vy');


INSERT INTO `cuahangtienloi`.`taikhoan` (`MaTaiKhoan`, `TenTaiKhoan`, `MatKhau`, `Email`, `SoDienThoai`, `MaKhachHang`) VALUES ('TK2', 'phuonganh', '147258', 'phuonganh@gmail.com', '0852156325', 'KH2');


INSERT INTO `cuahangtienloi`.`hoadon` (`MaHoaDon`, `MaNhanVien`, `MaKhachHang`, `NgayLap`, `TongTien`) VALUES ('HD2', 'NV3', 'KH2', '2022-04-20', '136000');


INSERT INTO `cuahangtienloi`.`chitiethoadon` (`MaHoaDon`, `MaSanPham`, `DonGia`, `SoLuong`, `ThanhTien`) VALUES ('HD2', 'SP19', '68000', '2', '136000');


INSERT INTO `cuahangtienloi`.`hoadon` (`MaHoaDon`, `MaNhanVien`, `MaKhachHang`, `NgayLap`, `TongTien`) VALUES ('HD3', 'NV4', 'KH3', '2022-04-21', '85000');
INSERT INTO `cuahangtienloi`.`hoadon` (`MaHoaDon`, `MaNhanVien`, `MaKhachHang`, `NgayLap`, `TongTien`) VALUES ('HD4', 'NV1', 'KH4', '2022-04-22', '75000');


INSERT INTO `cuahangtienloi`.`chitiethoadon` (`MaHoaDon`, `MaSanPham`, `DonGia`, `SoLuong`, `ThanhTien`) VALUES ('HD3', 'SP14', '85000', '1', '85000');
INSERT INTO `cuahangtienloi`.`chitiethoadon` (`MaHoaDon`, `MaSanPham`, `DonGia`, `SoLuong`, `ThanhTien`) VALUES ('HD4', 'SP9', '15000', '5', '75000');


INSERT INTO `cuahangtienloi`.`hoadon` (`MaHoaDon`, `MaNhanVien`, `MaKhachHang`, `NgayLap`, `TongTien`) VALUES ('HD5', 'NV3', 'KH1', '2022-04-25', '48000');


INSERT INTO `cuahangtienloi`.`chitiethoadon` (`MaHoaDon`, `MaSanPham`, `DonGia`, `SoLuong`, `ThanhTien`) VALUES ('HD5', 'SP6', '24000', '2', '48000');


ALTER TABLE `cuahangtienloi`.`chitietchuongtrinhkhuyenmai` 
DROP FOREIGN KEY `fk_CTCTKM_SP`;
ALTER TABLE `cuahangtienloi`.`chitietchuongtrinhkhuyenmai` 
CHANGE COLUMN `MaSanPham` `MaSanPham` VARCHAR(10) NOT NULL ,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`MaChuongTrinh`, `MaSanPham`);
;
ALTER TABLE `cuahangtienloi`.`chitietchuongtrinhkhuyenmai` 
ADD CONSTRAINT `fk_CTCTKM_SP`
  FOREIGN KEY (`MaSanPham`)
  REFERENCES `cuahangtienloi`.`sanpham` (`MaSanPham`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;


INSERT INTO `cuahangtienloi`.`chuongtrinhkhuyenmai` (`MaChuongTrinh`, `TenKhuyenMai`, `NgayBatDau`, `NgayKetThuc`) VALUES ('CT2', 'Ngày 24,25 tháng 4 khuyến mãi giảm 10% cho đồ ăn nhanh', '222-04-24', '2022-04-26');
INSERT INTO `cuahangtienloi`.`chuongtrinhkhuyenmai` (`MaChuongTrinh`, `TenKhuyenMai`, `NgayBatDau`, `NgayKetThuc`) VALUES ('CT3', 'Giảm 15% cho nước ngọt Cocacola dịp 30/4 - 1/5', '2022-04-30', '2022-05-02');


INSERT INTO `cuahangtienloi`.`chitietchuongtrinhkhuyenmai` (`MaChuongTrinh`, `MaSanPham`, `%Giam`) VALUES ('CT2', 'SP20', '10');
INSERT INTO `cuahangtienloi`.`chitietchuongtrinhkhuyenmai` (`MaChuongTrinh`, `MaSanPham`, `%Giam`) VALUES ('CT2', 'SP7', '10');
INSERT INTO `cuahangtienloi`.`chitietchuongtrinhkhuyenmai` (`MaChuongTrinh`, `MaSanPham`, `%Giam`) VALUES ('CT2', 'SP8', '10');
INSERT INTO `cuahangtienloi`.`chitietchuongtrinhkhuyenmai` (`MaChuongTrinh`, `MaSanPham`, `%Giam`) VALUES ('CT2', 'SP9', '10');
INSERT INTO `cuahangtienloi`.`chitietchuongtrinhkhuyenmai` (`MaChuongTrinh`, `MaSanPham`, `%Giam`) VALUES ('CT3', 'SP16', '15');


INSERT INTO `cuahangtienloi`.`nhacungcap` (`MaNhaCungCap`, `TenNhaCungCap`, `DiaChi`, `Sdt`, `Email`) VALUES ('NCC2', 'Đại lý mì gói Thành phố Hồ Chí Minh', '186 Phú Định, Phường 16, Quận 8, Thành phố Hồ Chí Minh', '0845223654', 'DaiLyMiGoiHCM@gmail.com');


ALTER TABLE `cuahangtienloi`.`chitietphieunhaphang` 
DROP PRIMARY KEY,
ADD PRIMARY KEY (`MaPhieuNhap`, `MaSanPham`);
;


INSERT INTO `cuahangtienloi`.`phieunhaphang` (`MaPhieuNhapHang`, `MaNhaCungCap`, `MaNhanVien`, `NgayLap`, `TongTien`) VALUES ('PNH2', 'NCC2', 'NV2', '2022-04-20', '5500000');


INSERT INTO `cuahangtienloi`.`chitietphieunhaphang` (`MaPhieuNhap`, `MaSanPham`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES ('PNH2', 'SP8', '200', '17000', '3400000');
INSERT INTO `cuahangtienloi`.`chitietphieunhaphang` (`MaPhieuNhap`, `MaSanPham`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES ('PNH2', 'SP9', '150', '14000', '2100000');


INSERT INTO `cuahangtienloi`.`nhacungcap` (`MaNhaCungCap`, `TenNhaCungCap`, `DiaChi`, `Sdt`, `Email`) VALUES ('NCC3', 'Đại Lý Nước Giải Khát 32', '32 Nguyễn Thái Bình, Phường Nguyễn Thái Bình, Quận 1, Thành phố Hồ Chí Minh', '0245184596', 'giaikhat32@gmail.com');


INSERT INTO `cuahangtienloi`.`phieunhaphang` (`MaPhieuNhapHang`, `MaNhaCungCap`, `MaNhanVien`, `NgayLap`, `TongTien`) VALUES ('PNH3', 'NCC3', 'NV4', '2022-04-22', '1000000');


INSERT INTO `cuahangtienloi`.`chitietphieunhaphang` (`MaPhieuNhap`, `MaSanPham`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES ('PNH3', 'SP16', '100', '7000', '700000');
INSERT INTO `cuahangtienloi`.`chitietphieunhaphang` (`MaPhieuNhap`, `MaSanPham`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES ('PNH3', 'SP17', '50', '6000', '300000');


INSERT INTO `cuahangtienloi`.`nhacungcap` (`MaNhaCungCap`, `TenNhaCungCap`, `DiaChi`, `Sdt`, `Email`) VALUES ('NCC4', 'Bánh Kẹo Nhập Khẩu', '430 Hồng Bàng, Phường 16, Quận 11, Thành phố Hồ Chí Minh', '0874562365', 'BANHKEO@gmail.com');


INSERT INTO `cuahangtienloi`.`phieunhaphang` (`MaPhieuNhapHang`, `MaNhaCungCap`, `MaNhanVien`, `NgayLap`, `TongTien`) VALUES ('PNH4', 'NCC4', 'NV3', '2022-04-21', '600000');


INSERT INTO `cuahangtienloi`.`chitietphieunhaphang` (`MaPhieuNhap`, `MaSanPham`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES ('PNH4', 'SP15', '25', '24000', '600000');



INSERT INTO `cuahangtienloi`.`nhacungcap` (`MaNhaCungCap`, `TenNhaCungCap`, `DiaChi`, `Sdt`, `Email`) VALUES ('NCC5', 'NPP KEM ĐỨC MẠNH', 'Tràng Tiền 35, số 1, Số 10, Chiến Thắng - Hà Đông - Hà Nội', '0975589382', 'duccanhdo@gmail.com');


INSERT INTO `cuahangtienloi`.`phieunhaphang` (`MaPhieuNhapHang`, `MaNhaCungCap`, `MaNhanVien`, `NgayLap`, `TongTien`) VALUES ('PNH5', 'NCC5', 'NV2', '2022-04-22', '2360000');


INSERT INTO `cuahangtienloi`.`chitietphieunhaphang` (`MaPhieuNhap`, `MaSanPham`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES ('PNH5', 'SP1', '50', '12000', '600000');
INSERT INTO `cuahangtienloi`.`chitietphieunhaphang` (`MaPhieuNhap`, `MaSanPham`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES ('PNH5', 'SP2', '35', '40000', '1400000');
INSERT INTO `cuahangtienloi`.`chitietphieunhaphang` (`MaPhieuNhap`, `MaSanPham`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES ('PNH5', 'SP3', '15', '24000', '360000');


INSERT INTO `cuahangtienloi`.`nhacungcap` (`MaNhaCungCap`, `TenNhaCungCap`, `DiaChi`, `Sdt`, `Email`) VALUES ('NCC6', 'Công ty Cổ phần Chuỗi Thực phẩm TH', '166 Nguyễn Thái Học, P. Quang Trung, TP. Vinh, Nghệ An', '1800545440', 'chamsockhachhang@thmilk.vn');


INSERT INTO `cuahangtienloi`.`phieunhaphang` (`MaPhieuNhapHang`, `MaNhaCungCap`, `MaNhanVien`, `NgayLap`, `TongTien`) VALUES ('PNH6', 'NCC6', 'NV1', '2022-04-23', '1400000');


INSERT INTO `cuahangtienloi`.`chitietphieunhaphang` (`MaPhieuNhap`, `MaSanPham`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES ('PNH6', 'SP4', '20', '30000', '600000');
INSERT INTO `cuahangtienloi`.`chitietphieunhaphang` (`MaPhieuNhap`, `MaSanPham`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES ('PNH6', 'SP6', '40', '20000', '800000');


INSERT INTO `cuahangtienloi`.`nhacungcap` (`MaNhaCungCap`, `TenNhaCungCap`, `DiaChi`, `Sdt`, `Email`) VALUES ('NCC7', 'Công ty TNHH MTV TMDV Phân phối hàng tiêu dùng Trường Hưng', 'Tầng 5, Tòa nhà Song Do, 62 A Phạm Ngọc Thạch, Phường 6, Quận 3, TP Hồ Chí Minh', '0916701606', 'TNHHTruongHung@gmail.com');


INSERT INTO `cuahangtienloi`.`phieunhaphang` (`MaPhieuNhapHang`, `MaNhaCungCap`, `MaNhanVien`, `NgayLap`, `TongTien`) VALUES ('PNH7', 'NCC7', 'NV3', '2022-04-25', '8480000');


INSERT INTO `cuahangtienloi`.`chitietphieunhaphang` (`MaPhieuNhap`, `MaSanPham`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES ('PNH7', 'SP7', '10', '205000', '2050000');
INSERT INTO `cuahangtienloi`.`chitietphieunhaphang` (`MaPhieuNhap`, `MaSanPham`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES ('PNH7', 'SP10', '20', '240000', '4800000');
INSERT INTO `cuahangtienloi`.`chitietphieunhaphang` (`MaPhieuNhap`, `MaSanPham`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES ('PNH7', 'SP11', '30', '46000', '1380000');
INSERT INTO `cuahangtienloi`.`chitietphieunhaphang` (`MaPhieuNhap`, `MaSanPham`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES ('PNH7', 'SP12', '25', '10000', '250000');


INSERT INTO `cuahangtienloi`.`nhacungcap` (`MaNhaCungCap`, `TenNhaCungCap`, `DiaChi`, `Sdt`, `Email`) VALUES ('NCC8', 'CÔNG TY CỔ PHẦN VCCORP', 'Tầng 17 Tòa nhà Center Building, Hapulico Complex, số 1 Nguyễn Huy Tưởng, Thanh Xuân, Hà Nội', '0932223656', 'hotro@muare.vn');


INSERT INTO `cuahangtienloi`.`phieunhaphang` (`MaPhieuNhapHang`, `MaNhaCungCap`, `MaNhanVien`, `NgayLap`, `TongTien`) VALUES ('PNH8', 'NCC8', 'NV4', '2022-04-25', '1800000');


INSERT INTO `cuahangtienloi`.`chitietphieunhaphang` (`MaPhieuNhap`, `MaSanPham`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES ('PNH8', 'SP13', '5', '200000', '1000000');
INSERT INTO `cuahangtienloi`.`chitietphieunhaphang` (`MaPhieuNhap`, `MaSanPham`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES ('PNH8', 'SP14', '10', '80000', '800000');


INSERT INTO `cuahangtienloi`.`nhacungcap` (`MaNhaCungCap`, `TenNhaCungCap`, `DiaChi`, `Sdt`, `Email`) VALUES ('NCC9', 'Công ty cổ phần thực phẩm Á Châu', '88 Đồng Khởi, Phường Bến Nghé, Quận 1,  Thành phố Hồ Chí Minh', '0784542364', 'CTTPACHAU@gmail.com');


INSERT INTO `cuahangtienloi`.`phieunhaphang` (`MaPhieuNhapHang`, `MaNhaCungCap`, `MaNhanVien`, `NgayLap`, `TongTien`) VALUES ('PNH9', 'NCC9', 'NV1', '2022-04-26', '2000000');


INSERT INTO `cuahangtienloi`.`chitietphieunhaphang` (`MaPhieuNhap`, `MaSanPham`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES ('PNH9', 'SP18', '40', '5000', '200000');
INSERT INTO `cuahangtienloi`.`chitietphieunhaphang` (`MaPhieuNhap`, `MaSanPham`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES ('PNH9', 'SP19', '30', '60000', '1800000');


INSERT INTO `cuahangtienloi`.`nhacungcap` (`MaNhaCungCap`, `TenNhaCungCap`, `DiaChi`, `Sdt`, `Email`) VALUES ('NCC10', 'THỰC PHẨM CHÍNH HÃNG', 'Ngõ 85 Đức Diễn, Phúc Diễn, Bắc Từ Liêm, Hà Nội', '0989285468', 'longthubg@gmail.com');


INSERT INTO `cuahangtienloi`.`phieunhaphang` (`MaPhieuNhapHang`, `MaNhaCungCap`, `MaNhanVien`, `NgayLap`, `TongTien`) VALUES ('PNH10', 'NCC10', 'NV3', '2022-04-28', '250000');


INSERT INTO `cuahangtienloi`.`chitietphieunhaphang` (`MaPhieuNhap`, `MaSanPham`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES ('PNH10', 'SP20', '25', '10000', '250000');


ALTER TABLE `cuahangtienloi`.`chitiethoadon` 
DROP PRIMARY KEY,
ADD PRIMARY KEY (`MaHoaDon`, `MaSanPham`);
;


INSERT INTO `cuahangtienloi`.`khachhang` (`MaKhachHang`, `TenKhachHang`) VALUES ('KH5', 'Võ Ngọc Trúc Chi');
INSERT INTO `cuahangtienloi`.`khachhang` (`MaKhachHang`, `TenKhachHang`) VALUES ('KH6', 'Hồ Trung Tín');
INSERT INTO `cuahangtienloi`.`khachhang` (`MaKhachHang`, `TenKhachHang`) VALUES ('KH7', 'Nguyễn Tuấn Vũ');
INSERT INTO `cuahangtienloi`.`khachhang` (`MaKhachHang`, `TenKhachHang`) VALUES ('KH8', 'Huỳnh Khánh Duy');
INSERT INTO `cuahangtienloi`.`khachhang` (`MaKhachHang`, `TenKhachHang`) VALUES ('KH9', 'Nguyễn Thị Ngọc Ánh');
INSERT INTO `cuahangtienloi`.`khachhang` (`MaKhachHang`, `TenKhachHang`) VALUES ('KH10', 'Nguyễn Minh Ngọc');


INSERT INTO `cuahangtienloi`.`hoadon` (`MaHoaDon`, `MaNhanVien`, `MaKhachHang`, `NgayLap`, `TongTien`) VALUES ('HD6', 'NV4', 'KH5', '2022-04-23', '24400');
INSERT INTO `cuahangtienloi`.`hoadon` (`MaHoaDon`, `MaNhanVien`, `MaKhachHang`, `NgayLap`, `TongTien`) VALUES ('HD7', 'NV3', 'KH8', '2022-04-23', '62000');
INSERT INTO `cuahangtienloi`.`hoadon` (`MaHoaDon`, `MaNhanVien`, `MaKhachHang`, `NgayLap`, `TongTien`) VALUES ('HD8', 'NV2', 'KH6', '2022-04-23', '85000');
INSERT INTO `cuahangtienloi`.`hoadon` (`MaHoaDon`, `MaNhanVien`, `MaKhachHang`, `NgayLap`, `TongTien`) VALUES ('HD9', 'NV1', 'KH7', '2022-04-23', '235000');
INSERT INTO `cuahangtienloi`.`hoadon` (`MaHoaDon`, `MaNhanVien`, `MaKhachHang`, `NgayLap`, `TongTien`) VALUES ('HD10', 'NV1', 'KH9', '2022-04-24', '61000');
INSERT INTO `cuahangtienloi`.`hoadon` (`MaHoaDon`, `MaNhanVien`, `MaKhachHang`, `NgayLap`, `TongTien`) VALUES ('HD11', 'NV3', 'KH10', '2022-04-24', '25000');
INSERT INTO `cuahangtienloi`.`hoadon` (`MaHoaDon`, `MaNhanVien`, `MaKhachHang`, `NgayLap`, `TongTien`) VALUES ('HD12', 'NV4', 'KH7', '2022-04-25', '61000');
UPDATE `cuahangtienloi`.`hoadon` SET `NgayLap` = '2022-04-22' WHERE (`MaHoaDon` = 'HD5');


INSERT INTO `cuahangtienloi`.`chitiethoadon` (`MaHoaDon`, `MaSanPham`, `DonGia`, `SoLuong`, `ThanhTien`) VALUES ('HD6', 'SP18', '5200', '2', '10400');
INSERT INTO `cuahangtienloi`.`chitiethoadon` (`MaHoaDon`, `MaSanPham`, `DonGia`, `SoLuong`, `ThanhTien`) VALUES ('HD6', 'SP17', '7000', '2', '14000');
INSERT INTO `cuahangtienloi`.`chitiethoadon` (`MaHoaDon`, `MaSanPham`, `DonGia`, `SoLuong`, `ThanhTien`) VALUES ('HD7', 'SP11', '50000', '1', '50000');
INSERT INTO `cuahangtienloi`.`chitiethoadon` (`MaHoaDon`, `MaSanPham`, `DonGia`, `SoLuong`, `ThanhTien`) VALUES ('HD7', 'SP12', '12000', '1', '12000');
INSERT INTO `cuahangtienloi`.`chitiethoadon` (`MaHoaDon`, `MaSanPham`, `DonGia`, `SoLuong`, `ThanhTien`) VALUES ('HD8', 'SP14', '85000', '1', '85000');
INSERT INTO `cuahangtienloi`.`chitiethoadon` (`MaHoaDon`, `MaSanPham`, `DonGia`, `SoLuong`, `ThanhTien`) VALUES ('HD9', 'SP7', '235000', '1', '235000');
INSERT INTO `cuahangtienloi`.`chitiethoadon` (`MaHoaDon`, `MaSanPham`, `DonGia`, `SoLuong`, `ThanhTien`) VALUES ('HD10', 'SP3', '25000', '1', '25000');
INSERT INTO `cuahangtienloi`.`chitiethoadon` (`MaHoaDon`, `MaSanPham`, `DonGia`, `SoLuong`, `ThanhTien`) VALUES ('HD10', 'SP4', '36000', '1', '36000');
INSERT INTO `cuahangtienloi`.`chitiethoadon` (`MaHoaDon`, `MaSanPham`, `DonGia`, `SoLuong`, `ThanhTien`) VALUES ('HD11', 'SP15', '25000', '1', '25000');
INSERT INTO `cuahangtienloi`.`chitiethoadon` (`MaHoaDon`, `MaSanPham`, `DonGia`, `SoLuong`, `ThanhTien`) VALUES ('HD12', 'SP3', '25000', '1', '25000');
INSERT INTO `cuahangtienloi`.`chitiethoadon` (`MaHoaDon`, `MaSanPham`, `DonGia`, `SoLuong`, `ThanhTien`) VALUES ('HD12', 'SP8', '18000', '2', '36000');



-- 20/04/2022 kết thúc

-- 24/04/2022 bắt đầu

-- TABLE khachhang  tách họ - tên , thêm sdt, thêm cmnd/cccd

ALTER TABLE `cuahangtienloi`.`khachhang` 
ADD COLUMN `HoKhachHang` VARCHAR(50) NOT NULL AFTER `MaKhachHang`;


UPDATE `cuahangtienloi`.`khachhang` SET `HoKhachHang` = 'Thiều Anh', `TenKhachHang` = 'Sang' WHERE (`MaKhachHang` = 'KH1');
UPDATE `cuahangtienloi`.`khachhang` SET `HoKhachHang` = 'Nguyễn Minh', `TenKhachHang` = 'Ngọc' WHERE (`MaKhachHang` = 'KH10');
UPDATE `cuahangtienloi`.`khachhang` SET `HoKhachHang` = 'Nguyễn Thị Phương', `TenKhachHang` = 'Anh' WHERE (`MaKhachHang` = 'KH2');
UPDATE `cuahangtienloi`.`khachhang` SET `HoKhachHang` = 'Nguyễn Thanh', `TenKhachHang` = 'Vũ' WHERE (`MaKhachHang` = 'KH3');
UPDATE `cuahangtienloi`.`khachhang` SET `HoKhachHang` = 'Phạm Nguyễn Phương', `TenKhachHang` = 'Vy' WHERE (`MaKhachHang` = 'KH4');
UPDATE `cuahangtienloi`.`khachhang` SET `HoKhachHang` = 'Võ Ngọc Trúc', `TenKhachHang` = 'Chi' WHERE (`MaKhachHang` = 'KH5');
UPDATE `cuahangtienloi`.`khachhang` SET `HoKhachHang` = 'Hồ Trung', `TenKhachHang` = 'Tín' WHERE (`MaKhachHang` = 'KH6');
UPDATE `cuahangtienloi`.`khachhang` SET `HoKhachHang` = 'Nguyễn Tuấn', `TenKhachHang` = 'Vũ' WHERE (`MaKhachHang` = 'KH7');
UPDATE `cuahangtienloi`.`khachhang` SET `HoKhachHang` = 'Huỳnh Khánh', `TenKhachHang` = 'Duy' WHERE (`MaKhachHang` = 'KH8');
UPDATE `cuahangtienloi`.`khachhang` SET `HoKhachHang` = 'Nguyễn Thị Ngọc', `TenKhachHang` = 'Ánh' WHERE (`MaKhachHang` = 'KH9');


ALTER TABLE `cuahangtienloi`.`khachhang` 
ADD COLUMN `CMND/CCCD` VARCHAR(20) NOT NULL AFTER `TenKhachHang`;


UPDATE `cuahangtienloi`.`khachhang` SET `CMND/CCCD` = '3120410449' WHERE (`MaKhachHang` = 'KH1');
UPDATE `cuahangtienloi`.`khachhang` SET `CMND/CCCD` = '3332456895' WHERE (`MaKhachHang` = 'KH10');
UPDATE `cuahangtienloi`.`khachhang` SET `CMND/CCCD` = '3954236585' WHERE (`MaKhachHang` = 'KH2');
UPDATE `cuahangtienloi`.`khachhang` SET `CMND/CCCD` = '3785444523' WHERE (`MaKhachHang` = 'KH3');
UPDATE `cuahangtienloi`.`khachhang` SET `CMND/CCCD` = '3412563254' WHERE (`MaKhachHang` = 'KH4');
UPDATE `cuahangtienloi`.`khachhang` SET `CMND/CCCD` = '3544125362' WHERE (`MaKhachHang` = 'KH5');
UPDATE `cuahangtienloi`.`khachhang` SET `CMND/CCCD` = '3542365423' WHERE (`MaKhachHang` = 'KH6');
UPDATE `cuahangtienloi`.`khachhang` SET `CMND/CCCD` = '3521456254' WHERE (`MaKhachHang` = 'KH7');
UPDATE `cuahangtienloi`.`khachhang` SET `CMND/CCCD` = '3325122242' WHERE (`MaKhachHang` = 'KH8');
UPDATE `cuahangtienloi`.`khachhang` SET `CMND/CCCD` = '3658742153' WHERE (`MaKhachHang` = 'KH9');

ALTER TABLE `cuahangtienloi`.`khachhang` 
ADD COLUMN `SdtKhachHang` VARCHAR(10) NULL AFTER `CMND/CCCD`;


UPDATE `cuahangtienloi`.`khachhang` SET `SdtKhachHang` = '0372844439' WHERE (`MaKhachHang` = 'KH1');
UPDATE `cuahangtienloi`.`khachhang` SET `SdtKhachHang` = '0954245125' WHERE (`MaKhachHang` = 'KH10');
UPDATE `cuahangtienloi`.`khachhang` SET `SdtKhachHang` = '0856236521' WHERE (`MaKhachHang` = 'KH4');
UPDATE `cuahangtienloi`.`khachhang` SET `SdtKhachHang` = '0845125423' WHERE (`MaKhachHang` = 'KH6');
UPDATE `cuahangtienloi`.`khachhang` SET `SdtKhachHang` = '0987554568' WHERE (`MaKhachHang` = 'KH7');
UPDATE `cuahangtienloi`.`khachhang` SET `SdtKhachHang` = '0987754232' WHERE (`MaKhachHang` = 'KH8');

-- table nhanvien xóa emmail, xóa sdt, tách họ-tên

ALTER TABLE `cuahangtienloi`.`nhanvien` 
DROP COLUMN `Email`;

ALTER TABLE `cuahangtienloi`.`nhanvien` 
DROP COLUMN `SoDienThoai`;

ALTER TABLE `cuahangtienloi`.`nhanvien` 
ADD COLUMN `HoNhanVien` VARCHAR(50) NOT NULL AFTER `MaNhanVien`;

UPDATE `cuahangtienloi`.`nhanvien` SET `HoNhanVien` = 'Nguyễn Bảo', `TenNhanVien` = 'Tân' WHERE (`MaNhanVien` = 'NV1');
UPDATE `cuahangtienloi`.`nhanvien` SET `HoNhanVien` = 'Mai Ngọc', `TenNhanVien` = 'Cảnh' WHERE (`MaNhanVien` = 'NV2');
UPDATE `cuahangtienloi`.`nhanvien` SET `HoNhanVien` = 'Huỳnh Đức', `TenNhanVien` = 'Tâm' WHERE (`MaNhanVien` = 'NV3');
UPDATE `cuahangtienloi`.`nhanvien` SET `HoNhanVien` = 'Lai Quang', `TenNhanVien` = 'Vinh' WHERE (`MaNhanVien` = 'NV4');


-- Table taikhoan xóa khóa ngoại tới KH, thêm khóa ngoại tới NV, cập nhật dữ liệu

ALTER TABLE `cuahangtienloi`.`taikhoan` 
DROP FOREIGN KEY `fk_TK_KH`;
ALTER TABLE `cuahangtienloi`.`taikhoan` 
DROP INDEX `fk_TK_KH_idx` ;
;

ALTER TABLE `cuahangtienloi`.`taikhoan` 
CHANGE COLUMN `MaKhachHang` `MaNhanVien` VARCHAR(10) NOT NULL ;

DELETE FROM `cuahangtienloi`.`taikhoan` WHERE (`MaTaiKhoan` = 'TK1');
DELETE FROM `cuahangtienloi`.`taikhoan` WHERE (`MaTaiKhoan` = 'TK2');


ALTER TABLE `cuahangtienloi`.`taikhoan` 
ADD INDEX `fk_TK_NV_idx` (`MaNhanVien` ASC) VISIBLE;
;
ALTER TABLE `cuahangtienloi`.`taikhoan` 
ADD CONSTRAINT `fk_TK_NV`
  FOREIGN KEY (`MaNhanVien`)
  REFERENCES `cuahangtienloi`.`nhanvien` (`MaNhanVien`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

INSERT INTO `cuahangtienloi`.`taikhoan` (`MaTaiKhoan`, `TenTaiKhoan`, `MatKhau`, `Email`, `SoDienThoai`, `MaNhanVien`) VALUES ('TK1', 'baotan2k2', '123456', 'tan@gmail.com', '0836548795', 'NV1');
INSERT INTO `cuahangtienloi`.`taikhoan` (`MaTaiKhoan`, `TenTaiKhoan`, `MatKhau`, `Email`, `SoDienThoai`, `MaNhanVien`) VALUES ('TK2', 'admin', '123456', 'CanhMai@gmail.com', '0954525478', 'NV2');
INSERT INTO `cuahangtienloi`.`taikhoan` (`MaTaiKhoan`, `TenTaiKhoan`, `MatKhau`, `Email`, `SoDienThoai`, `MaNhanVien`) VALUES ('TK3', 'ductam', '123456', 'tam@gmail.com', '0987456236', 'NV3');
INSERT INTO `cuahangtienloi`.`taikhoan` (`MaTaiKhoan`, `TenTaiKhoan`, `MatKhau`, `Email`, `SoDienThoai`, `MaNhanVien`) VALUES ('TK4', 'quangvinh', '123456', 'vinh@gmail.com', '0895625425', 'NV4');


UPDATE `cuahangtienloi`.`nhanvien` SET `HoNhanVien` = 'Thiều Anh', `TenNhanVien` = 'Sang' WHERE (`MaNhanVien` = 'NV1');
UPDATE `cuahangtienloi`.`taikhoan` SET `TenTaiKhoan` = 'anhsang', `Email` = 'sang@gmail.com' WHERE (`MaTaiKhoan` = 'TK1');


-- sửa kiểu dữ liệu cho tiền

ALTER TABLE `cuahangtienloi`.`chitietchuongtrinhkhuyenmai` 
CHANGE COLUMN `%Giam` `%Giam` DOUBLE NULL DEFAULT NULL ;

ALTER TABLE `cuahangtienloi`.`hoadon` 
CHANGE COLUMN `TongTien` `TongTien` DOUBLE NOT NULL ;


ALTER TABLE `cuahangtienloi`.`chitiethoadon` 
CHANGE COLUMN `DonGia` `DonGia` DOUBLE NOT NULL ,
CHANGE COLUMN `ThanhTien` `ThanhTien` DOUBLE NOT NULL ;


ALTER TABLE `cuahangtienloi`.`phieunhaphang` 
CHANGE COLUMN `TongTien` `TongTien` DOUBLE NOT NULL ;


ALTER TABLE `cuahangtienloi`.`chitietphieunhaphang` 
CHANGE COLUMN `DonGia` `DonGia` DOUBLE NOT NULL ,
CHANGE COLUMN `ThanhTien` `ThanhTien` DOUBLE NOT NULL ;


ALTER TABLE `cuahangtienloi`.`sanpham` 
CHANGE COLUMN `DonGia` `DonGia` DOUBLE NOT NULL ;

-- sửa thông tin trong hóa đơn thành năm-tháng-ngày giờ-phút-giây

ALTER TABLE `cuahangtienloi`.`hoadon` 
CHANGE COLUMN `NgayLap` `NgayLap` DATETIME NOT NULL ;

-- thêm tên sản phẩm cho cthd
ALTER TABLE `cuahangtienloi`.`chitiethoadon` 
ADD COLUMN `TenSanPham` VARCHAR(200) NOT NULL AFTER `MaSanPham`;


UPDATE `cuahangtienloi`.`chitiethoadon` SET `TenSanPham` = 'Kem socola hạnh nhân vani King\'s Grand 70ml' WHERE (`MaHoaDon` = 'HD1') and (`MaSanPham` = 'SP1');
UPDATE `cuahangtienloi`.`chitiethoadon` SET `TenSanPham` = 'Nước mắm Nam Ngư 10 độ đạm chai 900ml' WHERE (`MaHoaDon` = 'HD7') and (`MaSanPham` = 'SP11');
UPDATE `cuahangtienloi`.`chitiethoadon` SET `TenSanPham` = 'Đường kính trắng Toàn Phát gói 500g' WHERE (`MaHoaDon` = 'HD7') and (`MaSanPham` = 'SP12');
UPDATE `cuahangtienloi`.`chitiethoadon` SET `TenSanPham` = 'Nước lau nhà Sunlight tinh dầu thảo mộc hương chanh yuzu và sả ngăn côn trùng can 3.6kg' WHERE (`MaHoaDon` = 'HD3') and (`MaSanPham` = 'SP14');
UPDATE `cuahangtienloi`.`chitiethoadon` SET `TenSanPham` = 'Nước lau nhà Sunlight tinh dầu thảo mộc hương chanh yuzu và sả ngăn côn trùng can 3.6kg' WHERE (`MaHoaDon` = 'HD8') and (`MaSanPham` = 'SP14');
UPDATE `cuahangtienloi`.`chitiethoadon` SET `TenSanPham` = 'Bánh gạo ngọt vị phô mai bắp One One gói 118g' WHERE (`MaHoaDon` = 'HD11') and (`MaSanPham` = 'SP15');
UPDATE `cuahangtienloi`.`chitiethoadon` SET `TenSanPham` = 'Nước ngọt Pepsi Cola chai 390ml' WHERE (`MaHoaDon` = 'HD6') and (`MaSanPham` = 'SP17');
UPDATE `cuahangtienloi`.`chitiethoadon` SET `TenSanPham` = 'Snack tôm cay đặc biệt Oishi gói 39g' WHERE (`MaHoaDon` = 'HD6') and (`MaSanPham` = 'SP18');
UPDATE `cuahangtienloi`.`chitiethoadon` SET `TenSanPham` = 'Bánh Choco-pie hộp 660g (20 cái)' WHERE (`MaHoaDon` = 'HD2') and (`MaSanPham` = 'SP19');
UPDATE `cuahangtienloi`.`chitiethoadon` SET `TenSanPham` = 'Kem ly trà sữa trân châu Celano 100ml' WHERE (`MaHoaDon` = 'HD10') and (`MaSanPham` = 'SP3');
UPDATE `cuahangtienloi`.`chitiethoadon` SET `TenSanPham` = 'Kem ly trà sữa trân châu Celano 100ml' WHERE (`MaHoaDon` = 'HD12') and (`MaSanPham` = 'SP3');
UPDATE `cuahangtienloi`.`chitiethoadon` SET `TenSanPham` = 'Sữa tươi tiệt trùng nguyên chất TH True Milk hộp 1 lít' WHERE (`MaHoaDon` = 'HD10') and (`MaSanPham` = 'SP4');
UPDATE `cuahangtienloi`.`chitiethoadon` SET `TenSanPham` = 'Lốc 4 hộp sữa chua ít đường TH True Yogurt 100g' WHERE (`MaHoaDon` = 'HD5') and (`MaSanPham` = 'SP6');
UPDATE `cuahangtienloi`.`chitiethoadon` SET `TenSanPham` = 'Thùng 30 gói mì khoai tây Omachi xốt bò hầm 80g' WHERE (`MaHoaDon` = 'HD9') and (`MaSanPham` = 'SP7');
UPDATE `cuahangtienloi`.`chitiethoadon` SET `TenSanPham` = 'Mì Omachi 102 lẩu thả hải sản cay gói 108g' WHERE (`MaHoaDon` = 'HD12') and (`MaSanPham` = 'SP8');
UPDATE `cuahangtienloi`.`chitiethoadon` SET `TenSanPham` = 'Mì trộn Omachi xốt Spaghetti hộp 105g' WHERE (`MaHoaDon` = 'HD4') and (`MaSanPham` = 'SP9');

-- thêm phân quyền
ALTER TABLE `cuahangtienloi`.`taikhoan` 
ADD COLUMN `PhanQuyen` VARCHAR(10) NOT NULL AFTER `MatKhau`;

UPDATE `cuahangtienloi`.`taikhoan` SET `PhanQuyen` = 'user' WHERE (`MaTaiKhoan` = 'TK1');
UPDATE `cuahangtienloi`.`taikhoan` SET `TenTaiKhoan` = 'ngoccanh', `PhanQuyen` = 'admin' WHERE (`MaTaiKhoan` = 'TK2');
UPDATE `cuahangtienloi`.`taikhoan` SET `PhanQuyen` = 'user' WHERE (`MaTaiKhoan` = 'TK3');
UPDATE `cuahangtienloi`.`taikhoan` SET `PhanQuyen` = 'user' WHERE (`MaTaiKhoan` = 'TK4');


-- xóa liên kết ctctkm-sp, tạo cttckm-kh
ALTER TABLE `cuahangtienloi`.`chitietchuongtrinhkhuyenmai` 
DROP FOREIGN KEY `fk_CTCTKM_SP`;
ALTER TABLE `cuahangtienloi`.`chitietchuongtrinhkhuyenmai` 
DROP INDEX `fk_CTCTKM_SP_idx` ;
;

ALTER TABLE `cuahangtienloi`.`chitietchuongtrinhkhuyenmai` 
CHANGE COLUMN `MaSanPham` `MaKhachHang` VARCHAR(10) NOT NULL ;


DELETE FROM `cuahangtienloi`.`chitietchuongtrinhkhuyenmai` WHERE (`MaChuongTrinh` = 'CT1') and (`MaKhachHang` = 'SP5');
DELETE FROM `cuahangtienloi`.`chitietchuongtrinhkhuyenmai` WHERE (`MaChuongTrinh` = 'CT2') and (`MaKhachHang` = 'SP20');
DELETE FROM `cuahangtienloi`.`chitietchuongtrinhkhuyenmai` WHERE (`MaChuongTrinh` = 'CT2') and (`MaKhachHang` = 'SP7');
DELETE FROM `cuahangtienloi`.`chitietchuongtrinhkhuyenmai` WHERE (`MaChuongTrinh` = 'CT2') and (`MaKhachHang` = 'SP8');
DELETE FROM `cuahangtienloi`.`chitietchuongtrinhkhuyenmai` WHERE (`MaChuongTrinh` = 'CT2') and (`MaKhachHang` = 'SP9');
DELETE FROM `cuahangtienloi`.`chitietchuongtrinhkhuyenmai` WHERE (`MaChuongTrinh` = 'CT3') and (`MaKhachHang` = 'SP16');


DELETE FROM `cuahangtienloi`.`chuongtrinhkhuyenmai` WHERE (`MaChuongTrinh` = 'CT1');
DELETE FROM `cuahangtienloi`.`chuongtrinhkhuyenmai` WHERE (`MaChuongTrinh` = 'CT2');
DELETE FROM `cuahangtienloi`.`chuongtrinhkhuyenmai` WHERE (`MaChuongTrinh` = 'CT3');

INSERT INTO `cuahangtienloi`.`chuongtrinhkhuyenmai` (`MaChuongTrinh`, `TenKhuyenMai`, `NgayBatDau`, `NgayKetThuc`) VALUES ('CT1', 'Lễ giảm 10% cho mỗi khách hàng mua sắm tại cửa hàng', '2022-04-30', '2022-05-02');


ALTER TABLE `cuahangtienloi`.`chitietchuongtrinhkhuyenmai` 
ADD INDEX `fk_CTCTKM_KH_idx` (`MaKhachHang` ASC) VISIBLE;
;
ALTER TABLE `cuahangtienloi`.`chitietchuongtrinhkhuyenmai` 
ADD CONSTRAINT `fk_CTCTKM_KH`
  FOREIGN KEY (`MaKhachHang`)
  REFERENCES `cuahangtienloi`.`khachhang` (`MaKhachHang`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;


ALTER TABLE `cuahangtienloi`.`nhanvien` 
ADD COLUMN `SoDienThoai` VARCHAR(50) NULL AFTER `Luong`,
ADD COLUMN `Email` VARCHAR(20) NULL AFTER `SoDienThoai`;

ALTER TABLE `cuahangtienloi`.`taikhoan` 
DROP COLUMN `SoDienThoai`,
DROP COLUMN `Email`;

UPDATE `cuahangtienloi`.`nhanvien` SET `SoDienThoai` = '0372844439', `Email` = 'sang@gmail.com' WHERE (`MaNhanVien` = 'NV1');
UPDATE `cuahangtienloi`.`nhanvien` SET `SoDienThoai` = '0845785236', `Email` = 'canh@gmail.com' WHERE (`MaNhanVien` = 'NV2');
UPDATE `cuahangtienloi`.`nhanvien` SET `SoDienThoai` = '0987452654', `Email` = 'tam@gmail.com' WHERE (`MaNhanVien` = 'NV3');
UPDATE `cuahangtienloi`.`nhanvien` SET `SoDienThoai` = '0362154745', `Email` = 'vinh@gmail.com' WHERE (`MaNhanVien` = 'NV4');

-- 24/04/2022 end