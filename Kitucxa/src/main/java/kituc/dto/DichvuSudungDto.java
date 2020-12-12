package kituc.dto;

import kituc.entity.Thanhvien;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DichvuSudungDto {
	
	private int id;

	private String thoigianbd;

	private String thoigiankt;

	private float dongia;
	
	private int thoigiansddv;

	private DichvuDto dichvu;

	private Thanhvien sinhvien;
}
