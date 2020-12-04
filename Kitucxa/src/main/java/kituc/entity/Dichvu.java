package kituc.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name="dichvu")
@SecondaryTable(name = "vethang", pkJoinColumns = @PrimaryKeyJoinColumn(name = "dichvuid"))
public abstract class Dichvu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="ten")
	private String ten;
	
	@Column(name="dongia")
	private float dongia;
	
	@Column(name="thoigiansd")
	private Date thoigiansd;
	
	@Column(name="thang", table = "vethang")
	private Date thang;
	
	@Column(name="solanguitoida", table = "vethang")
	private int solanguitoida;
	
	
	//quan hệ 1-n với dịch vụ sử dụng
	@OneToMany(mappedBy = "dichvu")
	private List<DichvuSudung> dvsd;

	@Embedded
	private Vethang vethang;

	@OneToOne
	@JoinColumn(name = "xeid", table = "vethang")
	private Xe xe;
}
