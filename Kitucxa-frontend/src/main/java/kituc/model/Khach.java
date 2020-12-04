package kituc.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Khach {

	private int id;
	
	private String soCMT;
	
	private String ten;
	
	private Date ngaysinh;

	private Date ngayden;
	
	private Sinhvien sinhvien;
}
