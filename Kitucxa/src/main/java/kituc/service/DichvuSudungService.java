package kituc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kituc.data.DichvuSudungRepository;
import kituc.entity.DichvuSudung;

@Service
public class DichvuSudungService {
	@Autowired
	private DichvuSudungRepository dvsdRepo;
	
	public DichvuSudung luuDvsd(DichvuSudung dvsd) {
		return dvsdRepo.save(dvsd);
	}
}
