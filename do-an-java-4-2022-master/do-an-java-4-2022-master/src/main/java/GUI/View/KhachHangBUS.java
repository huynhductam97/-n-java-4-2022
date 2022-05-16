package GUI.View;

import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;

public class KhachHangBUS {
	static ArrayList<KhachHangDTO> ds_KhachHang;
	public KhachHangBUS() {
		
	}
	
	void doc_DS_KhachHangBUS() {
		KhachHangDAO dataKhachHangDAO = new KhachHangDAO();
		if(ds_KhachHang == null) {
			ds_KhachHang = new ArrayList<KhachHangDTO>();
		}
		ds_KhachHang = dataKhachHangDAO.doc_DS_KhachHangDAO();
	}
	
	
	void themKhachHang(KhachHangDTO kh) {
		KhachHangDAO dataKhachHangDAO = new KhachHangDAO();
		dataKhachHangDAO.themKhachHang(kh);
		ds_KhachHang.add(kh);
	}
	
	void xoaKhachHang(String makh, KhachHangDTO kh) {
		KhachHangDAO dataKhachHangDAO = new KhachHangDAO();
		dataKhachHangDAO.xoaKhachHang(makh);
		ds_KhachHang.remove(kh);
	}
	
	void suaKhachHang(String makh, String ho, String ten, String sdt ) {
		KhachHangDAO dataKhachHangDAO = new KhachHangDAO();
		dataKhachHangDAO.suaKhachHang(makh, ho, ten, sdt);
	}
}
