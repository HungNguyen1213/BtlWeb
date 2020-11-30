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
@Table(name = "vexe")
public class Vexe{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maVe;
	
	@Column
	private Date tgGui;
	
	@Column
	private Date tgLay;
	
	@ManyToOne
	@JoinColumn(name = "dichvu_ma")
	private Dichvu dv3;
	
	@ManyToOne
	@JoinColumn(name = "xe_bienso")
	private Xe xe2;
	
	@PrePersist
	void tgGui() {
		this.tgGui = new Date();
	}
	void tgLay() {
		this.tgLay = new Date();
	}
}
