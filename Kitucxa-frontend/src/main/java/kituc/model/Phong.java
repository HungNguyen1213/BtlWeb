package kituc.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Phong {
	private String soPhong;
	
	private String loaiPhong;
	
	private float donGia;
	
	private int soNguoitoida;
	
	private List<Phongthue> phongThue = new ArrayList<>();
}
