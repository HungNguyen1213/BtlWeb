package kituc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kituc.converted.DichvuConverter;
import kituc.data.DichvuRepository;
import kituc.dto.DichvuDto;
import kituc.entity.Dichvu;

@Service
public class DichvuService {
	@Autowired
	private DichvuRepository dvRepo;

	@Autowired
	private DichvuConverter dvCvt;

	public List<DichvuDto> getAllDichvu() {
		Iterable<Dichvu> listDvE = dvRepo.findAll();
		List<DichvuDto> listDvDto = new ArrayList<>();
		for (Dichvu dv : listDvE) {
			listDvDto.add(dvCvt.toDichvuDto(dv));
		}
		return listDvDto;
	}

	public DichvuDto getDichvuById(int id) {
		Optional<Dichvu> optDv = dvRepo.findById(id);
		if (optDv.isPresent()) {
			return dvCvt.toDichvuDto(optDv.get());
		}
		return null;
	}

	public List<DichvuDto> searchDichvu(String keyword) {
		Iterable<Dichvu> listDvE = dvRepo.findAll(keyword);
		List<DichvuDto> listDvDto = new ArrayList<>();
		for (Dichvu dv : listDvE) {
			listDvDto.add(dvCvt.toDichvuDto(dv));
		}
		return listDvDto;
	}

	public Dichvu luuDichvu(DichvuDto dv) {
		return dvRepo.save(dvCvt.toDichvuEntity(dv));
	}

	public void xoaDichvu(int id) {
		dvRepo.deleteById(id);
	}
}
