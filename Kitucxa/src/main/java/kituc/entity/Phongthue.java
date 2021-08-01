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
@Table(name="tblphongthue")
public class Phongthue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="don_gia")
	private float dongia;
	
	@Column(name="thoi_gian_bd")
	private Date thoigianbd;
	
	@Column(name="thoi_gian_kt")
	private Date thoigiankt;
	
	// quan hệ n-1 với phòng
	@ManyToOne
	@JoinColumn(name = "phong_id")
	private Phong phong;
	
	@ManyToOne
	@JoinColumn(name = "thanh_vien_id")
	private Thanhvien sinhvien;

}
