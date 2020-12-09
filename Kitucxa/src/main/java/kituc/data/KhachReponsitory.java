package kituc.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kituc.entity.Khach;

public interface KhachReponsitory extends JpaRepository<Khach, Integer>{
	
	@Query("SELECT k FROM Khach k WHERE sinhvienid = ?1")
	public List<Khach> getAllClientBySvId(int svId);
}
















