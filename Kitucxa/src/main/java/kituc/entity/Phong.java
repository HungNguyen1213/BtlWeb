package kituc.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phong")
public class Phong {
	@Id
	private String soPhong;
	
	@Column
	private String loaiPhong;
	
	@Column
	private float donGia;
	
	@Column
	private int soNguoitoida;
	
	@OneToMany(mappedBy = "phong")
	private List<Phongthue> phongThue = new ArrayList<>();
}
