package kituc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Khach {

	private int id;
	
	private String soCMT;
	
	private String ten;
	
	private Date ngaysinh;

	private Date ngayden;
	
	private Thanhvien sinhvien;
}
