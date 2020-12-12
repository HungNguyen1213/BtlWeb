package kituc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sinhvien{

	private int id;
	
	private String ten;
	
	private String soCMT;
	
	private String quequan;
	
	private String ngaysinh;
	
	private String vitri;
	
	private String lop;
}
