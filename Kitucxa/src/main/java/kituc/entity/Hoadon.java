package kituc.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hoadon")
public class Hoadon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ma;
	
	@Column
	private Date ngayTao;
	
	@Column
	private float tongTien;
	
	@OneToMany(mappedBy = "hoadon")
	private List<DichvuSudung> dvsd = new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name = "phongthue_ma", referencedColumnName = "ma")
	private Phongthue phongthue;
	
	@PrePersist
	void ngayTao() {
		this.ngayTao = new Date();
	}
}
