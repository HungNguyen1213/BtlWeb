package kituc.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EnableJpaRepositories
@Entity
@Table(name = "sinhvien")
@Embeddable
public class Sinhvien extends Thanhvien{
	
	
	@OneToMany(mappedBy = "sinhvien")
	private List<Khach> khach = new ArrayList<>();
	
	@OneToMany(mappedBy = "sinhvien")
	private List<Xegui> Xegui = new ArrayList<>();
	
	@OneToMany(mappedBy = "sinhvien")
	private List<DichvuSudung> dvsd = new ArrayList<>();
	
	@OneToMany(mappedBy = "sinhvien")
	private List<Phongthue> phongthue = new ArrayList<>();
		
}
