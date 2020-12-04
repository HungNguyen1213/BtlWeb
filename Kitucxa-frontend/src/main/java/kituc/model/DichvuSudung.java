package kituc.model;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DichvuSudung {
	
	private int id;
	

	private Date ngaysd;
	

	private float dongia;
	
	private Dichvu dichvu;
	
	private Sinhvien sinhvien;
	
	
}
