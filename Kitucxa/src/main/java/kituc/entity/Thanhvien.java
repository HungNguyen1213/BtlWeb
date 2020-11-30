package kituc.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Thanhvien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ma;
	
	@Column
	private String ten;
	
	@Column
	private String taikhoan;
	
	@Column
	private String password;
	
	@Column
	private String soCMT;
	
	@Column
	private String queQuan;
	
	@Column
	private String ngaySinh;
	
	@Column
	private String chucNang;
}
