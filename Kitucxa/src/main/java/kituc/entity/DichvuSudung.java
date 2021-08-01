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
@Table(name="tbldichvusudung")
public class DichvuSudung {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="thoi_gian_bd")
	private Date thoigianbd;
	
	@Column(name ="thoi_gian_kt")
	private Date thoigiankt;
	
	@Column(name="don_gia")
	private float dongia;
	
	@ManyToOne
	@JoinColumn(name = "dich_vu_id")
	private Dichvu dichvu;
	
	@ManyToOne
	@JoinColumn(name = "thanh_vien_id")
	private Thanhvien thanhvien;

	@PrePersist
	void thoigianbd() {
		this.thoigianbd = new Date();
	}
}
