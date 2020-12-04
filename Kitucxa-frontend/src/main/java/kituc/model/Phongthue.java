package kituc.model;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Phongthue {

	private int id;
	
	private float dongia;
	
	private Date thoigianbd;
	
	private Date thoigiankt;
	
	private Phong phong;

	private Sinhvien sinhvien;
	
}
