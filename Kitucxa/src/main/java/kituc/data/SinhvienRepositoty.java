package kituc.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import kituc.entity.Sinhvien;

@EnableJpaRepositories
public interface SinhvienRepositoty extends JpaRepository<Sinhvien, Integer> {
	
	@Query("SELECT sv FROM Sinhvien sv WHERE sv.ten LIKE %?1%")
	public List<Sinhvien> findAll(String keyword);
}
