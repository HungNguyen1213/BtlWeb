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
@Table(name="tbldichvu")
@SecondaryTable(name = "tblvethang", pkJoinColumns = @PrimaryKeyJoinColumn(name = "dichvuid"))
public class Dichvu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="ten")
	private String ten;
	
	@Column(name="dongia")
	private float dongia;
	
	@Column(name="thang", table = "tblvethang")
	private Date thang;
	
	@Column(name="solanguitoida", table = "tblvethang")
	private int solanguitoida;

	@Embedded
	private Vethang vethang;

	@OneToOne
	@JoinColumn(name = "xeid", table = "tblvethang")
	private Xe xe;
}
