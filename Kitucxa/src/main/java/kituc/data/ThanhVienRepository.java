package kituc.data;

import kituc.entity.Thanhvien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ThanhVienRepository extends JpaRepository<Thanhvien,Integer> {
    @Query("SELECT tv FROM Thanhvien tv WHERE tv.ten LIKE %?1%")
    public List<Thanhvien> findAllByKey(String keyword);
}
