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
@Table(name="dichvusudung")
public class DichvuSudung {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="ngaysd")
	private Date ngaysd;
	
	@Column(name="dongia")
	private float dongia;
	
	@ManyToOne
	@JoinColumn(name = "dichvuid")
	private Dichvu dichvu;
	
	@ManyToOne
	@JoinColumn(name = "sinhvienid")
	private Sinhvien sinhvien;

	@PrePersist
	void ngaySudung() {
		this.ngaysd = new Date();
	}
	
	
}
