package kituc.model;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Xegui {

	private int id;

	private float dongia;

	private Date ngaysd;
	
//	private Xe xe;
//	private Sinhvien sinhvien;

	private Sinhvien sinhvien;

	private Xe xe;
}
