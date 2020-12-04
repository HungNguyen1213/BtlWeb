package kituc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Thanhvien{

	private int id;
	
	private String ten;
	
	private String username;
	
	private String password;
	
	private String soCMT;
	
	private String quequan;
	
	private String ngaysinh;
	
	private String vitri;
	
}
