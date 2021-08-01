package kituc.data;

import java.util.Date;
import java.util.List;

import kituc.entity.Thanhvien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kituc.entity.Khach;

public interface KhachReponsitory extends JpaRepository<Khach, Integer>{
	
	@Query("SELECT k FROM Khach k WHERE k.thanhvien.id = ?1")
	public List<Khach> getAllClientBySvId(int svId);
	
	@Query("SELECT k FROM Khach k WHERE k.ten LIKE %?1% AND k.thanhvien.id = ?2")
	public List<Khach> findKhachByName(String name, int sinhvienid);

	@Query("SELECT t FROM Thanhvien t, Khach k WHERE k.thanhvien.id = t.id AND k.ngayden BETWEEN ?1 AND ?2")
	public List<Thanhvien> dsNgayden(Date ngaybd, Date ngaykt);
}
















