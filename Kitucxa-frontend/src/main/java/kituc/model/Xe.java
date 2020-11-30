package kituc.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Xe {
	
	private String bienSo;
	
	private String loai;
	
	private String mau;
	
	private List<Vethang> vethang = new ArrayList<>();
	
	private List<Vexe> vexe = new ArrayList<>();
	
}
