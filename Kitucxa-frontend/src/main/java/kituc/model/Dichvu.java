package kituc.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dichvu {
	
	private String maDv;
	
	private String ten;
	
	private float donGia;
	
	private List<DichvuSudung> dvsd1 = new ArrayList<>();
	
	private List<Vethang> vethang = new ArrayList<>();
	
	private List<Vexe> vexe = new ArrayList<>();
}
