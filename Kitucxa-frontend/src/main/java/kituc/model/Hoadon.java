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
public class Hoadon {
	
	private int ma;
	
	private Date ngayTao;
	
	private float tongTien;
	
	private List<DichvuSudung> dvsd = new ArrayList<>();
	
	private Phongthue phongthue;
	
}
