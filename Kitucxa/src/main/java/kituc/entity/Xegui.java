package kituc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="xegui")
public class Xegui {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="dongia")
	private float dongia;
	
	@Column(name="ngaysd")
	private Date ngaysd;
	
//	private Xe xe;
//	private Sinhvien sinhvien;
	
	@ManyToOne
	@JoinColumn(name="sinhvienid")
	private Sinhvien sinhvien;
	
	@ManyToOne
	@JoinColumn(name="xeid")
	private Xe xegui;
}
