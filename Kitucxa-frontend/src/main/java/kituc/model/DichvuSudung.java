package kituc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DichvuSudung {
	
	private int id;

	private String thoigianbd;

	private String thoigiankt;

	private float dongia;
	
	private int thoigiansddv;

	private Dichvu dichvu;

	private Thanhvien sinhvien;
}
