package kituc.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import kituc.entity.Sinhvien;

public interface SinhvienRepositoty extends CrudRepository<Sinhvien, Integer> {
	
	@Query("SELECT sv FROM Sinhvien sv WHERE sv.ten LIKE %?1%")
	public List<Sinhvien> findAll(String keyword);
}
