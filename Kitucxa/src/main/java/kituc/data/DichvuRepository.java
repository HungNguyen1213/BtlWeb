package kituc.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import kituc.entity.Dichvu;

public interface DichvuRepository extends CrudRepository<Dichvu, String>{
	@Query("SELECT dv FROM Dichvu dv WHERE dv.ten LIKE %?1%")
	public List<Dichvu> findAll(String keyword);
}
