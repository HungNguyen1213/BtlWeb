package kituc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="tblthanhvien")
public class Thanhvien implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="ten")
	private String ten;
	
	@Column(name="lop")
	private String lop;
	
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
}
