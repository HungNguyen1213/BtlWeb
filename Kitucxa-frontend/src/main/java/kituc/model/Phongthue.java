package kituc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phongthue {
	
	private int ma;
	
	private int thang;
	
	private Phong phong;
	
	private Sinhvien sv2;
	
	private Hoadon hoadon;
}
