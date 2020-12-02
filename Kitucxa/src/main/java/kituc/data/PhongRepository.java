package kituc.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import kituc.entity.Phong;

public interface PhongRepository extends CrudRepository<Phong, String>{
	@Query("SELECT p FROM Phong p WHERE p.soPhong LIKE %?1%")
	public List<Phong> findAll(String keyword);
}
