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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "xe")
public class Xe {
	@Id
	private String bienSo;
	
	@Column
	private String loai;
	
	@Column
	private String mau;
	
	@OneToMany(mappedBy = "xe1")
	private List<Vethang> vethang = new ArrayList<>();
	
	@OneToMany(mappedBy = "xe2")
	private List<Vexe> vexe = new ArrayList<>();
	
}
