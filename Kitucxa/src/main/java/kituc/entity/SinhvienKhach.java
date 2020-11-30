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
@Table(name = "sinhvien_khach")
public class SinhvienKhach {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ma;
	
	@Column
	private Date ngayDen;
	
	@ManyToOne
    @JoinColumn(name = "sinhvien_ma")	
    private Sinhvien sv1;
	
	@ManyToOne
	@JoinColumn(name = "khach_ma")
	private Khach khach;
	
	@PrePersist
	void ngayDen() {
		this.ngayDen = new Date();
	}
}
