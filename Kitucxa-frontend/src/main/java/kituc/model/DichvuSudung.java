package kituc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DichvuSudung {
	
	private int id;
	
	private Date thoigianbd;
	
	private Date thoigiankt;
	
	private float dongia;
	
	private Dichvu dichvu;
	private Thanhvien thanhvien;
}
