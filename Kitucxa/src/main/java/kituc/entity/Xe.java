package kituc.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "xe")
public class Xe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="bienso")
	private String bienSo;
	
	@Column(name="loaixe")
	private String loaixe;
	
	@OneToOne(mappedBy = "xe")
	private Vethang vethang; 
	
	@OneToMany(mappedBy = "xegui")
	private List<Xegui> xegui = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "ma_sinhvien")
	private Sinhvien sv4;
	
}
