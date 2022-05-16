package GUI.View;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TaiKhoanDAO {
	ArrayList ds_TaiKhoanDAO;
	Connection connection = MyConnection.getJDBCConnection();
	public ArrayList<TaiKhoan> docDSTK_DAO(){
		ds_TaiKhoanDAO = new ArrayList<TaiKhoan>();
		String qryString = "Select * from TaiKhoan";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(qryString);
			ResultSet rSet = preparedStatement.executeQuery();
			while(rSet.next()) {
				TaiKhoan tk = new TaiKhoan();
				tk.setMaTaiKhoan(rSet.getString("MaTaiKhoan"));
				tk.setTenTaiKhoan(rSet.getString("TenTaiKhoan"));
				tk.setMatKhau(rSet.getString("MatKhau"));
				tk.setPhanQuyen(rSet.getString("PhanQuyen"));
				tk.setMaNV(rSet.getString("MaNhanVien"));
				ds_TaiKhoanDAO.add(tk);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds_TaiKhoanDAO;
	}
}
