package kituc.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phong")
public class Phong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="sophong", unique = true)
	private String sophong;
	
	@Column(name="loaiphong")
	private String loaiphong;
	
	@Column(name="dongia")
	private float dongia;
	
	@Column(name="songuoitoida")
	private int songuoitoida;
	
	@OneToMany(mappedBy = "phong")
	private List<Phongthue> phongThue = new ArrayList<>();
}
