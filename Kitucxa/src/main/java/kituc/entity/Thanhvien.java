package kituc.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name ="tblthanhvien")
public class Thanhvien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="ten")
	private String ten;
	
	@Column(name="soCMT")
	private String soCMT;
	
	@Column(name="que_quan")
	private String quequan;
	
	@Column(name="ngay_sinh")
	private String ngaysinh;
	
	@Column(name="vi_tri")
	private String vitri;

	@Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String password;
	
	@Column(name="lop")
	private String lop;

	@OneToMany(mappedBy = "thanhvien", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Khach> khach;

	@OneToMany(mappedBy = "thanhvien", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DichvuSudung> dichvuSudungList;

}
