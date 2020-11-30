package kituc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Thanhvien {
	private int ma;
	private String ten;
	private String taikhoan;
	private String password;
	private String soCMT;
	private String queQuan;
	private String ngaySinh;
	private String chucNang;
}
