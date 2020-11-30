package kituc.entity;

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
@Table(name = "vethang")
public class Vethang{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maVe;
	
	@Column
	private int thang;
	
	@ManyToOne
	@JoinColumn(name = "dichvu_ma")
	private Dichvu dv2;
	
	@ManyToOne
	@JoinColumn(name = "xe_bienso")
	private Xe xe1;
}
