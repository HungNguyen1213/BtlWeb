package kituc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kituc.data.SinhvienRepositoty;
import kituc.entity.Sinhvien;

@Service
public class SinhvienService {
	@Autowired
	private SinhvienRepositoty svRepo;
	
	public Iterable<Sinhvien> findAll(){
		return svRepo.findAll();
	}
	
	public Iterable<Sinhvien> timSinhvien(String keyword){
		return svRepo.findAll(keyword);
	}
	
	public Sinhvien sinhvienByMa(int id) {
		Optional<Sinhvien> optSv = svRepo.findById(id);
		if (optSv.isPresent()) {
			return optSv.get();
		}
		return null;
	}
	
	public Sinhvien luuSinhvien(Sinhvien sv) {
		return svRepo.save(sv);
	}
	
	public void xoaSinhvien(int id) {
		svRepo.findById(id);
	}
}
