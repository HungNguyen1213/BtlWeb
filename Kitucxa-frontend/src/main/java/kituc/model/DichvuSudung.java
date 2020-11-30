package kituc.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DichvuSudung {
	
	private int ma;
	
	private Date ngaySudung;
	
	private Sinhvien sv3;
	
	private Dichvu dv1;
	
	private Hoadon hoadon;

}
