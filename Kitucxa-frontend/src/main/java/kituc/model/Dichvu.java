package kituc.model;

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

	private float dongia;

	private Date thoigiansd;

	private Date thang;

	private int solanguitoida;

	private List<DichvuSudung> dvsd;

	private Vethang vethang;

	private Xe xe;
}
