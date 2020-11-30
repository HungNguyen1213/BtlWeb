package kituc.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dichvu {
	@Id
	private String maDv;
	
	@Column
	private String ten;
	
	@Column
	private float donGia;
	
	@OneToMany(mappedBy = "dv1")
	private List<DichvuSudung> dvsd1 = new ArrayList<>();
	
	@OneToMany(mappedBy = "dv2")
	private List<Vethang> vethang = new ArrayList<>();
	
	@OneToMany(mappedBy = "dv3")
	private List<Vexe> vexe = new ArrayList<>();
}
