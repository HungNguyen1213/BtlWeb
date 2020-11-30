package kituc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Khach {
	
	private int ma;
	
	private String soCMT;
	
	private String ten;
	
	private Date ngaySinh;
	
	private List<SinhvienKhach> svKs = new ArrayList<>();
}
