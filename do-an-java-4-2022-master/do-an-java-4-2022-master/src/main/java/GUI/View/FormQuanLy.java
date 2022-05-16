package GUI.View;

import BUS.ChuongTrinhKhuyenMaiBUS;
import BUS.NhanVienBUS;
import BUS.SanPhamBUS;
import BUS.TaiKhoanBUS;
import DTO.ChuongTrinhKhuyenMaiDTO;
import DTO.NhanVienDTO;
import DTO.SanPhamDTO;
import DTO.TaiKhoanDTO;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class FormQuanLy extends JFrame {

  private JPanel contentPane;
  private JTable tableSanPham;
  private JTextField tfMaSP;
  private JTextField tfTenSP;
  private JTextField tfDonGia;
  private JTextField tfDonViTinh;
  private JTextField tfSoLuong;
  private JTextField tfMaNhaSanXuat_SP;
  private JTable tableNhanVien;
  private JTextField tfMaNhanVien;
  private JTextField tfHoNhanVien;
  private JTextField tfTenNhanVien;
  private JTextField tfSoDienThoai_NV;
  private JTextField tfLuongNhanVien;
  private JTextField tfEmail_NV;
  private JTable tableTaiKhoan;
  private JTextField tfMaTaiKhoan;
  private JTextField tfTenTaiKhoan;
  private JTextField tfMatKhauTK;
  private JTextField tfMaNV;
  private JTable tableNhaCungCap;
  private JTextField tfMaNhaCungCap;
  private JTextField tfTenNhaCungCap;
  private JTextField tfDiaChiNhaCungCap;
  private JTextField tfSoDienThoai_NCC;
  private JTextField tfEmail_NCC;
  private JTable tableNhaSanXuat;
  private JTextField tfMaNhaSanXuat;
  private JTextField tfTenNhaSanXuat;
  private JTextField tfSoDienThoai_NSX;
  private JTextField tfDiaChi_NSX;
  private JTable tableChuongTrinhKM;
  private JTextField tfMaCT;
  private JTextField tfTenCT;

  private ChuongTrinhKhuyenMaiBUS chuongTrinhKhuyenMaiBUS;
  private SanPhamBUS sanPhamBUS;
  private BUS.TaiKhoanBUS taiKhoanBUS;
  private NhanVienBUS nhanVienBUS;
  private DefaultTableModel modelCTKM = new DefaultTableModel();
  private DefaultTableModel modelSP = new DefaultTableModel();
  private DefaultTableModel modelTK = new DefaultTableModel();
  private DefaultTableModel modelNV = new DefaultTableModel();

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          FormQuanLy frame = new FormQuanLy();

        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public FormQuanLy() {
    chuongTrinhKhuyenMaiBUS = new ChuongTrinhKhuyenMaiBUS();
    sanPhamBUS = new SanPhamBUS();
    sanPhamBUS = new SanPhamBUS();
    taiKhoanBUS = new TaiKhoanBUS();
    nhanVienBUS = new NhanVienBUS();
    setTitle("Qu\u1EA3n L\u00FD");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 905, 527);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    setLocationRelativeTo(null);

    JPanel panel = new JPanel();
    panel.setBounds(0, 0, 896, 496);
    contentPane.add(panel);
    panel.setLayout(null);

    JSplitPane splitPane = new JSplitPane();
    splitPane.setOneTouchExpandable(true);
    splitPane.setResizeWeight(0.25);
    splitPane.setBounds(0, 0, 896, 496);
    panel.add(splitPane);

    JPanel pnChon = new JPanel();
    pnChon.setBackground(new Color(102, 205, 170));
    splitPane.setLeftComponent(pnChon);
    pnChon.setLayout(null);

    JButton btnSanPham = new JButton("S\u1EA3n Ph\u1EA9m");

    btnSanPham.setBounds(10, 75, 202, 49);
    pnChon.add(btnSanPham);

    JButton btnNhanVien = new JButton("Nh\u00E2n Vi\u00EAn");
    btnNhanVien.setBounds(10, 135, 202, 49);
    pnChon.add(btnNhanVien);

    JButton btnTaiKhoan = new JButton("T\u00E0i Kho\u1EA3n");
    btnTaiKhoan.setBounds(10, 195, 202, 49);
    pnChon.add(btnTaiKhoan);

    JButton btnThongKe = new JButton("Th\u1ED1ng K\u00EA");
    btnThongKe.setBounds(10, 374, 202, 49);
    pnChon.add(btnThongKe);

    JButton btnDangXuat = new JButton("\u0110\u0103ng Xu\u1EA5t");
    btnDangXuat.setBounds(10, 434, 96, 49);
    pnChon.add(btnDangXuat);

    JButton btnThoat = new JButton("Tho\u00E1t");
    btnThoat.setBounds(116, 434, 96, 49);
    pnChon.add(btnThoat);

    JButton btnNhaSanXuat = new JButton("Nh\u00E0 S\u1EA3n Xu\u1EA5t");
    btnNhaSanXuat.setBounds(10, 315, 202, 49);
    pnChon.add(btnNhaSanXuat);

    JButton btnNhaCungCap = new JButton("Nh\u00E0 Cung C\u1EA5p");
    btnNhaCungCap.setBounds(10, 255, 202, 49);
    pnChon.add(btnNhaCungCap);

    JButton btnCT_KhuyenMai = new JButton("CT_Khuy\u1EBFn M\u00E3i");
    btnCT_KhuyenMai.setBounds(10, 11, 202, 49);
    pnChon.add(btnCT_KhuyenMai);
    btnDangXuat.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

      }
    });

    JPanel CardThongTin = new JPanel();
    CardThongTin.setBackground(new Color(95, 158, 160));
    splitPane.setRightComponent(CardThongTin);
    CardThongTin.setLayout(new CardLayout(0, 0));

    JPanel pnTT_SanPham = new JPanel();
    pnTT_SanPham.setBackground(new Color(135, 206, 235));
    CardThongTin.add(pnTT_SanPham, "name_830384674955600");
    pnTT_SanPham.setLayout(null);

    tableSanPham = new JTable();
    tableSanPham.setBounds(10, 244, 647, 239);
    pnTT_SanPham.add(tableSanPham);

    JScrollPane scrollPaneSP = new JScrollPane();
    scrollPaneSP.setBounds(10, 250, 647, 260);
    pnTT_SanPham.add(scrollPaneSP);
    scrollPaneSP.setViewportView(tableSanPham);
    Vector headerSP = new Vector<>();
    headerSP.add("Mã SP");
    headerSP.add("Tên SP");
    headerSP.add("Đơn giá");
    headerSP.add("Đơn vị tính");
    headerSP.add("Số lượng");
    headerSP.add("Mã loại");
    headerSP.add("Mã nhà sản xuất");
    if (modelSP.getRowCount() == 0) {
      modelSP = new DefaultTableModel(headerSP, 0);
      readDataSP();
    }
    tableSanPham.setModel(modelSP);

    JLabel lblMaSP = new JLabel("M\u00E3 S\u1EA3n Ph\u1EA9m :");
    lblMaSP.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblMaSP.setBounds(10, 59, 120, 21);
    pnTT_SanPham.add(lblMaSP);

    JLabel lblTenSanPham = new JLabel("T\u00EAn S\u1EA3n Ph\u1EA9m :");
    lblTenSanPham.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblTenSanPham.setBounds(10, 91, 123, 21);
    pnTT_SanPham.add(lblTenSanPham);

    JLabel lblDonGia = new JLabel(" \u0110\u01A1n gi\u00E1 :");
    lblDonGia.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblDonGia.setBounds(10, 123, 76, 21);
    pnTT_SanPham.add(lblDonGia);

    JLabel lblSoLuong = new JLabel("S\u1ED1 l\u01B0\u1EE3ng :");
    lblSoLuong.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblSoLuong.setBounds(329, 61, 80, 21);
    pnTT_SanPham.add(lblSoLuong);

    JLabel lblMaLoai = new JLabel("M\u00E3 lo\u1EA1i :");
    lblMaLoai.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblMaLoai.setBounds(329, 93, 70, 21);
    pnTT_SanPham.add(lblMaLoai);

    JLabel lblMaNhaSanXuat_SP = new JLabel("M\u00E3 Nh\u00E0 S\u1EA3n Xu\u1EA5t :");
    lblMaNhaSanXuat_SP.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblMaNhaSanXuat_SP.setBounds(329, 121, 149, 21);
    pnTT_SanPham.add(lblMaNhaSanXuat_SP);

    JLabel lblDonViTinh = new JLabel("\u0110\u01A1n v\u1ECB t\u00EDnh :");
    lblDonViTinh.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblDonViTinh.setBounds(10, 155, 98, 21);
    pnTT_SanPham.add(lblDonViTinh);

    tfMaSP = new JTextField();
    tfMaSP.setBounds(140, 59, 162, 22);
    pnTT_SanPham.add(tfMaSP);
    tfMaSP.setColumns(10);

    tfTenSP = new JTextField();
    tfTenSP.setColumns(10);
    tfTenSP.setBounds(140, 92, 162, 22);
    pnTT_SanPham.add(tfTenSP);

    tfDonGia = new JTextField();
    tfDonGia.setColumns(10);
    tfDonGia.setBounds(140, 125, 162, 22);
    pnTT_SanPham.add(tfDonGia);

    tfDonViTinh = new JTextField();
    tfDonViTinh.setColumns(10);
    tfDonViTinh.setBounds(140, 158, 162, 22);
    pnTT_SanPham.add(tfDonViTinh);

    tfSoLuong = new JTextField();
    tfSoLuong.setColumns(10);
    tfSoLuong.setBounds(488, 62, 149, 22);
    pnTT_SanPham.add(tfSoLuong);

    tfMaNhaSanXuat_SP = new JTextField();
    tfMaNhaSanXuat_SP.setColumns(10);
    tfMaNhaSanXuat_SP.setBounds(488, 122, 149, 22);
    pnTT_SanPham.add(tfMaNhaSanXuat_SP);

    JComboBox cbMaLoai = new JComboBox();
    cbMaLoai.setBounds(488, 94, 149, 22);
    cbMaLoai.setModel(new DefaultComboBoxModel(new String[]{null, "L1", "L2", "L3", "L4", "L5"}));
    pnTT_SanPham.add(cbMaLoai);

    JButton btnThemSP = new JButton("TH\u00CAM");
    btnThemSP.setBounds(10, 189, 107, 44);
    btnThemSP.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        SanPhamDTO sanPhamDTO = new SanPhamDTO();
        try {
          sanPhamDTO.setMaSanPham(tfMaSP.getText());
          sanPhamDTO.setTenSanPham(tfTenSP.getText());
          sanPhamDTO.setMaNhaSanXuat(tfMaNhaSanXuat_SP.getText());
          sanPhamDTO.setMaLoai(cbMaLoai.getSelectedItem() + "");
          sanPhamDTO.setDonViTinh(tfDonViTinh.getText());
          sanPhamDTO.setDonGia(Double.parseDouble(tfDonGia.getText()));
          sanPhamDTO.setSoLuong(Integer.parseInt(tfSoLuong.getText()));
        } catch (Exception ex1) {
          if (tfMaSP.getText().equals("")) {
            JOptionPane.showMessageDialog(tfMaSP, "Vui lòng nhập Mã Sản Phẩm!!!");
          }
          if (tfTenSP.getText().equals("")) {
            JOptionPane.showMessageDialog(tfTenSP, "Vui lòng nhập Tên Sản Phẩm!!!");
          }
          if (tfMaNhaSanXuat_SP.getText().equals("")) {
            JOptionPane.showMessageDialog(tfMaNhaSanXuat_SP, "Vui lòng nhập Mã Nhà Sản Xuất!!!");
          }
          if (tfDonGia.getText().equals("")) {
            JOptionPane.showMessageDialog(tfDonGia, "Vui lòng nhập đơn giá!!!");
          }
          if (tfSoLuong.getText().equals("")) {
            JOptionPane.showMessageDialog(tfSoLuong, "Vui lòng nhập số lượng!!");
          }

          if (cbMaLoai.getSelectedItem().equals(null)) {
            JOptionPane.showMessageDialog(cbMaLoai, "Vui lòng nhập mã loại!!!");
          }
          if (tfDonViTinh.getText().equals("")) {
            JOptionPane.showMessageDialog(tfDonViTinh, "Vui lòng nhập đơn vị tính!!!");
          }
        }
        sanPhamBUS.them(sanPhamDTO);
        readDataSP();
      }
    });
    pnTT_SanPham.add(btnThemSP);

    JButton btnXoaSP = new JButton("X\u00D3A");
    btnXoaSP.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (tfMaSP.getText().equals("")) {
          JOptionPane.showMessageDialog(tfMaSP, "Vui lòng nhập mã sản phẩm để xóa!!!");
        }
        sanPhamBUS.xoa(tfMaSP.getText());
        readDataSP();
      }
    });
    btnXoaSP.setBounds(142, 189, 107, 44);
    pnTT_SanPham.add(btnXoaSP);

    JButton btnSuaSP = new JButton("S\u1EECA");
    btnSuaSP.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String maSanPham = tfMaSP.getText();
        if (tfMaSP.getText().equals("")) {
          JOptionPane.showMessageDialog(tfMaSP, "Vui lòng nhập mã sản phẩm để xóa!!!");
        }
        SanPhamDTO sanPhamDTO = sanPhamBUS.timKiem(maSanPham);
        if (tfTenSP.getText().equals("")) {
          tfTenSP.setText(sanPhamDTO.getTenSanPham());
        }
        sanPhamDTO.setTenSanPham(tfTenSP.getText());

        if (tfDonGia.getText().equals("")) {
          tfDonGia.setText(sanPhamDTO.getDonGia() + "");
        }
        sanPhamDTO.setDonGia(Double.parseDouble(tfDonGia.getText()));

        if (tfDonViTinh.getText().equals("")) {
          tfDonViTinh.setText(sanPhamDTO.getDonViTinh());
        }
        sanPhamDTO.setDonViTinh(tfDonViTinh.getText());

        if (tfSoLuong.getText().equals("")) {
          tfSoLuong.setText(sanPhamDTO.getSoLuong() + "");
        }
        sanPhamDTO.setSoLuong(Integer.parseInt(tfSoLuong.getText()));

        if (cbMaLoai.getSelectedItem() == null) {
          cbMaLoai.setSelectedItem(sanPhamDTO.getMaLoai());
        }
        sanPhamDTO.setMaLoai(cbMaLoai.getSelectedItem() + "");
        if (tfMaNhaSanXuat_SP.getText().equals("")) {
          tfMaNhaSanXuat_SP.setText(sanPhamDTO.getMaNhaSanXuat());
        }
        sanPhamDTO.setMaNhaSanXuat(tfMaNhaSanXuat_SP.getText());
        sanPhamBUS.sua(sanPhamDTO);
        readDataSP();
      }
    });
    btnSuaSP.setBounds(279, 191, 107, 42);
    pnTT_SanPham.add(btnSuaSP);

    JButton btnTimKiemSP = new JButton("T\u00CCM KI\u1EBEM");
    btnTimKiemSP.setBounds(414, 191, 107, 42);
    btnTimKiemSP.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (!tfMaSP.getText().equals("")) {
          sanPhamBUS.timKiem(tfMaSP.getText());
          readDataSP();
        }
        if (!tfTenSP.getText().equals("")) {
          modelSP.setRowCount(0);
          for (SanPhamDTO sanPhamDTO : sanPhamBUS.findByConditionUseLike("TenSanPham",
              "%" + tfTenSP.getText() + "%")) {
            Vector row = new Vector();
            row.add(sanPhamDTO.getMaSanPham());
            row.add(sanPhamDTO.getTenSanPham());
            row.add(sanPhamDTO.getDonGia());
            row.add(sanPhamDTO.getDonViTinh());
            row.add(sanPhamDTO.getSoLuong());
            row.add(sanPhamDTO.getMaLoai());
            row.add(sanPhamDTO.getMaNhaSanXuat());
            modelSP.addRow(row);
          }
          tableSanPham.setModel(modelSP);
        }
        if (!tfDonGia.getText().equals("")) {
          modelSP.setRowCount(0);
          for (SanPhamDTO sanPhamDTO : sanPhamBUS.findByCondition("DonGia",
              tfDonGia.getText())) {
            Vector row = new Vector();
            row.add(sanPhamDTO.getMaSanPham());
            row.add(sanPhamDTO.getTenSanPham());
            row.add(sanPhamDTO.getDonGia());
            row.add(sanPhamDTO.getDonViTinh());
            row.add(sanPhamDTO.getSoLuong());
            row.add(sanPhamDTO.getMaLoai());
            row.add(sanPhamDTO.getMaNhaSanXuat());
            modelSP.addRow(row);
          }
          tableSanPham.setModel(modelSP);
        }
        if (!tfDonViTinh.getText().equals("")) {
          modelSP.setRowCount(0);
          for (SanPhamDTO sanPhamDTO : sanPhamBUS.findByCondition("DonViTinh",
              tfDonViTinh.getText())) {
            Vector row = new Vector();
            row.add(sanPhamDTO.getMaSanPham());
            row.add(sanPhamDTO.getTenSanPham());
            row.add(sanPhamDTO.getDonGia());
            row.add(sanPhamDTO.getDonViTinh());
            row.add(sanPhamDTO.getSoLuong());
            row.add(sanPhamDTO.getMaLoai());
            row.add(sanPhamDTO.getMaNhaSanXuat());
            modelSP.addRow(row);
          }
          tableSanPham.setModel(modelSP);
        }
        if (!tfSoLuong.getText().equals("")) {
          modelSP.setRowCount(0);
          for (SanPhamDTO sanPhamDTO : sanPhamBUS.findByCondition("SoLuong",
              tfSoLuong.getText())) {
            Vector row = new Vector();
            row.add(sanPhamDTO.getMaSanPham());
            row.add(sanPhamDTO.getTenSanPham());
            row.add(sanPhamDTO.getDonGia());
            row.add(sanPhamDTO.getDonViTinh());
            row.add(sanPhamDTO.getSoLuong());
            row.add(sanPhamDTO.getMaLoai());
            row.add(sanPhamDTO.getMaNhaSanXuat());
            modelSP.addRow(row);
          }
          tableSanPham.setModel(modelSP);
        }
        if (cbMaLoai.getSelectedItem() != null) {
          modelSP.setRowCount(0);
          for (SanPhamDTO sanPhamDTO : sanPhamBUS.findByCondition("MaLoai",
              cbMaLoai.getSelectedItem() + "")) {
            Vector row = new Vector();
            row.add(sanPhamDTO.getMaSanPham());
            row.add(sanPhamDTO.getTenSanPham());
            row.add(sanPhamDTO.getDonGia());
            row.add(sanPhamDTO.getDonViTinh());
            row.add(sanPhamDTO.getSoLuong());
            row.add(sanPhamDTO.getMaLoai());
            row.add(sanPhamDTO.getMaNhaSanXuat());
            modelSP.addRow(row);
          }
          tableSanPham.setModel(modelSP);
        }
        if (!tfMaNhaSanXuat_SP.getText().equals("")) {
          modelSP.setRowCount(0);
          for (SanPhamDTO sanPhamDTO : sanPhamBUS.findByCondition("MaNhaSanXuat",
              tfMaNhaSanXuat_SP.getText())) {
            Vector row = new Vector();
            row.add(sanPhamDTO.getMaSanPham());
            row.add(sanPhamDTO.getTenSanPham());
            row.add(sanPhamDTO.getDonGia());
            row.add(sanPhamDTO.getDonViTinh());
            row.add(sanPhamDTO.getSoLuong());
            row.add(sanPhamDTO.getMaLoai());
            row.add(sanPhamDTO.getMaNhaSanXuat());
            modelSP.addRow(row);
          }
          tableSanPham.setModel(modelSP);
        }
        //readDataSP();
      }
    });
    pnTT_SanPham.add(btnTimKiemSP);

    JButton btnLoaiSP = new JButton("LO\u1EA0I");
    btnLoaiSP.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        LoaiSanPham loaiSanPham = new LoaiSanPham();
        loaiSanPham.setVisible(true);
      }
    });
    btnLoaiSP.setBounds(550, 189, 107, 44);
    pnTT_SanPham.add(btnLoaiSP);

    JLabel lblNewLabel_1 = new JLabel("TH\u00D4NG TIN S\u1EA2N PH\u1EA8M");
    lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
    lblNewLabel_1.setBounds(219, 11, 216, 24);
    pnTT_SanPham.add(lblNewLabel_1);

    JPanel pnTT_NhanVien = new JPanel();
    pnTT_NhanVien.setBackground(new Color(100, 149, 237));
    CardThongTin.add(pnTT_NhanVien, "name_830757335461200");
    pnTT_NhanVien.setLayout(null);

    tableNhanVien = new JTable();
    tableNhanVien.setBounds(10, 280, 647, 203);
    pnTT_NhanVien.add(tableNhanVien);

    JScrollPane scrollPaneNhanVien = new JScrollPane();
    scrollPaneNhanVien.setBounds(10, 280, 647, 260);
    pnTT_NhanVien.add(scrollPaneNhanVien);
    scrollPaneNhanVien.setViewportView(tableNhanVien);
    Vector headerNV = new Vector<>();
    headerNV.add("Mã NV");
    headerNV.add("Họ");
    headerNV.add("Tên");
    headerNV.add("Ngày vào làm");
    headerNV.add("Vị trí");
    headerNV.add("Lương");
    headerNV.add("Số điện thoại");
    headerNV.add("Email");
    if (modelNV.getRowCount() == 0) {
      modelNV = new DefaultTableModel(headerNV, 0);
      readDataNV();
    }
    tableNhanVien.setModel(modelNV);

    JLabel lblMaNhanVien = new JLabel("M\u00E3 Nh\u00E2n Vi\u00EAn :");
    lblMaNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblMaNhanVien.setBounds(10, 57, 124, 21);
    pnTT_NhanVien.add(lblMaNhanVien);

    JLabel lblHNhnVin = new JLabel("H\u1ECD Nh\u00E2n Vi\u00EAn :");
    lblHNhnVin.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblHNhnVin.setBounds(10, 102, 122, 21);
    pnTT_NhanVien.add(lblHNhnVin);

    JLabel lblTnNhnVin = new JLabel("T\u00EAn Nh\u00E2n Vi\u00EAn :");
    lblTnNhnVin.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblTnNhnVin.setBounds(10, 149, 127, 21);
    pnTT_NhanVien.add(lblTnNhnVin);

    JLabel lblNgyVoLm = new JLabel("Ng\u00E0y v\u00E0o l\u00E0m :");
    lblNgyVoLm.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblNgyVoLm.setBounds(10, 196, 117, 21);
    pnTT_NhanVien.add(lblNgyVoLm);

    JLabel lblVTri = new JLabel("V\u1ECB tr\u00ED :");
    lblVTri.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblVTri.setBounds(370, 56, 51, 21);
    pnTT_NhanVien.add(lblVTri);

    JLabel lblLng = new JLabel("L\u01B0\u01A1ng :");
    lblLng.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblLng.setBounds(370, 101, 62, 21);
    pnTT_NhanVien.add(lblLng);

    JLabel lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i :");
    lblSinThoi.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblSinThoi.setBounds(370, 149, 113, 21);
    pnTT_NhanVien.add(lblSinThoi);

    JLabel lblEmail = new JLabel("Email :");
    lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblEmail.setBounds(370, 196, 55, 21);
    pnTT_NhanVien.add(lblEmail);

    tfMaNhanVien = new JTextField();
    tfMaNhanVien.setBounds(156, 57, 155, 22);
    pnTT_NhanVien.add(tfMaNhanVien);
    tfMaNhanVien.setColumns(10);

    tfHoNhanVien = new JTextField();
    tfHoNhanVien.setColumns(10);
    tfHoNhanVien.setBounds(156, 103, 155, 21);
    pnTT_NhanVien.add(tfHoNhanVien);

    tfTenNhanVien = new JTextField();
    tfTenNhanVien.setColumns(10);
    tfTenNhanVien.setBounds(156, 150, 155, 21);
    pnTT_NhanVien.add(tfTenNhanVien);

    tfSoDienThoai_NV = new JTextField();
    tfSoDienThoai_NV.setColumns(10);
    tfSoDienThoai_NV.setBounds(487, 149, 155, 21);
    pnTT_NhanVien.add(tfSoDienThoai_NV);

    tfLuongNhanVien = new JTextField();
    tfLuongNhanVien.setColumns(10);
    tfLuongNhanVien.setBounds(487, 102, 155, 21);
    pnTT_NhanVien.add(tfLuongNhanVien);

    tfEmail_NV = new JTextField();
    tfEmail_NV.setColumns(10);
    tfEmail_NV.setBounds(487, 196, 155, 21);
    pnTT_NhanVien.add(tfEmail_NV);

    JComboBox cbViTriNhanVien = new JComboBox();
    cbViTriNhanVien.setBounds(487, 57, 155, 22);
    cbViTriNhanVien.setModel(new DefaultComboBoxModel(new String[]{null, "Nhân viên", "Quản lý"}));
    pnTT_NhanVien.add(cbViTriNhanVien);

    JComboBox cbNgaySinh_NV = new JComboBox();
    cbNgaySinh_NV.setBounds(156, 197, 45, 22);
    cbNgaySinh_NV.setModel(new DefaultComboBoxModel(
        new String[]{null, "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
            "13",
            "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
            "28", "29", "30", "31"}));
    pnTT_NhanVien.add(cbNgaySinh_NV);

    JComboBox cbNamSinh_NV = new JComboBox();
    cbNamSinh_NV.setBounds(260, 197, 51, 22);
    cbNamSinh_NV.setModel(new DefaultComboBoxModel(new String[]{null, "2020", "2021", "2022"}));
    pnTT_NhanVien.add(cbNamSinh_NV);

    JComboBox cbThangSinh_NV = new JComboBox();
    cbThangSinh_NV.setBounds(205, 197, 45, 22);
    cbThangSinh_NV.setModel(new DefaultComboBoxModel(
        new String[]{null, "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11",
            "12"}));
    pnTT_NhanVien.add(cbThangSinh_NV);

    JButton btnThemNV = new JButton("TH\u00CAM");
    btnThemNV.setBounds(10, 230, 127, 39);
    btnThemNV.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        NhanVienDTO nhanVienDTO = new NhanVienDTO();
        try {
          nhanVienDTO.setMaNhanVien(tfMaNhanVien.getText());
          nhanVienDTO.setHoNhanVien(tfHoNhanVien.getText());
          nhanVienDTO.setTenNhanVien(tfTenNhanVien.getText());
          String ngayVaoLam =
              cbNamSinh_NV.getSelectedItem() + "-" + cbThangSinh_NV.getSelectedItem() + "-"
                  + cbNgaySinh_NV.getSelectedItem();
          nhanVienDTO.setNgayVaoLam(java.sql.Date.valueOf(ngayVaoLam));
          nhanVienDTO.setViTri(cbViTriNhanVien.getSelectedItem() + "");
          nhanVienDTO.setLuong(Integer.parseInt(tfLuongNhanVien.getText()));
          nhanVienDTO.setEmail(tfEmail_NV.getText());
          nhanVienDTO.setSoDienThoai(tfSoDienThoai_NV.getText());
          nhanVienBUS.them(nhanVienDTO);
        } catch (Exception ex1) {
          if (tfMaNhanVien.getText().equals("")) {
            JOptionPane.showMessageDialog(tfMaNhanVien, "Vui lòng nhập Mã Nhân Viên!!!");
          }
          if (tfHoNhanVien.getText().equals("")) {
            JOptionPane.showMessageDialog(tfHoNhanVien, "Vui lòng nhập Họ nhân viên!!!");
          }
          if (tfTenNhanVien.getText().equals("")) {
            JOptionPane.showMessageDialog(tfTenNhanVien, "Vui lòng nhập Tên Nhân viên!!!");
          }
          if (cbNamSinh_NV.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(cbNamSinh_NV, "Vui lòng nhập Năm vào làm!!!");
          }
          if (cbThangSinh_NV.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(cbThangSinh_NV, "Vui lòng nhập Tháng vào làm!!!");
          }
          if (cbNgaySinh_NV.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(cbNgaySinh_NV, "Vui lòng nhập Ngày vào làm!!!");
          }
          if (cbViTriNhanVien.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(cbViTriNhanVien, "Vui lòng chọn vị trí nhân viên!!");
          }
          if (tfLuongNhanVien.getText().equals("")) {
            JOptionPane.showMessageDialog(tfLuongNhanVien, "Vui lòng nhập lương!!!");
          }
          if (tfSoDienThoai_NV.getText().equals("")) {
            JOptionPane.showMessageDialog(tfSoDienThoai_NV, "Vui lòng nhập số điện thoại!!!");
          }
          if (tfEmail_NV.getText().equals("")) {
            JOptionPane.showMessageDialog(tfEmail_NV, "Vui lòng nhập email!!!");
          }
        }
        readDataNV();
      }
    });
    pnTT_NhanVien.add(btnThemNV);

    JButton btnXoaNhanVien = new JButton("X\u00D3A");
    btnXoaNhanVien.setBounds(182, 230, 127, 39);
    btnXoaNhanVien.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          if (tfMaNhanVien.getText().equals("")) {
            JOptionPane.showMessageDialog(tfMaNhanVien, "Vui lòng nhập mã nhân viên!!!!");
          }
          nhanVienBUS.xoa(tfMaNhanVien.getText());
        } catch (Exception e1) {
          if (tfMaNhanVien.getText().equals("")) {
            JOptionPane.showMessageDialog(tfMaNhanVien, "Vui lòng nhập mã nhân viên!!!!");
          }
        }
        readDataNV();
      }
    });
    pnTT_NhanVien.add(btnXoaNhanVien);

    JButton btnSuaNV = new JButton("S\u1EECA");
    btnSuaNV.setBounds(352, 230, 127, 39);
    btnSuaNV.addActionListener(e -> {
      try {
        if (tfMaNhanVien.getText().equals("")) {
          JOptionPane.showMessageDialog(tfMaNhanVien, "Vui lòng nhập mã nhân viên!!!!");
        }
        NhanVienDTO nhanVienDTO = nhanVienBUS.timKiem(tfMaNhanVien.getText());
        if (!tfHoNhanVien.getText().equals("")) {
          nhanVienDTO.setHoNhanVien(tfHoNhanVien.getText());
        }
        if (!tfTenNhanVien.getText().equals("")) {
          nhanVienDTO.setTenNhanVien(tfTenNhanVien.getText());
        }
        String[] ngayVaoLam = nhanVienDTO.getNgayVaoLam().toString().split("-");
        if (cbNgaySinh_NV.getSelectedItem() != null && cbThangSinh_NV.getSelectedItem() != null
            && cbNamSinh_NV.getSelectedItem() != null) {
          ngayVaoLam[0] = cbNamSinh_NV.getSelectedItem() + "";
          ngayVaoLam[1] = cbThangSinh_NV.getSelectedItem() + "";
          ngayVaoLam[2] = cbNgaySinh_NV.getSelectedItem() + "";
        }
        if (cbNgaySinh_NV.getSelectedItem() != null) {
          ngayVaoLam[2] = cbNgaySinh_NV.getSelectedItem() + "";
        }
        if (cbThangSinh_NV.getSelectedItem() != null) {
          ngayVaoLam[1] = cbThangSinh_NV.getSelectedItem() + "";
        }
        if (cbNamSinh_NV.getSelectedItem() != null) {
          ngayVaoLam[0] = cbNamSinh_NV.getSelectedItem() + "";
        }
        String newNgayVaoLam = String.join("-", ngayVaoLam);
        nhanVienDTO.setNgayVaoLam(java.sql.Date.valueOf(newNgayVaoLam));
        if (cbViTriNhanVien.getSelectedItem() != null) {
          nhanVienDTO.setViTri(cbViTriNhanVien.getSelectedItem() + "");
        }
        if (!tfLuongNhanVien.getText().equals("")) {
          nhanVienDTO.setLuong(Integer.parseInt(tfLuongNhanVien.getText()));
        }
        if (!tfSoDienThoai_NV.getText().equals("")) {
          nhanVienDTO.setSoDienThoai(tfSoDienThoai_NV.getText());
        }
        if (!tfEmail_NV.getText().equals("")) {
          nhanVienDTO.setEmail(tfEmail_NV.getText());
        }
        nhanVienBUS.sua(nhanVienDTO);
      } catch (Exception e1) {
        JOptionPane.showMessageDialog(tfMaNhanVien, "Mã nhân viên không đúng!!!!");
      }
      readDataNV();
    });
    pnTT_NhanVien.add(btnSuaNV);

    JButton btnTimKiem = new JButton("T\u00CCM KI\u1EBEM");
    btnTimKiem.setBounds(516, 230, 127, 39);
    btnTimKiem.addActionListener(e -> {
          try {
            if (!tfMaNhanVien.getText().equals("")) {
              NhanVienDTO nhanVienDTO = nhanVienBUS.timKiem(tfMaNhanVien.getText());
              modelNV.setRowCount(0);
              Vector row = new Vector();
              row.add(nhanVienDTO.getMaNhanVien());
              row.add(nhanVienDTO.getHoNhanVien());
              row.add(nhanVienDTO.getTenNhanVien());
              row.add(nhanVienDTO.getNgayVaoLam());
              row.add(nhanVienDTO.getViTri());
              row.add(nhanVienDTO.getLuong());
              row.add(nhanVienDTO.getSoDienThoai());
              row.add(nhanVienDTO.getEmail());
              modelNV.addRow(row);
              tableNhanVien.setModel(modelNV);
            }
            if (!tfHoNhanVien.getText().equals("")) {
              modelNV.setRowCount(0);
              for (NhanVienDTO nhanVienDTO : nhanVienBUS.findWithLikeCondition("HoNhanVien",
                  "%" + tfHoNhanVien.getText() + "%")) {
                Vector row = new Vector();
                row.add(nhanVienDTO.getMaNhanVien());
                row.add(nhanVienDTO.getHoNhanVien());
                row.add(nhanVienDTO.getTenNhanVien());
                row.add(nhanVienDTO.getNgayVaoLam());
                row.add(nhanVienDTO.getViTri());
                row.add(nhanVienDTO.getLuong());
                row.add(nhanVienDTO.getSoDienThoai());
                row.add(nhanVienDTO.getEmail());
                modelNV.addRow(row);
              }
              tableNhanVien.setModel(modelNV);
            }
            if (!tfTenNhanVien.getText().equals("")) {
              modelNV.setRowCount(0);
              for (NhanVienDTO nhanVienDTO : nhanVienBUS.findWithLikeCondition("TenNhanVien",
                  "%" + tfTenNhanVien.getText() + "%")) {

                Vector row = new Vector();
                row.add(nhanVienDTO.getMaNhanVien());
                row.add(nhanVienDTO.getHoNhanVien());
                row.add(nhanVienDTO.getTenNhanVien());
                row.add(nhanVienDTO.getNgayVaoLam());
                row.add(nhanVienDTO.getViTri());
                row.add(nhanVienDTO.getLuong());
                row.add(nhanVienDTO.getSoDienThoai());
                row.add(nhanVienDTO.getEmail());
                modelNV.addRow(row);
              }
              tableNhanVien.setModel(modelNV);
            }
            if (cbNamSinh_NV.getSelectedItem() != null && cbThangSinh_NV.getSelectedItem() != null
                && cbNgaySinh_NV.getSelectedItem() != null) {
              String ngayVaoLam =
                  cbNamSinh_NV.getSelectedItem() + "-" + cbThangSinh_NV.getSelectedItem() + "-"
                      + cbNgaySinh_NV.getSelectedItem();
              modelNV.setRowCount(0);
              for (NhanVienDTO nhanVienDTO : nhanVienBUS.findWithLikeCondition("NgayVaoLam",
                  ngayVaoLam)) {
                Vector row = new Vector();
                row.add(nhanVienDTO.getMaNhanVien());
                row.add(nhanVienDTO.getHoNhanVien());
                row.add(nhanVienDTO.getTenNhanVien());
                row.add(nhanVienDTO.getNgayVaoLam());
                row.add(nhanVienDTO.getViTri());
                row.add(nhanVienDTO.getLuong());
                row.add(nhanVienDTO.getSoDienThoai());
                row.add(nhanVienDTO.getEmail());
                modelNV.addRow(row);
              }
              tableNhanVien.setModel(modelNV);
            }
            if (cbNamSinh_NV.getSelectedItem() != null) {
              modelNV.setRowCount(0);
              String namVaoLam = cbNamSinh_NV.getSelectedItem() + "%";
              for (NhanVienDTO nhanVienDTO : nhanVienBUS.findWithLikeCondition("NgayVaoLam",
                  namVaoLam)) {
                Vector row = new Vector();
                row.add(nhanVienDTO.getMaNhanVien());
                row.add(nhanVienDTO.getHoNhanVien());
                row.add(nhanVienDTO.getTenNhanVien());
                row.add(nhanVienDTO.getNgayVaoLam());
                row.add(nhanVienDTO.getViTri());
                row.add(nhanVienDTO.getLuong());
                row.add(nhanVienDTO.getSoDienThoai());
                row.add(nhanVienDTO.getEmail());
                modelNV.addRow(row);
              }
              tableNhanVien.setModel(modelNV);
            }
            if (cbThangSinh_NV.getSelectedItem() != null) {
              String thangVaoLam = "%" + cbThangSinh_NV.getSelectedItem() + "%";
              modelNV.setRowCount(0);
              for (NhanVienDTO nhanVienDTO : nhanVienBUS.findWithLikeCondition("NgayVaoLam",
                  thangVaoLam)) {
                if (nhanVienDTO.getNgayVaoLam().getMonth() + 1 == Integer.parseInt(
                    cbThangSinh_NV.getSelectedItem() + "")) {
                  Vector row = new Vector();
                  row.add(nhanVienDTO.getMaNhanVien());
                  row.add(nhanVienDTO.getHoNhanVien());
                  row.add(nhanVienDTO.getTenNhanVien());
                  row.add(nhanVienDTO.getNgayVaoLam());
                  row.add(nhanVienDTO.getViTri());
                  row.add(nhanVienDTO.getLuong());
                  row.add(nhanVienDTO.getSoDienThoai());
                  row.add(nhanVienDTO.getEmail());
                  modelNV.addRow(row);
                }
              }
              tableNhanVien.setModel(modelNV);
            }
            if (cbNgaySinh_NV.getSelectedItem() != null) {
              String ngayVaoLam = "%" + cbNgaySinh_NV.getSelectedItem();
              modelNV.setRowCount(0);
              for (NhanVienDTO nhanVienDTO : nhanVienBUS.findWithLikeCondition("NgayVaoLam",
                  ngayVaoLam)) {
                Vector row = new Vector();
                row.add(nhanVienDTO.getMaNhanVien());
                row.add(nhanVienDTO.getHoNhanVien());
                row.add(nhanVienDTO.getTenNhanVien());
                row.add(nhanVienDTO.getNgayVaoLam());
                row.add(nhanVienDTO.getViTri());
                row.add(nhanVienDTO.getLuong());
                row.add(nhanVienDTO.getSoDienThoai());
                row.add(nhanVienDTO.getEmail());
                modelNV.addRow(row);
              }
              tableNhanVien.setModel(modelNV);
            }
            if (cbViTriNhanVien.getSelectedItem() != null) {
              modelNV.setRowCount(0);
              for (NhanVienDTO nhanVienDTO : nhanVienBUS.findWithLikeCondition("viTri",
                  cbViTriNhanVien.getSelectedItem() + "")) {
                Vector row = new Vector();
                row.add(nhanVienDTO.getMaNhanVien());
                row.add(nhanVienDTO.getHoNhanVien());
                row.add(nhanVienDTO.getTenNhanVien());
                row.add(nhanVienDTO.getNgayVaoLam());
                row.add(nhanVienDTO.getViTri());
                row.add(nhanVienDTO.getLuong());
                row.add(nhanVienDTO.getSoDienThoai());
                row.add(nhanVienDTO.getEmail());
                modelNV.addRow(row);
              }
              tableNhanVien.setModel(modelNV);
            }
            if (!tfLuongNhanVien.getText().equals("")) {
              modelNV.setRowCount(0);
              for (NhanVienDTO nhanVienDTO : nhanVienBUS.findWithLikeCondition("Luong",
                  "%" + tfLuongNhanVien.getText() + "%")) {
                Vector row = new Vector();
                row.add(nhanVienDTO.getMaNhanVien());
                row.add(nhanVienDTO.getHoNhanVien());
                row.add(nhanVienDTO.getTenNhanVien());
                row.add(nhanVienDTO.getNgayVaoLam());
                row.add(nhanVienDTO.getViTri());
                row.add(nhanVienDTO.getLuong());
                row.add(nhanVienDTO.getSoDienThoai());
                row.add(nhanVienDTO.getEmail());
                modelNV.addRow(row);
              }
              tableNhanVien.setModel(modelNV);
            }
            if (!tfSoDienThoai_NV.getText().equals("")) {
              modelNV.setRowCount(0);
              for (NhanVienDTO nhanVienDTO : nhanVienBUS.findWithLikeCondition("SoDienThoai",
                  "%" + tfSoDienThoai_NV.getText() + "%")) {
                Vector row = new Vector();
                row.add(nhanVienDTO.getMaNhanVien());
                row.add(nhanVienDTO.getHoNhanVien());
                row.add(nhanVienDTO.getTenNhanVien());
                row.add(nhanVienDTO.getNgayVaoLam());
                row.add(nhanVienDTO.getViTri());
                row.add(nhanVienDTO.getLuong());
                row.add(nhanVienDTO.getSoDienThoai());
                row.add(nhanVienDTO.getEmail());
                modelNV.addRow(row);
              }
              tableNhanVien.setModel(modelNV);
            }
            if (!tfEmail_NV.getText().equals("")) {
              modelNV.setRowCount(0);
              for (NhanVienDTO nhanVienDTO : nhanVienBUS.findWithLikeCondition("Email",
                  "%" + tfEmail_NV.getText() + "%")) {
                Vector row = new Vector();
                row.add(nhanVienDTO.getMaNhanVien());
                row.add(nhanVienDTO.getHoNhanVien());
                row.add(nhanVienDTO.getTenNhanVien());
                row.add(nhanVienDTO.getNgayVaoLam());
                row.add(nhanVienDTO.getViTri());
                row.add(nhanVienDTO.getLuong());
                row.add(nhanVienDTO.getSoDienThoai());
                row.add(nhanVienDTO.getEmail());
                modelNV.addRow(row);
              }
              tableNhanVien.setModel(modelNV);
            }
          } catch (Exception e1) {
            JOptionPane.showMessageDialog(tfHoNhanVien, "Thao tác không thành công");
          }
        }
    );
    pnTT_NhanVien.add(btnTimKiem);

    JLabel lblNewLabel = new JLabel("TH\u00D4NG TIN NH\u00C2N VI\u00CAN");
    lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
    lblNewLabel.setBounds(229, 11, 224, 24);
    pnTT_NhanVien.add(lblNewLabel);

    JPanel pnTT_TaiKhoan = new JPanel();
    pnTT_TaiKhoan.setBackground(new Color(30, 144, 255));
    CardThongTin.add(pnTT_TaiKhoan, "name_830764199438500");
    pnTT_TaiKhoan.setLayout(null);

    tableTaiKhoan = new JTable();
    tableTaiKhoan.setBounds(10, 252, 647, 231);
    pnTT_TaiKhoan.add(tableTaiKhoan);

    JLabel lblMaTaiKhoan = new JLabel("M\u00E3 T\u00E0i Kho\u1EA3n :");
    lblMaTaiKhoan.setFont(new Font("Times New Roman", Font.BOLD, 19));
    lblMaTaiKhoan.setBounds(10, 70, 130, 22);
    pnTT_TaiKhoan.add(lblMaTaiKhoan);

    JLabel lblTnTiKhon = new JLabel("T\u00EAn T\u00E0i Kho\u1EA3n :");
    lblTnTiKhon.setFont(new Font("Times New Roman", Font.BOLD, 19));
    lblTnTiKhon.setBounds(10, 116, 134, 22);
    pnTT_TaiKhoan.add(lblTnTiKhon);

    JLabel lblMtKhu = new JLabel("M\u1EADt kh\u1EA9u :");
    lblMtKhu.setFont(new Font("Times New Roman", Font.BOLD, 19));
    lblMtKhu.setBounds(10, 163, 130, 22);
    pnTT_TaiKhoan.add(lblMtKhu);

    JLabel lblPhnQuyn = new JLabel("Ph\u00E2n quy\u1EC1n :");
    lblPhnQuyn.setFont(new Font("Times New Roman", Font.BOLD, 19));
    lblPhnQuyn.setBounds(338, 70, 130, 22);
    pnTT_TaiKhoan.add(lblPhnQuyn);

    JLabel lblMNhnVin = new JLabel("M\u00E3 Nh\u00E2n Vi\u00EAn :");
    lblMNhnVin.setFont(new Font("Times New Roman", Font.BOLD, 19));
    lblMNhnVin.setBounds(338, 121, 130, 22);
    pnTT_TaiKhoan.add(lblMNhnVin);

    JLabel lblThngTinTi = new JLabel("TH\u00D4NG TIN T\u00C0I KHO\u1EA2N");
    lblThngTinTi.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
    lblThngTinTi.setBounds(226, 11, 222, 24);
    pnTT_TaiKhoan.add(lblThngTinTi);

    tfMaTaiKhoan = new JTextField();
    tfMaTaiKhoan.setBounds(150, 70, 166, 23);
    pnTT_TaiKhoan.add(tfMaTaiKhoan);
    tfMaTaiKhoan.setColumns(10);

    tfTenTaiKhoan = new JTextField();
    tfTenTaiKhoan.setColumns(10);
    tfTenTaiKhoan.setBounds(150, 119, 166, 23);
    pnTT_TaiKhoan.add(tfTenTaiKhoan);

    tfMatKhauTK = new JTextField();
    tfMatKhauTK.setColumns(10);
    tfMatKhauTK.setBounds(150, 166, 166, 23);
    pnTT_TaiKhoan.add(tfMatKhauTK);

    tfMaNV = new JTextField();
    tfMaNV.setColumns(10);
    tfMaNV.setBounds(478, 119, 166, 23);
    pnTT_TaiKhoan.add(tfMaNV);

    JComboBox cbPhanQuyenTK = new JComboBox();
    cbPhanQuyenTK.setBounds(478, 72, 166, 22);
    pnTT_TaiKhoan.add(cbPhanQuyenTK);

    JButton btnThemTK = new JButton("TH\u00CAM");
    btnThemTK.setBounds(76, 206, 89, 35);
    pnTT_TaiKhoan.add(btnThemTK);

    JButton btnXoaTK = new JButton("X\u00D3A");
    btnXoaTK.setBounds(216, 206, 89, 35);
    pnTT_TaiKhoan.add(btnXoaTK);

    JButton btnSuaTK = new JButton("S\u1EECA");
    btnSuaTK.setBounds(359, 206, 89, 35);
    pnTT_TaiKhoan.add(btnSuaTK);

    JButton btnTimKiemTK = new JButton("T\u00CCM KI\u1EBEM");
    btnTimKiemTK.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    btnTimKiemTK.setBounds(497, 206, 89, 35);
    pnTT_TaiKhoan.add(btnTimKiemTK);

    JPanel pnTT_NhaCungCap = new JPanel();
    pnTT_NhaCungCap.setBackground(new Color(0, 191, 255));
    CardThongTin.add(pnTT_NhaCungCap, "name_830765793286600");
    pnTT_NhaCungCap.setLayout(null);

    tableNhaCungCap = new JTable();
    tableNhaCungCap.setBounds(10, 258, 647, 225);
    pnTT_NhaCungCap.add(tableNhaCungCap);

    JScrollPane scrollPaneTK = new JScrollPane();
    scrollPaneTK.setBounds(5, 260, 647, 260);
    pnTT_TaiKhoan.add(scrollPaneTK);
    scrollPaneTK.setViewportView(tableTaiKhoan);
    Vector headerTK = new Vector<>();
    headerTK.add("Mã TK");
    headerTK.add("Tên TK");
    headerTK.add("Mật khẩu");
    headerTK.add("Phân quyền");
    headerTK.add("Mã nhân viên");
    if (modelTK.getRowCount() == 0) {
      modelTK = new DefaultTableModel(headerTK, 0);
      readDataTK();
    }
    tableTaiKhoan.setModel(modelTK);

    JLabel lblMaNCC = new JLabel("M\u00E3 Nh\u00E0 Cung C\u1EA5p :");
    lblMaNCC.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblMaNCC.setBounds(10, 57, 157, 21);
    pnTT_NhaCungCap.add(lblMaNCC);

    JLabel lblTnNhCung = new JLabel("T\u00EAn Nh\u00E0 Cung C\u1EA5p :");
    lblTnNhCung.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblTnNhCung.setBounds(10, 104, 160, 21);
    pnTT_NhaCungCap.add(lblTnNhCung);

    JLabel lblaCh = new JLabel("\u0110\u1ECBa ch\u1EC9 :");
    lblaCh.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblaCh.setBounds(379, 57, 65, 21);
    pnTT_NhaCungCap.add(lblaCh);

    JLabel lblSinThoi_1 = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i :");
    lblSinThoi_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblSinThoi_1.setBounds(10, 149, 113, 21);
    pnTT_NhaCungCap.add(lblSinThoi_1);

    JLabel lblEmail_1 = new JLabel("Email :");
    lblEmail_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblEmail_1.setBounds(379, 107, 55, 21);
    pnTT_NhaCungCap.add(lblEmail_1);

    tfMaNhaCungCap = new JTextField();
    tfMaNhaCungCap.setBounds(177, 57, 166, 22);
    pnTT_NhaCungCap.add(tfMaNhaCungCap);
    tfMaNhaCungCap.setColumns(10);

    tfTenNhaCungCap = new JTextField();
    tfTenNhaCungCap.setColumns(10);
    tfTenNhaCungCap.setBounds(177, 106, 166, 22);
    pnTT_NhaCungCap.add(tfTenNhaCungCap);

    tfDiaChiNhaCungCap = new JTextField();
    tfDiaChiNhaCungCap.setColumns(10);
    tfDiaChiNhaCungCap.setBounds(454, 58, 187, 22);
    pnTT_NhaCungCap.add(tfDiaChiNhaCungCap);

    tfSoDienThoai_NCC = new JTextField();
    tfSoDienThoai_NCC.setColumns(10);
    tfSoDienThoai_NCC.setBounds(177, 150, 166, 22);
    pnTT_NhaCungCap.add(tfSoDienThoai_NCC);

    tfEmail_NCC = new JTextField();
    tfEmail_NCC.setColumns(10);
    tfEmail_NCC.setBounds(454, 108, 187, 22);
    pnTT_NhaCungCap.add(tfEmail_NCC);

    JLabel lblThngTinNh = new JLabel("TH\u00D4NG TIN NH\u00C0 CUNG C\u1EA4P");
    lblThngTinNh.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
    lblThngTinNh.setBounds(213, 11, 260, 24);
    pnTT_NhaCungCap.add(lblThngTinNh);

    JButton btnThemNCC = new JButton("TH\u00CAM ");
    btnThemNCC.setBounds(20, 200, 113, 49);
    pnTT_NhaCungCap.add(btnThemNCC);

    JButton btnXoaNCC = new JButton("X\u00D3A");
    btnXoaNCC.setBounds(181, 200, 113, 47);
    pnTT_NhaCungCap.add(btnXoaNCC);

    JButton btnSuaNCC = new JButton("S\u1EECA");
    btnSuaNCC.setBounds(350, 202, 113, 47);
    pnTT_NhaCungCap.add(btnSuaNCC);

    JButton btnTimKiemNCC = new JButton("T\u00CCM KI\u1EBEM");
    btnTimKiemNCC.setBounds(520, 200, 113, 49);
    pnTT_NhaCungCap.add(btnTimKiemNCC);

    JPanel pnTT_NhaSanXuat = new JPanel();
    pnTT_NhaSanXuat.setBackground(new Color(224, 255, 255));
    CardThongTin.add(pnTT_NhaSanXuat, "name_830767186557700");
    pnTT_NhaSanXuat.setLayout(null);

    tableNhaSanXuat = new JTable();
    tableNhaSanXuat.setBounds(10, 218, 647, 265);
    pnTT_NhaSanXuat.add(tableNhaSanXuat);

    JLabel lblMaNhaSanXuat = new JLabel("M\u00E3 Nh\u00E0 S\u1EA3n Xu\u1EA5t :");
    lblMaNhaSanXuat.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblMaNhaSanXuat.setBounds(10, 65, 149, 21);
    pnTT_NhaSanXuat.add(lblMaNhaSanXuat);

    JLabel lblTnNhSn = new JLabel("T\u00EAn Nh\u00E0 S\u1EA3n Xu\u1EA5t :");
    lblTnNhSn.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblTnNhSn.setBounds(10, 111, 152, 21);
    pnTT_NhaSanXuat.add(lblTnNhSn);

    JLabel lblaCh_1 = new JLabel("\u0110\u1ECBa ch\u1EC9 :");
    lblaCh_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblaCh_1.setBounds(354, 63, 65, 21);
    pnTT_NhaSanXuat.add(lblaCh_1);

    JLabel lblSinThoi_2 = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i :");
    lblSinThoi_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblSinThoi_2.setBounds(354, 114, 113, 21);
    pnTT_NhaSanXuat.add(lblSinThoi_2);

    tfMaNhaSanXuat = new JTextField();
    tfMaNhaSanXuat.setBounds(169, 65, 164, 22);
    pnTT_NhaSanXuat.add(tfMaNhaSanXuat);
    tfMaNhaSanXuat.setColumns(10);

    tfTenNhaSanXuat = new JTextField();
    tfTenNhaSanXuat.setColumns(10);
    tfTenNhaSanXuat.setBounds(169, 113, 164, 22);
    pnTT_NhaSanXuat.add(tfTenNhaSanXuat);

    tfSoDienThoai_NSX = new JTextField();
    tfSoDienThoai_NSX.setColumns(10);
    tfSoDienThoai_NSX.setBounds(478, 110, 164, 22);
    pnTT_NhaSanXuat.add(tfSoDienThoai_NSX);

    tfDiaChi_NSX = new JTextField();
    tfDiaChi_NSX.setColumns(10);
    tfDiaChi_NSX.setBounds(478, 65, 164, 22);
    pnTT_NhaSanXuat.add(tfDiaChi_NSX);

    JButton btnThemNSX = new JButton("TH\u00CAM");
    btnThemNSX.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    btnThemNSX.setBounds(31, 166, 101, 41);
    pnTT_NhaSanXuat.add(btnThemNSX);

    JButton btnXoaNSX = new JButton("X\u00D3A");
    btnXoaNSX.setBounds(193, 166, 101, 41);
    pnTT_NhaSanXuat.add(btnXoaNSX);

    JButton btnSuaNSX = new JButton("S\u1EECA");
    btnSuaNSX.setBounds(364, 166, 101, 41);
    pnTT_NhaSanXuat.add(btnSuaNSX);

    JButton btnTimKiemNSX = new JButton("T\u00CCM KI\u1EBEM");
    btnTimKiemNSX.setBounds(527, 166, 101, 41);
    pnTT_NhaSanXuat.add(btnTimKiemNSX);

    JLabel lblThngTinNh_1 = new JLabel("TH\u00D4NG TIN NH\u00C0 S\u1EA2N XU\u1EA4T");
    lblThngTinNh_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
    lblThngTinNh_1.setBounds(187, 15, 263, 24);
    pnTT_NhaSanXuat.add(lblThngTinNh_1);

    JPanel pnTT_ThongKe = new JPanel();
    pnTT_ThongKe.setBackground(new Color(0, 255, 255));
    CardThongTin.add(pnTT_ThongKe, "name_830768477387000");
    pnTT_ThongKe.setLayout(null);

    JPanel pnMoDau = new JPanel();
    pnMoDau.setBackground(new Color(255, 105, 180));
    CardThongTin.add(pnMoDau, "name_11636176876500");
    pnMoDau.setLayout(null);

    JLabel lblLogo = new JLabel("");
    lblLogo.setBounds(194, 120, 271, 198);
    lblLogo.setIcon(new ImageIcon("imgButton/logo.png"));
    pnMoDau.add(lblLogo);

    JLabel lblHinhNen = new JLabel("");
    lblHinhNen.setIcon(new ImageIcon("imgButton/hinhnen.png"));
    lblHinhNen.setBounds(-229, 0, 896, 494);
    pnMoDau.add(lblHinhNen);

    JPanel pnTTCT_KhuyenMai = new JPanel();
    pnTTCT_KhuyenMai.setBackground(new Color(255, 160, 122));
    CardThongTin.add(pnTTCT_KhuyenMai, "name_15312920090800");
    pnTTCT_KhuyenMai.setLayout(null);

    tableChuongTrinhKM = new JTable();
    tableChuongTrinhKM.setBounds(10, 223, 647, 260);
    pnTTCT_KhuyenMai.add(tableChuongTrinhKM);

    JLabel lblMaChuongTrinh = new JLabel("M\u00E3 Ch\u01B0\u01A1ng tr\u00ECnh :");
    lblMaChuongTrinh.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblMaChuongTrinh.setBounds(10, 69, 152, 21);
    pnTTCT_KhuyenMai.add(lblMaChuongTrinh);

    JLabel lblTnChngTrnh = new JLabel("T\u00EAn Ch\u01B0\u01A1ng tr\u00ECnh :");
    lblTnChngTrnh.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblTnChngTrnh.setBounds(10, 122, 152, 21);
    pnTTCT_KhuyenMai.add(lblTnChngTrnh);

    JLabel lblNgyB = new JLabel("Ng\u00E0y B\u0110 :");
    lblNgyB.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblNgyB.setBounds(348, 69, 80, 21);
    pnTTCT_KhuyenMai.add(lblNgyB);

    JLabel lblNgyKt = new JLabel("Ng\u00E0y KT :");
    lblNgyKt.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblNgyKt.setBounds(348, 122, 80, 21);
    pnTTCT_KhuyenMai.add(lblNgyKt);

    tfMaCT = new JTextField();
    tfMaCT.setBounds(174, 71, 164, 20);
    pnTTCT_KhuyenMai.add(tfMaCT);
    tfMaCT.setColumns(10);

    tfTenCT = new JTextField();
    tfTenCT.setColumns(10);
    tfTenCT.setBounds(174, 124, 164, 20);
    pnTTCT_KhuyenMai.add(tfTenCT);

    JComboBox cbNgayBD_CTKM = new JComboBox();
    cbNgayBD_CTKM.setBounds(449, 70, 39, 22);
    cbNgayBD_CTKM.setModel(new DefaultComboBoxModel(
        new String[]{null, "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
            "13",
            "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
            "28", "29", "30", "31"}));

    pnTTCT_KhuyenMai.add(cbNgayBD_CTKM);

    JComboBox cbThangBD_CTKM = new JComboBox();
    cbThangBD_CTKM.setBounds(508, 70, 39, 22);
    cbThangBD_CTKM.setModel(new DefaultComboBoxModel(
        new String[]{null, "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11",
            "12"}));
    pnTTCT_KhuyenMai.add(cbThangBD_CTKM);

    JComboBox tfNamBD_CTKM = new JComboBox();
    tfNamBD_CTKM.setBounds(557, 70, 63, 22);
    tfNamBD_CTKM.setModel(new DefaultComboBoxModel(new String[]{null, "2020", "2021", "2022"}));
    pnTTCT_KhuyenMai.add(tfNamBD_CTKM);

    JComboBox cbNgayKT_CTKM = new JComboBox();
    cbNgayKT_CTKM.setBounds(449, 122, 39, 22);
    cbNgayKT_CTKM.setModel(new DefaultComboBoxModel(
        new String[]{null, "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
            "13",
            "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
            "28", "29", "30", "31"}));
    pnTTCT_KhuyenMai.add(cbNgayKT_CTKM);

    JComboBox cbThangKT_CTKM = new JComboBox();
    cbThangKT_CTKM.setBounds(508, 122, 39, 22);
    cbThangKT_CTKM.setModel(new DefaultComboBoxModel(
        new String[]{null, "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11",
            "12"}));
    pnTTCT_KhuyenMai.add(cbThangKT_CTKM);

    JComboBox cbNamKT_CTKM = new JComboBox();
    cbNamKT_CTKM.setBounds(557, 122, 63, 22);
    cbNamKT_CTKM.setModel(new DefaultComboBoxModel(new String[]{null, "2020", "2021", "2022"}));
    pnTTCT_KhuyenMai.add(cbNamKT_CTKM);

    JLabel lblThngTinChng = new JLabel(
        "TH\u00D4NG TIN CH\u01AF\u01A0NG TR\u00CCNH KHUY\u1EBEN M\u00C3I");
    lblThngTinChng.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblThngTinChng.setBounds(145, 11, 376, 21);
    pnTTCT_KhuyenMai.add(lblThngTinChng);

    JButton btnThemCTKM = new JButton("TH\u00CAM");
    btnThemCTKM.setBounds(10, 180, 109, 32);
    btnThemCTKM.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO = new ChuongTrinhKhuyenMaiDTO();
        chuongTrinhKhuyenMaiDTO.setMaChuongTrinh(tfMaCT.getText());
        chuongTrinhKhuyenMaiDTO.setTenKhuyenMai(tfTenCT.getText());
        String ngayBatDau =
            tfNamBD_CTKM.getSelectedObjects()[0] + "-" + cbThangBD_CTKM.getSelectedObjects()[0]
                + "-"
                + cbNgayBD_CTKM.getSelectedObjects()[0];
        chuongTrinhKhuyenMaiDTO.setNgayBatDau(java.sql.Date.valueOf(ngayBatDau));

        String ngayKetThuc =
            cbNamKT_CTKM.getSelectedObjects()[0] + "-" + cbThangKT_CTKM.getSelectedObjects()[0]
                + "-"
                + cbNgayKT_CTKM.getSelectedObjects()[0];
        chuongTrinhKhuyenMaiDTO.setNgayKetThuc(java.sql.Date.valueOf(ngayKetThuc));
        chuongTrinhKhuyenMaiBUS.them(chuongTrinhKhuyenMaiDTO);
        modelCTKM.setRowCount(0);
        tableChuongTrinhKM.setModel(modelCTKM);
      }
    });
    pnTTCT_KhuyenMai.add(btnThemCTKM);

    JButton btnXoaCTKM = new JButton("X\u00D3A");
    btnXoaCTKM.setBounds(145, 180, 109, 32);
    btnXoaCTKM.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String ma = tfMaCT.getText();
        chuongTrinhKhuyenMaiBUS.xoa(ma);
        modelCTKM.setRowCount(0);
        readDataCTKM();
        tableChuongTrinhKM.setModel(modelCTKM);
      }
    });
    pnTTCT_KhuyenMai.add(btnXoaCTKM);

    JButton btnSuaCTKM = new JButton("S\u1EECA");
    btnSuaCTKM.setBounds(280, 180, 109, 32);
    btnSuaCTKM.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (tfMaCT.getText() == null || tfMaCT.getText().equals("")) {
//          JOptionPane.showMessageDialog(null, tfMaCT, "Vui lòng nhập mã!!!");
          JOptionPane.showMessageDialog(tfMaCT, "Vui lòng nhập mã để tìm kiếm!!!!");
        }
        ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO = chuongTrinhKhuyenMaiBUS.timKiem(
            tfMaCT.getText().toUpperCase()); // tránh lỗi quên bật CapsLock

        try {
          if (!tfTenCT.getText().equals("") || tfTenCT.getText() != null) {
            chuongTrinhKhuyenMaiDTO.setTenKhuyenMai(tfTenCT.getText());
          }
        } catch (Exception e1) {
          System.out.println("Lỗi ở btnSuaCTKM: " + e1.getMessage());
        }

        try {
          if (tfNamBD_CTKM.getSelectedItem() != null
              && cbThangBD_CTKM.getSelectedItem() != null
              && cbNgayBD_CTKM.getSelectedItem() != null) {
            String ngayBatDau =
                tfNamBD_CTKM.getSelectedObjects()[0] + "-" + cbThangBD_CTKM.getSelectedObjects()[0]
                    + "-"
                    + cbNgayBD_CTKM.getSelectedObjects()[0];
            chuongTrinhKhuyenMaiDTO.setNgayBatDau(java.sql.Date.valueOf(ngayBatDau));
          }
          if (tfNamBD_CTKM.getSelectedItem() != null) {
            String namBatDau = tfNamBD_CTKM.getSelectedObjects()[0] + "";
            String[] ngayBatDau = chuongTrinhKhuyenMaiDTO.getNgayBatDau().toString().split("-");
            ngayBatDau[0] = namBatDau;
            String newNgayBatDau = String.join("-", ngayBatDau);
            chuongTrinhKhuyenMaiDTO.setNgayBatDau(java.sql.Date.valueOf(newNgayBatDau));
          }
          if (cbThangBD_CTKM.getSelectedItem() != null) {
            String thangBatDau = cbThangBD_CTKM.getSelectedItem() + "";
            String[] ngayBatDau = chuongTrinhKhuyenMaiDTO.getNgayBatDau().toString().split("-");
            ngayBatDau[1] = thangBatDau;
            String newNgayBatDau = String.join("-", ngayBatDau);
            chuongTrinhKhuyenMaiDTO.setNgayBatDau(java.sql.Date.valueOf(newNgayBatDau));
          }
          if (cbNgayBD_CTKM.getSelectedItem() != null) {
            String ngayBD = cbNgayBD_CTKM.getSelectedItem() + "";
            String[] ngayBatDau = chuongTrinhKhuyenMaiDTO.getNgayBatDau().toString().split("-");
            ngayBatDau[2] = ngayBD;
            String newNgayBatDau = String.join("-", ngayBatDau);
            chuongTrinhKhuyenMaiDTO.setNgayBatDau(java.sql.Date.valueOf(newNgayBatDau));
          }
          if (cbNamKT_CTKM.getSelectedItem() != null
              && cbThangKT_CTKM.getSelectedItem() != null
              && cbNgayKT_CTKM.getSelectedItem() != null) {
            String ngayKetThuc =
                cbNamKT_CTKM.getSelectedItem() + "-" + cbThangKT_CTKM.getSelectedItem()
                    + "-"
                    + cbNgayKT_CTKM.getSelectedItem();
            chuongTrinhKhuyenMaiDTO.setNgayKetThuc(java.sql.Date.valueOf(ngayKetThuc));
          }
          if (cbNamKT_CTKM.getSelectedItem() != null) {
            String namKetThuc = cbNamKT_CTKM.getSelectedItem() + "";
            String[] ngayKetThuc = chuongTrinhKhuyenMaiDTO.getNgayKetThuc().toString().split("-");
            ngayKetThuc[0] = namKetThuc;
            String newNgayKetThuc = String.join("-", ngayKetThuc);
            chuongTrinhKhuyenMaiDTO.setNgayKetThuc(java.sql.Date.valueOf(newNgayKetThuc));
          }
          if (cbThangKT_CTKM.getSelectedItem() != null) {
            String thangKetThuc = cbThangKT_CTKM.getSelectedItem() + "";
            String[] ngayKetThuc = chuongTrinhKhuyenMaiDTO.getNgayKetThuc().toString().split("-");
            ngayKetThuc[1] = thangKetThuc;
            String newNgayKetThuc = String.join("-", ngayKetThuc);
            chuongTrinhKhuyenMaiDTO.setNgayKetThuc(java.sql.Date.valueOf(newNgayKetThuc));
          }
          if (cbNgayKT_CTKM.getSelectedItem() != null) {
            String ngayKT = cbNgayKT_CTKM.getSelectedItem() + "";
            String[] ngayKetThuc = chuongTrinhKhuyenMaiDTO.getNgayKetThuc().toString().split("-");
            ngayKetThuc[2] = ngayKT;
            String newNgayKetThuc = String.join("-", ngayKetThuc);
            chuongTrinhKhuyenMaiDTO.setNgayKetThuc(java.sql.Date.valueOf(newNgayKetThuc));
          }
        } catch (Exception e1) {
          System.out.println("Lỗi ở sửa NGÀY THÁNG NĂM KẾT THÚC btnTimKiem: " + e1.getMessage());
        }
        chuongTrinhKhuyenMaiBUS.sua(chuongTrinhKhuyenMaiDTO);
        modelCTKM.setRowCount(0);
        readDataCTKM();
        tableChuongTrinhKM.setModel(modelCTKM);
      }
    });
    pnTTCT_KhuyenMai.add(btnSuaCTKM);

    JButton btnTimKiemCTKM = new JButton("T\u00CCM KI\u1EBEM");
    btnTimKiemCTKM.setBounds(420, 180, 109, 32);
    btnTimKiemCTKM.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String ma = tfMaCT.getText();
        try {
          //if (tfMaCT.getText().equals("") || tfMaCT.getText() != null || tfMaCT.getText().length() == 0) {
          if (!ma.equals("")) {
            ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO = chuongTrinhKhuyenMaiBUS.timKiem(ma);
            tfTenCT.setText(chuongTrinhKhuyenMaiDTO.getTenKhuyenMai());
            String[] ngayBatDau = chuongTrinhKhuyenMaiDTO.getNgayBatDau().toString().split("-");
            cbNgayBD_CTKM.setSelectedItem(ngayBatDau[2]);
            cbThangBD_CTKM.setSelectedItem(ngayBatDau[1]);
            tfNamBD_CTKM.setSelectedItem(
                ngayBatDau[0]);  //do  lưu  theo dạng  YYYY/mm/DD nên query ngược lại
            String[] ngayKetThuc = chuongTrinhKhuyenMaiDTO.getNgayKetThuc().toString().split("-");
            cbNgayKT_CTKM.setSelectedItem(ngayKetThuc[2]);
            cbThangKT_CTKM.setSelectedItem(ngayKetThuc[1]);
            cbNamKT_CTKM.setSelectedItem(ngayKetThuc[0]);
            modelCTKM.setRowCount(0);
            for (ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO1 : chuongTrinhKhuyenMaiBUS.findAllByCondition(
                "MaChuongTrinh", tfMaCT.getText())) {
              Vector row = new Vector();
              row.add(chuongTrinhKhuyenMaiDTO1.getMaChuongTrinh());
              row.add(chuongTrinhKhuyenMaiDTO1.getTenKhuyenMai());
              row.add(chuongTrinhKhuyenMaiDTO1.getNgayBatDau());
              row.add(chuongTrinhKhuyenMaiDTO1.getNgayKetThuc());
              modelCTKM.addRow(row);
            }
            tableChuongTrinhKM.setModel(modelCTKM);
          }
        } catch (Exception ex) {
          System.out.println("Loi tim theo ma: " + ex.getMessage());
        }

        try {
          String[] fields = {"NgayBatDau", "NgayKetThuc"};
          String ngayBatDau =
              tfNamBD_CTKM.getSelectedItem() + "-" + cbThangBD_CTKM.getSelectedItem()
                  + "-"
                  + cbNgayBD_CTKM.getSelectedItem();
          String ngayKetThuc =
              cbNamKT_CTKM.getSelectedItem() + "-" + cbThangKT_CTKM.getSelectedItem()
                  + "-"
                  + cbNgayKT_CTKM.getSelectedItem();

          if (tfNamBD_CTKM.getSelectedItem() != null
              && cbThangBD_CTKM.getSelectedItem() != null
              && cbNgayBD_CTKM.getSelectedItem() != null) {
            modelCTKM.setRowCount(0);
            for (ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO1 : chuongTrinhKhuyenMaiBUS.findAllByCondition(
                fields[0], ngayBatDau)) {
              Vector row = new Vector();
              row.add(chuongTrinhKhuyenMaiDTO1.getMaChuongTrinh());
              row.add(chuongTrinhKhuyenMaiDTO1.getTenKhuyenMai());
              row.add(chuongTrinhKhuyenMaiDTO1.getNgayBatDau());
              row.add(chuongTrinhKhuyenMaiDTO1.getNgayKetThuc());
              modelCTKM.addRow(row);
            }
          }
          if (tfNamBD_CTKM.getSelectedItem() != null) {
            String namBatDau = tfNamBD_CTKM.getSelectedItem() + "%";
            List<ChuongTrinhKhuyenMaiDTO> results = chuongTrinhKhuyenMaiBUS.findByDateWithLike(
                fields[0], namBatDau);
            modelCTKM.setRowCount(0);
            for (ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO : results) {
              Vector row = new Vector();
              row.add(chuongTrinhKhuyenMaiDTO.getMaChuongTrinh());
              row.add(chuongTrinhKhuyenMaiDTO.getTenKhuyenMai());
              row.add(chuongTrinhKhuyenMaiDTO.getNgayBatDau());
              row.add(chuongTrinhKhuyenMaiDTO.getNgayKetThuc());
              modelCTKM.addRow(row);
            }
          }
          if (cbThangBD_CTKM.getSelectedItem() != null) {
            String thangBatDau = "%" + cbThangBD_CTKM.getSelectedItem() + "%";
            List<ChuongTrinhKhuyenMaiDTO> results = chuongTrinhKhuyenMaiBUS.findByDateWithLike(
                fields[0], thangBatDau);
            modelCTKM.setRowCount(0);
            for (ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO : results) {
              if (chuongTrinhKhuyenMaiDTO.getNgayBatDau().getMonth() + 1 == Integer.parseInt(
                  cbThangBD_CTKM.getSelectedItem() + "")) {
                Vector row = new Vector();
                row.add(chuongTrinhKhuyenMaiDTO.getMaChuongTrinh());
                row.add(chuongTrinhKhuyenMaiDTO.getTenKhuyenMai());
                row.add(chuongTrinhKhuyenMaiDTO.getNgayBatDau());
                row.add(chuongTrinhKhuyenMaiDTO.getNgayKetThuc());
                modelCTKM.addRow(row);
              }
            }
          }
          if (cbNgayBD_CTKM.getSelectedItem() != null) {
            String ngayBD = "%" + cbNgayBD_CTKM.getSelectedItem();
            List<ChuongTrinhKhuyenMaiDTO> results = chuongTrinhKhuyenMaiBUS.findByDateWithLike(
                fields[0], ngayBD);
            modelCTKM.setRowCount(0);
            for (ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO : results) {
              Vector row = new Vector();
              row.add(chuongTrinhKhuyenMaiDTO.getMaChuongTrinh());
              row.add(chuongTrinhKhuyenMaiDTO.getTenKhuyenMai());
              row.add(chuongTrinhKhuyenMaiDTO.getNgayBatDau());
              row.add(chuongTrinhKhuyenMaiDTO.getNgayKetThuc());
              modelCTKM.addRow(row);
            }
          }

          //NgayKetThuc
          if (cbNamKT_CTKM.getSelectedItem() != null
              && cbThangKT_CTKM.getSelectedItem() != null
              && cbNgayKT_CTKM.getSelectedItem() != null) {
            modelCTKM.setRowCount(0);
            for (ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO1 : chuongTrinhKhuyenMaiBUS.findAllByCondition(
                fields[1], ngayKetThuc)) {
              Vector row = new Vector();
              row.add(chuongTrinhKhuyenMaiDTO1.getMaChuongTrinh());
              row.add(chuongTrinhKhuyenMaiDTO1.getTenKhuyenMai());
              row.add(chuongTrinhKhuyenMaiDTO1.getNgayBatDau());
              row.add(chuongTrinhKhuyenMaiDTO1.getNgayKetThuc());
              modelCTKM.addRow(row);
            }
          }
          if (cbNamKT_CTKM.getSelectedItem() != null) {
            String namKetThuc = cbNamKT_CTKM.getSelectedItem() + "%";
            List<ChuongTrinhKhuyenMaiDTO> results = chuongTrinhKhuyenMaiBUS.findByDateWithLike(
                fields[1], namKetThuc);
            modelCTKM.setRowCount(0);
            for (ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO : results) {
              Vector row = new Vector();
              row.add(chuongTrinhKhuyenMaiDTO.getMaChuongTrinh());
              row.add(chuongTrinhKhuyenMaiDTO.getTenKhuyenMai());
              row.add(chuongTrinhKhuyenMaiDTO.getNgayBatDau());
              row.add(chuongTrinhKhuyenMaiDTO.getNgayKetThuc());
              modelCTKM.addRow(row);
            }
          }
          if (cbThangKT_CTKM.getSelectedItem() != null) {
            String thangKetThuc = "%" + cbThangKT_CTKM.getSelectedItem() + "%";
            List<ChuongTrinhKhuyenMaiDTO> results = chuongTrinhKhuyenMaiBUS.findByDateWithLike(
                fields[1], thangKetThuc);
            modelCTKM.setRowCount(0);
            for (ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO : results) {
              if (chuongTrinhKhuyenMaiDTO.getNgayKetThuc().getMonth() + 1 == Integer.parseInt(
                  cbThangKT_CTKM.getSelectedItem()
                      + "")) { //do dùng theo kiểu %data% nên phải lọc thêm để trả ra đúng data
                Vector row = new Vector();
                row.add(chuongTrinhKhuyenMaiDTO.getMaChuongTrinh());
                row.add(chuongTrinhKhuyenMaiDTO.getTenKhuyenMai());
                row.add(chuongTrinhKhuyenMaiDTO.getNgayBatDau());
                row.add(chuongTrinhKhuyenMaiDTO.getNgayKetThuc());
                modelCTKM.addRow(row);
              }
            }
          }
          if (cbNgayKT_CTKM.getSelectedItem() != null) {
            String ngayKT = "%" + cbNgayKT_CTKM.getSelectedItem();
            List<ChuongTrinhKhuyenMaiDTO> results = chuongTrinhKhuyenMaiBUS.findByDateWithLike(
                fields[1], ngayKT);
            modelCTKM.setRowCount(0);
            for (ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO : results) {
              Vector row = new Vector();
              row.add(chuongTrinhKhuyenMaiDTO.getMaChuongTrinh());
              row.add(chuongTrinhKhuyenMaiDTO.getTenKhuyenMai());
              row.add(chuongTrinhKhuyenMaiDTO.getNgayBatDau());
              row.add(chuongTrinhKhuyenMaiDTO.getNgayKetThuc());
              modelCTKM.addRow(row);
            }
          }

        } catch (Exception ex1) {
          System.out.println("Lỗi ở tìm theo năm: " + ex1.getMessage());
        }

        tableChuongTrinhKM.setModel(modelCTKM);
      }

    });
    pnTTCT_KhuyenMai.add(btnTimKiemCTKM);

    JButton btnCT_CTKM = new JButton("CHI TI\u1EBET");

    JScrollPane scrollPaneCTKM = new JScrollPane();
    scrollPaneCTKM.setBounds(10, 223, 647, 260);
    pnTTCT_KhuyenMai.add(scrollPaneCTKM);
    scrollPaneCTKM.setViewportView(tableChuongTrinhKM);
    Vector headerCTKM = new Vector<>();
    headerCTKM.add("Mã CT");
    headerCTKM.add("Tên CT");
    headerCTKM.add("Ngày BD");
    headerCTKM.add("Ngày KT");
    if (modelCTKM.getRowCount() == 0) {
      modelCTKM = new DefaultTableModel(headerCTKM, 0);
      readDataCTKM();
    }
    tableChuongTrinhKM.setModel(modelCTKM);

    btnCT_CTKM.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        FormChiTiet_CTKM ctkm = new FormChiTiet_CTKM();
        ctkm.setVisible(true);
      }
    });
    btnCT_CTKM.setBounds(548, 180, 109, 32);
    pnTTCT_KhuyenMai.add(btnCT_CTKM);

    //code logic
    //invisible all panel ThongTin
    pnTT_SanPham.setVisible(false);
    pnTT_NhanVien.setVisible(false);
    pnTT_TaiKhoan.setVisible(false);
    pnTT_NhaCungCap.setVisible(false);
    pnTT_NhaSanXuat.setVisible(false);
    pnTT_ThongKe.setVisible(false);
    pnMoDau.setVisible(true);

    btnSanPham.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        pnTT_SanPham.setVisible(true);
        pnTT_NhanVien.setVisible(false);
        pnTT_TaiKhoan.setVisible(false);
        pnTT_NhaCungCap.setVisible(false);
        pnTT_NhaSanXuat.setVisible(false);
        pnTT_ThongKe.setVisible(false);
        pnTTCT_KhuyenMai.setVisible(false);
      }
    });
    btnNhanVien.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        pnTT_SanPham.setVisible(false);
        pnTT_NhanVien.setVisible(true);
        pnTT_TaiKhoan.setVisible(false);
        pnTT_NhaCungCap.setVisible(false);
        pnTT_NhaSanXuat.setVisible(false);
        pnTT_ThongKe.setVisible(false);
        pnTTCT_KhuyenMai.setVisible(false);
      }
    });
    btnTaiKhoan.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        pnTT_SanPham.setVisible(false);
        pnTT_NhanVien.setVisible(false);
        pnTT_TaiKhoan.setVisible(true);
        pnTT_NhaCungCap.setVisible(false);
        pnTT_NhaSanXuat.setVisible(false);
        pnTT_ThongKe.setVisible(false);
        pnTTCT_KhuyenMai.setVisible(false);
      }
    });
    btnNhaCungCap.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        pnTT_SanPham.setVisible(false);
        pnTT_NhanVien.setVisible(false);
        pnTT_TaiKhoan.setVisible(false);
        pnTT_NhaCungCap.setVisible(true);
        pnTT_NhaSanXuat.setVisible(false);
        pnTT_ThongKe.setVisible(false);
        pnTTCT_KhuyenMai.setVisible(false);
      }
    });
    btnNhaSanXuat.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        pnTT_SanPham.setVisible(false);
        pnTT_NhanVien.setVisible(false);
        pnTT_TaiKhoan.setVisible(false);
        pnTT_NhaCungCap.setVisible(false);
        pnTT_NhaSanXuat.setVisible(true);
        pnTT_ThongKe.setVisible(false);
        pnTTCT_KhuyenMai.setVisible(false);
      }
    });
    btnThongKe.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        pnTT_SanPham.setVisible(false);
        pnTT_NhanVien.setVisible(false);
        pnTT_TaiKhoan.setVisible(false);
        pnTT_NhaCungCap.setVisible(false);
        pnTT_NhaSanXuat.setVisible(false);
        pnTT_ThongKe.setVisible(true);
        pnTTCT_KhuyenMai.setVisible(false);
      }
    });
    btnCT_KhuyenMai.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        pnTT_SanPham.setVisible(false);
        pnTT_NhanVien.setVisible(false);
        pnTT_TaiKhoan.setVisible(false);
        pnTT_NhaCungCap.setVisible(false);
        pnTT_NhaSanXuat.setVisible(false);
        pnTT_ThongKe.setVisible(false);
        pnTTCT_KhuyenMai.setVisible(true);
        pnMoDau.setVisible(false);
      }
    });

    this.setVisible(true);
  }

  public void readDataCTKM() {
    modelCTKM.setRowCount(0);
    for (ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO1 : chuongTrinhKhuyenMaiBUS.findAll()) {
      Vector row = new Vector();
      row.add(chuongTrinhKhuyenMaiDTO1.getMaChuongTrinh());
      row.add(chuongTrinhKhuyenMaiDTO1.getTenKhuyenMai());
      row.add(chuongTrinhKhuyenMaiDTO1.getNgayBatDau());
      row.add(chuongTrinhKhuyenMaiDTO1.getNgayKetThuc());
      modelCTKM.addRow(row);
    }
    tableChuongTrinhKM.setModel(modelCTKM);
  }

  public void readDataSP() {
    modelSP.setRowCount(0);
    for (SanPhamDTO sanPhamDTO : sanPhamBUS.findAll()) {
      Vector row = new Vector();
      row.add(sanPhamDTO.getMaSanPham());
      row.add(sanPhamDTO.getTenSanPham());
      row.add(sanPhamDTO.getDonGia());
      row.add(sanPhamDTO.getDonViTinh());
      row.add(sanPhamDTO.getSoLuong());
      row.add(sanPhamDTO.getMaLoai());
      row.add(sanPhamDTO.getMaNhaSanXuat());
      modelSP.addRow(row);
    }
    tableSanPham.setModel(modelSP);
  }

  public void readDataTK() {
    modelTK.setRowCount(0);
    for (TaiKhoanDTO taiKhoanDTO : taiKhoanBUS.findAll()) {
      Vector row = new Vector();
      row.add(taiKhoanDTO.getMaTaiKhoan());
      row.add(taiKhoanDTO.getTenTaiKhoan());
      row.add(taiKhoanDTO.getMatKhau());
      row.add(taiKhoanDTO.getPhanQuyen());
      row.add(taiKhoanDTO.getMaNhanVien());
      modelTK.addRow(row);
    }
    tableTaiKhoan.setModel(modelTK);
  }

  public void readDataNV() {
    modelNV.setRowCount(0);
    for (NhanVienDTO nhanVienDTO : nhanVienBUS.findAll()) {
      Vector row = new Vector();
      row.add(nhanVienDTO.getMaNhanVien());
      row.add(nhanVienDTO.getHoNhanVien());
      row.add(nhanVienDTO.getTenNhanVien());
      row.add(nhanVienDTO.getNgayVaoLam());
      row.add(nhanVienDTO.getViTri());
      row.add(nhanVienDTO.getLuong());
      row.add(nhanVienDTO.getSoDienThoai());
      row.add(nhanVienDTO.getEmail());
      modelNV.addRow(row);
    }
    tableNhanVien.setModel(modelNV);
  }
}
