package GUI.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class FormChiTiet_CTKM extends JFrame {

	private JPanel contentPane;
	private JTable tableChiTietCTKM;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormChiTiet_CTKM frame = new FormChiTiet_CTKM();
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
	public FormChiTiet_CTKM() {
		setTitle("CHI TI\u1EBET CTKM");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 596, 405);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 164, 96));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		tableChiTietCTKM = new JTable();
		tableChiTietCTKM.setBounds(10, 155, 560, 200);
		contentPane.add(tableChiTietCTKM);
		
		JLabel lblMaChuongTrinh = new JLabel("M\u00E3 Ch\u01B0\u01A1ng tr\u00ECnh :");
		lblMaChuongTrinh.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMaChuongTrinh.setBounds(10, 82, 147, 21);
		contentPane.add(lblMaChuongTrinh);
		
		JLabel lblMKhchHng = new JLabel("M\u00E3 Kh\u00E1ch h\u00E0ng :");
		lblMKhchHng.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMKhchHng.setBounds(306, 82, 147, 21);
		contentPane.add(lblMKhchHng);
		
		textField = new JTextField();
		textField.setBounds(163, 82, 119, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(444, 82, 126, 22);
		contentPane.add(textField_1);
		
		JLabel lblGim = new JLabel("Gi\u1EA3m (%) :");
		lblGim.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblGim.setBounds(10, 123, 147, 21);
		contentPane.add(lblGim);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(163, 122, 119, 22);
		contentPane.add(textField_2);
		
		JLabel lblThngTinChi = new JLabel("TH\u00D4NG TIN CHI TI\u1EBET CTKM");
		lblThngTinChi.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblThngTinChi.setBounds(167, 11, 262, 24);
		contentPane.add(lblThngTinChi);
	}

}
