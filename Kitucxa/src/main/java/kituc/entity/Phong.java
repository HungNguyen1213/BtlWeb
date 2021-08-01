package kituc.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblphong")
public class Phong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="so_phong", unique = true)
	private String sophong;
	
	@Column(name="loai_phong")
	private String loaiphong;
	
	@Column(name="don_gia")
	private float dongia;
	
	@Column(name="so_nguoi_toi_da")
	private int songuoitoida;
	
}
