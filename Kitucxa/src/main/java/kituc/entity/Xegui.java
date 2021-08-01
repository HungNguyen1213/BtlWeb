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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tblxegui")
public class Xegui {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="don_gia")
	private float dongia;
	
	@Column(name="ngay_sd")
	private Date ngaysd;

	@ManyToOne
	@JoinColumn(name="thanh_vien_id")
	private Thanhvien thanhvien;
	
	@ManyToOne
	@JoinColumn(name="xe_id")
	private Xe xegui;
}
