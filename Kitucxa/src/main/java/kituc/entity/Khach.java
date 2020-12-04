package kituc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="khach")
public class Khach {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="soCMT")
	private String soCMT;
	
	@Column(name="ten")
	private String ten;
	
	@Column(name="ngaysinh")
	private Date ngaysinh;
	
	@Column(name="ngayden")
	private Date ngayden;
	
	// quan hệ n-1 với sinh viên
	@ManyToOne
	@JoinColumn(name="sinhvienid")
	private Sinhvien sinhvien;
}
