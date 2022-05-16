package GUI.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.sasl.ScramSha1SaslClient;
import com.mysql.cj.xdevapi.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.SplashScreen;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormDangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField tfTaiKhoan,tfMatKhau;
	private JLabel lblTaiKhoan, lblMatKhau,lblNhanVien,lblQuanLy;
	private JButton btnDangNhap, btnQuayLai;
	static ArrayList<TaiKhoan> taikhoan = new ArrayList<TaiKhoan>();
	static ArrayList<String> maNV_dangdung = new ArrayList<String>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDangNhap frame = new FormDangNhap();
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
	public void Visible() {
		lblNhanVien.setVisible(false);
		lblQuanLy.setVisible(false);
		lblTaiKhoan.setVisible(true);
		lblMatKhau.setVisible(true);
		tfTaiKhoan.setVisible(true);
		tfMatKhau.setVisible(true);
		btnDangNhap.setVisible(true);
		btnQuayLai.setVisible(true);
	}
	public FormDangNhap() {
		setTitle("\u0110\u0102NG NH\u1EACP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel pnChon = new JPanel();
		pnChon.setBackground(new Color(135, 206, 250));
		pnChon.setBounds(0, 0, 434, 508);
		contentPane.add(pnChon);
		pnChon.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(120, 21, 233, 201);
		lblLogo.setIcon(new ImageIcon("imgButton/logo.png"));
		pnChon.add(lblLogo);
		
		JLabel lblNhanVien = new JLabel("");
		lblNhanVien.setBounds(99, 274, 254, 81);
		lblNhanVien.setIcon(new ImageIcon("imgButton/nhanvien.png"));
		pnChon.add(lblNhanVien);
		
		JLabel lblQuanLy = new JLabel("");
		lblQuanLy.setBounds(99, 370, 254, 81);
		lblQuanLy.setIcon(new ImageIcon("imgButton/quanly.png"));
		pnChon.add(lblQuanLy);
		
		tfTaiKhoan = new JTextField();
		tfTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfTaiKhoan.setBounds(44, 300, 332, 40);
		pnChon.add(tfTaiKhoan);
		tfTaiKhoan.setColumns(10);
		tfTaiKhoan.setVisible(false);
		
		tfMatKhau = new JTextField();
		tfMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfMatKhau.setColumns(10);
		tfMatKhau.setBounds(44, 382, 332, 40);
		pnChon.add(tfMatKhau);
		tfMatKhau.setVisible(false);
		
		JButton btnDangNhap = new JButton("\u0110\u0103ng nh\u1EADp");
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDangNhap.setBounds(140, 462, 138, 35);
		pnChon.add(btnDangNhap);
		btnDangNhap.setVisible(false);
		
		JLabel lblTaiKhoan = new JLabel("T\u00E0i kho\u1EA3n :");
		lblTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTaiKhoan.setBounds(44, 271, 126, 30);
		pnChon.add(lblTaiKhoan);
		lblTaiKhoan.setVisible(false);
		
		JLabel lblMatKhau = new JLabel("M\u1EADt kh\u1EA9u :");
		lblMatKhau.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMatKhau.setBounds(44, 351, 126, 30);
		pnChon.add(lblMatKhau);
		lblMatKhau.setVisible(false);
		
		JButton btnQuayLai = new JButton("<-");
		btnQuayLai.setBounds(10, 11, 45, 23);
		btnQuayLai.setVisible(false);
		pnChon.add(btnQuayLai);
		
		lblNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNhanVien.setVisible(false);
				lblQuanLy.setVisible(false);
				lblTaiKhoan.setVisible(true);
				lblMatKhau.setVisible(true);
				tfTaiKhoan.setVisible(true);
				tfMatKhau.setVisible(true);
				btnDangNhap.setVisible(true);
				btnQuayLai.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNhanVien.setIcon(new ImageIcon("imgButton/nhanvien1.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNhanVien.setIcon(new ImageIcon("imgButton/nhanvien.png"));
			}
		});
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNhanVien.setVisible(true);
				lblQuanLy.setVisible(true);
				lblTaiKhoan.setVisible(false);
				lblMatKhau.setVisible(false);
				tfTaiKhoan.setVisible(false);
				tfMatKhau.setVisible(false);
				btnDangNhap.setVisible(false);
				btnQuayLai.setVisible(false);
			}
		});
		
		lblQuanLy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNhanVien.setVisible(false);
				lblQuanLy.setVisible(false);
				lblTaiKhoan.setVisible(true);
				lblMatKhau.setVisible(true);
				tfTaiKhoan.setVisible(true);
				tfMatKhau.setVisible(true);
				btnDangNhap.setVisible(true);
				btnQuayLai.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblQuanLy.setIcon(new ImageIcon("imgButton/quanly1.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblQuanLy.setIcon(new ImageIcon("imgButton/quanly.png"));
			}
		});
		TaiKhoanBUS bus = new TaiKhoanBUS();
		TaiKhoan tk = new TaiKhoan();
		bus.doc_DS_TaiKhoan();
		ArrayList doc_DS_TaiKhoan = TaiKhoanBUS.ds_TaiKhoan;
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfTaiKhoan.getText().equals("")||tfMatKhau.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "VUI LÒNG NHẬP TÀI KHOẢN/MẬT KHẨU");
				}else {
					String tentaikhoan = tfTaiKhoan.getText();
					String matkhau = tfMatKhau.getText();
					for(TaiKhoan tk: TaiKhoanBUS.ds_TaiKhoan) {
						if((tk.getTenTaiKhoan().equals(tentaikhoan))&&(tk.getMatKhau().equals(matkhau))&&tk.getPhanQuyen().equals("user")) {
							JOptionPane.showMessageDialog(null, "Bạn đang đăng nhập với quyền Nhân Viên !!!");
							FromChonHang chonHang = new FromChonHang();
							chonHang.setVisible(true);
							maNV_dangdung.add(tk.getMaNV());
							String [] str = new String[maNV_dangdung.size()];
							for(int i =0; i<maNV_dangdung.size(); i++) {
								str[i] = maNV_dangdung.get(i);
							}
							for(String k: str) {
								System.out.print(k);
							}
						}else if(tk.getTenTaiKhoan().equals(tentaikhoan)&&(tk.getMatKhau().equals(matkhau))&&tk.getPhanQuyen().equals("admin")) {
							JOptionPane.showMessageDialog(null, "Bạn đang đăng nhập với quyền Quản Lý !!!");
							FormQuanLy quanLy = new FormQuanLy();
							quanLy.setVisible(true);
							maNV_dangdung.add(tk.getMaNV());
							String [] str = new String[maNV_dangdung.size()];
							for(int i =0; i<maNV_dangdung.size(); i++) {
								str[i] = maNV_dangdung.get(i);
							}
							for(String k: str) {
								System.out.print(k);
							}
						}else if (!tk.getTenTaiKhoan().equals(tentaikhoan)  && !tk.getMatKhau().equals(matkhau)) {
							JOptionPane.showMessageDialog(null, "Tài khoản hoặc Mật khẩu không đúng/không tồn tại !!!");
							FormDangNhap dangNhap = new FormDangNhap();
							dangNhap.setVisible(true);
							JOptionPane.showMessageDialog(null, "Vui lòng thao tác lại !!!");
							break;
						}
					}
					dispose();	
				}
			}
		});
	}
}
