package kituc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "phongthue")
public class Phongthue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ma;
	
	@Column
	private int thang;
	
	@ManyToOne
	@JoinColumn(name = "phong_sophong")
	private Phong phong;
	
	@ManyToOne
	@JoinColumn(name = "sinhvien_ma")
	private Sinhvien sv2;
	
	@OneToOne(mappedBy = "phongthue")
	private Hoadon hoadon;
}
