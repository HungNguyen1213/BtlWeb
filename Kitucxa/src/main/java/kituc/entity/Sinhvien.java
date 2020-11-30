package kituc.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sinhvien")
public class Sinhvien extends Thanhvien{
	@Column
	private String maSv;
	
	@Column
	private String lop;
	
	@OneToMany(mappedBy = "sv1")
	private List<SinhvienKhach> svKs = new ArrayList<>();
	
	@OneToMany(mappedBy = "sv2")
	private List<Phongthue> phongThue = new ArrayList<>();
	
	@OneToMany(mappedBy = "sv3")
	private List<DichvuSudung> dvsd = new ArrayList<>();
}
