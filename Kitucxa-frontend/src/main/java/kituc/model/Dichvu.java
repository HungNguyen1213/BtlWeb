package kituc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Dichvu {

	private int id;
	

	private String ten;
	

	private float donGia;
	

	private Date thoigiansd;
	

	private List<DichvuSudung> dvsd;

}
