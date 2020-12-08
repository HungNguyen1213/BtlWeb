package kituc.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="tblthanhvien")
@SecondaryTable(name = "tblsinhvien", pkJoinColumns = @PrimaryKeyJoinColumn(name = "thanhvienid"))
@SecondaryTable(name = "tblnvquanly", pkJoinColumns = @PrimaryKeyJoinColumn(name = "thanhvienid"))
public class Thanhvien{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="ten")
	private String ten;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="soCMT")
	private String soCMT;
	
	@Column(name="quequan")
	private String quequan;
	
	@Column(name="ngaysinh")
	private String ngaysinh;
	
	@Column(name="vitri")
	private String vitri;
	
	@Column(name="lop", table = "tblsinhvien")
	private String lop;
	
	@Embedded
	private Sinhvien sinhvien;
	
	@Embedded
	private Nvquanly nvquanly;
}
