package kituc.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SinhvienKhach {
	
	private int ma;
	
	private Date ngayDen;
		
    private Sinhvien sv1;
	
	private Khach khach;
	
}
