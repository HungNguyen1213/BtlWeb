package kituc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kituc.data.DichvuRepository;
import kituc.entity.Dichvu;

@Service
public class DichvuService {
	@Autowired
	private DichvuRepository dvRepo;
	
	public Iterable<Dichvu> getAllDichvu() {
		 return dvRepo.findAll();
	}
	
	public Dichvu getDichvuById(int id) {
		Optional<Dichvu> optDv = dvRepo.findById(id);
		if(optDv.isPresent()) {
			return optDv.get();
		}
		return null;
	}
	
	public Iterable<Dichvu> searchDichvu(String keyword){
		return dvRepo.findAll(keyword);
	}
	
	public Dichvu luuDichvu(Dichvu dv) {
		return dvRepo.save(dv);
	}
	
	public void xoaDichvu(int id) {
		dvRepo.deleteById(id);
	}
}
