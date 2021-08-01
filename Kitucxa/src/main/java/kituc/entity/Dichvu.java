package kituc.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbldichvu")
public class Dichvu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="ten")
	private String ten;
	
	@Column(name="don_gia")
	private float dongia;

	@OneToMany(mappedBy = "dichvu", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DichvuSudung> dichvuSudungList;
}
