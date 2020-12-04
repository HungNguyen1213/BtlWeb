package kituc.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Sinhvien extends Thanhvien{
	
	private String lop;
	
	private List<Khach> khach = new ArrayList<>();
	
	private List<Xegui> Xegui = new ArrayList<>();
	
	private List<DichvuSudung> dvsd = new ArrayList<>();
	
	private List<Phongthue> phongthue = new ArrayList<>();
		
}
