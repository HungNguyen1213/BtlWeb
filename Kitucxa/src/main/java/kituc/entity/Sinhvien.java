package kituc.entity;

import java.util.ArrayList;
import java.util.List;

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
@Table(name = "tblsinhvien")
public class Sinhvien extends Thanhvien{
	
	@OneToMany(mappedBy = "sinhvien")
	private List<Khach> khach = new ArrayList<>();
	
	@OneToMany(mappedBy = "sinhvien")
	private List<Phongthue> phongThue = new ArrayList<>();
	
	@OneToMany(mappedBy = "sinhvien")
	private List<Xegui> xegui = new ArrayList<>();
}
