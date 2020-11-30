package kituc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dichvusudung")
public class DichvuSudung {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ma;
	
	@Column
	private Date ngaySudung;
	
	@ManyToOne
	@JoinColumn(name = "sinhvien_ma")
	private Sinhvien sv3;
	
	@ManyToOne
	@JoinColumn(name = "dichvu_ma")
	private Dichvu dv1;
	
	@ManyToOne
	@JoinColumn(name = "hoadon_ma")
	private Hoadon hoadon;
	
	@PrePersist
	void ngaySudung() {
		this.ngaySudung = new Date();
	}
}
