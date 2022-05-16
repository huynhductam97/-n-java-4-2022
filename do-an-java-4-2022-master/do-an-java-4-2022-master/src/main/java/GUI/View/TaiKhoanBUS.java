package GUI.View;

import java.util.ArrayList;

public class TaiKhoanBUS {
	static ArrayList<TaiKhoan> ds_TaiKhoan;
	public TaiKhoanBUS() {
		
	}
	void doc_DS_TaiKhoan() {
		TaiKhoanDAO dataTaiKhoanDAO = new TaiKhoanDAO();
		if(ds_TaiKhoan == null) {
			ds_TaiKhoan = new ArrayList<TaiKhoan>();
		}
		ds_TaiKhoan = dataTaiKhoanDAO.docDSTK_DAO();
	}
}
