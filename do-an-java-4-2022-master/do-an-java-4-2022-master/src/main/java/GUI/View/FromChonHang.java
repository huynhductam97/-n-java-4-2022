package GUI.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.security.auth.login.FailedLoginException;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.border.CompoundBorder;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class FromChonHang extends JFrame {

	private JPanel contentPane;
	private JPanel pnHoaMyPham,pnBanhKeo,pnDoAnNhanh,pnKem_NGK,pnThucPhamKho;
	private JTable tableThucPhamKho;
	private JTextField tfTK_ThucPhamKho;
	private JTable table;
	private JTextField tfTongTien;
	private JTable table_1;
	private JTextField tfMaKH_HD;
	private JTextField tfMaNV_HD;
	private JTextField tfMaHD_HD;
	private JTextField tfTongTienHD;
	private final JLabel lblMaKH = new JLabel("MÃ KHÁCH HÀNG :");
	private JTextField tfTenKH;
	private JTextField tfHoKH;
	private JTextField tfMaKH;
	private JTextField tfSoDienThoaiKH;
	private JTable table_KhachHang;
	static ArrayList<String> maNV_hienhanh = FormDangNhap.maNV_dangdung;
	DefaultTableModel modelKhachHang = new DefaultTableModel();	
	private JTextField tfCMND;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FromChonHang frame = new FromChonHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void clear() {
		tfMaKH.setText("");
		tfHoKH.setText("");
		tfTenKH.setText("");
		tfSoDienThoaiKH.setText("");
	}
	public FromChonHang() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1080, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setTitle("Chọn hàng");
	
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setName("b\u00E0n h\u00E0ng\r\n");
		tabbedPane.setBounds(0, 0, 1064, 599);
		contentPane.add(tabbedPane);
		
		JPanel pnBanHang = new JPanel();
		pnBanHang.setName("B\u00E1n h\u00E0ng");
		tabbedPane.addTab("Bán hàng", null, pnBanHang, null);
		pnBanHang.setLayout(null);
		
		JPanel pnLoaiSP = new JPanel();
		pnLoaiSP.setBackground(new Color(0, 191, 255));
		pnLoaiSP.setBounds(0, 0, 288, 571);
		pnBanHang.add(pnLoaiSP);
		pnLoaiSP.setLayout(null);
		
		JPanel pnChonMon = new JPanel();
		pnChonMon.setVisible(false);
		pnChonMon.setBackground(new Color(255, 105, 180));
		pnChonMon.setBounds(287, 0, 479, 571);
		pnBanHang.add(pnChonMon, "name_126056180043200");
		pnChonMon.setLayout(null);
		
		JLabel lblLoai = new JLabel("THỰC PHẨM KHÔ");
		lblLoai.setForeground(new Color(0, 0, 0));
		lblLoai.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblLoai.setBounds(10, 5, 252, 45);
		pnChonMon.add(lblLoai);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 459, 349);
		pnChonMon.add(scrollPane);
		
		tableThucPhamKho = new JTable();
		scrollPane.setViewportView(tableThucPhamKho);
		
		tfTK_ThucPhamKho = new JTextField();
		tfTK_ThucPhamKho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfTK_ThucPhamKho.setText("");
			}
		});
		tfTK_ThucPhamKho.setText("Tìm kiếm sản phẩm ...");
		tfTK_ThucPhamKho.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		tfTK_ThucPhamKho.setBounds(283, 12, 186, 38);
		pnChonMon.add(tfTK_ThucPhamKho);
		tfTK_ThucPhamKho.setColumns(10);
		
		JButton btnThem = new JButton("");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThem.setBounds(24, 437, 70, 66);
		btnThem.setIcon(new ImageIcon("imgButton/+.png"));
		pnChonMon.add(btnThem);
		
		JButton btnGiam = new JButton("");
		btnGiam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGiam.setBounds(157, 437, 70, 66);
		btnGiam.setIcon(new ImageIcon("imgButton/-.png"));
		pnChonMon.add(btnGiam);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(250, 421, 208, 139);
		pnChonMon.add(scrollPane_5);
		
		JTextArea txtArea_ThongTin = new JTextArea();
		txtArea_ThongTin.setEditable(false);
		txtArea_ThongTin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		scrollPane_5.setViewportView(txtArea_ThongTin);
		
		JLabel lblNewLabel_1 = new JLabel("0");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(104, 451, 43, 37);
		pnChonMon.add(lblNewLabel_1);
		
		
		
		JPanel pnGioHang = new JPanel();
		pnGioHang.setBackground(new Color(30, 144, 255));
		pnGioHang.setBounds(764, 0, 295, 571);
		pnBanHang.add(pnGioHang);
		pnGioHang.setLayout(null);
		
		JButton btnNewButton = new JButton("THÊM VÀO GIỎ");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(24, 514, 203, 46);
		btnNewButton.setIcon(new ImageIcon("imgButton/thanhtoan.png"));
		pnChonMon.add(btnNewButton);
		
		
		JLabel lblLogoBanHang = new JLabel();
		lblLogoBanHang.setBounds(440, 165, 271, 253);
		pnBanHang.add(lblLogoBanHang);
		lblLogoBanHang.setIcon(new ImageIcon("imgButton/logo.png"));
		
		JLabel lblHinhNen = new JLabel("");
		lblHinhNen.setBounds(0, 0, 1059, 571);
		lblHinhNen.setIcon(new ImageIcon("imgButton/hinhnen.png"));
		pnBanHang.add(lblHinhNen);
		
		JLabel lblGiHng = new JLabel("GIỎ HÀNG");
		lblGiHng.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblGiHng.setBounds(97, 11, 98, 24);
		pnGioHang.add(lblGiHng);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(10, 63, 275, 319);
		pnGioHang.add(scrollPane_6);
		
		table = new JTable();
		scrollPane_6.setViewportView(table);
		
	
		
		JButton btnThem_1 = new JButton("");
		btnThem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThem_1.setBounds(10, 442, 90, 57);
		btnThem_1.setIcon(new ImageIcon("imgButton/+.png"));
		pnGioHang.add(btnThem_1);
		
		JButton btnGiam_1 = new JButton("");
		btnGiam_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGiam_1.setBounds(195, 442, 90, 57);
		btnGiam_1.setIcon(new ImageIcon("imgButton/-.png"));
		pnGioHang.add(btnGiam_1);
		
		JLabel lblNewLabel = new JLabel("TỔNG TIỀN :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(20, 393, 114, 24);
		pnGioHang.add(lblNewLabel);
		
		tfTongTien = new JTextField();
		tfTongTien.setEditable(false);
		tfTongTien.setFont(new Font("Times New Roman", Font.BOLD, 15));
		tfTongTien.setBounds(144, 393, 141, 25);
		pnGioHang.add(tfTongTien);
		tfTongTien.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("0");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(120, 450, 58, 37);
		pnGioHang.add(lblNewLabel_1_1);
		
		JPanel pnHoaDon = new JPanel();
		tabbedPane.addTab("Hóa đơn", null, pnHoaDon, null);
		pnHoaDon.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 105, 180));
		panel.setBounds(0, 0, 1059, 571);
		pnHoaDon.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 304, 1039, 256);
		panel.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JPanel pnDienThongTin = new JPanel();
		pnDienThongTin.setBackground(new Color(175, 238, 238));
		pnDienThongTin.setBounds(10, 11, 496, 288);
		panel.add(pnDienThongTin);
		pnDienThongTin.setLayout(null);
		
		JLabel lblTongTien = new JLabel("TỔNG TIỀN :");
		lblTongTien.setBounds(10, 253, 123, 24);
		pnDienThongTin.add(lblTongTien);
		lblTongTien.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblNgayLap = new JLabel("NGÀY LẬP :");
		lblNgayLap.setBounds(10, 198, 113, 24);
		pnDienThongTin.add(lblNgayLap);
		lblNgayLap.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblMaKhachHang = new JLabel("MÃ KHÁCH HÀNG :");
		lblMaKhachHang.setBounds(10, 148, 185, 24);
		pnDienThongTin.add(lblMaKhachHang);
		lblMaKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblMaNhanVien = new JLabel("MÃ NHÂN VIÊN :");
		lblMaNhanVien.setBounds(10, 101, 159, 24);
		pnDienThongTin.add(lblMaNhanVien);
		lblMaNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblMaHoaDon = new JLabel("MÃ HÓA ĐƠN :");
		lblMaHoaDon.setBounds(10, 54, 143, 24);
		pnDienThongTin.add(lblMaHoaDon);
		lblMaHoaDon.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		tfMaHD_HD = new JTextField();
		tfMaHD_HD.setBounds(206, 54, 271, 32);
		pnDienThongTin.add(tfMaHD_HD);
		tfMaHD_HD.setColumns(10);
		
		tfMaNV_HD = new JTextField();
		tfMaNV_HD.setBounds(206, 97, 271, 34);
		pnDienThongTin.add(tfMaNV_HD);
		tfMaNV_HD.setColumns(10);
		
		tfMaKH_HD = new JTextField();
		tfMaKH_HD.setBounds(206, 142, 185, 36);
		pnDienThongTin.add(tfMaKH_HD);
		tfMaKH_HD.setColumns(10);
		
		tfTongTienHD = new JTextField();
		tfTongTienHD.setBounds(206, 245, 271, 32);
		pnDienThongTin.add(tfTongTienHD);
		tfTongTienHD.setColumns(10);
		
		JLabel lblDienThongTin = new JLabel("ĐIỀN THÔNG TIN HÓA ĐƠN");
		lblDienThongTin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblDienThongTin.setBounds(123, 11, 265, 24);
		pnDienThongTin.add(lblDienThongTin);
		
		JComboBox cbNgayLapHD = new JComboBox();
		cbNgayLapHD.setBounds(205, 198, 59, 25);
		pnDienThongTin.add(cbNgayLapHD);
		
		JComboBox cbThangLapHD = new JComboBox();
		cbThangLapHD.setBounds(300, 200, 59, 25);
		pnDienThongTin.add(cbThangLapHD);
		
		JComboBox cbNamLapHD = new JComboBox();
		cbNamLapHD.setBounds(398, 200, 79, 25);
		pnDienThongTin.add(cbNamLapHD);
		
		JButton btnCheck_KH = new JButton("CHECK");
		btnCheck_KH.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnCheck_KH.setBounds(398, 142, 79, 36);
		pnDienThongTin.add(btnCheck_KH);
		
		JPanel pnButton_ChucNang = new JPanel();
		pnButton_ChucNang.setBackground(new Color(175, 238, 238));
		pnButton_ChucNang.setBounds(728, 11, 321, 288);
		panel.add(pnButton_ChucNang);
		pnButton_ChucNang.setLayout(null);
		
		JButton btnThemHD = new JButton("THÊM");
		btnThemHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThemHD.setBounds(27, 11, 126, 81);
		btnThemHD.setIcon(new ImageIcon("imgButton/+.png"));
		pnButton_ChucNang.add(btnThemHD);
		
		JButton btnSuaHD = new JButton("SỬA");
		btnSuaHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSuaHD.setBounds(27, 113, 126, 77);
		btnSuaHD.setIcon(new ImageIcon("imgButton/sua.png"));
		pnButton_ChucNang.add(btnSuaHD);
		
		JButton btnTimKiemHD = new JButton("TÌM");
		btnTimKiemHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimKiemHD.setBounds(182, 113, 121, 77);
		btnTimKiemHD.setIcon(new ImageIcon("imgButton/timkiem.png"));
		pnButton_ChucNang.add(btnTimKiemHD);
		
		JButton btnXoaHD = new JButton("XÓA");
		btnXoaHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoaHD.setBounds(182, 11, 121, 81);
		btnXoaHD.setIcon(new ImageIcon("imgButton/-.png"));
		pnButton_ChucNang.add(btnXoaHD);
		
		JButton btnThoatHD = new JButton("THOÁT");
		btnThoatHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThoatHD.setBounds(27, 206, 276, 62);
		btnThoatHD.setIcon(new ImageIcon("imgButton/thoat.png"));
		pnButton_ChucNang.add(btnThoatHD);
		
		JLabel lblLogoHD = new JLabel("");
		lblLogoHD.setBounds(516, 11, 202, 186);
		lblLogoHD.setIcon(new ImageIcon("imgButton/logo.png"));
		panel.add(lblLogoHD);
		
		JButton btnChiTietHoaDon = new JButton(" CHI TIẾT HÓA ĐƠN");
		btnChiTietHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnChiTietHoaDon.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		btnChiTietHoaDon.setBounds(516, 222, 202, 71);
		btnChiTietHoaDon.setIcon(new ImageIcon("imgButton/chitiet.png"));
		panel.add(btnChiTietHoaDon);
		
		JPanel pnQuanLyKhachHang = new JPanel();
		tabbedPane.addTab("Khách hàng", null, pnQuanLyKhachHang, null);
		pnQuanLyKhachHang.setLayout(null);
		
		JPanel pnDienThongTinKH = new JPanel();
		pnDienThongTinKH.setBackground(new Color(255, 105, 180));
		pnDienThongTinKH.setBounds(0, 0, 555, 571);
		pnQuanLyKhachHang.add(pnDienThongTinKH);
		pnDienThongTinKH.setLayout(null);
		lblMaKH.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblMaKH.setBounds(25, 98, 232, 30);
		pnDienThongTinKH.add(lblMaKH);
		
		JLabel lblTn = new JLabel("HỌ KHÁCH HÀNG :");
		lblTn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblTn.setBounds(25, 169, 227, 30);
		pnDienThongTinKH.add(lblTn);
		
		JLabel lblTnKhchHng = new JLabel("TÊN KHÁCH HÀNG :");
		lblTnKhchHng.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblTnKhchHng.setBounds(25, 235, 241, 30);
		pnDienThongTinKH.add(lblTnKhchHng);
		
		JLabel lblSinThoi = new JLabel("SỐ ĐIỆN THOẠI :");
		lblSinThoi.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblSinThoi.setBounds(25, 364, 203, 30);
		pnDienThongTinKH.add(lblSinThoi);
		
		tfTenKH = new JTextField();
		tfTenKH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfTenKH.setText("");
			}
		});
		tfTenKH.setText("VD : Hoàng");
		tfTenKH.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		tfTenKH.setBounds(276, 233, 257, 38);
		pnDienThongTinKH.add(tfTenKH);
		tfTenKH.setColumns(10);
		
		tfHoKH = new JTextField();
		tfHoKH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfHoKH.setText("");
			}
		});
		tfHoKH.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		tfHoKH.setText("VD: Nguyễn Văn ...");
		tfHoKH.setColumns(10);
		tfHoKH.setBounds(276, 169, 257, 38);
		pnDienThongTinKH.add(tfHoKH);
		
		tfMaKH = new JTextField();
		tfMaKH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfMaKH.setText("");
			}
		});
		tfMaKH.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		tfMaKH.setText("số CMND/CCCD ...");
		tfMaKH.setColumns(10);
		tfMaKH.setBounds(276, 98, 257, 38);
		pnDienThongTinKH.add(tfMaKH);
		
		tfSoDienThoaiKH = new JTextField();
		tfSoDienThoaiKH.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		tfSoDienThoaiKH.setColumns(10);
		tfSoDienThoaiKH.setBounds(276, 362, 257, 38);
		pnDienThongTinKH.add(tfSoDienThoaiKH);
		
		JButton btnSuaKH = new JButton("SỬA");
		btnSuaKH.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSuaKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table_KhachHang.getSelectedRow();
				if(i>=0) {
					//database
					KhachHangBUS bus = new KhachHangBUS();
					String makh = tfMaKH.getText();
					String ho = tfHoKH.getText();
					String ten = tfTenKH.getText();
					String sdt = tfSoDienThoaiKH.getText();
					bus.suaKhachHang(makh, ho, ten, sdt);
					//table
					KhachHangDTO kh = new KhachHangDTO();
					kh.setMaKH(makh);
					kh.setHoKH(ho);
					kh.setTenKH(ten);
					kh.setCCCD(makh);
					kh.setSDT(sdt);
					modelKhachHang.setValueAt(kh.MaKH, i, 0);
					modelKhachHang.setValueAt(kh.HoKH, i, 1);
					modelKhachHang.setValueAt(kh.TenKH, i, 2);
					modelKhachHang.setValueAt(kh.CCCD, i, 3);
					modelKhachHang.setValueAt(kh.SDT, i, 4);
					clear();
					JOptionPane.showMessageDialog(null, "Sửa thông tin thành công !!!");
				}
			}
		});
		btnSuaKH.setBounds(49, 502, 208, 58);
		btnSuaKH.setIcon(new ImageIcon("imgButton/sua.png"));
		pnDienThongTinKH.add(btnSuaKH);
		
		JButton btnTimKiemKH = new JButton("TÌM KIẾM");
		btnTimKiemKH.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnTimKiemKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] luachon = {"Mã","Họ","Tên","SĐT"};
				JComboBox cbLuaChon = new JComboBox<>(luachon);
				JOptionPane.showMessageDialog(null, cbLuaChon,"Lựa chọn phương thức !!!",JOptionPane.QUESTION_MESSAGE);
				if(cbLuaChon.getSelectedItem().equals("Mã")) {
					for(int i=modelKhachHang.getRowCount()-1; i>=0; i--) {
						modelKhachHang.removeRow(i);
					}
					String inputMaString = JOptionPane.showInputDialog(null,"Nhập Mã cần tìm !!!");
					for(KhachHangDTO kh : KhachHangBUS.ds_KhachHang) {
						if(kh.getMaKH().equals(inputMaString)) {
							Vector rowTimkiem = new Vector<>();
							rowTimkiem.add(kh.getMaKH());
							rowTimkiem.add(kh.getHoKH());
							rowTimkiem.add(kh.getTenKH());
							rowTimkiem.add(kh.getCCCD());
							rowTimkiem.add(kh.getSDT());
							modelKhachHang.addRow(rowTimkiem);
							table_KhachHang.setModel(modelKhachHang);
							break;
						}
					}
				}
				if(cbLuaChon.getSelectedItem().equals("Họ")) {
					for(int i=modelKhachHang.getRowCount()-1; i>=0; i--) {
						modelKhachHang.removeRow(i);
					}
					String inputHoString = JOptionPane.showInputDialog(null,"Nhập Họ cần tìm !!!");
					for(KhachHangDTO kh : KhachHangBUS.ds_KhachHang) {
						if(kh.getHoKH().equals(inputHoString)) {
							Vector rowTimkiem = new Vector<>();
							rowTimkiem.add(kh.getMaKH());
							rowTimkiem.add(kh.getHoKH());
							rowTimkiem.add(kh.getTenKH());
							rowTimkiem.add(kh.getCCCD());
							rowTimkiem.add(kh.getSDT());
							modelKhachHang.addRow(rowTimkiem);
							table_KhachHang.setModel(modelKhachHang);
						}
					}
				}
				if(cbLuaChon.getSelectedItem().equals("Tên")) {
					for(int i=modelKhachHang.getRowCount()-1; i>=0; i--) {
						modelKhachHang.removeRow(i);
					}
					String inputTenString = JOptionPane.showInputDialog(null,"Nhập Tên cần tìm !!!");
					for(KhachHangDTO kh : KhachHangBUS.ds_KhachHang) {
						if(kh.getTenKH().equals(inputTenString)) {
							Vector rowTimkiem = new Vector<>();
							rowTimkiem.add(kh.getMaKH());
							rowTimkiem.add(kh.getHoKH());
							rowTimkiem.add(kh.getTenKH());
							rowTimkiem.add(kh.getCCCD());
							rowTimkiem.add(kh.getSDT());
							modelKhachHang.addRow(rowTimkiem);
							table_KhachHang.setModel(modelKhachHang);
						}
					}
				}
				if(cbLuaChon.getSelectedItem().equals("SĐT")) {
					for(int i=modelKhachHang.getRowCount()-1; i>=0; i--) {
						modelKhachHang.removeRow(i);
					}
					
					 String inputSDT = JOptionPane.showInputDialog(null,"Nhập SĐT cần tìm !!!");
					 for(KhachHangDTO kh : KhachHangBUS.ds_KhachHang) {
						if(kh.getSDT().equals(inputSDT)) {
							Vector rowTimkiem = new Vector<>();
							rowTimkiem.add(kh.getMaKH());
							rowTimkiem.add(kh.getHoKH());
							rowTimkiem.add(kh.getTenKH());
							rowTimkiem.add(kh.getCCCD());
							rowTimkiem.add(kh.getSDT());
							modelKhachHang.addRow(rowTimkiem);
							table_KhachHang.setModel(modelKhachHang);
							break;
						}
					}
				}
			}
		});
		
		btnTimKiemKH.setBounds(294, 502, 205, 58);
		btnTimKiemKH.setIcon(new ImageIcon("imgButton/timkiem.png"));
		pnDienThongTinKH.add(btnTimKiemKH);
		
		JButton btnThemKH = new JButton("THÊM");
		btnThemKH.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnThemKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			for(KhachHangDTO kh : KhachHangBUS.ds_KhachHang) {
				if(tfMaKH.getText().equals(kh.getMaKH())){
					JOptionPane.showMessageDialog(null, "Mã khách hàng trùng !!!");
					break;
				}else {
					
				}
			}
				KhachHangDTO kh = new KhachHangDTO();
				kh.setMaKH(tfMaKH.getText());
				kh.setHoKH(tfHoKH.getText());
				kh.setTenKH(tfTenKH.getText());
				kh.setCCCD(tfCMND.getText());
				kh.setSDT(tfSoDienThoaiKH.getText());

				KhachHangBUS bus = new KhachHangBUS();
				bus.themKhachHang(kh);
				Vector rowKhachHang = new Vector<>();
				rowKhachHang.add(kh.getMaKH());
				rowKhachHang.add(kh.getHoKH());
				rowKhachHang.add(kh.getTenKH());
				rowKhachHang.add(kh.getCCCD());
				rowKhachHang.add(kh.getSDT());
				modelKhachHang.addRow(rowKhachHang);
				table_KhachHang.setModel(modelKhachHang);
				clear();
				JOptionPane.showMessageDialog(null, "Khách Hàng đã được thêm vào DS !!!");
			}
		});
		btnThemKH.setBounds(49, 422, 208, 58);
		btnThemKH.setIcon(new ImageIcon("imgButton/+.png"));
		pnDienThongTinKH.add(btnThemKH);
		
		JButton btnXoaKH = new JButton("XÓA");
		btnXoaKH.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnXoaKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KhachHangDTO kh = new KhachHangDTO(); 
				int i = table_KhachHang.getSelectedRow();
				if(i>=0){
					int luachon = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa !!!", "Xóa",JOptionPane.YES_NO_OPTION);
					if(luachon == 0) {
						modelKhachHang.removeRow(i);
						table_KhachHang.setModel(modelKhachHang);
						String makh = tfMaKH.getText();
						KhachHangBUS bus = new KhachHangBUS();
						bus.xoaKhachHang(makh, kh);
						clear();
					}
				}else{
					JOptionPane.showMessageDialog(null, "Vui lòng chọn Khách Hàng cần xóa !!!");
				}
			}
		});
		btnXoaKH.setBounds(294, 422, 205, 58);
		btnXoaKH.setIcon(new ImageIcon("imgButton/-.png"));
		pnDienThongTinKH.add(btnXoaKH);
		
		JLabel lblDienThongTinKhangHang = new JLabel("ĐIỀN THÔNG TIN KHÁCH HÀNG");
		lblDienThongTinKhangHang.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));
		lblDienThongTinKhangHang.setBounds(76, 30, 423, 33);
		pnDienThongTinKH.add(lblDienThongTinKhangHang);
		
		tfCMND = new JTextField();
		tfCMND.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		tfCMND.setColumns(10);
		tfCMND.setBounds(276, 295, 257, 38);
		pnDienThongTinKH.add(tfCMND);
		
		JLabel lblCmndcccd = new JLabel("CMND/CCCD :");
		lblCmndcccd.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblCmndcccd.setBounds(25, 297, 241, 30);
		pnDienThongTinKH.add(lblCmndcccd);
		
		JPanel pnDS_KhachHang = new JPanel();
		pnDS_KhachHang.setBackground(new Color(51, 0, 51));
		pnDS_KhachHang.setBounds(554, 0, 505, 571);
		pnQuanLyKhachHang.add(pnDS_KhachHang);
		pnDS_KhachHang.setLayout(null);
		
		JLabel lblDanhSchKhch = new JLabel("Danh sách khách hàng thân thiết");
		lblDanhSchKhch.setForeground(new Color(240, 255, 255));
		lblDanhSchKhch.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 32));
		lblDanhSchKhch.setBounds(24, 23, 442, 38);
		pnDS_KhachHang.add(lblDanhSchKhch);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 72, 485, 488);
		pnDS_KhachHang.add(scrollPane_2);
		
		//Do du lieu khach hang vao table_KhachHang
		
		table_KhachHang = new JTable();
		table_KhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int i = table_KhachHang.getSelectedRow();
				 KhachHangDTO kh = new KhachHangDTO();
				 kh.setMaKH(modelKhachHang.getValueAt(i, 0).toString());
				 tfMaKH.setText(kh.getMaKH());
				 kh.setHoKH(modelKhachHang.getValueAt(i, 1).toString());
				 tfHoKH.setText(kh.getHoKH());
				 kh.setTenKH(modelKhachHang.getValueAt(i, 2).toString());
				 tfTenKH.setText(kh.getTenKH());
				 kh.setCCCD(modelKhachHang.getValueAt(i, 3).toString());
				 tfCMND.setText(kh.getCCCD());
				 kh.setSDT(modelKhachHang.getValueAt(i, 4).toString());
				 tfSoDienThoaiKH.setText(kh.getSDT()); 
			}
		});
		KhachHangBUS bus = new KhachHangBUS();
		bus.doc_DS_KhachHangBUS();
		Vector headerKhachHang = new Vector<>();
		headerKhachHang.add("Mã KH");
		headerKhachHang.add("Họ KH");
		headerKhachHang.add("Tên KH");
		headerKhachHang.add("CMND/CCCD");
		headerKhachHang.add("SĐT");
		if(modelKhachHang.getRowCount() == 0) {
			modelKhachHang = new DefaultTableModel(headerKhachHang, 0);
		}
		ArrayList ds_KhachHangGUI = KhachHangBUS.ds_KhachHang;
		for(KhachHangDTO kh: KhachHangBUS.ds_KhachHang) {
			Vector rowKhachHang = new Vector<>();
			rowKhachHang.add(kh.getMaKH()+"");
			rowKhachHang.add(kh.getHoKH()+"");
			rowKhachHang.add(kh.getTenKH()+"");
			rowKhachHang.add(kh.getCCCD()+"");
			rowKhachHang.add(kh.getSDT()+"");
			modelKhachHang.addRow(rowKhachHang);
		}
		table_KhachHang.setModel(modelKhachHang);
		scrollPane_2.setViewportView(table_KhachHang);
		
		//Button
		JButton btnHoaMyPham = new JButton("MyPham");
		btnHoaMyPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        lblLoai.setText("HÓA MỸ PHẨM");
		        pnChonMon.setVisible(true);
			}
		});
		btnHoaMyPham.setIcon(new ImageIcon("imgButton/hoamypham.png"));
		btnHoaMyPham.setBounds(10, 389, 268, 51);
		pnLoaiSP.add(btnHoaMyPham);
		
		JButton btnDoAnNhanh = new JButton("DoAnNhanh");
		btnDoAnNhanh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        lblLoai.setText("ĐỒ ĂN NHANH");
		        pnChonMon.setVisible(true);
			}
		});
		btnDoAnNhanh.setBounds(10, 327, 268, 57);
		btnDoAnNhanh.setIcon(new ImageIcon("imgButton/doannhanh.png"));
		pnLoaiSP.add(btnDoAnNhanh);
		
		JButton btnBanhKeo = new JButton("BanhKeo");
		btnBanhKeo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblLoai.setText("BÁNH KẸO");
				pnChonMon.setVisible(true);
			}
		});
		btnBanhKeo.setBounds(10, 269, 268, 51);
		btnBanhKeo.setIcon(new ImageIcon("imgButton/banhkeo.png"));
		pnLoaiSP.add(btnBanhKeo);
		
		JButton btnKem_NGK = new JButton("Kem");
		btnKem_NGK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblLoai.setText("KEM VÀ NƯỚC GIẢI KHÁT");
				pnChonMon.setVisible(true);
			}
		});
		btnKem_NGK.setBounds(10, 212, 268, 51);
		btnKem_NGK.setIcon(new ImageIcon("imgButton/kem_ngk.png"));
		pnLoaiSP.add(btnKem_NGK);
		
		JButton btnThucPhamKho = new JButton("ThucPham");
		btnThucPhamKho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblLoai.setText("THỰC PHẨM KHÔ");
				pnChonMon.setVisible(true);
			}
		});
		btnThucPhamKho.setBounds(10, 155, 268, 51);
		btnThucPhamKho.setIcon(new ImageIcon("imgButton/thucphamkho.png"));
		pnLoaiSP.add(btnThucPhamKho);
		
		JButton btnThanhToan = new JButton("THANH TOÁN");
		btnThanhToan.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
				String MaNV ="";
				String [] str = new String[maNV_hienhanh.size()];
				for(int i =0; i<maNV_hienhanh.size(); i++) {
					str[i] = maNV_hienhanh.get(i);
				}
				for(String k: str) {
					System.out.print(k);
					tfMaNV_HD.setText(k+"");
				}
			}
		});
		btnThanhToan.setBounds(10, 510, 275, 50);
		btnThanhToan.setIcon(new ImageIcon("imgButton/thanhtoan1.png"));
		pnGioHang.add(btnThanhToan);
		
		
		JButton btnDangXuat = new JButton("ĐĂNG XUẤT");
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDangXuat.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDangXuat.setIcon(new ImageIcon("imgButton/dangxuat.png"));
		btnDangXuat.setBounds(60, 453, 166, 51);
		pnLoaiSP.add(btnDangXuat);
		
		JButton btnThoat = new JButton("THOÁT");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThoat.setIcon(new ImageIcon("imgButton/thoat.png"));
		btnThoat.setBounds(60, 509, 166, 51);
		pnLoaiSP.add(btnThoat);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBackground(new Color(135, 206, 250));
		lblLogo.setBounds(60, 0, 198, 154);
		lblLogo.setIcon(new ImageIcon("imgButton/logo1.jpg"));
		pnLoaiSP.add(lblLogo);
		
		JPanel pnPhieuNhap = new JPanel();
		tabbedPane.addTab("Phiếu nhập hàng", null, pnPhieuNhap, null);
		pnPhieuNhap.setLayout(null);
			
		JPanel pnLichLV = new JPanel();
		tabbedPane.addTab("Lịch làm việc", null, pnLichLV, null);
		pnLichLV.setLayout(null);
		
		// click hien thi thong tin
		
		
	}
}
