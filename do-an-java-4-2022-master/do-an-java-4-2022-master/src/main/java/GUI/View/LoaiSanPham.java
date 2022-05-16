package GUI.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class LoaiSanPham extends JFrame {

	private JPanel contentPane;
	private JTable tableLoaiSanPham;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoaiSanPham frame = new LoaiSanPham();
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
	public LoaiSanPham() {
		setTitle("Lo\u1EA1i");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 636, 423);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		
		tableLoaiSanPham = new JTable();
		tableLoaiSanPham.setBounds(10, 168, 600, 205);
		contentPane.add(tableLoaiSanPham);
		
		JLabel lblMaLoaiSP = new JLabel("M\u00E3 Lo\u1EA1i :");
		lblMaLoaiSP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMaLoaiSP.setBounds(10, 65, 82, 25);
		contentPane.add(lblMaLoaiSP);
		
		JLabel lblTnLoi = new JLabel("T\u00EAn Lo\u1EA1i :");
		lblTnLoi.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTnLoi.setBounds(302, 65, 82, 25);
		contentPane.add(lblTnLoi);
		
		textField = new JTextField();
		textField.setBounds(102, 65, 171, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(394, 65, 216, 25);
		contentPane.add(textField_1);
		
		JButton btnThemLoai = new JButton("TH\u00CAM ");
		btnThemLoai.setBounds(10, 112, 120, 45);
		contentPane.add(btnThemLoai);
		
		JButton btnXoaLoai = new JButton("X\u00D3A");
		btnXoaLoai.setBounds(162, 112, 120, 45);
		contentPane.add(btnXoaLoai);
		
		JButton btnSuaLoai = new JButton("S\u1EECA");
		btnSuaLoai.setBounds(332, 112, 120, 45);
		contentPane.add(btnSuaLoai);
		
		JButton btnTimKiemLoai = new JButton("T\u00CCM KI\u1EBEM");
		btnTimKiemLoai.setBounds(490, 112, 120, 45);
		contentPane.add(btnTimKiemLoai);
		
		JLabel lblThngTinLoi = new JLabel("TH\u00D4NG TIN LO\u1EA0I S\u1EA2N PH\u1EA8M");
		lblThngTinLoi.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblThngTinLoi.setBounds(184, 11, 279, 24);
		contentPane.add(lblThngTinLoi);
	}

}
